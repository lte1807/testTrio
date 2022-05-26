package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.Users;

//JSP의 DAO
//자동으로 bean 등록이 된다.
//@Repository 생략 가능
public interface UserRepository extends JpaRepository<Users, Integer>{
	//Users findByUsernameAndPassword(String username, String password);
	Optional<Users> findByUsername(String username);
}
