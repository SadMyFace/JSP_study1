package domain;

public class BoardVO {
	
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private String moddate;
	private int readCount;
	
	public BoardVO() {}
	
	// insert : title, writer, content
	// list : bno, title, writer, regdate, readCount
	// update : bno, title, content
	// detail : 전부다
	
	public BoardVO(String title, String writer, String content ) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
	public BoardVO(int bno, String title, String writer, String regdate, int readCount) {
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
		this.readCount = readCount;
	}
	
	public BoardVO(int bno, String title, String content) {
		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	
	public BoardVO(int bno, String title, String writer, String content, String regdate, String moddate, int readCount) {
		this(bno, title, writer, regdate, readCount);
		this.content = content;
		this.moddate = moddate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", moddate=" + moddate + ", readCount=" + readCount + "]";
	}
	
	
}
