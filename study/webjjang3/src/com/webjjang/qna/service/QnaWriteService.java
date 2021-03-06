/*qnawrite service: 질문하기 처리
 * 
 */

package com.webjjang.qna.service;

import com.webjjang.main.Service;
import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.dto.QnaDTO;

public class QnaWriteService implements Service{

	private QnaDAO dao;
	public QnaWriteService(QnaDAO dao) {
		this.dao = dao;
	}
	@Override
	// 데이터 Controller <-> DAO
	// 입력받은 글(QnaDTO)를 Controller 에서 받아서 처리한다.
	public Integer service(Object[] objs) throws Exception{
		// 전달된 데이터의 변환
		QnaDTO dto = (QnaDTO)objs[0];
		// 데이터 처리부분에 해당된다.
		System.out.println("QnaWriteService.service()");
		
		// 게시판 글쓰기에서 오류가 나고 있다는 처리를 할때 예외처리를 해준다.
		// - 예외가 발생이되면 알맞은 메시지로 바꿔서 던진다.
		try {
			// Beans에서 생성된 dao를 생성자를 통해서 전달받고 호출한다. 
			// 데이터Controller에서 오라클에 저장하기 위해서 객체를 생성하고 호출한다.
			// QnaController - QnaWriteService - [QnaDAO]
			return dao.write(dto);
		} catch (Exception e) {
			// TODO: handle exception
			// 상세한 내용의 예의메시지를 셋팅해서 다시 던지기를 할 수 있다.
//			throw new Exception("질문하기 중 오류가 발생되었습니다.");
			throw e;
		}
	}
	
}
