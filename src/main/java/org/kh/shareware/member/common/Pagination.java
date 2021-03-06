package org.kh.shareware.member.common;


public class Pagination {
	public static PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		int memberLimit = 10;
		int naviLimit = 10;
		int maxPage;
		int startNavi;
		int endNavi;
		boolean prev, next;
		maxPage = (int)((double)totalCount/memberLimit + 0.9);
		startNavi = (((int)((double)currentPage/naviLimit+0.9))-1)*naviLimit+1;
		endNavi = startNavi + naviLimit - 1;
		prev = startNavi > 1;
		next = endNavi < maxPage; 
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		
		pi = new PageInfo(currentPage, memberLimit, naviLimit, startNavi, endNavi, totalCount, maxPage,prev, next, null, null, null);
		return pi;
	}
}
