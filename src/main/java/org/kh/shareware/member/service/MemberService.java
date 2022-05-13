package org.kh.shareware.member.service;

import java.util.List;

import org.kh.shareware.common.Search;
import org.kh.shareware.member.domain.Division;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.member.common.PageInfo;

public interface MemberService {

	public Member loginMember(Member member);
	public Member printOneById(String memberNum); //사원정보
	
	public List<Member> printAll(PageInfo pi); //주소록
	public int getListCount(); //페이징
	public List<Division> printOrganization(); //조직도
	public List<Member> printOrgInfo(); //조직도 사원정보
	
	//주소록 검색
	public List<Member> printAllSearch(PageInfo pi); 
	public int getListCountSearch(); //검색 페이징


	public List<Member> modalPrintAll();
	public List<Member> modalPrintSearch(Search search);
}
