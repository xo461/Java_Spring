package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //이 클래스를 가져와서 쓴다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j //진행사항 로그로 출력 - 서버인경우 txt파일로 저장되고, 이클립스인경우 콘솔에 표시
public class SampleTests {
	
	//자동 DI받기
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;

	//테스트 메소드 작성
	@Test //테스트라고 알려줌
	public void testExist() {
		
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("--------------------------");
		//null이면 DI적용안됨. null이 아니면 DI적용됨
		log.info(restaurant.getChef());
	}
}
