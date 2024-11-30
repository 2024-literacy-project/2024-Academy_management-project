package com.lastdance.project.notice.controller;

import com.lastdance.project.notice.model.dto.NoticeDTO;
import com.lastdance.project.notice.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class NoticeController {

    private final NoticeService noticeService;

    // NoticeService 의존성 주입
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    // 메인 페이지 (루트 URL, "/")에서 모든 공지사항을 조회하는 엔드포인트
    @GetMapping("/")
    public String getMainPage(Model model) {
        try {
            // 모든 공지사항을 가져와서 모델에 추가
            List<NoticeDTO> noticeList = noticeService.getAllNotices();
            model.addAttribute("noticeList", noticeList);
        } catch (Exception e) {
            model.addAttribute("error", "공지사항을 불러오는 중 오류가 발생했습니다.");
            return "error"; // 에러 페이지로 이동
        }
        return "index"; // 메인 페이지 템플릿
    }

    // 모든 공지사항을 조회하는 엔드포인트
    @GetMapping("/notice")
    public String getAllNotices(Model model) {
        try {
            List<NoticeDTO> noticeList = noticeService.getAllNotices();
            model.addAttribute("noticeList", noticeList);
        } catch (Exception e) {
            model.addAttribute("error", "공지사항을 불러오는 중 오류가 발생했습니다.");
            return "error"; // 에러 페이지로 이동
        }
        return "notice/notice"; // notice/notice.html로 이동
    }

    // 개별 공지사항 조회 엔드포인트
    @GetMapping("/notice/{notice_no}")
    public String getNoticeByNo(@PathVariable int notice_no, Model model) {
        try {
            NoticeDTO notice = noticeService.getNoticeByNo(notice_no);
            model.addAttribute("notice", notice);
        } catch (Exception e) {
            model.addAttribute("error", "공지사항을 불러오는 중 오류가 발생했습니다.");
            return "error"; // 에러 페이지로 이동
        }
        return "notice/noticeView"; // 개별 공지사항 보기 페이지
    }

    // 공지사항 추가 폼
    @GetMapping("/notice/add")
    public String addNoticeForm(Model model) {
        model.addAttribute("notice", new NoticeDTO());
        return "notice/noticeAdd";
    }

    // 공지사항 추가 처리
    @PostMapping("/notice/add")
    public String addNotice(@ModelAttribute("notice") NoticeDTO notice,
                            @RequestParam("notice_date") String noticeDateString) {
        try {
            // 날짜 형식 변환: yyyy-MM-dd 형태의 문자열을 LocalDate로 변환
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate formattedDate = LocalDate.parse(noticeDateString, formatter);
            notice.setNotice_date(formattedDate);

            // 로그인한 사용자 정보에서 member_no를 설정 (예시로 5번 사용자를 설정)
            notice.setMember_no(5);

            noticeService.addNotice(notice);
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // 에러 페이지로 리다이렉트
        }
        return "redirect:/notice"; // 공지사항 목록으로 이동
    }

    // 공지사항 삭제 처리
    @PostMapping("/notice/delete/{notice_no}")
    public String deleteNotice(@PathVariable("notice_no") int notice_no) {
        try {
            noticeService.deleteNotice(notice_no);
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // 에러 페이지로 리다이렉트
        }
        return "redirect:/notice"; // 공지사항 목록으로 리다이렉트
    }

    // 공지사항 수정 폼을 보여주는 메서드
    @GetMapping("/notice/edit/{notice_no}")
    public String showUpdateForm(@PathVariable("notice_no") int noticeNo, Model model) {
        try {
            NoticeDTO notice = noticeService.getNoticeByNo(noticeNo);
            if (notice == null) {
                model.addAttribute("error", "해당 공지사항을 찾을 수 없습니다.");
                return "error"; // 에러 페이지로 이동
            }
            // 날짜 형식을 yyyy-MM-dd로 변경
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = notice.getNotice_date().format(formatter);
            model.addAttribute("notice", notice);
            model.addAttribute("formattedDate", formattedDate); // 날짜 문자열 추가
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "공지사항을 불러오는 중 오류가 발생했습니다.");
            return "error"; // 에러 페이지로 이동
        }
        return "notice/noticeEdit"; // noticeEdit.html로 이동
    }

    // 공지사항 수정 처리
    @PostMapping("/notice/update")
    public String updateNotice(@ModelAttribute("notice") NoticeDTO notice,
                               @RequestParam("notice_date") String noticeDateString) {
        try {
            // 날짜 형식 변환
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate formattedDate = LocalDate.parse(noticeDateString, formatter);
            notice.setNotice_date(formattedDate);

            // 로그인한 사용자 정보에서 member_no를 설정 (예시로 5번 사용자를 설정)
            notice.setMember_no(5);

            noticeService.updateNotice(notice);
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // 에러 페이지로 리다이렉트
        }
        return "redirect:/notice"; // 수정 후 공지사항 목록으로 이동
    }
}
