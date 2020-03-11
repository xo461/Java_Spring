package com.webjjang.util.file;

import java.io.File;

public class FileUtil {

	//파일 중복시 이름 새로 만들어주는 메소드 : controller에서 호출해서 사용한다.
	public static File removeDuplicateFileName(final String realPath, final String fileName) throws Exception {
		int cnt = 0; // 중복되면 cnt 1씩 증가시킨 이름 붙여서 파일만들기
		
		//이어붙여서 경로만들어서 파일 만들어준다.
		File saveFile = new File(realPath, fileName); 

		//확장자명 앞에 점 잘라서
		int seperatePos = fileName.lastIndexOf(".");
		//0부터 고 앞까지
		String name = fileName.substring(0, seperatePos);
		//확장자
		String ext = fileName.substring(seperatePos);
		
		System.out.println("name: " + name + ", ext: " + ext );

		//중복된파일이 있으면 파일 새로 만듦
		while(saveFile.exists()) { //파일존재하면 true 반복
			saveFile = new File(realPath, name + (++cnt) + ext);
		}

		return saveFile;
	}
}
