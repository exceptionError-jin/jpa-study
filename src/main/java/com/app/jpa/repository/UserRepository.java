package com.app.jpa.repository;

import com.app.jpa.entity.Users;
//JpaRepository는 Spring Data JPA에서 제공하는 JPA 구현을 위한 인터페이스로
// 간단하게 상속하여 사전에 정의된 여러 메서드를 통해 간단히 DB에 Create/Read/Update/Delete 쿼리를 수행할 수 있습니다.
//또한 정해진 규칙과 단어를 조합한 이름으로 메서드명을 작성하는 것만으로 다양한 쿼리를 생성할 수 있습니다.
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//실제 DB에 Access 하여 쿼리를 수행하는 등의 역할
@Repository // JpaRepository를 상속
public interface UserRepository extends JpaRepository<Users, Long> {

    //Name을 Like 검색한 값을 ID Desc로 Order by 하여 2개만 가져오는 메서드를 생성
    List<Users> findFirst2ByUsernameLikeOrderByIDDesc(String name);

}
