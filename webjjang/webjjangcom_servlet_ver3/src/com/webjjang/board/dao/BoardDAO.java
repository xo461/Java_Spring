package com.webjjang.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.board.dto.BoardReplyDTO;
import com.webjjang.util.idb.DBUtil;
import com.webjjang.util.page.PageObject;

public class BoardDAO {

	// service.BoardListService -> dao.BoardDAO
	// 1. 게시판 리스트 데이터 가져오기
	// 데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런 경우에는 예외처리를 반드시 해야 하므로
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	public List<BoardDTO> list(PageObject pageObject) throws Exception {

		System.out.println("BoardDAO.list()");

		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴타입과 같아야 한다.
		List<BoardDTO> list = null;

		// 데이터 가져오는 처리문
		// 1. 드라이버 확인 // 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 1) 데이터를 정렬시켜서 가져오기.
		String sql = " select no, title, writer, " + " to_char(writeDate, 'yyyy-mm-dd') writeDate , hit "
				+ " from board ";
		// 검색한글내용이 null이 아니고 ""빈칸도 아닐때
		if (pageObject.getWord() != null && !pageObject.getWord().equals("")) {
			sql += " where 1 = 2 ";
			if (pageObject.getKey().indexOf("t") >= 0) // indexof는 글자 위치 찾아주는건데 해당 글자가 없으면 -1이 나옴. 0보다 크거나같다는 건 해당 글자가
														// 있다는 뜻.
				sql += " or title like ? ";
			if (pageObject.getKey().indexOf("c") >= 0)
				sql += " or content like ? ";
			if (pageObject.getKey().indexOf("w") >= 0)
				sql += " or writer like ? ";
		}
		sql += " order by no desc ";
//	    2) 위에서 정렬시킨 데이터에 순서 번호를 붙인다.
		sql = " select rownum rnum, no, title, writer, writeDate, hit from( " + sql + " ) ";
//	    3) 페이지에 맞는 시작 번호와 끝번호 사이의 데이터를 가져온다.
		sql = " select * from ( " + sql + " ) where rnum between ? and ? ";

		System.out.println("BoardDAO.list().sql:" + sql);

		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		int idx = 1;
		if (pageObject.getWord() != null && !pageObject.getWord().equals("")) {
			if (pageObject.getKey().indexOf("t") >= 0) // indexof는 글자 위치 찾아주는건데 해당 글자가 없으면 -1이 나옴. 0보다 크거나같다는 건 해당 글자가
														// 있다는 뜻.
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
			if (pageObject.getKey().indexOf("c") >= 0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
			if (pageObject.getKey().indexOf("w") >= 0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
		}
		pstmt.setInt(idx++, pageObject.getStartRow());
		pstmt.setInt(idx++, pageObject.getEndRow());
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		// 6. 표시 / 저장
		if (rs != null) {
			// rs.next() : 다음 데이터로 넘어가면서 데이터가 있으면 true,없으면 false를 리턴한다.
			while (rs.next()) {
				// 최종적으로 저장할 list가 null이면 생성해서 사용가능하도록 해준다.
				// ArrayList는 list의 일종으로 배열을 사용한다.(연속된 주소)
				if (list == null)
					list = new ArrayList<BoardDTO>();
				// 게시판 하나의 데이터를 담는 객체 생성 ->BoardDTO
				BoardDTO dto = new BoardDTO();
				// 데이터를 담는다. rs에서 꺼내서 dto에
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setHit(rs.getInt("hit"));
				// 리스트 데이터가 여러개 이므로 데이터를 담은 dto를 list에 추가시킨다.
				// 내용을 저장해준다. 이게 업으면 if문끝나면 날라간다.
				list.add(dto);
			} // end of while(rs.next())
		} // end of if(rs == null)

		// 7. 닫기
		con.close();
		pstmt.close();
		rs.close();

		System.out.println("BoardDAO.list().list:" + list);

		return list;
	} // end of list()

	// service.BoardListService -> dao.BoardDAO
	// 1-1. 게시판 리스트 데이터 가져오기 - 전체 데이터의 갯수를 가져오는 메서드
	// 데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런 경우에는 예외처리를 반드시 해야 하므로
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public int getTotalRow(PageObject pageObject) throws Exception {

		System.out.println("BoardDAO.getTotalRow()");

		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴타입과 같아야 한다.
		int totalRow = 0;

		// 데이터 가져오는 처리문
		// 1. 드라이버 확인 // 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다. 전체데이터개수를 세서 cnt에 저장한다.
		String sql = " select count(*) cnt from board ";
		if (pageObject.getWord() != null && !pageObject.getWord().equals("")) {
			sql += " where 1 =2 ";
			if (pageObject.getKey().indexOf("t") >= 0) // indexof는 글자 위치 찾아주는건데 해당 글자가 없으면 -1이 나옴. 0보다 크거나같다는 건 해당 글자가
														// 있다는 뜻.
				sql += " or title like ? ";
			if (pageObject.getKey().indexOf("c") >= 0)
				sql += " or content like ? ";
			if (pageObject.getKey().indexOf("w") >= 0)
				sql += " or writer like ? ";
		}
		System.out.println("BoardDAO.getTotal().sql:" + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		int idx = 1;
		if (pageObject.getWord() != null && !pageObject.getWord().equals("")) {
			sql += " where 1 =2 ";
			if (pageObject.getKey().indexOf("t") >= 0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
			if (pageObject.getKey().indexOf("c") >= 0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
			if (pageObject.getKey().indexOf("w") >= 0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
		}
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		// 6. 표시 / 저장
		// rs.next() : 다음 데이터로 넘어가면서 데이터가 있으면 true,없으면 false를 리턴한다.
		if (rs != null && rs.next()) {
			totalRow = rs.getInt("cnt");
		} // end of if(rs != null && rs.next())

		// 7. 닫기
		DBUtil.close(con, pstmt, rs);

		System.out.println("BoardDAO.getTotalRow().totalRow:" + totalRow);

		return totalRow;
	} // end of gettotalRow()

	// service.BoardViewService -> dao.BoardDAO
	// 2. 게시판 글보기 데이터 가져오기 - 한개 데이터 - 글번호에 따라서 결정(전달 받는다.)
	// 데이터 가져오기가 실패하면 출력하러 갈 수가 없다. 그런 경우에는 예외처리를 반드시 해야 하므로
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public BoardDTO view(int no) throws Exception {

		System.out.println("BoardDAO.view().no:" + no);

		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴타입과 같아야 한다.
		BoardDTO dto = null;

		// 데이터 가져오는 처리문
		// 1. 드라이버 확인 // 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " select no, title, content, writer, " + " to_char(writeDate, 'yyyy-mm-dd') writeDate , hit "
				+ " from board where no = ? ";
		System.out.println("BoardDAO.list().sql:" + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, no);
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		// 6. 표시 / 저장
		// rs.next() : 다음 데이터로 넘어가면서 데이터가 있으면 true,없으면 false를 리턴한다.
		if (rs != null && rs.next()) {
			// 게시판 하나의 데이터를 담는 객체 생성 ->BoardDTO
			dto = new BoardDTO();
			// 데이터를 담는다. rs에서 꺼내서 dto에
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setWriter(rs.getString("writer"));
			dto.setWriteDate(rs.getString("writeDate"));
			dto.setHit(rs.getInt("hit"));
		} // end of if(rs != null && rs.next())

		// 7. 닫기
		DBUtil.close(con, pstmt, rs);

		System.out.println("BoardDAO.list().dto:" + dto);

		return dto;
	} // end of view()

	// 2-1. Controller.main() 2. 글보기를 한 경우 조회수를 1 증가시킨다.
	// service.BoardViewService -> dao.BoardDAO
	// 답변데이터를 넣기 전에 실행해야 한다!!!
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public void increaseHit(int no) throws Exception {

		// 확인해야 할 데이터 - 관련글번호, 순서번호
		System.out.println("BoardDAO.update().no:" + no);

		// 데이터 저장 처리문
		// 1. 드라이버 확인
//				Class.forName(driver);
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();

		// 아래와같은방법으로 사용 가능
		// con.setAutoCommit(false); //기본은 true임
//			con.commit();
//			con.rollback();
//			// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " update board set hit = hit +1 " + " where no = ? ";
		System.out.println("BoardDAO.update().sql:" + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, no);

		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		if (result > 0)
			System.out.println("조회수 1 증가 성공");
		// 순서번호가 3번까지만 있다. 4번을 답변하고자 한다. -> 같거나 큰 데이터가 없으므로 수정되지 않음.
		// 조회수는 반드시 1증가해야함
		else {
			System.out.println("조회수 1 증가 실패");
			throw new Exception("조회수 1 증가 처리 중 오류");
		}
		// 7. 닫기
//				con.close();
//				pstmt.close();
		DBUtil.close(con, pstmt);
	} // end of increaseHit()

	// service.BoardWriteService -> dao.BoardDAO
	// 3. 게시판 글쓰기 데이터 가져오기 - 한개 데이터 전달 받아서 DB에 저장
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public int write(BoardDTO dto) throws Exception {

		System.out.println("BoardDAO.write().dto:" + dto);

		// 데이터 저장 처리문
		// 1. 드라이버 확인 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " insert into board(no, title, content, writer) " + " values(board_seq.nextval, ?, ?, ?) ";
		System.out.println("BoardDAO.write().sql:" + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getWriter());
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글쓰기 성공");

		// 7. 닫기
		con.close();
		pstmt.close();

		return result;
	} // end of write()

	// 4. 게시판 글수정 데이터 가져오기 - 한개 데이터 전달 받아서 DB에 저장
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public void update(BoardDTO dto) throws Exception {

		// 확인해야 할 데이터 - 번호, 제목, 내용, 작성자
		System.out.println("BoardDAO.update().dto:" + dto);

		// 데이터 저장 처리문
		// 1. 드라이버 확인
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " update board set title = ?, content = ?, writer = ? " + " where no = ? ";
		System.out.println("BoardDAO.update().sql:" + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getWriter());
		pstmt.setInt(4, dto.getNo());
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글수정 성공");

		// 7. 닫기
		con.close();
		pstmt.close();

	} // end of update()

	// 5. 게시판 글삭제 데이터 가져오기 - 한개 데이터 전달 받아서 DB에 저장
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public int delete(int no) throws Exception {

		// 확인해야 할 데이터 - 번호, 제목, 내용, 작성자
		System.out.println("BoardDAO.delete().no:" + no);

		// 데이터 저장 처리문
		// 1. 드라이버 확인
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " delete from board where no = ? ";
		System.out.println("BoardDAO.delete().sql:" + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, no);

		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();

		// 6. 표시 / 저장
		System.out.println("글삭제 성공");

		// 7. 닫기
		con.close();
		pstmt.close();
		return result;

	} // end of delete()

	public List<BoardReplyDTO> replyList(int no) throws Exception {

		System.out.println("BoardDAO.replyList().no" + no);

		// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴타입과 같아야 한다.
		List<BoardReplyDTO> list = null;

		// 데이터 가져오는 처리문
		// 1. 드라이버 확인 // 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 1) 데이터를 정렬시켜서 가져오기.
		String sql = " select rno, no, content, writer, " + " to_char(writeDate, 'yyyy-mm-dd') writeDate "
				+ " from board_rep " + " where no=? order by rno desc ";
//				//검색한글내용이 null이 아니고 ""빈칸도 아닐때 
//				if(pageObject.getWord() != null && !pageObject.getWord().equals("")) {
//					sql += " where 1 = 2 ";
//					if (pageObject.getKey().indexOf("t") >= 0) //indexof는 글자 위치 찾아주는건데 해당 글자가 없으면 -1이 나옴. 0보다 크거나같다는 건 해당 글자가 있다는 뜻.
//						sql += " or title like ? ";
//					if (pageObject.getKey().indexOf("c") >= 0)
//						sql += " or content like ? ";
//					if (pageObject.getKey().indexOf("w") >= 0)
//						sql += " or writer like ? ";			
//				}
//				sql += " order by no desc ";
////			    2) 위에서 정렬시킨 데이터에 순서 번호를 붙인다.
//				sql = " select rownum rnum, no, title, writer, writeDate, hit from( " + sql + " ) ";
////			    3) 페이지에 맞는 시작 번호와 끝번호 사이의 데이터를 가져온다.
//				sql = " select * from ( " + sql + " ) where rnum between ? and ? ";

		System.out.println("BoardDAO.replyList().sql:" + sql);

		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		// 5. 실행
		ResultSet rs = pstmt.executeQuery();
		// 6. 표시 / 저장
		if (rs != null) {
			// rs.next() : 다음 데이터로 넘어가면서 데이터가 있으면 true,없으면 false를 리턴한다.
			while (rs.next()) {
				// 최종적으로 저장할 list가 null이면 생성해서 사용가능하도록 해준다.
				// ArrayList는 list의 일종으로 배열을 사용한다.(연속된 주소)
				if (list == null)
					list = new ArrayList<>();
				// 게시판 하나의 데이터를 담는 객체 생성 ->BoardDTO
				BoardReplyDTO dto = new BoardReplyDTO();
				// 데이터를 담는다. rs에서 꺼내서 dto에
				dto.setRno(rs.getInt("rno"));
				dto.setNo(rs.getInt("no"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setWriteDate(rs.getString("writeDate"));
				// 리스트 데이터가 여러개 이므로 데이터를 담은 dto를 list에 추가시킨다.
				// 내용을 저장해준다. 이게 업으면 if문끝나면 날라간다.
				list.add(dto);
			} // end of while(rs.next())
		} // end of if(rs == null)

		// 7. 닫기
		con.close();
		pstmt.close();
		rs.close();

		System.out.println("BoardDAO.replyList().list:" + list);

		return list;
	} // end of list()

	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public int replyWrite(BoardReplyDTO dto) throws Exception {

		System.out.println("BoardDAO.replyWrite().dto:" + dto);

		// 데이터 저장 처리문
		// 1. 드라이버 확인 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " insert into board_rep(rno, no, content, writer) " + " values(board_rep_seq.nextval, ?, ?, ?) ";
		System.out.println("BoardDAO.replyWrite().sql:" + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, dto.getNo());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getWriter());
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("댓글달기 성공");

		// 7. 닫기
		DBUtil.close(con, pstmt); // select인경우에만 resultset 닫음

		return result;
	} // end of write()

	// 4. 게시판 댓글수정 데이터 가져오기 - 한개 데이터 전달 받아서 DB에 저장
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public int replyUpdate(BoardReplyDTO dto) throws Exception {

		// 확인해야 할 데이터 - 번호, 제목, 내용, 작성자
		System.out.println("BoardDAO.replyUpdate().dto:" + dto);

		// 데이터 저장 처리문
		// 1. 드라이버 확인
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " update board_rep set content = ? " + " where rno = ? ";
		System.out.println("BoardDAO.replyUpdate().sql:" + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setString(1, dto.getContent());
		pstmt.setInt(2, dto.getRno());
		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();
		// 6. 표시 / 저장
		if(result == 1)System.out.println("댓글수정 성공");
		else System.out.println("댓글수정 실패");
		// 7. 닫기
		DBUtil.close(con, pstmt);
		return result;
	} // end of update()

	// 5. 게시판 글삭제 데이터 가져오기 - 한개 데이터 전달 받아서 DB에 저장
	// 여기서는 예외처리하지 않고 throw 시키는 것으로 할 수 있다.
	// BoardController : 실행내용 결정 - 데이터 수집 / 데이터 표시
	// BoardController -> Service -> DAO
	public int replyDelete(int rno) throws Exception {

		// 확인해야 할 데이터 - 번호, 제목, 내용, 작성자
		System.out.println("BoardDAO.deleteReply().rno:" + rno);

		// 데이터 저장 처리문
		// 1. 드라이버 확인
		// 2. 연결 객체
		Connection con = DBUtil.getConnection();
		// 3. 실행한 쿼리문작성
		// 쿼리 문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이된다.
		String sql = " delete from board_rep where rno = ? ";
		System.out.println("BoardDAO.replyDelete().sql:" + sql);
		// 4. 실행객체 가져오기 / 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
		// pstmt.setInt(?의 위치, ?를 대체해야할 값)
		pstmt.setInt(1, rno);

		// 5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		int result = pstmt.executeUpdate();

		// 6. 표시 / 저장
		if(result == 1)System.out.println("댓글삭제 성공");
		else System.out.println("댓글삭제 실패");
		// 7. 닫기
		DBUtil.close(con, pstmt);
		return result;

	} // end of delete()

}
