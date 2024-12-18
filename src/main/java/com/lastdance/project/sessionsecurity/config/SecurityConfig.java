package com.lastdance.project.sessionsecurity.config;

import com.lastdance.project.sessionsecurity.common.UserRole;
import com.lastdance.project.sessionsecurity.config.handler.AuthFailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthFailHandler authFailHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // ignore ? 무시하다.
        // 부트스트랩 템플릿을 사용하게 되면 css, js, asset 등등 폴더가 엄청 많음
        // 하지만 view 페이지에서 css 랑 js 파일 사용하는 것도 일종의 URL 통신
        // 나중에 css, js, 등등 부트스트랩에서 딸려오는 파일들은 static 폴더에 저장해야 됨.
        return web -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .requestMatchers("/assets/**", "/css/**", "/js/**", "/images/**");
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> {
            // 해당하는 URL 은 로그인(인증이 되지 않은 사람도 들어갈 수 있다.)
            auth.requestMatchers("/auth/login", "/auth/fail", "/", "/main","/users/**").permitAll();
            // 해당하는 URL 은 권한이 ADMIN 인 사람만 들어갈 수 있다.
            auth.requestMatchers("/employee/signup", "/employeeList").hasAnyAuthority(UserRole.ADMIN.getRole());
            // 해당하는 URL 은 권한이 STUDENT 인 사람만 들어갈 수 있다.
            auth.requestMatchers("/student/info","/student/time-table", "/student/exam-results", "/student/planner/list").hasAnyAuthority(UserRole.STUDENT.getRole());
            // 해당하는 URL 은 권한이 EMPLOYEE 인 사람만 들어갈 수 있다.
//            auth.requestMatchers("").hasAnyAuthority(UserRole.EMPLOYEE.getRole());
            // 해당하는 URL 은 권한이 EMPLOYEE랑 ADMIN 사람만 들어갈 수 있다.
            auth.requestMatchers("/student/signup","/classList","/studentList", "/class_support/**").hasAnyAuthority(UserRole.ADMIN.getRole(), UserRole.EMPLOYEE.getRole());

            // 위에 작성하지 않은 URL 은 로그인(인증이 필요하다.) > 로그인페이지로 이동 됨.
            auth.anyRequest().authenticated();

        }).formLogin(login -> {
            // 실제로 로그인 기능을 만든 URL 기술
            login.loginPage("/auth/login");
            // form 태그의 id 입력하는 name 속성을 입력하는 공간
            login.usernameParameter("user");
            // form 태그의 pass 입력하는 name 속성을 입력하는 공간
            login.passwordParameter("pass");
            // 로그인 성공 했을 때 어디로 가는 지 URL 입력하는 공간
            login.defaultSuccessUrl("/", true);
            // 로그인 실패 했을 때 수행 할 작업 AuthFailHanldler 클래스로 이동
            login.failureHandler(authFailHandler);

        }).logout(logout -> {
            // 로그아웃 기능 작성하는 URL
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"));
            logout.deleteCookies("JSESSIONID");
            logout.invalidateHttpSession(true);
            // 로그아웃 성공했을 때 이동 할 경로
            logout.logoutSuccessUrl("/");

        }).sessionManagement(session -> {
            session.maximumSessions(1);
            session.invalidSessionUrl("/");

        }).csrf(csrf -> csrf.disable());


        return http.build();
    }

}


