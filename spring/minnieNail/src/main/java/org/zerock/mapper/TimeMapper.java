package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

//mybatis mapper사용을 위한 인터페이스.
//2.xx버전까지는 ibatis -> 3.xx버전부터 mybatis로 바뀜
//인터페이스와 어노테이션을 통해 일일이 db 연결하는 sql작성하지 않고도 자동으로 연결가능
public interface TimeMapper {
	
	//방법1)TimeMapper.xml을 이용한 메서드 선언 (sql문장이 길때. xml파일에다가 mapper태그로 만든다.)
	//1.xml 파일명은 인터페이스파일명과 동일하게 만든다. xml의 태그의 id속성값은 인터페이스의 메소드와 동일한 이름으로 해야 한다.
	public String getTime();
	
	//방법2) interface와 annotation을 이용한 메서드 선언 (sql간단할때. 더 편리.)
	//1.인터페이스에 메소드 선언 2.root-context.xml에 scan태그추가 
	@Select("select sysdate from dual")
	public String getTimeAN();
}
