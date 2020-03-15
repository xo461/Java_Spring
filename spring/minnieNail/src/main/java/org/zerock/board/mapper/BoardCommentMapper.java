package org.zerock.board.mapper;
import java.util.List;
import org.zerock.board.dto.Board_repDTO;
import org.zerock.board.dto.Board_rep_likeDTO;

public interface BoardCommentMapper {

	public List<Board_repDTO> commentList(int no);

    public int commentInsert(Board_repDTO dto);

	public int commentUpdate(Board_repDTO dto);

	public int commentDelete(int rep_no);

	//좋아요한적있는지 확인
	public Board_rep_likeDTO ifLike(Board_rep_likeDTO dto);

	//좋아요0, 싫어요1 추가
	public int insertLike(Board_rep_likeDTO dto);

	//좋아요, 싫어요 수 1 증가
	public int incTotalLike(Board_rep_likeDTO dto);
	public int incTotalDislike(Board_rep_likeDTO dto);
	

}
