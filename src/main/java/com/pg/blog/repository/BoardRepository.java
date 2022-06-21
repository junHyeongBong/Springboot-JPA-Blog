package com.pg.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pg.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
}

