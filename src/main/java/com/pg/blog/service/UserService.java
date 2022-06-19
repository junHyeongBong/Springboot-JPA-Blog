package com.pg.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.blog.model.User;
import com.pg.blog.repository.UserRepository;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public int 회원가입(User user) {
		
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService : 회원가입() : " + e.getMessage());
			// TODO: handle exception
		}
		return -1;
	}

}
