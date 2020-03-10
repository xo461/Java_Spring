package com.webjjang.image.mapper;

import java.util.List;
import com.webjjang.image.dto.ImageDTO;
import com.webjjang.util.page.PageObject;

//src/main/resources 안에 com/webjjang/image/mapper 폴더 각각 만들고 (이 패키지 이름하고 동일하게) 이름은 이 파일과 동일하게 imagemapper.xml로 만들어야 하고, 태그의 아이디는 메서드이름과 동일하게 써야 한다. 
public interface ImageMapper {

	//***1.리스트 - list()
	public List<ImageDTO> list(PageObject pageObject);
	public int getTotalRow(PageObject pageObject);
	
	//***2.글쓰기 처리 - write(dto)
	public Integer write(ImageDTO dto);
	
	//***3.글보기 - view(no) / increaseHit(no)
	public ImageDTO view(int no);
	public Integer increaseHit(int no); //수정되면 1리턴
	
	//***4.글수정 처리 - update(dto)
	public Integer update(ImageDTO dto);
	
	//***5.글삭제 - delete(dto) ==> no와 pw:post 방식
	public Integer delete(ImageDTO dto);


}
