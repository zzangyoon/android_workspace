package com.koreait.bootgradle.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.bootgradle.model.domain.Board;

@Controller
public class BoardController {

	@GetMapping("/rest/board/{board_id}")
	@ResponseBody	//결과가 jsp가 아닌 json, 반환형이 String이 아닌 VO형인 경우, Converter가 지원되어야 한다
	//스프링설정파일.xml에서 jackson jar 다운받아... messageConverter...설정... 스프링부트는 이 등록이 설정되어 있다.. 이런 작업을 할 필요가 없다
	public Board getDetail(@PathVariable int board_id) {
		Board board = new Board();
		board.setBoard_id(board_id);
		board.setTitle("난 VO야");
		
		return board;
	}
}
