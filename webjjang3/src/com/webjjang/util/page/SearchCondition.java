/**
 *  검색에 필요한 메서드 선언.
 *  리스트 데이터를 가져올 때 뿐아니라 전체 글 갯수를 가져 올 때도 사용해야 하므로 메서드로 만들어 사용하면 좋다.
 *  getSearchSQLWithWhere() : 검색을 SQL쿼리에 추가하는 메서드'
 *   사용예 )
 *    sql += SearchCondition.getSearchSQLWithWhere(pageObject);
 *  
 *  setPreparedStatement() : PreparedStatement 객체에 데이터를 셋팅하는 메서드
 *   사용예 )
 *    idx = 1;
 *    idx = SearchCondition.setPreparedStatement(pstmt, pageObject, idx);
 */
package com.webjjang.util.page;

import java.sql.PreparedStatement;

public class SearchCondition {

	// 검색을 SQL쿼리에 추가하는 메서드
	public static String getSearchSQLWithWhere(PageObject pageObject) {
		System.out.println("SearchCondition.getSearchSQLWithWhere()");
		String sql = "";
		if(pageObject.getWord() != null && !pageObject.getWord().equals("")) {
			sql += " where 1 = 2 ";
			if(pageObject.getKey().indexOf("t") >= 0)
				sql += " or title like ? ";
			if(pageObject.getKey().indexOf("c") >= 0)
				sql += " or content like ? ";
			if(pageObject.getKey().indexOf("w") >= 0)
				sql += " or writer like ? ";
			if(pageObject.getKey().indexOf("i") >= 0)
				sql += " or id like ? ";
		}
		return sql;
	}
	
	// 실행객체에 검색 데이터를 셋팅하는 메서드
	public static int setPreparedStatement(PreparedStatement pstmt, 
			PageObject pageObject, int idx) throws Exception {
		if(pageObject.getWord() != null && !pageObject.getWord().equals("")) {
			if(pageObject.getKey().indexOf("t") >= 0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
			if(pageObject.getKey().indexOf("c") >= 0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
			if(pageObject.getKey().indexOf("w") >= 0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
		}
		return idx;
	}
	
}
