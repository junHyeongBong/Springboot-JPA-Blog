package com.pg.blog.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncTest {
	
	@Test
	public void hash_test() {
		String encPaswrod = new BCryptPasswordEncoder().encode("1234");
		System.out.println("1234 해쉬 : " + encPaswrod);
	}

}
