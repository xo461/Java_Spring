/**
 * 페이지 처리를 위한 객체
 * - 페이지 처리
 * 작성일 : 2019-11-28
 * 작성자 : 이영환
 */

package com.webjjang.util.page;

public class PageObject {

	// === java 부분의 페이지 처리를 위한 변수==============================================
	// 현재 페이지
	private int page;
	// 한 페이지에 표시할 데이터의 갯수(default 10개)
	private int perPageNum;
	// 현재 페이지에서 첫번째 게시글의 글번호
	private int startRow;
	// 현재 페이지에서 마지막번째 게시글의 글번호
	private int endRow;
	
	// == jsp 에서 사용할 페이지처리 변수===================================================
	// totalRow: 전체 데이터의 갯수 - dao에서 count(*) -> service에서 데이터를 셋팅.
	private int totalRow; 
	
	// totalPage: 전체 페이지 - totalRow 데이터가 들어오면 자동으로 계산하도록 한다. setTotalRow() 작성
	private int totalPage;
	
	// perGroupPageNum: 하단 부분의 페이지 링크부분(페이지네이션)에 나타날 페이지의 갯수 -> perGroupPageNum
	// 페이지그룹 5개면  ---1 2 3 4 5----나타나고 그 뒷장에 6 7 8 9 10 ..이런식으로
	private int perGroupPageNum;
	
	// pagenation에서 보이는 페이지그룹 - 현재 페이지에 따라 다른게 설정된다.
	// 12345 678910 이런식으로 다셧개씩 묶여있으면 만약 현재페이지가 6이면 678910이 보인다. 이떄 startPage가 6 endPage가 10 만약 totalpage가 8이면 endpage도 8이 된다.
	private int startPage; //페이지그룹의 첫번째페이지 
	private int endPage; //endPage가 totalPage를 넘는 경우는 endPage를 totalPage로 변경
	
	// ======= 검색에 필요한 데이터 변수===============================================================
	private String key; //t, c, w
	private String word; //실제 검색한 단어
	
	
	// 기본 값을 셋팅하기 위한 기본 생성자
	// 처음 들어가거나 현재페이지,페이지당데이터를 설정안하면 - 뷰에서 넘어오는 데이터 없음 - 파라메터가 없는 기본 생성자가 적용된다.
	public PageObject() {
		// 현재 1 페이지, 페이지당 게시글 10 개 보이게.(개발자가 정한다.)
		this(1,10);
		// 기본생성자밖에 없었다면 아래와 같이 값넣을 변수를 지정해줘야 하지만, 밑에 추가 생성자가 있어서, 거기에 선언해준 애들이 override된다.
		//	this.page = 1;
		//	this.perPageNum = 10;
	}
	
	// 파라메터 2개 넘기는 생성자
	// 현재 페이지와 한 페이지당 표시하는 데이터의 갯수를 전달받아서 처리
	public PageObject(int page, int perPageNum) {
		// 현재 페이지와 한 페이지당 표시하는 데이터의 갯수를 전달받아서 처리한다.
		this(page, perPageNum, 10);
	}
	
	//한 그룹당 몇개의페이지가 보일지까지 셋팅하는 이 메소드는 활용안한다.
	public PageObject(int page, int perPageNum, int perGroupPageNum) {
		this.page = page; //이 클래스의 page 변수에 뷰에서 받은 파라메터 값(사용자가 클릭한 페이지) 넣는다.
		this.perPageNum = perPageNum;
		this.perGroupPageNum = perGroupPageNum;
		// 현재 페이지의 시작 줄번호 계산 (현재 3페이지이고 페이지당 게시글 10개이면 startRow: (3-1)*10+1 = 21)
		// 시작 줄번호 = 이전페이지의 갯수를 넘긴 다음 번호 : (page-1)*perPageNum + 1
		this.startRow = (page - 1) * perPageNum + 1;
		// 끝 줄번호 = 시작 줄번호에다가 한페이지당 표시하는 데이터의 갯수 더하면 다음 페이지의 시작 번호가 되는데
		// 여기서 1 빼주면 현재 페이지의 마지막 번호가 된다.
		this.endRow = this.startRow + perPageNum - 1;
//		this.endRow = page * perPageNum; // 위에 문장과 같다.
	}

