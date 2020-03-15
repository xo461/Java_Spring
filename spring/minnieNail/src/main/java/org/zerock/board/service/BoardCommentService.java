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
		return bcmapper.commentList(no);
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

	private int result = 0;
	private int ifInc = 0;
	//좋아요혹은싫어요 추가시1, 이미좋아요 2, 이미싫어요3 리턴
	public int ifLike(Board_rep_likeDTO dto) {
		if (bcmapper.ifLike(dto) == null) { // 좋아요싫어요목록에없으면
			if (dto.getLikeDislike()==0) { //좋아요클릭했으면(0이면)
				result = bcmapper.insertLike(dto); // 좋아요(0) 추가. return 1
				ifInc = bcmapper.incTotalLike(dto); //좋아요수1증가
				System.out.println("BoardCommentService.ifLike().좋아요추가성공여부: "+result);
				System.out.println("BoardCommentService.ifLike().좋아요수1증가성공여부: "+ifInc);
			}
			else { //싫어요클릭했으면(1이면)
				result = bcmapper.insertLike(dto); // 싫어요 추가(1). return 1
				ifInc = bcmapper.incTotalDislike(dto); //싫어요수 1증가 
				System.out.println("BoardCommentService.ifLike().싫어요추가성공여부: "+result);
				System.out.println("BoardCommentService.ifLike().싫어요수1증가성공여부: "+ifInc);
			}
		}

		else {// 좋아요싫어요 기록있으면

			if (bcmapper.ifLike(dto).getLikeDislike() == 0) {// 기존에좋아요한기록이있으면
				result = 2;// 이미좋아요하셧습니다.
				System.out.println("BoardCommentService.ifLike().이미좋아요: "+result);
			} else {
				System.out.println("BoardCommentService.ifLike().이미싫어요: "+result);
				result = 3; // 이미 싫어요하셨습니다.
			}
		}
		return result;
	}
}
