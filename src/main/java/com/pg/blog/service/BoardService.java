package com.pg.blog.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pg.blog.model.Board;
import com.pg.blog.model.RoleType;
import com.pg.blog.model.User;
import com.pg.blog.repository.BoardRepository;
import com.pg.blog.repository.UserRepository;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	//회원가입 성공이 되면 commit, 안되면 rollback
	@Transactional
	public void write(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	//글 목록 readOnly = true select만 하니깐
	@Transactional(readOnly = true)
	public Page<Board> selectList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	
	//글 상세보기
	@Transactional(readOnly = true)
	public Board selectBoard(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()-> {
					return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
				});
	}
	
	//글 삭제
	@Transactional
	public void deleteBoard(int id) {
		 boardRepository.deleteById(id);
	}
	
	@Transactional
	public void updateBoard(int id, Board requestBoard) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()-> {
					return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
				}); //영속화 완료
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		// 해당 함수로 종료시에 (Service가 종료될 때) 트랜잭션이 종료된다. 이때 더티체킹 - 자동 업데이트가 db flush
	}
	

}
