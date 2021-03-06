package org.kh.shareware.notice.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.notice.domain.Notice;

public interface NoticeStore {

	int selectClistCount(SqlSession sqlsession);

	List<Notice> selectAllNotice(SqlSession sqlsession, PageInfo pi);
	//검색 글 개수
	int selectSearchCount(SqlSession sqlsession, Search search);
	//검색
	List<Search> selectSearchNotice(SqlSession sqlsession, Search search, PageInfo pi);
	//조회수 증가
	void countViewNotice(SqlSession sqlsession, Integer noticeNo);
	//상세보기
	Notice selectOneNotice(SqlSession sqlsession, Integer noticeNo);
	// 홈 - 공지사항
	List<Notice> selectAllHomeNotice(SqlSession sqlsession);
	//넥사크로 글 작성
	int insertNotice(SqlSession sqlsession, Notice newNotice);
	//넥사크로 글 수정
	int updateNotice(SqlSession sqlsession, Notice newNotice);
	//넥사크로 리스트
	List<Notice> selectAdminList(SqlSession sqlsession);
	//넥사크로 검색
	List<Notice> selectAdminSearch(SqlSession sqlsession, Search search);
	//넥사크로 상세보기
	Notice selectOneAdminNotice(SqlSession sqlsession, int noticeNo);
	//넥사크로 글 삭제
	int deleteAdminNotice(SqlSession sqlsession, int noticeNo);
	//알림 최근 공지 조회
	public Notice selectOneLastNotice(SqlSession sqlsession);

}
