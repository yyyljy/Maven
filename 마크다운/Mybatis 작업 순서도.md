EmpServiceImpl

EmpDAOImpl

emp.xml(namespace=multi.erp.emp)



## 작업 흐름

1. request view
   1. (login.jsp)
2. Controller
   1. response view(board/list) <- 로그인 후 커뮤니티 화면으로 연결
   2. 로그인 후 top.jsp 본인 이미지로 변경
3. service
4. dao
5. mapper.xml





1. VO파일 생성 후 기본생성자, 전체 생성자, setter, getter, toString 생성

   스프링이 자동으로 객체를 생성할 때는 기본생성자를 이용해서 생성함. 

2. config파일(설정파일)에 mapper등록 ex)mybatis-config.xml

   여기서 등록한 VO의 이름이 mapper에서 resultType과 parameterType에서 사용됨.

3. mapper에 SQL 입력 ex) emp.xml

4. DAO (interface)생성 및 작업, DAOImpl를 인터페이스 추가해서 생성

   1. @repository("")

   2. sqlSession 생성. + (@Autowired)

      ex) SqlSession sqlSession;

5. Service (interface)생성 및 작업, ServiceImpl를 인터페이스 추가해서 생성

   1. @Service

   2. DAO 추가 + (@Autowired)

      ex) EmpDAO dao;

6. Controller 작성 view 연결 및 ModelAndView추가

   1. ModelAndView 생성해서 사용자가 입력한 값 매개변수로 넘겨받기

7. View 단(.jsp)에서 연결 되어있나 확인