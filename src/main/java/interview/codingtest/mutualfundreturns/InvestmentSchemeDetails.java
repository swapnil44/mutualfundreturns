package interview.codingtest.mutualfundreturns;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)
public class InvestmentSchemeDetails {
	@JsonProperty("meta")
	private InvestmentSchemeMetaData schemeMetaData;
	
	@JsonProperty("data")
	private List<NAVData> investmentData;
	
	public InvestmentSchemeMetaData getSchemeMetaData() {
		return schemeMetaData;
	}

	public void setSchemeMetaData(InvestmentSchemeMetaData schemeMetaData) {
		this.schemeMetaData = schemeMetaData;
	}

	public List<NAVData> getInvestmentData() {
		return investmentData;
	}

	public void setInvestmentData(List<NAVData> investmentData) {
		this.investmentData = investmentData;
	}

	@Override
	public String toString() {
		return "MutualFundData [schemeMetaData=" + schemeMetaData + ", investmentData=" + "]";
	}
	
	

}
