package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//test...
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTest {

	//timemapper 가져오기위한 변수선언
	@Setter(onMethod_ = {@Autowired})
	private TimeMapper timeMapper;

	
	@Test
	public void testGetTime() {
		log.info("getTime");
		log.info(timeMapper.getTime()); //메서드호출해서 실행
	}
	
	@Test
	public void testGetTimeAN() {
		log.info("getTimeAN");
		log.info(timeMapper.getTimeAN()); //메서드호출해서 실행
	}
}
