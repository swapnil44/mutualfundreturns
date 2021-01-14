package interview.codingtest.mutualfundreturns;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NAVData {


	@JsonProperty("date")
	private String date;
	
	@JsonProperty("nav")
	private double nav;

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	public double getNav() {
		return nav;
	}

	public void setNav(double nav) {
		this.nav = nav;
	}
	
	
	@Override
	public String toString() {
		return "SchemeInvestmentData [date=" + date + ", nav=" + nav + "]";
	}
	
	

}
