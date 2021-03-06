package com.webjjang.image.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.webjjang.image.dto.ImageDTO;
import com.webjjang.image.mapper.ImageMapper;
import com.webjjang.util.page.PageObject;
import lombok.AllArgsConstructor;

//@Log4j //로그 출력: log.info()
@Service 
@Qualifier("is")
@AllArgsConstructor
//Imageservice상속받으므로 imagecontroller에서 imageservice 변수선언시 bean이 imageservice와 imageserviceimpl 두개 가 된다 ->  같은 타입의 빈이 두 개 이상이 존재하는 경우에 스프링이 어떤 빈을 주입해야 할지 알 수 없어서 스프링 컨테이너를 초기화하는 과정에서 예외를 발생시킨다.
//이 경우 양쪽에 @Qualifier("같은이름") 써줘서 어떤 bean을 가져오는지 명시해준다.
public class ImageServiceImpl implements ImageService{

	//db처리를 위한 mapper 변수 선언
	private ImageMapper mapper;
	
	@Override
	public List<ImageDTO> list(PageObject pageObject) {
		// 넘어온 페이지의 첫번째와 마지막 게시글의 글번호 구하는 메서드
		pageObject.calcuPageInfo();
		// jsp의 페이지네이션을 위한 계산 -> jsp에 전달이 되어야 한다. request에 담는다.
		pageObject.setTotalRow(mapper.getTotalRow(pageObject)); //db에서 전체데이터개수가져와서(검색해서필터링되면 된대로) => 전체페이지수및 페이지그룹의시작페이지,끝페이지 구하기.
		System.out.println("ImageServiceImpl.list().pageObject : "+pageObject);
		return mapper.list(pageObject);
	}

	@Override
	public Integer write(ImageDTO dto) {
		return mapper.write(dto);
	}

	@Override
	public ImageDTO view(int no) {
		return mapper.view(no);
	}

	@Override
	public Integer update(ImageDTO dto) {
		// TODO Auto-generated method stub
		return mapper.update(dto);
	}

	@Override
	public Integer delete(ImageDTO dto) {
		// TODO Auto-generated method stub
		return mapper.delete(dto);
	}
}
