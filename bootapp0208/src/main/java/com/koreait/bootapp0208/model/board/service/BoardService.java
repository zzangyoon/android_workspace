package com.koreait.bootapp0208.model.board.service;

import java.util.List;

import com.koreait.bootapp0208.model.domain.Board;

public interface BoardService {
	public List selectAll();
	public Board select(int board_id);
	public void regist(Board board);
	public void update(Board board);
	public void delete(int board_id);
}
