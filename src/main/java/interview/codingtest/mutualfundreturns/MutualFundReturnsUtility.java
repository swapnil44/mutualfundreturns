package interview.codingtest.mutualfundreturns;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MutualFundReturnsUtility {
	private int  schemeId;
	private int investmentPeriod;
	private int horizon;
	MutualFundReturnsUtility(int schemeId, int investmentPeriod, int horizon) {
		this.schemeId = schemeId;
		this.investmentPeriod = investmentPeriod;
		this.horizon = horizon;
	}

	public void calculateReturn(String outputDirectory) {
		URL url;
		FileWriter fileWriterOutput = null;
		try {
			fileWriterOutput = new FileWriter(outputDirectory+"/output.csv");
			url = new URL("https://api.mfapi.in/mf/" +schemeId);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				in.close();

				InvestmentSchemeDetails mutualFundData = null;
				ObjectMapper objectMapper = new ObjectMapper();
				String responseString = response.toString();
				mutualFundData = objectMapper.readValue(responseString, InvestmentSchemeDetails.class);

				TreeMap<Integer, Double> dateToNavMap =  new TreeMap<Integer, Double>();
				for(NAVData schemeInvestmentData:mutualFundData.getInvestmentData() ) {
					dateToNavMap.put(getYYYYMMDD(schemeInvestmentData.getDate()), schemeInvestmentData.getNav());
				}
				calculateReturnRateForGivenHorizon(dateToNavMap, fileWriterOutput);

			} else {
				System.out.println("Data not found, make sure input is valid");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		} finally {
			if(fileWriterOutput!= null) {
				try {
					fileWriterOutput.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void calculateReturnRateForGivenHorizon(TreeMap<Integer, Double> dateToNavMap, FileWriter fileWriter) throws IOException {
		int startDate = getYYYMMDD(System.currentTimeMillis());
		int count =1;// horizon*12;

		startDate = startDate-(10000*horizon);
		System.out.println(startDate);
		fileWriter.write("Month,rate,startNavDate,endNavDate\n");
		while(count <=horizon*12) {
			int date = startDate+(100*(count%12)) +(10000*(count/12));
			int endNavDate= date;
			int startNavDate =date-(10000*investmentPeriod);
			double endNav = getNavforGivenDate(dateToNavMap, endNavDate);
			double startNav = getNavforGivenDate(dateToNavMap,startNavDate);
			double rate  = 0;
			if(endNav == 0|| startNav ==0) {
				rate = 0.0;
			} else {
				rate = Math.pow(endNav/startNav, 1.0/Double.parseDouble(String.valueOf(investmentPeriod)));
				rate = Math.round((rate-1)*100);

			}
			fileWriter.write(endNavDate/100 + "," + rate+ "," +getDDMMYYYY(startNavDate) +"," +getDDMMYYYY(endNavDate) + "\n");
			count++;

		}
	}

	public int getYYYYMMDD(String date) {
		String dateInfo[] = date.split("-");
		return Integer.parseInt(dateInfo[2]+dateInfo[1]+dateInfo[0]);

	}
	public String getDDMMYYYY(int date) {
		String ddmmyyyy=  (date%100 >9?date%100+"":"0"+date%100) +"-"+((date%10000)/100 >9?(date%10000)/100 :"0"+(date%10000)/100) +"-"+ date/10000;
		return ddmmyyyy;

	}
	public int getYYYMMDD(Long ts) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(ts);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String label = dateFormat.format(calendar.getTimeInMillis());
		return  Integer.parseInt(label);

	}
	double getNavforGivenDate(TreeMap<Integer, Double> dateToNavMap,int date) {

		if(dateToNavMap.get(date)==null) {
			Integer key=  dateToNavMap.higherKey(date);
			if(key != null) {
				return dateToNavMap.get(key);
			}
			return 0; 
		} else 
			return dateToNavMap.get(date);
	}


}
