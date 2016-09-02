package com.beerfun;

public class Beer {
	
	public int beerId = 0;
	public String brewer = null;
	public String name = null;
	public String style = null;
	public double abv = 0.0;
	
	
	public Beer() {
		super();
	}


	public int getBeerId() {
		return beerId;
	}


	public void setBeerId(int beerId) {
		this.beerId = beerId;
	}


	public String getBrewer() {
		return brewer;
	}


	public void setBrewer(String brewer) {
		this.brewer = brewer;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStyle() {
		return style;
	}


	public void setStyle(String style) {
		this.style = style;
	}


	public double getAbv() {
		return abv;
	}


	public void setAbv(double abv) {
		this.abv = abv;
	}
	
	

}
