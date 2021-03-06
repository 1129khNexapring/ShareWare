package org.kh.shareware.community.service;

import java.util.List;
import java.util.Map;

import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
import org.kh.shareware.community.domain.CommunityVoteSelect;
import org.kh.shareware.community.domain.Reply;


public interface CommunityService {

	int registerCommunity(Community community);
	int searchComNo();
	//전체 게시물의 갯수
	int getListCount(String memberNum);
	List<Community> listCommunity(PageInfo pi, String memberNum);
	Community detailCommunity(Integer comNo);
	int removeCommunity(int comNo);
	int countViewCommunity(Integer comNo);
	
	
	
	
	
	int registerCommunityVote(CommunityVote communityVote);
	int removeCommunityVote(Integer comNo);
	CommunityVote detailCommunityVote(Integer comNo);
	CommunityVoteSelect viewCommunityVote(CommunityVoteSelect cVoteSelect);
	int endCommunityVote(Integer comNo);
	int registerCVoteSelect(CommunityVoteSelect cVoteSelect);
	int countCVoteSelect(Map<String, Object> map);
	int removeCVoteMember(Integer comNo);
	int modifyCommunity(Community community);
	void modifyCommunityVote(CommunityVote communityVote);
	
	//글 검색 개수
	int getSearchCount(Search search);
	//검색
	List<Search> printSearchCommunity(PageInfo pi, Search search);
	//덧글
	//리스트 보기
	List<Reply> printAllCommunityReply(int comNo);
	//등록
	int registerReply(Reply reply);
	//자신이 쓴 댓글 삭제
	int deleteReply(Reply reply);
	//댓글 전체 삭제
	void removeReplyAll(Integer comNo);
	//댓글 수정
	int modifyReply(Reply reply);
	
	
	

	
	
	
	

}
