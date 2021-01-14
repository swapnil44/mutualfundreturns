# mutualfundreturns
Calculate Returns


Mutual Fund Returns

Historical NAV data for Indian mutual funds are provided by the site https://www.mfapi.in/. For instance NAV data of “SBI Equity Hybrid Fund” can be got in JSON format using the URL https://api.mfapi.in/mf/102885


You are required to compute the trailing returns for a Mutual fund investment month wise for different time period of investments over a time period (horizon). 

Returns are calculated using the formula.

Returns = (End Value/Start Value)^(1/Years)-1

Say a mutual fund started with a value of Rs 1000 on January 1, 2019, ended with NAV of Rs 2500 on January 1, 2026.
Then year-on-year return will be calculated like this
Returns = (2500/1000)^(1/7) – 1 = 0.14 =~ 14%

You are required to find the trailing returns for given period of investment and horizon. Horizon means for how many months you need to find the returns.

Program outline
    1. Get the scheme number from user
    2. Download historic NAV data from mfapi site
    3. Get the period of investment and horizon from the user
    4. Compute trailing returns for entire horizon month over month for the latest date available in NAV data

Example
You are running the program on 16-Jul-20, the latest NAV you will have would be for 15-Jul-20
Input
Period of Investment = 1 
Horizon = 1

Output
Month wise returns

****** How to run project ******
Run file App.java with with command line argument as shown below :
outputdirectory [space] schemeId [space] InvestmentPeriod [space] horizon
example :: /home/vassar/Documents/Mutualfund 102885 3 5


