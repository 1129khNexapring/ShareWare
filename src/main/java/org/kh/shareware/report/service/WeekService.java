package org.kh.shareware.report.service;

import java.util.List;

import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.report.domain.Week;

public interface WeekService {
	
	public int getListCount(String memNum); //페이징
	public int registerWeek(Week week); // 주간업무 등록
	public List<Week> printAllWeek(String memNum, PageInfo pi); // 주간업무 목록
	public Week printOneByNo(Integer wrNo); //주간업무 상세
	public int removeWeek(int wrNo);	//주간업무 삭제
	public int modifyWeek(Week week); // 주간업무 수정 
	public int removeFileInfo(Integer wrNo);  // 첨부파일 삭제

}
