package org.zerock.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.board.dto.Board_repDTO;
import org.zerock.board.dto.Board_rep_likeDTO;
import org.zerock.board.mapper.BoardCommentMapper;

@Service("org.zerock.board.service.BoardCommentService")
public class BoardCommentService {

	@Inject
	BoardCommentMapper bcmapper;

	// 댓글리스트*********
	public List<Board_repDTO> commentList(int no) throws Exception {
		// System.out.println("BoardCommentService.commentList:"+bcmapper.commentList(no));
		System.out.println("BoardCommentService.commentList().no: "+no);
		return bcmapper.commentList(no);
	}

	// 글번호no에 대한 댓글들을 좋아한 목록
	public List<Board_rep_likeDTO> commentLikeList(int no, Integer id) {
		System.out.println("BoardCommentService.commentLikeList().no: "+no);
		System.out.println("BoardCommentService.commentLikeList().id: "+id);
		return bcmapper.commentLikeList(no, id);
	}

	// **** 댓글달기
	public Integer commentInsert(Board_repDTO dto) throws Exception {
		// System.out.println("BoardCommentService.commentInsert성공여부:
		// "+bcmapper.commentInsert(dto)); //이렇게 쓰면 두번 삽입된다.
		return bcmapper.commentInsert(dto);
	}

	public int commentUpdate(Board_repDTO dto) {
		// TODO Auto-generated method stub
		return bcmapper.commentUpdate(dto);
	}

	public int commentDelete(int rep_no) {
		return bcmapper.commentDelete(rep_no);
	}

	//좋아요/싫어요버튼클릭시:
	private int result = 0; // 이미좋아요시 2, 이미싫어요 3, 좋아요/싫어요 적용 성공1 넘길 예정
	// 넘어오는값: 좋아요버튼 클릭시likedislike=0, 싫어요 버튼 클릭시likedislike=1
	public int ifLike(Board_rep_likeDTO dto, int likeDislike) {

		// 이미 좋아요 0 이미싫어요 1 기록없음 null(
		Board_rep_likeDTO alreadydto = bcmapper.ifAlreadyLike(dto);
		int ifAlready = alreadydto.getLikeDislike();

		if (likeDislike == 0) {// 좋아요클릭시
			if (ifAlready == 0) {// 이미좋아요
				bcmapper.cancelLike(dto); // db에서 좋아요 삭제
				result = 2;
			} else if (ifAlready == 1) {// 이미싫어요
				result = 3;
			} else {// 기록없음
				dto.setLikeDislike(0); // 좋아요추가
				bcmapper.insertLike(dto);
				result = bcmapper.insertLike(dto); // 좋아요(0) 추가. return 1
			}

		} else {// 싫어요 클릭시
			if (ifAlready == 0) {// 이미좋아요
				result = 2;
			} else if (ifAlready == 1) {// 이미싫어요
				bcmapper.cancelLike(dto); // db에서 좋아요 삭제
				result = 3;
			} else {// 기록없음
				dto.setLikeDislike(1); // 싫어요추가
				bcmapper.insertLike(dto);
				result = bcmapper.insertLike(dto); // 싫어요 추가(1). return 1
			}
		}
		return result;
	}
}
