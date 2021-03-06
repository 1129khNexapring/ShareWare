package org.kh.shareware.member.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.common.Search;
import org.kh.shareware.member.common.PageInfo;
import org.kh.shareware.member.domain.Division;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.member.store.MemberStore;
import org.springframework.stereotype.Repository;

@Repository
public class MemberStoreLogic implements MemberStore{
	
	//로그인
	@Override
	public Member selectLoginMember(SqlSession session, Member member) {
		Member memberOne = session.selectOne("MemberMapper.selectLoginMember", member);
		return memberOne;
	}
	
	//마이페이지
	@Override
	public Member selectOneById(SqlSession session, String memberNum) {
		Member memberOne = session.selectOne("MemberMapper.selectOneById",memberNum);
		return memberOne;
	}
	
	//조직도
	@Override
	public List<Division> selectOrganization(SqlSession sqlSession) {
		List<Division>oList
		= sqlSession.selectList("MemberMapper.selectOrganization");
		return oList;
	}
	//조직도 사원정보
	@Override
	public List<Member> selectOrgInfo(SqlSession sqlSession) {
		List<Member> mList 
		= sqlSession.selectList("MemberMapper.selectAllList");
		return mList;
	}

	//주소록
	@Override
	public List<Member> selectAll(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getMemberLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Member> mList 
			= sqlSession.selectList("MemberMapper.selectAllList", pi, rowBounds);
		return mList;
	}
	@Override
	public int selectListCount(SqlSession sqlSession) {
		int totalCount = sqlSession.selectOne("MemberMapper.selectListCount");
		return totalCount;
	}
	//주소록 검색
	@Override
	public int selectListCount(SqlSession sqlSession, Search search) {
		int totalCount = sqlSession.selectOne("MemberMapper.selectListSearchCount", search);
		return totalCount;
	}
	@Override
	public List<Member> selectAllSearch(SqlSession sqlSession, PageInfo pi, Search search) {
		int limit = pi.getMemberLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Member> mList 
			= sqlSession.selectList("MemberMapper.selectMemberSearch", search, rowBounds);
		return mList;
	}

	// 사원 조회 모달
	@Override
	public List<Member> selectAllMember(SqlSession sqlSession, String memberNum) {
		List<Member> mList = sqlSession.selectList("MemberMapper.selectAllModalMember", memberNum);
		return mList;
	}
	
	// 사원 조회 모달 검색
	@Override
	public List<Member> selectMemberSearch(SqlSession sqlSession, Search search) {
		List<Member> mList = sqlSession.selectList("MemberMapper.selectModalMemberSearch", search);
		return mList;
	}
	
	// 채팅 사용자 추가 초대 모달
	@Override
	public List<Member> selectAllChatMember(SqlSession sqlSession, int chatRoomNo) {
		List<Member> mList = sqlSession.selectList("MemberMapper.selectListChatMember", chatRoomNo);
		return mList;
	}
	
	// 채팅 사용자 추가 초대 모달 검색
	@Override
	public List<Member> selectAllChatMemberSearch(SqlSession sqlSession, Search search) {
		List<Member> mList = sqlSession.selectList("MemberMapper.selectListChatMemberSearch", search);
		return mList;
	}
	
	// 넥사크로 - 관리자
	@Override
	public List<Member> selectAllMemberNexa(SqlSession sqlSession, Search search) { // 사원 전체 조회
		List<Member> mList = sqlSession.selectList("MemberMapper.selectAllListMemberNexa", search);
		return mList;
	}

	@Override
	public int insertMember(SqlSession sqlSession, Member newMember) { // 사원 등록
		int result = sqlSession.insert("MemberMapper.insertMember", newMember);
		return result;
	}

	@Override
	public Member selectOneMember(SqlSession sqlSession, String memberNum) { // 사원 상세 조회
		Member member = sqlSession.selectOne("MemberMapper.selectOneMember", memberNum);
		return member;
	}

	@Override
	public int deleteMember(SqlSession sqlSession, String memberNum) { // 사원 삭제
		int result = sqlSession.delete("MemberMapper.deleteMember", memberNum);
		return result;
	}

	@Override
	public int updateMember(SqlSession sqlSession, Member newMember) { // 사원 정보 수정
		int result = sqlSession.update("MemberMapper.updateMember", newMember);
		return result;
	}

	@Override
	public List<Division> selectAllDivision(SqlSession sqlSession) { // 부서 조회
		List<Division> dList = sqlSession.selectList("MemberMapper.selectAllDivision");
		return dList;
	}

	@Override
	public List<Division> selectOneDivision(SqlSession sqlSession, String divCode) { // 부서 사원 조회
		List<Division> mList = sqlSession.selectList("MemberMapper.selectOneDivision", divCode);
		return mList;
	}

	// 알림
	@Override
	public List<Member> selectAllAlarmMember(SqlSession sqlSession) { // 전체 사원 조회
		List<Member> mList = sqlSession.selectList("MemberMapper.selectListAlarmMember");
		return mList;
	}
	
	// 비밀번호 변경
	@Override
	public int updatePassword(SqlSession sqlSession, Member member) {
		int result = sqlSession.update("MemberMapper.updatePassword", member);
		return result;
	}

}
