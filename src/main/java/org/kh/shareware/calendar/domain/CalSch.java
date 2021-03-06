package org.kh.shareware.calendar.domain;



public class CalSch {
	private int schNo;
	private String memNum;
	private String calNo;
	private String schName;
	private String schStartDate;
	private String schStartTime;
	private String schEndDate;
	private String schEndTime;
	private String schContent;
	private String schCate;
	private String schColor;
	
	
	
	public CalSch() {}



	public CalSch(int schNo, String memNum, String calNo, String schName, String schStartDate, String schStartTime,
			String schEndDate, String schEndTime, String schContent, String schCate, String schColor) {
		super();
		this.schNo = schNo;
		this.memNum = memNum;
		this.calNo = calNo;
		this.schName = schName;
		this.schStartDate = schStartDate;
		this.schStartTime = schStartTime;
		this.schEndDate = schEndDate;
		this.schEndTime = schEndTime;
		this.schContent = schContent;
		this.schCate = schCate;
		this.schColor = schColor;
	}



	public int getSchNo() {
		return schNo;
	}



	public void setSchNo(int schNo) {
		this.schNo = schNo;
	}



	public String getMemNum() {
		return memNum;
	}



	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}



	public String getCalNo() {
		return calNo;
	}



	public void setCalNo(String calNo) {
		this.calNo = calNo;
	}



	public String getSchName() {
		return schName;
	}



	public void setSchName(String schName) {
		this.schName = schName;
	}



	public String getSchStartDate() {
		return schStartDate;
	}



	public void setSchStartDate(String schStartDate) {
		this.schStartDate = schStartDate;
	}



	public String getSchStartTime() {
		return schStartTime;
	}



	public void setSchStartTime(String schStartTime) {
		this.schStartTime = schStartTime;
	}



	public String getSchEndDate() {
		return schEndDate;
	}



	public void setSchEndDate(String schEndDate) {
		this.schEndDate = schEndDate;
	}



	public String getSchEndTime() {
		return schEndTime;
	}



	public void setSchEndTime(String schEndTime) {
		this.schEndTime = schEndTime;
	}



	public String getSchContent() {
		return schContent;
	}



	public void setSchContent(String schContent) {
		this.schContent = schContent;
	}



	public String getSchCate() {
		return schCate;
	}



	public void setSchCate(String schCate) {
		this.schCate = schCate;
	}



	public String getSchColor() {
		return schColor;
	}



	public void setSchColor(String schColor) {
		this.schColor = schColor;
	}



	@Override
	public String toString() {
		return "CalSch [schNo=" + schNo + ", memNum=" + memNum + ", calNo=" + calNo + ", schName=" + schName
				+ ", schStartDate=" + schStartDate + ", schStartTime=" + schStartTime + ", schEndDate=" + schEndDate
				+ ", schEndTime=" + schEndTime + ", schContent=" + schContent + ", schCate=" + schCate + ", schColor="
				+ schColor + "]";
	}
	
}
