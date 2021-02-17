package com.koreait.bootgradle.exception;

public class FileUpdateException extends RuntimeException{
	public FileUpdateException(String msg) {
		super(msg);
	}
	
	public FileUpdateException(String msg, Throwable e) {
		super(msg, e);
	}
	
	public FileUpdateException(Throwable e) {
		super(e);
	}
}
