package com.cos.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.Users;
import com.cos.blog.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encodeer;
	
	@Transactional
	public void 회원가입(Users user) {
		String rawPassword = user.getPassword();
		String encPassword = encodeer.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRoles(RoleType.USER);
			userRepository.save(user);
	}
	
//	@Transactional
//	public Users 로그인(Users user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(),
//		user.getPassword());
//	}
	
	@Transactional
	public void 회원수정(Users user) {
		Users persistance = userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("회원 찾기 실패");
		});
		String rawPassword = user.getPassword();
		String encPassword = encodeer.encode(rawPassword);
		persistance.setPassword(encPassword);
		persistance.setRoles(RoleType.USER);
	}
}
