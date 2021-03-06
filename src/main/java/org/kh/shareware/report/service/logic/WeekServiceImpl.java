package org.kh.shareware.report.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.report.domain.Week;
import org.kh.shareware.report.service.WeekService;
import org.kh.shareware.report.store.WeekStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeekServiceImpl implements WeekService {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private WeekStore wStore;
	
	//주간업무 등록 
	@Override
	public int registerWeek(Week week) {
		int result = wStore.insertWeek(week, sqlSession);
		return result;
	}
	//주간업무 목록
	@Override
	public List<Week> printAllWeek(String memNum, PageInfo pi) {
		List<Week> wList = wStore.selectAllWeek(sqlSession , memNum , pi);
		return wList;
	}
	//주간업무 상세
	@Override
	public Week printOneByNo(Integer wrNo) {
		Week week = wStore.selectOneByNo(sqlSession, wrNo);
		return week;
	}
	//주간 업무 수정
	@Override
	public int modifyWeek(Week week) {
		int result = wStore.updateWeek(sqlSession, week);
		return result;
	}
	
	//주간업무 삭제
	@Override
	public int removeWeek(int wrNo) {
		int result = wStore.deleteWeek(sqlSession, wrNo);
		return result;
	}
	//첨부파일 삭제
	@Override
	public int removeFileInfo(Integer wrNo) {
		int result = wStore.deleteFileInfo(sqlSession, wrNo);
		return result;
	}
	//페이징
	@Override
	public int getListCount(String memNum) {
		int totalCount = wStore.selectListCount(sqlSession, memNum);
		return totalCount;
	}

}
