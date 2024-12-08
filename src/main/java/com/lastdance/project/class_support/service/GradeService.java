package com.lastdance.project.class_support.service;

import com.lastdance.project.class_support.model.dao.ClassDAO;
import com.lastdance.project.class_support.model.dao.GradeDAO;
import com.lastdance.project.class_support.model.dto.GradeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class GradeService {

    private final GradeDAO gradeDAO;
    private final ClassDAO classDAO;

    @Autowired
    public GradeService(GradeDAO gradeDAO,ClassDAO classDAO ) {
        this.gradeDAO = gradeDAO;
        this.classDAO = classDAO;
    }

    /**
     * 성적 등록
     *
     * @param gradeDTO 성적 데이터
     * @return 삽입된 행의 수
     */
    public int addGrade(GradeDTO gradeDTO) {

        // test 테이블에 시험 정보 INSERT (testNo 자동 생성)
        gradeDAO.insertGrade(gradeDTO);

        // 학생 성적 student_test에 INSERT
        gradeDAO.addStudentTest(gradeDTO.getTestNo(), gradeDTO.getMemberNo());

        // class_test에 기록할 때는 해당 클래스를 담당하는 직원의 member_no 사용
        int teacherMemberNo = classDAO.getTeacherMemberNoByClassNo(gradeDTO.getClassNo());
        gradeDAO.addClassTest(gradeDTO.getClassNo(), gradeDTO.getTestNo(), teacherMemberNo);

        return 1;
    }

    /**
     * 클래스별 특정 날짜의 성적 조회
     *
     * @param classNo  클래스 번호
     * @param testDate 시험 날짜
     * @return 성적 리스트
     */
    public List<GradeDTO> getGradesByClassAndDate(int classNo, Date testDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("class_no", classNo);
        params.put("test_date", testDate);
        return gradeDAO.getGradesByClass(params);
    }

    /**
     * 성적 수정
     *
     * @param gradeDTO 수정할 성적 데이터
     * @return 수정된 행의 수
     */
    public int updateGrade(GradeDTO gradeDTO) {
        return gradeDAO.updateGrade(gradeDTO);
    }

    /**
     * 성적 삭제
     *
     * @param testNo    시험 번호
     * @param memberNo  학생 번호
     * @return 삭제된 행의 수
     */
    public int deleteGrade(int testNo, int memberNo) {
        return gradeDAO.deleteGrade(testNo, memberNo);
    }
}
