


# 💃학원관리 프로그램

 




<img src="https://github.com/user-attachments/assets/04226e0b-920e-40cd-b50a-d78f7a5c488a" alt="사진" width="750" height="600">
                  



 


## 1. 프로그램 기획
#### *학원관리 프로그램?*

- 학원 운영자와 직원, 학생 모두가사용할 수 있는 웹 기반 학원관리 프로그램으로
학원관리, 학생관리, 수업지원 등 주요 기능을 통해 관리 효율성을 극대화하고 
사용자 친화적인 인터페이스 제공으로 학생과 학원 간의 원활한 소통을 지원한다.
  
 ### ① 추진배경

 ####  1. 사교육 시장의 확대로 복잡해지는 학원 운영
 - 사교육 시장 성장에 따라 학생 수와 학원 규모가 확대되며, 효율적인 관리 시스템이 필요해짐.
 - 여러 클래스 및 학과 관리, 시험 일정 조율 등으로 운영 난이도 증가.
 #### 2. 수동으로 작업하는 학생/직원 관리, 행정 업무
 -  엑셀 기반 또는 수기 관리 방식으로 인한 업무 효율성 저하.
 - 직원 출퇴근 기록, 학생 출석 체크 및 급여 계산 등의 반복적인 작업에 시간과 인력 낭비 발생.
 #### 3. 비효율적인 소통 방식과 학원 관리의 불편함
 - 공지사항 전달 시 SMS 또는 전화 등 비효율적 방식 사용.
- 학생 및 학부모와의 양방향 소통 채널 부족.
- 학원 내부의 정보 전달 누락 및 혼선.




### ② 프로젝트 소개

  - **로그인, 회원가입 기능**: 
    - Spring Security를 통해 사용자 인증 및 권한 부여 기능 구현
    - 권한 기반 접근 제어:
사용자 역할에 따라 학원 운영자, 직원, 학생으로 구분하여 접근 권한 관리.
페이지별 접근 제한 설정 (예: 관리자 전용 페이지 접근 차단).
  - **학원관리**: 
    - 학원 정보 등록 및 수정 기능 제공.  
    - 클래스 생성 및 관리 기능.  
  - **학생 관리**: 
    - **학생 등록**: 신규 학생 등록 및 관리 기능 제공.  
    - **클래스별 학생 목록 관리**: 클래스에 속한 학생들의 정보를 일괄 조회 및 수정 가능.  
  - **수업지원**: 
   - **성적 관리** 성적 등록, 수정, 삭제 기능 제공. 
     - 클래스별 성적 조회 및 검색 기능.
      - 해당 클래스의 학생 성적을 차트로 시각화하여 표시.
   - **출석 관리**: 당일 학생별 출석 상태 체크 (출석, 지각, 결석 구분).
     날짜별 출석률 확인 및 통계를 차트로 시각화.
  - **학생상세 페이지**: 
    -  **플래너 기능**:  
        - 학생이 학습 계획을 플래너에 작성하면 **선생님이 피드백 제공**.  
        - 이를 통해 학습 효율을 높이고 학생-교사 간의 소통 활성화.  
    
 ### ③ 프로젝트 기대효과

  ####  1.운영 효율성 중대
 - 종이 작업을 줄이고 데이터의 디지털화를 통해 관리의 편리함을 도모
 #### 2.학습 성과 개선
 -  개인별 맞춤 피드백을 통해 학생의 성취도를 평가하고 동기부여 강화
 #### 3.데이터 기반 의사결정
- 축적된 데이터를 분석 후 학생들의 학습 패턴과 성과파악 & 맞춤형 교육 전략을 수립

 ## 2. 팀원 소개

 <h1>팀명</h1>
 <p align="center">
<img src="https://github.com/user-attachments/assets/14b8e49e-1695-4243-90d4-fc0fe007721c" alt="사진" width="600" height="200">
 </p>
 
 <div align="center">

