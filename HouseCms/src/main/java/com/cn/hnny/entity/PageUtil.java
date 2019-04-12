package com.cn.hnny.entity;

public class PageUtil {
	//婵絽绻橀妴澶愬级閳╁啯娈�
private int rows=10;
    //鐟滅増鎸告晶鐘炽亜閿燂拷
private int currpage=1;
   //濞ｅ洦绻冪�垫棃寮婚妷顭戝殑闁告艾閰ｉ妴澶愬极閿燂拷
private int totalpage;
  //濞ｅ洦绻傞悺銊╁蓟閵夘煈鍤勯柛姘濞碱垶寮敓锟�
private int totalnumber;
public int getRows() {
	return rows;
}
public void setRows(int rows) {
	this.rows = rows;
}
public int getCurrpage() {
	return currpage;
}
public void setCurrpage(int currpage) {
	this.currpage = currpage;
}
public int getTotalpage() {
	int mod=totalnumber%rows;
	totalpage=totalnumber/rows;
	if(mod!=0){
		totalpage++;
	}
	return totalpage;
}
public void setTotalpage(int totalpage) {
	this.totalpage = totalpage;
}
public int getTotalnumber() {
	return totalnumber;
}
public void setTotalnumber(int totalnumber) {
	this.totalnumber = totalnumber;
}
}