	//getter: 1. 변수 선언 2. 뷰에서 전달받은 데이터를 dto로 저장해놓는데, 이걸 가져다가 변수에 저장할 수 있게 하기 위함. page = dto.getPage()???????????
	public int getPage() {
		return page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}
	
	// 리스트 표시 요청이 있을 때마다 새로운 PageObjec 객체가 새로 생성이 되므로 처리하는 동안에는 변경되지 않는다.
	// 생성자에서 데이터를 처리하도록 작성한다. -> Spring에서는 setter를 만들어서 해야한다.

	public void setPage(int page) {
		this.page = page; //뷰에서 받아온 페이지를 this클래스의 page변수에 넣는다.
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	// 넘어온 페이지에 해당하는 게시글의 글번호 구하는 메서드
	// 뷰에서 넘어온 page, perPageNum 있으면 구할수있다.
	public void calcuPageInfo() {
		// 현재 페이지의 첫번째 글번호 :
		startRow = (page - 1) * perPageNum + 1;
		// 현재페이지의 마지막 게시글의 글번호:
		endRow = startRow + perPageNum - 1;
	}
	
	public int getTotalRow() {
		return totalRow;
	}

	// 전체페이지수, 페이지그룹의 startpage, endpage구하기
	// db에서 전체 데이터의 갯수(totalRow)가 넘어오고, 
	// 뷰에서 현재페이지page, 페이지당데이터수(10개)가 넘어오고
	// 페이지그룹당페이지수(10페이지)가 정해지면 구할 수 있다. 
	// service에서 계산하는 것으로 한다.
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
		this.totalPage = (totalRow - 1) / perPageNum + 1;
		// 시작페이지
		// page = 1 -> (1-1) => 0 / 10 => 0 * 10 => 0 + 1 => 1
		// page = 5 -> (5-1) => 4 / 10 => 0 * 10 => 0 + 1 => 1
		// page = 9 -> (9-1) => 8 / 10 => 0 * 10 => 0 + 1 => 1
		// page = 10 -> (10-1) => 9 / 10 => 0 * 10 => 0 + 1 => 1
		this.startPage = (page - 1) / perGroupPageNum * perGroupPageNum + 1;
		// 끝페이지
		this.endPage = startPage + perGroupPageNum - 1;
		// 끝페이지가 전체 페이지 보다 큰 경우 조정
		if(endPage > totalPage)
			this.endPage = totalPage; 
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word.trim();
	}

	// 데이터 확인용.
	@Override
	public String toString() {
		return "PageObject [page=" + page + ", perPageNum=" + perPageNum + ", startRow=" + startRow + ", endRow="
				+ endRow + ", totalRow=" + totalRow + ", totalPage=" + totalPage + ", perGroupPageNum="
				+ perGroupPageNum + ", startPage=" + startPage + ", endPage=" + endPage + ", key=" + key + ", word="
				+ word + "]";
	}

	// page 문자열과 perPageNum 문자열 받아서 객체를 생성해 주는 메서드 (get메소드로 받으므로 String타입이다. - > int로바꿔준다.)
	public static PageObject getInstance(String strPage, String strPerPageNum) {
		PageObject pageObject = null;
		// 처음 게시판으로 들어오거나 페이지 데이터가 넘어오기 않으면 1페이지로 간주한다.: 파라메터 안넘기므로 이에 해당하는 기본생성자 사용 -> (1,10)
		if(strPage == null || strPage.equals("")) {
			pageObject = new PageObject(); // page : 1, perPageNum : 10
		} else {
			int page = Integer.parseInt(strPage);
			// 한페이지당 데이터의 갯수가 넘어 오지 않는 경우 처리 : 기본 개수 10으로 셋팅한다.
			if (strPerPageNum == null || strPerPageNum.equals("")) {
				strPerPageNum = "10";
			}
			int perPageNum = Integer.parseInt(strPerPageNum);
			//page, perPageNum 뷰에서 넘어왔으므로 파라메터 2개 넘기는 생성자가 활용된다.
			pageObject = new PageObject(page, perPageNum);
		}
		
		System.out.println("PageObject.getInstance.pageObject:"+pageObject);
		
		return pageObject;
	}
	
}
