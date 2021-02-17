package com.koreait.bootgradle.model.common;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.bootgradle.exception.FileUpdateException;

import lombok.extern.slf4j.Slf4j;

//파일 저장을 전답하는 로직 객체

@Component
@Slf4j
public class UploadManager {
	public void save(MultipartFile multi) throws FileUpdateException{
		//저장경로
		//String path="c:/~~~"; 	>	피해가는법 : ServletContext getRealPath()
		String dir = this.getClass().getResource("/static/data").getPath();	//boot는 servletContext 로 얻어올 필요 없음
		String filename = multi.getOriginalFilename();
		log.debug("저장할 경로는 {}입니다", dir+"/"+filename);
		
		try {
			multi.transferTo(new File(dir+"/"+filename));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new FileUpdateException("파일저장 실패", e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileUpdateException("파일저장 실패", e);
		}
	}
}
