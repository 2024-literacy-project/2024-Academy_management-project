package com.lastdance.project.notice.service;

import com.lastdance.project.notice.model.dao.NoticeDAO;
import com.lastdance.project.notice.model.dto.NoticeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    private final NoticeDAO noticeDAO;

    @Autowired
    public NoticeService(NoticeDAO noticeDAO) {
        this.noticeDAO = noticeDAO;
    }

    // 모든 공지사항 가져오기
    public List<NoticeDTO> getAllNotices() throws Exception {
        return noticeDAO.selectAllNotices();
    }

    // 공지사항 번호로 공지사항 가져오기
    public NoticeDTO getNoticeByNo(int notice_no) throws Exception {
        return noticeDAO.selectNoticeByNo(notice_no);
    }

    // 공지사항 추가하기
    public void addNotice(NoticeDTO notice) throws Exception {
        noticeDAO.insertNotice(notice);
    }

    // 공지사항 수정하기
    public void updateNotice(NoticeDTO notice) throws Exception {
        noticeDAO.updateNotice(notice);
    }

    // 공지사항 삭제하기
    public void deleteNotice(int notice_no) throws Exception {
        noticeDAO.deleteNotice(notice_no);
    }
}
