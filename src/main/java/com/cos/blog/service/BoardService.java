package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.UserRepository;



// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해줌.
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	

	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional
	public void save(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	public Page<Board> list(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	public Board view(int id) {
		return boardRepository.findById(id)
			.orElseThrow(()->{
				return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
			});
	}
}
