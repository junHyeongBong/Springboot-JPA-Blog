package com.pg.blog.test;

import org.junit.Test;

import com.pg.blog.model.Reply;

public class ReplyObjectTest {
	
	@Test
	public void toStringTest() {
		Reply reply = Reply.builder()
				.id(1)
				.user(null)
				.board(null)
				.content("안녕")
				.build();
		
		System.out.println(reply);
	}

}
