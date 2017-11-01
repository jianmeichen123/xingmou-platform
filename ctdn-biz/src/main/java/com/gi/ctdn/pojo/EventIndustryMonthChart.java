package com.gi.ctdn.pojo;

import java.util.List;

public class EventIndustryMonthChart  {


    /**
	 * @Field round a -g 分别代表轮次 '种子/天使/PreA轮', 'A/A+轮','PreB/B/B+轮','C轮','D轮','D轮以上','其他' 下的行业投资事件数:
	 * 例:
	 * industryname a    b   c   d   e   f   g
	 * 企业服务	   291	233	106	45	26	22	62
	 */
	private Integer rounda;

	private Integer roundb;

	private Integer roundc;

	private Integer roundd;

	private Integer rounde;

	private Integer roundf;

	private Integer roundg;

	private String industryname;

	private List<List<Integer>> roundNumList;

	private List<String> industryNameList;


	public Integer getRounda() {
		return rounda;
	}

	public void setRounda(Integer rounda) {
		this.rounda = rounda;
	}

	public Integer getRoundb() {
		return roundb;
	}

	public void setRoundb(Integer roundb) {
		this.roundb = roundb;
	}

	public Integer getRoundc() {
		return roundc;
	}

	public void setRoundc(Integer roundc) {
		this.roundc = roundc;
	}

	public Integer getRoundd() {
		return roundd;
	}

	public void setRoundd(Integer roundd) {
		this.roundd = roundd;
	}

	public Integer getRounde() {
		return rounde;
	}

	public void setRounde(Integer rounde) {
		this.rounde = rounde;
	}

	public Integer getRoundf() {
		return roundf;
	}

	public void setRoundf(Integer roundf) {
		this.roundf = roundf;
	}

	public Integer getRoundg() {
		return roundg;
	}

	public void setRoundg(Integer roundg) {
		this.roundg = roundg;
	}

	public void setRoundNumList(List<List<Integer>> roundNumList) {
		this.roundNumList = roundNumList;
	}

	public List<List<Integer>> getRoundNumList() {
		return roundNumList;
	}

	public void setIndustryname(String industryname) {
		this.industryname = industryname;
	}

	public String getIndustryname() {
		return industryname;
	}

	public void setIndustryNameList(List<String> industryNameList) {
		this.industryNameList = industryNameList;
	}

	public List<String> getIndustryNameList() {
		return industryNameList;
	}
}