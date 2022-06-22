package com.pg.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pg.blog.dto.ResponseDto;
import com.pg.blog.model.User;
import com.pg.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
//	@Autowired // DI해도된다.
//	private HttpSession session;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { //username, password, email
		System.out.println("UserApiController : save호출됨");
		// 실제로 DB에 insert를 하고 아래에서 return이 되면 된다.
		//user.setRole(RoleType.USER);
		userService.userJoin(user);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //자바오브젝트를 JSON으로 변환해서 리턴 (JACKSON)
	}
	
//	//전통 로그인 방식
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
//		System.out.println("UserApiController : login호출됨");
//		User principal = userService.userLogin(user); //principa(접근주체) 
//		
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user) { // json형식(@RequestBody)으로 말고 form 으로 날리면 key=value, x-www-form-urlencoded
		userService.updateUser(user);
		//여기서는 트랜잭션이 종료되기 때문에 DB에 값은 변경이 됬음
		// 하지만 세션값은 변경되지 않은 상태이기 떄문에 우리가 직접 세션값을 변경해줄 것임.
		// 세션등록
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
}
