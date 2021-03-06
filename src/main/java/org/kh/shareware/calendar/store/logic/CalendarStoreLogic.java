
package org.kh.shareware.calendar.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.calendar.domain.CalSch;
import org.kh.shareware.calendar.domain.Calendar;
import org.kh.shareware.calendar.store.CalendarStore;
import org.springframework.stereotype.Repository;

@Repository
public class CalendarStoreLogic implements CalendarStore{



	@Override
	public int insertMySchedule(CalSch calSch, SqlSession sqlSession) {
		int mResult = sqlSession.insert("CalendarMapper.insertMySchedule", calSch);
		return mResult;
	}
	@Override
	public int insertComSchedule(CalSch calSch, SqlSession sqlSession) {
		int cResult = sqlSession.insert("CalendarMapper.insertComSchedule", calSch);
		return cResult;
	}
	@Override
	public int insertDeptSchedule(CalSch calSch, SqlSession sqlSession) {
		int dResult = sqlSession.insert("CalendarMapper.insertDeptSchedule", calSch);
		return dResult;
	}

	@Override
	public List<CalSch> selectAllSchedule(CalSch calSch, SqlSession sqlSession) {
		List<CalSch> sList = sqlSession.selectList("CalendarMapper.selectAllSchedule", calSch);
		return sList;
	}
	@Override
	public List<CalSch> selectAllComSchedule(CalSch calSch, SqlSession sqlSession) {
		List<CalSch> sList = sqlSession.selectList("CalendarMapper.selectAllComSchedule", calSch);
		return sList;
	}
	@Override
	public CalSch selectOneSchedule(SqlSession sqlSession, int schNo) {
		CalSch calSch = sqlSession.selectOne("CalendarMapper.selectOneSchedule", schNo);
		return calSch;
	}
	
	@Override
	public int updateSchedule(CalSch calSch, SqlSession sqlSession) {
		int result = sqlSession.update("CalendarMapper.updateSchedule", calSch);
		return result;
	}
	@Override
	public int deleteSchedule(int schNo, SqlSession sqlSession) { // 일정 삭제
		int result = sqlSession.delete("CalendarMapper.deleteSchedule", schNo);
		return result;
	}
	@Override
	public int registerCalendar(Calendar calendar, SqlSession sqlSession) {
		int result = sqlSession.insert("CalendarMapper.insertCalendar", calendar);
		return result;
	}

	@Override
	public List<Calendar> selectCalMyList(SqlSession sqlSession, Calendar calendar) {
		List<Calendar> cList = sqlSession.selectList("CalendarMapper.selectCalMyList", calendar);
		return cList;
	}

	@Override
	public int deleteCalendar(int calNo, SqlSession sqlSession) {
		int result = sqlSession.delete("CalendarMapper.deleteCalendar", calNo);
		return result;
	}
	
	// 홈 - 일정
	@Override
	public List<CalSch> selectListHomeCal(SqlSession sqlSession, CalSch calSch) { // 일정 목록
		List<CalSch> cList = sqlSession.selectList("CalendarMapper.selectListHomeCal", calSch);
		return cList;
	}

	@Override
	public CalSch selectOneHomeCal(SqlSession sqlSession, int schNo) { // 일정 상세
		CalSch calSch = sqlSession.selectOne("CalendarMapper.selectOneHomeCal", schNo);
		return calSch;
	}

	@Override
	public List<CalSch> selectAllHomeCal(SqlSession sqlSession, String memberNum) { // 전체 일정 목록
		List<CalSch> sList = sqlSession.selectList("CalendarMapper.selectAllHomeCal", memberNum);
		return sList;
	}
	
	// 알림
	@Override
	public CalSch selectLastCalSch(SqlSession sqlSession) { // 최근 전사 일정 조회
		CalSch calSch = sqlSession.selectOne("CalendarMapper.selectLastCalSch");
		return calSch;
	}
	@Override
	public List<CalSch> selectMyCalendar(int calNo, SqlSession sqlSession) {
		List<CalSch> cList = sqlSession.selectList("CalendarMapper.selectCalList", calNo);
		return cList;
	}
	
	
}
