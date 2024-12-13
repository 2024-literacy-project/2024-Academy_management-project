package com.lastdance.project.class_support.service;

import com.lastdance.project.class_support.model.dao.ClassDAO;
import com.lastdance.project.class_support.model.dao.GradeDAO;
import com.lastdance.project.class_support.model.dto.GradeDTO;
import com.lastdance.project.class_support.model.dto.ScoreDataDTO;
import com.lastdance.project.class_support.model.dto.StudentDTO;
import com.lastdance.project.class_support.model.dto.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class GradeService {

    private final GradeDAO gradeDAO;
    private final ClassDAO classDAO;

    @Autowired
    public GradeService(GradeDAO gradeDAO, ClassDAO classDAO) {
        this.gradeDAO = gradeDAO;
        this.classDAO = classDAO;
    }

    /**
     * 성적 등록
     *
     * @param gradeDTO 성적 데이터
     * @return 삽입된 행의 수 (현재는 1을 반환)
     */
    @Transactional
    public int addGrade(GradeDTO gradeDTO) {
        try {
            // test 테이블에 시험 정보 INSERT (testNo 자동 생성)
            TestDTO testDTO = new TestDTO();
            testDTO.setTestName(gradeDTO.getTestName());
            testDTO.setTestDate(gradeDTO.getTestDate());
            testDTO.setTestInfo(gradeDTO.getTestInfo());
            gradeDAO.insertTest(testDTO);

            // 삽입된 testNo를 gradeDTO에 설정
            gradeDTO.setTestNo(testDTO.getTestNo());

            // 학생 성적 student_test에 INSERT
            gradeDAO.addOrUpdateStudentTest(gradeDTO.getTestNo(), gradeDTO.getMemberNo(), gradeDTO.getScore());

            // class_test에 기록할 때는 해당 클래스를 담당하는 직원의 memberNo 사용
            int teacherMemberNo = classDAO.getTeacherMemberNoByClassNo(gradeDTO.getClassNo());
            gradeDAO.addClassTest(
                    gradeDTO.getClassNo(),
                    gradeDTO.getTestNo(),
                    teacherMemberNo);
            // test_result 업데이트 (평균 점수 계산)
            gradeDAO.updateTestResult(testDTO.getTestNo());

            return 1; // 성공을 나타내기 위해 1 반환
        } catch (Exception e) {
            // 트랜잭션 롤백 (자동으로 이루어짐)
            throw e;
        }
    }

    /**
     * 기존 시험에 여러 학생의 점수 추가 및 test_result 업데이트 (배치 처리)
     *
     * @param scoreDataList 학생 점수 리스트
     * @return 성공 시 1
     */
    @Transactional
    public int addScoresToExistingTest(List<ScoreDataDTO> scoreDataList) {
        if (scoreDataList == null || scoreDataList.isEmpty()) {
            throw new IllegalArgumentException("점수 데이터가 없습니다.");
        }

        try {
            // 모든 학생 점수 추가/수정
            gradeDAO.addOrUpdateStudentTests(scoreDataList);

            // 첫 번째 항목의 testNo를 사용 (모든 항목이 동일한 testNo라고 가정)
            int testNo = scoreDataList.get(0).getTestNo();

            // test_result 업데이트 (한 번만 호출)
            gradeDAO.updateTestResult(testNo);

            return 1; // 성공을 나타내기 위해 1 반환
        } catch (Exception e) {
            // 트랜잭션 롤백 (자동으로 이루어짐)
            throw e;
        }
    }



    /**
     * 클래스별 특정 날짜의 성적 조회
     *
     * @param classNo  클래스 번호
     * @param testDate 시험 날짜
     * @param testNo   시험 번호
     * @return 성적 리스트
     */
    public List<GradeDTO> getGradesByClassAndDate(int classNo, Date testDate, int testNo) {
        Map<String, Object> params = new HashMap<>();
        params.put("class_no", classNo);
        params.put("test_date", testDate);
        params.put("test_no", testNo); // 시험 번호 추가
        return gradeDAO.getGradesByClass(params);
    }
    /**
     * 클래스별 시험 목록 조회
     *
     * @param classNo 클래스 번호
     * @return 시험 리스트
     */
    public List<TestDTO> getTestsByClass(int classNo) {
        return gradeDAO.getTestsByClass(classNo);
    }

    /**
     * 시험별 학생 목록 조회
     *
     * @param testNo 시험 번호
     * @return 학생 리스트
     */
    public List<StudentDTO> getStudentsByTest(int testNo) {
        return gradeDAO.getStudentsByTest(testNo);
    }

    public List<StudentDTO> getStudentsByClassAndTest(int classNo, int testNo) {
        return gradeDAO.getStudentsByClassAndTest(classNo, testNo);
    }


    /**
     * 모든 시험 정보 조회
     *
     * @return 시험 리스트
     */
    public List<TestDTO> getAllTests() {
        return gradeDAO.getAllTests();
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
