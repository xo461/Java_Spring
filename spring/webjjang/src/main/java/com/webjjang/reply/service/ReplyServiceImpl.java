package com.webjjang.reply.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.webjjang.reply.dto.ReplyDTO;
import com.webjjang.reply.mapper.ReplyMapper;
import com.webjjang.util.page.PageObject;
import lombok.AllArgsConstructor;

@Service 
@Qualifier("rs")
//생성자를 이용해서 private member에 di 주입
@AllArgsConstructor
//Replyservice상속받으므로 replycontroller에서 replyservice 변수선언시 bean이 replyservice와 replyserviceimpl 두개 가 된다 ->  같은 타입의 빈이 두 개 이상이 존재하는 경우에 스프링이 어떤 빈을 주입해야 할지 알 수 없어서 스프링 컨테이너를 초기화하는 과정에서 예외를 발생시킨다.
//이 경우 양쪽에 @Qualifier("같은이름") 써줘서 어떤 bean을 가져오는지 명시해준다.
public class ReplyServiceImpl implements ReplyService{

	//db처리를 위한 mapper 변수 선언
	private ReplyMapper mapper;
	
	@Override
	public List<ReplyDTO> list(int no, PageObject pageObject) {
		// 넘어온 페이지의 첫번째와 마지막 게시글의 글번호 구하는 메서드
		pageObject.calcuPageInfo();
		// jsp의 페이지네이션을 위한 계산 -> jsp에 전달이 되어야 한다. request에 담는다.
		pageObject.setTotalRow(mapper.getTotalRow(no));
		System.out.println("ReplyServiceImpl.list().pageObject : "+pageObject);
		System.out.println("===========================");
		System.out.println(no);
		System.out.println("===========================");
		return mapper.list(no, pageObject);
	}

	@Override
	public Integer write(ReplyDTO dto) {
		// TODO Auto-generated method stub
		return mapper.write(dto);
	}

	@Override
	public Integer update(ReplyDTO dto) {
		// TODO Auto-generated method stub
		return mapper.update(dto);
	}

	@Override
	public Integer delete(ReplyDTO dto) {
		// TODO Auto-generated method stub
		return mapper.delete(dto);
	}

}
