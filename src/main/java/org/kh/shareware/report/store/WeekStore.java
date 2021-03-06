package org.kh.shareware.report.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.report.domain.Week;

public interface WeekStore {

	public int insertWeek(Week week, SqlSession sqlSession); //주간 업무 등록
	public List<Week> selectAllWeek(SqlSession sqlSession, String memNum, PageInfo pi);  //주간 업무 목록
	public Week selectOneByNo(SqlSession sqlSession, Integer wrNo); //주간 업무 상세 
	public int deleteWeek(SqlSession sqlSession, int wrNo);	//주간 업무 삭제
	public int updateWeek(SqlSession sqlSession, Week week); //주간 업무 수정
	public int deleteFileInfo(SqlSession sqlSession, Integer wrNo);  //첨부파일 삭제 
	public int selectListCount(SqlSession sqlSession, String memNum); //페이징

}
