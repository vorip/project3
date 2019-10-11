package com.rt.travel.board.Pagination;

public class PageMaker {

	private Pagination cri;
	private int totalCount; //총 게시글 수
	private int startPage;
	private int endPage; //화면에 보여질 마지막 페이지 번호, 끝 페이지 번호
	private boolean prev;
	private boolean next;
	private int displayPageNum = 5; //화면 하단에 보여지는 페이지의 버튼의 수
	
	public Pagination getCri() {
		return cri;
	}
	
	public void setCri(Pagination cri) {
		this.cri = cri;
	}
	
	public int getTotalCount() {
		return totalCount; //총 게시글 수를 셋팅할때 calcData() 메서드를  호출하여 페이징 관련 버튼 계산
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	
	public void calcData() { //페이징의 버튼들을 생성하는 계산식. 끝 페이지 번호, 시작 페이지 번호, 이전, 다음 버튼들을 구현
		endPage = (int)(Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum); //끝 페이지 번호 = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 갯수) * 화면에 보여질 페이지 번호의 갯수
		int tempEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));	//마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글의 갯수
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		//시작 페이지 번호 = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 갯수) + 1
		startPage = (endPage - displayPageNum) + 1;
		
		prev = startPage == 1 ? false : true; //이전 버튼 생성 여부 = 시작 페이지 번호 == 1 ? false : true
		
		//다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 갯수 >= 총 게시글의 수 ? false : true
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true; //Criteria cri.getPerPageNum() : 한 페이지당 보여줄 게시글의 갯수
																			//Criteria cri.getPage() : 현재 페이지 번호
	}
	
	public int getStartPage() {
        return startPage;
    }
    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }
    public int getEndPage() {
        return endPage;
    }
    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
    public boolean isPrev() {
        return prev;
    }
    public void setPrev(boolean prev) {
        this.prev = prev;
    }
    public boolean isNext() {
        return next;
    }
    public void setNext(boolean next) {
        this.next = next;
    }
    public int getDisplayPageNum() {
        return displayPageNum;
    }
    public void setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
    }

}
