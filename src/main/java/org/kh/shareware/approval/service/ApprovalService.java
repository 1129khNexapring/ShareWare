package org.kh.shareware.approval.service;

import java.util.List;

import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.domain.AppFile;
import org.kh.shareware.approval.domain.AppForm;
import org.kh.shareware.approval.domain.AppReference;
import org.kh.shareware.approval.domain.Approval;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Search;

public interface ApprovalService {

	public int registerDoc(AppDocument appDoc); // 기안서 등록
	public int registerApp(Approval app); // 결재자 등록
	public int registerRef(AppReference ref); // 참조자 등록
	public int registerFile(AppFile file); // 파일 등록
	public AppForm printForm(int formNo); // 문서 양식 조회
	public List<AppForm> printAllForm(); // 문서 양식 전체 조회
	public String printOneLeaveDoc(String memberNum); // 휴가 신청서 조회(잔여 연차)
	public List<AppDocument> printAll(AppDocument appDoc, PageInfo pi); // 기안 문서 조회(기안 문서함)
	public int getListCount(AppDocument appDoc); // 문서함 페이징
	public List<AppDocument> printSearchDraft(Search search, PageInfo pi); // 기안 문서함 검색
	public int getSearchDraftCount(Search search); // 기안 문서함 검색 페이징
	public AppDocument printOneDoc(int docNo); // 기안 문서함 상세 조회
	public List<Approval> printAllApp(int docNo); // 기안 문서함 상세 조회(결재자)
	public List<AppReference> printAllRef(int docNo); // 기안 문서함 상세 조회(참조자)
	public int removeDoc(int docNo); // 상신 취소
	public AppFile printOneFile(int docNo); // 기안 문서함 상세 조회(파일)

}
