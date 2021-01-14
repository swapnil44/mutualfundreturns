package interview.codingtest.mutualfundreturns;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvestmentSchemeMetaData {
	@JsonProperty("fund_house")
	private String fundHouse;
	
	@JsonProperty("scheme_type")
	private String schemeType;
	
	@JsonProperty("scheme_category")
	private String schemeCategory;
	
	@JsonProperty("scheme_code")
	private int schemeCode;
	
	@JsonProperty("scheme_name")
	private String schemeName;
	
	public String getFundHouse() {
		return fundHouse;
	}
	public void setFundHouse(String fundHouse) {
		this.fundHouse = fundHouse;
	}
	public String getSchemeType() {
		return schemeType;
	}
	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}
	public String getSchemeCategory() {
		return schemeCategory;
	}
	public void setSchemeCategory(String schemeCategory) {
		this.schemeCategory = schemeCategory;
	}
	public int getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(int schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	@Override
	public String toString() {
		return "SchemeMetaData [fundHouse=" + fundHouse + ", schemeType=" + schemeType + ", schemeCategory="
				+ schemeCategory + ", schemeCode=" + schemeCode + ", schemeName=" + schemeName + "]";
	}
	 
}
