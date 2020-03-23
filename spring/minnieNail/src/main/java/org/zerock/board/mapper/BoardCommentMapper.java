package org.zerock.board.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.board.dto.Board_repDTO;
import org.zerock.board.dto.Board_rep_likeDTO;

public interface BoardCommentMapper {
	
	//댓글리스트
	public List<Board_repDTO> commentList(int no);
	//내가좋아요/싫어요한 댓글리스트
	//★파라메터 여러개 넘길때는 @Param("이름") 지정해줘야 인식.(아니면 ibatis.binding.BindingException 오류)
	public List<Board_rep_likeDTO> commentLikeList(@Param("no") int no, @Param("id") int id);

    public int commentInsert(Board_repDTO dto);

	public int commentUpdate(Board_repDTO dto);

	public int commentDelete(int rep_no);
	

	//좋아요한적있는지 확인
	public Board_rep_likeDTO ifAlreadyLike(Board_rep_likeDTO dto);
	//db에서 좋아요/싫어요 삭제
	public int cancelLike(Board_rep_likeDTO dto);
	
	//좋아요0, 싫어요1 추가
	public int insertLike(Board_rep_likeDTO dto);

	//좋아요, 싫어요 총개수 1 증가, 감소
	public int incTotalLike(Board_rep_likeDTO dto);
	public int incTotalDislike(Board_rep_likeDTO dto);
	public int decTotalLike(Board_rep_likeDTO dto);
	public int decTotalDislike(Board_rep_likeDTO dto);
	

}
