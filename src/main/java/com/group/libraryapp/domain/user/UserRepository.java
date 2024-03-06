package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //반환 타입 User, 유저 없다면 null 반환
    //findByName 함수 이름만 작성하면 알아서 sql이 조립됨
    //find라고 작성하면 1개의 데이터만 가져옴
    //By뒤에 붙는 필드 이름으로 select쿼리의 where문이 작성
    Optional<User> findByName(String name);


}
