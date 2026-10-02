# 포트폴리오 프로젝트 제작(학번 : 20241402 이름 : 장예지)
<img src="/src/main/resources/static/images/5-1.png">
<img src="/src/main/resources/static/images/5-2.png">

# 5주차 정리
# 지난 주 온라인 강의로 데이터베이스 연동을 진행한 뒤 웹 보안 파트로 넘어왔다. 5주차에서 주요하게 다룰 보안은 인증 보안이다. 지난 학기 SHA256을 썼지만 이번에는 BCrypt를 사용하여 비밀번호를 저장했다. BCrypt SALT는 22글자로 무작위 값이 자동으로 생성된다. 기존 포트폴리오에서 이제 로그인/로그아웃을 구현하고 BCrypt 사용하여 비밀번호를 암호화한다.
# pom.xml에서 의존성 파일을 2개 추가했고 SecurityConfig 파일을 통해 보안을 설정한다. PasswordEncoder와 authorizeHttpRequests, formLogin을 활용했다. 또, Controller를 새로 만들어 요청을 받아주고 화면을 연결해준다. 또 Member.java를 만들어 아이디를 중복되지 않게 만들어준다. 4주차에서는 직접 db에 입력했지만 얘는 자동으로 증가한다. MemberRepository.java를 생성하여 아이디가 중복되지 않게 만들어준다. MemberForm.java를 만들어 가입 데이터를 관리한다.
# MemberService.java를 생성하여 회원가입 서비스를 만들어준다. 서비스를 등록하고 이미 아이디가 사용중이라고 알려주며 아이디의 중복을 방지해준다. 또 기존 MemberController.java에 회원가입 처리 등을 추가했으며 로그인을 연결해주기 위해 MemberService를 수정했다. 또한 연습문제를 풀어 MemberService에 있는 if문을 활용하여 비밀번호 확인을 구현했으며 SecurityConfig에서 .rememberMe()를 활용하여 로그인 상태를 유지하도록 만들었다.
# 또 지속적으로 포트폴리오 템플릿을 나만의 포트폴리오로 바꿔나갈 예정이다.