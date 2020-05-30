package burger;

import java.util.Date;

public class boardVO {
	private int idx;
	private String id;
	private String memo;
	private Date writeDate;
	private int starPoint;
	private String Filename;
	
	
	public boardVO() {
		
	}
	
	public boardVO(String id, String memo, int starPoint, String filename) {
		this.id = id;
		this.memo = memo;
		this.starPoint = starPoint;
		Filename = filename;
	}


	public String getFilename() {
		return Filename;
	}
	public void setFilename(String filename) {
		Filename = filename;
	}
	public int getStarPoint() {
		return starPoint;
	}
	public void setStarPoint(int starPoint) {
		this.starPoint = starPoint;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		String str = "["+this.getIdx()+"]\n이름: "+this.getId()+ this.getWriteDate() +"\n별점: "+this.getStarPoint()+"\n후기: "+this.getMemo();
		
		return str;
	}
	
	

}
