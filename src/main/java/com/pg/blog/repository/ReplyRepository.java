package com.pg.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pg.blog.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{

}
