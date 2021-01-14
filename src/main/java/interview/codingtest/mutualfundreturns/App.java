package interview.codingtest.mutualfundreturns;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if(args == null|| args.length <4) {
    		System.out.println("Please provide valid input");
    		System.out.println("outputdirectory[space]schemeId[space]InvestmentPeriod[space]horizon");
    		System.out.println("Example ::");
    		System.out.println("/home/vassar/Documents/Mutualfund 102885 3 5");
            
        } else {
        	String outputDirectory = args[0].trim();
            int schemeId = Integer.parseInt(args[1].trim());
            int investMentPeriod = Integer.parseInt(args[2].trim());
            int horizon = Integer.parseInt(args[3].trim());
            MutualFundReturnsUtility mutualFundReturn = new MutualFundReturnsUtility(schemeId,investMentPeriod,horizon);
            mutualFundReturn.calculateReturn(outputDirectory);
        }
    }
}
