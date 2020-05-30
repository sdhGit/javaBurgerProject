package burger;

import java.sql.Date;

public class MenuVO {
	static int i=0;
	
	private int idx = ++i;
	private String name;
	private int count;
	private int price;
	private Date date;

	public MenuVO() {
		
	}
	public MenuVO(String name, int count, int price) {
		super();
		this.name = name;
		this.count = count;
		this.price = price;
	}
	public int getIdx() {return idx;}
	public void setIdx(int idx) {this.idx = idx;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public int getCount() {return count;}
	public void setCount(int count) {this.count = count;}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
	
}
