package com.kh.product.model.vo;

public class PAttachment {
//	FILE_NO	NUMBER
//	REF_PNO	NUMBER
//	ORIGIN_NAME	VARCHAR2(500 BYTE)
//	CHANGE_NAME	VARCHAR2(500 BYTE)
//	FILE_PATH	VARCHAR2(1000 BYTE)
//	FILE_LEVEL	NUMBER
	
	private int fileNo;
	private int refPno;
	private String originName;
	private String changeName;
	private String filePath;
	private int fileLevel;
	
	public PAttachment() {
		super();
	}

	public PAttachment(int fileNo, int refPno, String originName, String changeName, String filePath, int fileLevel) {
		super();
		this.fileNo = fileNo;
		this.refPno = refPno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.fileLevel = fileLevel;
	}
	
	public PAttachment(int fileNo, String originName, String filePath) {
		super();
		this.fileNo = fileNo;
		this.originName = originName;
		this.filePath = filePath;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getRefPno() {
		return refPno;
	}

	public void setRefPno(int refPno) {
		this.refPno = refPno;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	@Override
	public String toString() {
		return "P_Attachment [fileNo=" + fileNo + ", refPno=" + refPno + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", fileLevel=" + fileLevel + "]";
	}
	
}
