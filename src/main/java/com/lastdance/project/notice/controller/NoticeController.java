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

    // 모든 공지사항을 조회하는 엔드포인트
    @GetMapping("/notice")
    public String getAllNotices(Model model) {
        try {
            List<NoticeDTO> noticeList = noticeService.getAllNotices();
            model.addAttribute("noticeList", noticeList);
        } catch (Exception e) {
            // 예외 처리: 에러 페이지로 리다이렉트하거나, 에러 메시지를 반환합니다.
            model.addAttribute("error", "공지사항을 불러오는 중 오류가 발생했습니다.");
            return "error"; // 에러 페이지로 이동하도록 합니다.
        }
        return "notice/notice";
    }
    // 개별 공지사항 조회 엔드포인트
    @GetMapping("/notice/{notice_no}")
    public String getNoticeByNo(@PathVariable int notice_no, Model model) {
        try {
            NoticeDTO notice = noticeService.getNoticeByNo(notice_no);
            model.addAttribute("notice", notice);
        } catch (Exception e) {
            model.addAttribute("error", "공지사항을 불러오는 중 오류가 발생했습니다.");
            return "error";
        }
        return "notice/noticeView";
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

            noticeService.addNotice(notice);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/notice"; // 공지사항 목록으로 이동
    }
    @PostMapping("/notice/delete/{notice_no}")
    public String deleteNotice(@PathVariable("notice_no") int notice_no) {
        try {
            noticeService.deleteNotice(notice_no);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/notice"; // 공지사항 목록으로 리다이렉트
    }


}