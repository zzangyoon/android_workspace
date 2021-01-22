package com.koreait.restproject.rest.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.restproject.exception.MemberListException;
import com.koreait.restproject.message.Message;

import lombok.extern.slf4j.Slf4j;

//Rest요청을 처리하는 컨트롤러들에서 발생하는 모든 예외는 여기서 잡아낸다
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	//회원목록을 가져올때 발생하는 예외처리
	@ExceptionHandler(MemberListException.class)
	@ResponseBody
	//Message라는 클래스를 따로 만들어 객체로 만들면, 자동으로 객체-json 변환이 되므로 편안!
	public ResponseEntity<Message> handle(MemberListException e) {
		//뭐라고 데이터를 구성해서 보내야 클라이언트가 제대로 예외를 처리할지...
		log.debug("Rest 요청시 발생하는 예외처리");
		Message message = new Message();
		message.setMsg(e.getMessage());
		message.setStatusCode(500);

		//스프링에서는 http 프로토콜을 따르는 응답정보 전담 객체가 지원된다
		//따라서 이 객체를 이용하면 클라이언트에게 데이터만 전송하는게 아니라, 서버의 상태도 함께 전송할 수 있다
		//ResponseEntity는 HttpEntity 상속받은 http 응답객체이다 (메시지, 헤더정보, 상태코드)
		ResponseEntity entity = new ResponseEntity<Message>(message, null, HttpStatus.BAD_REQUEST);
		
		return entity;
	}
}
