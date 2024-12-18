package com.lastdance.project.sessionsecurity.auth.model.service;

import com.lastdance.project.sessionsecurity.auth.model.AuthDetails;
import com.lastdance.project.sessionsecurity.user.model.dto.LoginUserDTO;
import com.lastdance.project.sessionsecurity.user.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserService userService;


    // 여기도 마찬가지로 로그인을 수행하는 핵심 로직이다. username 이 이름 같지만, 실제로는 id 이다
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginUserDTO login = userService.findByUsername(username);

        if (Objects.isNull(login)) {
            throw new UsernameNotFoundException("해당하는 회원 정보가 존재하지 않습니다");
        }

        return new AuthDetails(login);
    }
}
