package boardmysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.*;

// DAO - DBó���ϴ� business logic
public class BoardDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	String sql = "";

	// Singletone ��ü ���� - �޸� ���� ȿ���� ����
	private static BoardDAO dao = new BoardDAO();

	// private default constructor - �ܺο��� ��ü�� �������� �� �ϵ���
	// �ٸ� ��Ű������ new�� ��ü ���� �Ұ�
	private BoardDAO() {
	};

	// JSP���� dao ��ü�� ����ϱ� ���� method �ۼ�
	public static BoardDAO getDao() {
		return dao;
	}// end of getDao()

	// get connection - method�� �ۼ��ؼ� ȣ��
	private Connection getCon() throws Exception {
		Context ct = new InitialContext();
		DataSource ds = (DataSource) ct.lookup("java:comp/env/jdbc/mysql");

		return ds.getConnection();
	}// end of getCon()

	// ����, ��� ����
	public void insertArticle(BoardDTO dto) throws Exception {
		System.out.println("BoardDAO.insertArtcle().dto : " + dto);
		// 0�̸� ����, 0�� �ƴϸ� ���
		int num = dto.getNum();
		// ����̸� ���� �Ѿ�´�.
		int ref = dto.getRef();
		// ����̸� ���� �Ѿ�´�.
		int re_step = dto.getRe_step();
		// ����̸� ���� �Ѿ�´�.
		int re_level = dto.getRe_level();
		System.out.println("BoardDAO.insertArticle().num : " + num);
		System.out.println("BoardDAO.insertArticle().ref : " + ref);
		System.out.println("BoardDAO.insertArticle().re_step : " + re_step);
		System.out.println("BoardDAO.insertArticle().re_level : " + re_level);

		// �� �׷� ó���ϱ� ���� ����
		int number = 0;

		try {
			// get Connection
			con = getCon();
			// DB�� �׷��Լ� - count, max, min, avg
			// �ִ� �� ��ȣ ���
			pstmt = con.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();

			// ���� �����ϸ�
			if (rs.next()) {
				number = rs.getInt(1) + 1;

				// ó�� �� ���� ��
			} else {
				number = 1; // ref = number
			}

			if (num != 0) {
				sql = "update board set re_step=re_step+1 where ref=? and re_step>?";
				pstmt = con.prepareStatement(sql);
				// ?�� ä���
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();

				re_step = re_step + 1;// �ۼ���
				re_level = re_level + 1;// �۱���=�鿩����

			} else {
				ref = number;
				re_step = 0;
				re_level = 0;
			}// end else
				// mysql: now()
				// mysql: curdate()
				// oracle: sysdate()

			sql = "insert into board(writer, email, subject, passwd, "
					+ " reg_date, ref, re_step, re_level, content, ip) "
					+ " values(?,?,?,?,now(),?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);// ���������� ����.

			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7, re_level);
			pstmt.setString(8, dto.getContent());
			pstmt.setString(9, dto.getIp());

			pstmt.executeUpdate();// ��������

		} catch (Exception ex1) {
			System.out.println("BoardDAO.insertArticle() ���� : " + ex1);

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex3) {
			}
		}// end of try - catch - finally

	}// end of insertArticle()

	public int getArticleCount() throws Exception {
		int x = 0;
		try {
			con = getCon();// Ŀ�ؼ� ���
			pstmt = con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x = rs.getInt(1);// �۰����Ҵ�
			}// endif

		} catch (Exception ex1) {
			System.out.println("getArticleCount()��������" + ex1);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception ex2) {
			}
		}// end finally
		return x;
	}// end getarticlecount()

	// ����Ʈ==============
	public List<BoardDTO> getList(int start, int cnt) throws Exception {
		List<BoardDTO> list = null;
		try {
			con = getCon();// Ŀ�ؼ� ���
			sql = "select * from board order by ref desc, re_step asc limit ?,?"; // ?��°����
																					// ?������ŭ
																					// ������
																					// (0����
																					// ����)
			pstmt = con.prepareStatement(sql);// ������ ���� ����
			pstmt.setInt(1, start - 1); // 0���� �����ؼ� .
			pstmt.setInt(2, cnt);
			rs = pstmt.executeQuery();// ��������

			if (rs.next()) {// ���� ������
				list = new ArrayList<BoardDTO>();
				do {
					BoardDTO dto = new BoardDTO();
					dto.setNum(rs.getInt("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setEmail(rs.getString("email"));
					dto.setSubject(rs.getString("subject"));
					dto.setPasswd(rs.getString("passwd"));

					dto.setReg_date(rs.getTimestamp("reg_date"));

					System.out.println("��¥" + rs.getDate("reg_date"));
					System.out.println("��¥" + rs.getString("reg_date"));
					System.out.println("��¥" + rs.getTimestamp("reg_date"));

					dto.setReadcount(rs.getInt("readcount"));
					dto.setRef(rs.getInt("ref"));
					dto.setRe_step(rs.getInt("re_step"));
					dto.setRe_level(rs.getInt("re_level"));
					dto.setContent(rs.getString("content"));
					dto.setIp(rs.getString("ip"));

					list.add(dto);// dto�� ��°�� list �� ����. �ؿ��� list�� ����.

				} while (rs.next());
			}

		} catch (Exception e) {
			System.out.println("getList()��������:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception ex2) {
			}
		}// end finally
		return list;
	}// end getlist()

	// /�۳��뺸��

	public BoardDTO getArticle(int num) throws Exception {
		BoardDTO dto = null;
		try {
			con = getCon();

			// ��ȸ������
			sql = "update board set readcount=readcount+1 where num=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();// ��������

			// �۳��� ����
			pstmt = con.prepareStatement("select * from board where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setEmail(rs.getString("email"));
				dto.setSubject(rs.getString("subject"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setContent(rs.getString("content"));
				dto.setIp(rs.getString("ip"));

			}
		} catch (Exception ex1) {

		} finally {
			try {

			} catch (Exception ex2) {
				System.out.println(ex2);
			}// fin
		}
		return dto;
	}// getarticle() end

	// �ۼ����� - ������ ���� �ܾ����
	public BoardDTO updateGetArticle(int num) throws Exception {
		BoardDTO dto = null;
		try {
			con = getCon();
			pstmt = con.prepareStatement("select * from board where num=? ");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				dto = new BoardDTO();

				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setEmail(rs.getString("email"));

				dto.setSubject(rs.getString("subject"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				dto.setReadcount(rs.getInt("readcount"));

				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));

				dto.setContent(rs.getString("content"));
				dto.setIp(rs.getString("ip"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("updategetarticle����" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception ex2) {
			}
		}
		return dto;
	} // updategetarticle end

	// db�����ϱ� - ��ȣ ��ġ�ϸ� �� ����

	public int updateArticle(BoardDTO dto) throws Exception {
		String dbPasswd = "";
		int x = -100;
		try {
			con = getCon();
			pstmt = con
					.prepareStatement("select passwd from board where num=? ");
			pstmt.setInt(1, dto.getNum());
			rs = pstmt.executeQuery();// ��������

			if (rs.next()) {
				dbPasswd = rs.getString("passwd");
				if (dbPasswd.equals(dto.getPasswd())) {
					sql = "update board set writer=?, email=?, subject=?, "
							+ " content=? where num = ? ";
					pstmt = con.prepareStatement(sql);

					pstmt.setString(1, dto.getWriter());
					pstmt.setString(2, dto.getEmail());
					pstmt.setString(3, dto.getSubject());
					pstmt.setString(4, dto.getContent());
					pstmt.setInt(5, dto.getNum());

				} else {
					x = 0;
				}// else end
			}// if end
		} catch (Exception e) {
			// TODO: handle exception

		}
		return x;
	}// updateArticle end

	// ----------------
	// �ۻ���
	// ----------------

	public int deleteArticle(int num, String passwd) throws Exception {
		String dbPasswd = "";
		int x = -100;
		try {
			con = getCon();
			pstmt = con
					.prepareStatement("select passwd from board where num=? ");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();// ��������

			if (rs.next()) {
				dbPasswd = rs.getString("passwd");
				if (dbPasswd.equals(passwd)) {
					pstmt = con
							.prepareStatement("delete from board where num=? ");
					pstmt.setInt(1, num);
					pstmt.executeUpdate();// ��������
					x = 1;
				} else {
					x = 0;
				}
			}// try

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("deleteArticle()���ܹ߻�" + e);
		} finally {
			try {

			} catch (Exception e) {
			}// fin end

		}
		return x;
	}// end of deleteArticle()
}// end of BoardDAO class