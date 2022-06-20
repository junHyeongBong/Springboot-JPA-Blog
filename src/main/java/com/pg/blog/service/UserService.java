package com.pg.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pg.blog.model.User;
import com.pg.blog.repository.UserRepository;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//회원가입 성공이 되면 commit, 안되면 rollback
	@Transactional
	public void userJoin(User user) {
			userRepository.save(user);
	}
	
//	@Transactional(readOnly = true) // Select 할 떄 트랜잭션시작, 서비스 종료시에 트랜잭션 종료 (정합성)
//	public User userLogin(User user) {
//			return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}

}
