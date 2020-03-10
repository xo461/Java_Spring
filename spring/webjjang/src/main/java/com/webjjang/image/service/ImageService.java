package com.webjjang.image.service;

import java.util.List;
import com.webjjang.image.dto.ImageDTO;
import com.webjjang.util.page.PageObject;

//서비스는 컨트롤러용..컨트롤러가 호출해서 사용할것이니.. 
//mapper는 db용... 서비스에서는 내가 하고싶은것만 적는다면, mapper에는 그 하고싶은걸 햇을때 db딴에서 추가적으로 적용되는걸 다 담음..
public interface ImageService {
	
	//***1.리스트 - list()
	public List<ImageDTO> list(PageObject pageObject);
	
	//***2.글쓰기 처리 - write(dto)
	public Integer write(ImageDTO dto);
	
	//***3.글보기 - view(no) / increaseHit(no)
	public ImageDTO view(int no);
	
	//***4.글수정 처리 - update(dto)
	public Integer update(ImageDTO dto);
	
	//***5.글삭제 - delete(dto) ==> no와 pw:post 방식
	public Integer delete(ImageDTO dto);

	
}
