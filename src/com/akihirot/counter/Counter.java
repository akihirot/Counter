package com.akihirot.counter;


public class Counter{
	private int Num;
	private String Name;
	
	Counter(String Name) {
		this.Name = Name;
		this.Num = 0;
	}
	
	// setter
	public String getName() { return Name; }
	public int getNum() { return Num; }
	
	// getter
	public void setNum(int Num) { this.Num = Num; }
	public void setName(String Name) { this.Name = Name; }

	 // decrement count number
	 public void dec() {
		 Num--;
		 return ;
	 }
	 
	 // increment count number
	 public void inc() {
		 Num++;
		 return ;
	 }
	 
	 // reset count number
	 public void reset() {
		 Num = 0;
		 return ;
	 }
}