| **안홍영** | **김민수** | **박세연** | **진윤재** |
| :------: |  :------: |  :------: |  :------: |
| [<img src="https://github.com/2024-literacy-project/2024-literacy-project/assets/82174047/34321251-97e6-4ef1-adfd-059cc4f0066f" height=150 width=150> <br/> @inredzero](https://github.com/inredzero) | [<img src="https://github.com/2024-literacy-project/2024-literacy-project/assets/82174047/e21f081d-d9ee-431a-b8ff-0e963fad3811" height=150 width=150> <br/> @moressangplease](https://github.com/moressangplease) | [<img src="https://github.com/2024-literacy-project/2024-literacy-project/assets/82174047/4a486b99-1b23-4a85-bb09-a29c026e37e1" height=150 width=150> <br/> @se-3-yeon](https://github.com/se-3-yeon) | [<img src="https://github.com/2024-literacy-project/2024-literacy-project/assets/82174047/87154d04-2119-472d-89d9-eb512feff02b" height=150 width=150> <br/> @Realyunjae](https://github.com/Realyunjae) |
| 팀장 | 팀원 | 팀원 | 팀원 | 
| 기획, DB구성, 로그인/회원가입 기능, 학습리포트 관리, 성적 평균 통계 |기획,DB구성, 학생 상세페이지(정보,클래스, 플래너), 플래너 피드백|기획, DB구성, 강사관리, 학생 관리, 클래스 관리 |기획, DB구성, 수업지원(성적,출석) 페이지 구현, 공지사항 구현<br>  | 
</div>



<br/>

### LastDance 팀 작업관리


- GitHub issue, 학교에서 대면으로 진행상황 공유
- 매일  짧은 회의를 통해 notion에 회의내용을 기록함.
- 매주 멘토님과 Zoom미팅 후 피드백
-  notion 에 회의내용을 기록함.

#### 깃허브 Issues & Discussions
<div align="left"><img src="https://github.com/user-attachments/assets/5ee3dfc8-83e2-4224-a3de-676a1c998759" alt="사진" width="600" height="300"/></div>

#### 개발 기간
-  개발 기간 : 2024-08 ~ 2024-12
  

## 3.채택한 개발 기술과 브랜치 전략


 ###   ① 개발 환경 
 ###  프로그래밍 언어 및 프레임워크
  

#### Spring boot
-   Spring Boot Java 기반의 오픈 소스 경량 프레임워크로, Spring 프레임워크 위에서 동작
#### thymeleaf
- Thymeleaf는 서버 사이드 자바 템플릿 엔진으로, XML/XHTML/HTML5 컨텐츠를 웹 애플리케이션에서 동적으로 생성하는데 사용.
#### MySQL
-  MySQL을 데이터베이스 관리 시스템으로 사용
#### MyBatis
-  데이터베이스와 객체 간의 자동 매핑 기능을 제공하여, SQL 쿼리 실행 및 결과 매핑
#### CSS 
-  웹 페이지의 레이아웃, 색상, 글꼴 등의 스타일을 정의하는 스타일 시트 언어


### ② 버전 및 이슈관리
  -  Github, Github Issues, Github Project
   <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
  
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
  

### ③ 협업 툴
 <div align=left>
 <img src="https://img.shields.io/badge/discord-5865F2?style=for-the-badge&logo=discord&logoColor=white"></div> 
 <div align=left> <a href="https://www.notion.so/Find-Dog-2f081d1cdc6c46f0b27c2a591f2be77d?pvs=4">
 <img src="https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white"></div>
 </a><div align=left>
 <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"></div>
<div align="left">
    <img src="https://github.com/DBTeamP/DBProject/assets/135615995/470c2391-acbd-48b4-b410-5cd0afb1de96" alt="사진" width="30" height="30"> Chrome Remote Desktop
</div>
<div align="left">
    <img src="https://github.com/DBTeamP/Find-Dog/assets/135615995/5e61746a-f6f2-4912-a31e-ca8b9755d8fe" alt="사진" width="30" height="30"> Google Meet
</div>

###  ④ 브랜치전략
- 각자 맡은 기능에따라 브랜치를 생성하여
- 브랜치명은 feature/기능/(자기 깃허브 닉네임)
- feature/ : 기능단위로 독립적인 개발환경을 위해 사용.




## 4. 유사 프로그램 분석
### 
<div align="left"> <img src="https://github.com/user-attachments/assets/769fb1f5-93e1-4e8d-871f-9bc3ca98d0ad" alt="사진" width="600" height="300">
<div align="left"> <img src="https://github.com/user-attachments/assets/1b4e480f-ae0f-4948-bdf8-e9916c062d88" alt="사진" width="700" height="300">





#### 문제점
- 사용자 UI/UX가 복잡해 직관성이 떨어짐
- 실시간 데이터 반영 및 통계 기능 부족
### ② 차별화 전략
- 1. **플래너 기능 제공**  
   - 학생이 자신의 학습 계획을 플래너에 작성하면  
   - 선생님이 해당 내용을 확인하고 실시간으로 피드백 제공  
   - 이를 통해 학습 효율성과 학생-교사 간의 소통 극대화  

- 2. **통계 시각화 기능**  
   - 출결 및 성적 데이터를 기반으로 차트와 그래프로 시각화  
   - 학생과 학부모가 학습 상황을 한눈에 확인 가능  

- 3. **학생 맞춤형 페이지**  
   - 출석, 성적, 플래너 등을 통합해 관리할 수 있는 페이지 제공  

- 4. **사용자 친화적 UI/UX**  
   - 복잡한 기능을 최소화하고 직관적인 인터페이스 제공  
   - 모든 기능을 쉽게 접근할 수 있도록 간소화화

     
## 6. DB/프로젝트 구조
### 논리 ERD
![논리](https://github.com/user-attachments/assets/10656655-b77b-454f-8966-261cd9dbe497)

 ### 물리 ERD
![물리](https://github.com/user-attachments/assets/0acdc5ab-df53-42fe-9d58-c36acb2ae3cd)

 



## 7. 페이지별 설명

### ① 메인 화면

- 모든 페이지(아동안전지킴이집 지도, 자율방범대 커뮤니티, 안전수칙 메뉴얼, 수호천사 리스트) 연결
- 로그인, 회원가입 기능
- 지문등록, 실종 아동 신고 알림 배너

 <img width="700" alt="스크린샷 2024-06-03 오후 6 34 30" src="">


### ② 메인 지도 기능(내 주변 아동안전 지킴이집)

- 현재 내 위치 기준으로 주변 아동안전지킴이집 리스트 확인/보여주기
- 내 현재 위치 반경 1km, 2km ,3km, 5km 주변 아동지킴이집 검색
 <img width="972" alt="스크린샷 2024-06-13 오후 11 37 33" src="">


### ③ 로그인 & 회원가입 

- 사용자 회원가입 
- 사용자, 관리자 로그인/로그아웃 
- 관리자용 페이지 구현 (사용자 관리)


<img width="400" alt="스크린샷 2024-06-03 오후 6 34 30" src=""><br>


### ④ 날짜별 출석 현황 표시

**기능 설명:**
사용자가 원하는 날짜를 검색하면 해당 날짜의 출석 정보를 조회할 수 있습니다. 이후 특정 클래스를 선택하면 해당 클래스에 속한 학생들의 출석 현황이 차트로 시각화되어 표시됩니다.
- 날짜 선택: 날짜를 기준으로 출석 데이터 필터링
- 클래스 선택: 특정 클래스의 출석 현황 조회
- 차트 시각화: 각 학생의 출석 상태 (출석, 지각, 결석)가 차트로 표시되어 한눈에 확인할 수 있습니다.
  
<img width="700" alt="스크린샷 2024-06-03 오후 6 34 30" src="https://github.com/user-attachments/assets/e9cbac02-343f-43a0-8712-7e1e59c30567">


 
### ⑤ 시험별 성적 검색 
**기능 설명:**
클래스 선택 후 해당 클래스의 시험 정보를 선택하면, 학생들의 시험 성적이 차트로 시각화되어 표시됩니다. 이를 통해 각 학생의 성적 분포를 한눈에 파악하고 클래스 전체의 성과를 분석할 수 있습니다.
- 클래스 선택: 특정 클래스의 시험 데이터를 조회
- 시험 선택: 해당 클래스의 시험 목록에서 원하는 시험 선택
- 차트 시각화: 각 학생의 성적이 막대 차트로 표시되며 성적 평균이나 분포를 시각적으로 확인할 수 있습니다.
  
<img width="900" alt="스크린샷 2024-06-03 오후 6 34 30" src="https://github.com/user-attachments/assets/aacfa64e-6e8b-47d6-bd89-6c58157acb89">




### ⑥ 수호천사 리스트 페이지

 - 내 주변 아동안전수호천사(아동지킴이들) 리스트를 제공하여 동네 아동 안전 강화

<img width="700" alt="스크린샷 2024-06-03 오후 6 34 30" src="">



 


  



