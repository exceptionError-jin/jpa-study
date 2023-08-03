package com.app.jpa.entity;

import lombok.*;

import javax.persistence.*;
//SpringBoot jpa.hibernate.ddl-auto 설정의 기본값이 create-drop이라서
// In-Memory DB를 사용하는 경우 Entity를 기준으로 애플리케이션 실행 시,
// 테이블을 Drop 하고 신규로 생성하게 되어, @Entity 어노테이션을 필수로 작성합니다.

@Entity //자동으로 Users라는 테이블이 생성
@Getter
@Setter
public class Users {
    @Id //Key가 될 ID란 칼럼에 @Id 어노테이션을 붙여야 함
    @GeneratedValue(strategy = GenerationType.IDENTITY) //직접 정의하지 않아도 자동으로 작성이 되는 AUTO_INCREMENT 기능을 위해 @GeneratedValue 어노테이션을 추가
    private Long ID;

    private String username;
}
