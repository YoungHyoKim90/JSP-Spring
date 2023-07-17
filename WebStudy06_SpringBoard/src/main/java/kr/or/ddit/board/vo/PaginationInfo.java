package kr.or.ddit.board.vo;

import java.text.MessageFormat;
import java.util.List;

import lombok.Getter;

/**
 * 페이징 처리와 관련된 모든 속성을 가진 객체
 *
 */
@Getter
public class PaginationInfo<T> {
	private long totalRecord; // DB 조회
	private int screenSize = 10;
	private int blockSize = 5;
	
	private long totalPage; // 연산1
	private long currentPage; // request parameter
	
	private long startRow; // 연산2
	private long endRow; // 연산3
	
	private long startPage; // 연산4
	private long endPage; // 연산5
	
	private List<T> dataList;
	
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
		this.totalPage = (totalRecord + screenSize-1 )/ screenSize;
	}
	
	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
		
		this.endRow = currentPage * screenSize;
		this.startRow = endRow - (screenSize - 1);
		
		this.endPage = ( (currentPage + blockSize-1 ) / blockSize ) * blockSize; 
		this.startPage = endPage - (blockSize - 1);
	}
	
	
	String htmlPattern = "<a href=''?page={0}''>{1}</a>";
	public String getPagingHTML() {
		StringBuilder html = new StringBuilder();
		
		if(startPage>1) {
			html.append(
				MessageFormat.format(htmlPattern, startPage-1, "이전")	
			);
		}
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		for(long page = startPage; page <= endPage; page++ ) {
			html.append(
				MessageFormat.format(htmlPattern, page, page)	
			);
		}
		
		if(endPage < totalPage) {
			html.append(
				MessageFormat.format(htmlPattern, endPage+1, "다음")	
			);
		}
		
		return html.toString();
	}
}





























