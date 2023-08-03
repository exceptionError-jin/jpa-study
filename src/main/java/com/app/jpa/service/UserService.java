package com.app.jpa.service;

import com.app.jpa.entity.Users;
import com.app.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<Users> getUsersService(String name){
        if (name.isBlank()) //name 파라미터가 Null이면 전체 user를 리턴
            return userRepository.findAll();
        else // name 이 존재를 하면, Like 쿼리로 2개만 리턴
            return userRepository.findFirst2ByUsernameLikeOrderByIDDesc(name);
    }

    //Users 객체를 받아 JpaRepository의 save 메서드를 통해 Insert 쿼리를 날리는 createUsers 서비스
    public String createUserService(Users user){
        userRepository.save(user); // User Insert 쿼리 수행
        return "등록 완료";
    }
}
