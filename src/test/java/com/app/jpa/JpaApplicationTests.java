package com.app.jpa;

import com.app.jpa.entity.Users;
import com.app.jpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@DataJpaTest
@Slf4j
class JpaPjtApplicationTests {

	@Autowired
	UserRepository userRepository;

	@BeforeEach
	void insertTestData() {
		Users user = new Users();
		user.setUserName("kim ori");
		userRepository.save(user);

		user = new Users();
		user.setUserName("lee ori");
		userRepository.save(user);

		user = new Users();
		user.setUserName("kim ental");
		userRepository.save(user);

		user = new Users();
		user.setUserName("lee ental");
		userRepository.save(user);

		user = new Users();
		user.setUserName("kim samuel");
		userRepository.save(user);
	}

	@Test
	void findAllTest() { // 저장된 데이터 모두를 Spring JPA에 미리 구현된 findAll 명령을 통해 불러온다
		List<Users> userList = userRepository.findAll();
		for(Users u : userList) log.info("[FindAll]: " + u.getID() + " | " +u.getUserName());
	}

	@Test
	void find2ByNameTest() { // Like 검색으로 2개만 값을 가져오는 내가 작성한 명령을 실행해본다
		List<Users> userList = userRepository.findFirst2ByUserNameLikeOrderByIDDesc("kim%");
		for(Users u : userList) log.info("[FindSome]: "  + u.getID() + " | " +u.getUserName());
	}

}
