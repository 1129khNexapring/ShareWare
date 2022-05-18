
package org.kh.shareware.calendar.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.calendar.domain.CalSch;

public interface CalendarStore {

	

	public int insertSchedule(CalSch calSch, SqlSession sqlSession);

	public List<CalSch> selectAllSchedule(CalSch calSch, SqlSession sqlSession);

	public CalSch selectOneSchedule(SqlSession sqlSession, int schNo);
	
	public int updateSchedule(CalSch calSch, SqlSession sqlSession);
	
	// 홈 - 일정
	public List<CalSch> selectCalList(SqlSession sqlSession, CalSch calSch);

}
