package com.lastdance.project.notice.model.dao;

import com.lastdance.project.notice.model.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface NoticeDAO {
    // 공지사항 추가
    void insertNotice(NoticeDTO notice) throws Exception;

    // 공지사항 조회 (모든 공지사항)
    List<NoticeDTO> selectAllNotices() throws Exception;
    // 공지사항 조회 (공지사항 번호로 조회)
    NoticeDTO selectNoticeByNo(int notice_no) throws Exception;
    // 공지사항 업데이트
    void updateNotice(NoticeDTO notice) throws Exception;
    // 공지사항 삭제
    void deleteNotice(int notice_no) throws Exception;
}
