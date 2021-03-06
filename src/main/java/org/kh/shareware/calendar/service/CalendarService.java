
package org.kh.shareware.calendar.service;

import java.util.List;

import org.kh.shareware.calendar.domain.CalSch;
import org.kh.shareware.calendar.domain.Calendar;

public interface CalendarService {

	
	// 개인 일정 등록
	public int registerMySchedule(CalSch calSch);
	// 전사 일정 등록
	public int registerComSchedule(CalSch calSch);
	//부서 일정 등록
	public int registerDeptSchedule(CalSch calSch);
	public List<CalSch> printAllSchedule(CalSch calSch);

	public CalSch printOneSchedule(int schNo);
	
	public int modifySchedule(CalSch calSch);
	
	public int deleteSchedule(int schNo);
	
	public int registerCalendar(Calendar calendar);
	// 내 캘린더 메뉴바에서 조회
	public List<Calendar> printAllMyCalendar(Calendar calendar);
	// 메뉴 캘린더 삭
	public int deleteCalendar(int calNo);
	
	// 홈 - 일정
	public List<CalSch> printListHomeCal(CalSch calSch); // 일정 목록
	
	public CalSch printOneHomeCal(int schNo); // 일정 상세

	public List<CalSch> printAllHomeCal(String memberNum); // 전체 일정 목록
	
	// 알림
	public CalSch printLastCalSch(); // 최근 전사 일정 조회
	
	//내 캘린더 조회
	public List<CalSch> printMyCalendar(int calNo);
	//전사 일정 조회
	public List<CalSch> printAllComSchedule(CalSch calSch);
	



	

}
