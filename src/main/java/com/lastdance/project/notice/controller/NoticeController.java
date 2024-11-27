package com.lastdance.project.notice.controller;

import com.lastdance.project.notice.model.dto.NoticeDTO;
import com.lastdance.project.notice.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "notice";
    }


}