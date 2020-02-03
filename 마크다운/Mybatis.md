# Mybatis

1. pom.xml에 의존모듈을 추가

   - mybatis
   - mybatis-spring

   ```xml
   <!-- mybatis라이브러리 추가 -->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis</artifactId>
       <version>3.3.0</version>
   </dependency>
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis-spring</artifactId>
       <version>1.2.3</version>
   </dependency>
   ```

   

2. mybatis에서 사용할 설정 파일을 작성

   - mybatis메인 설정 파일 : mybatis를 실행할 때 필요한 내용을 정의

     ​											connection관리를 위해 필요한 내용(spring으로 관리하므로 생략)

     ​											mapper에 대한 정보

     ​											mapper에서 사용할 dto

     ​											spring설정파일이 저장되는 위치에 추가

     ​											/WEB-INF/config/mybatis-config.xml 로 저장

     ```xml
     <?xml version="1.0" encoding="UTF-8" ?>
     <!DOCTYPE configuration
       PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
       "http://mybatis.org/dtd/mybatis-3-config.dtd">
       
     <configuration>
     	<typeAliases>
     		<typeAlias type="multi.erp.board.BoardVO" alias="board"/>
     	</typeAliases>
     	<mappers>
     		<mapper resource="mapper/board.xml"/>
     	</mappers>
     </configuration>
     ```

     

   - mapper : sql문을 정의하는 설정 파일

     ​					테이블 한 개 에서 사용하는 sql문을 하나의 mapper파일

     ​					src폴더에 추가 (ex. src/mapper/board.xml)

     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <!DOCTYPE mapper
       PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
       "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
     
     <mapper namespace="multi.erp.board">
     	<select id="listall" resultType="board">
     		select * from board
     	</select>
     </mapper>
     ```

3. spring설정 파일에 mybatis를 사용할 수 있도록 등록

   - connection을 사용(생성)할 수 있도록 등록

   - SqlSession을 사용하려면 factory객체부터 생성해야 하므로 Factory객체를 먼저 설정한다.

     (spring에서 mybatis의 핵심클래스를 사용할 수 있게 하기 위한 객체)

     =>Connection객체를 사용, mybatis의 메인 설정 파일을 등록

   - mybatis의 핵심클래스인 SqlSession클래스의 하위클래스를 생성

     SqlSessionTemplate => spring-jdbc의 JdbcTemplate과 같은 역할



[[기능 추가하기]]

0. 새로운 테이블로 작업을 한다면 mybatis-config.xml파일에 VO파일과 mapper파일 등록

1. mapper에 sql문 추가

2. DAOImpl클래스에 메소드 추가

3. ServiceImpl클래스에서 dao의 메소드 호출할 수 있도록 메소드 정의

4. Controller에서 ServiceImpl의 메소드를 호출해서 작업할 수 있도록 정의

5. Controller에서 response하는 뷰에서 Controller에서 공유해준 데이터를 꺼내서 출력하기(select작업)

6. tiles설정 파일에서 뷰 등록

   (SQL하나당 메소드 한개!)

   ```java
   @Override
   	public List<BoardVO> categorySearch(String category) {
   		List<BoardVO> list = sqlSession.selectList("categorySearch", category);
   		System.out.println(list);
   		return list;
   	}
   ```

   `"categorySearch"` = mapper에서 지정한 이름(id)

