package kr.or.ddit.ui;

import kr.or.ddit.emp.vo.Pagination;

public class BootstrapPaginationRenderer implements PaginationRenderer {

	private final String DISABLEPTRN = "<li class='page-item disabled'><span class='page-link'>%s</span></li>";
	private final String PATTERN = "<li class='page-item'><a class='page-link' href=':;' onclick='return fn_paging(%d, event);'>%s</a></li>";
	private final String ACTIVEPTRN = "<li class='page-item active' aria-current='page'><span class='page-link'>%d</span></li>";
	
	@Override
	public String renderPagination(Pagination pagination) {
		int startPage = pagination.getStartPage();
		int endPage = pagination.getEndPage();
		int totalPage = pagination.getTotalPage();
		int lastPage = endPage > totalPage ? totalPage : endPage;
		int blockSize = pagination.getBlockSize();
		StringBuffer html = new StringBuffer();
		html.append("<nav aria-label='...'>");
		html.append(" <ul class='pagination'>");
		if(startPage > blockSize) {
			html.append(
				String.format(PATTERN,  startPage - blockSize , "이전")
			);
		}else {
			html.append(
				String.format(DISABLEPTRN,  "이전")
			);
			
		}
		for(int page = startPage; page <= lastPage; page++) {
			if(page == pagination.getCurrentPage()) {
				html.append(String.format(ACTIVEPTRN, page));
			}else {
				html.append(
					String.format(PATTERN, page, page)	
				);
				
			}
		}
		
		if(lastPage < totalPage) {
			html.append(
				String.format(PATTERN,  lastPage + 1 , "다음")
			);
		}else {
			html.append(
				String.format(DISABLEPTRN,  "다음")
			);
		}
		html.append("</ul>");
		html.append("</nav>");
		return html.toString();
	}

}














