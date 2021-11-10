package main.java.com.viacomcbs.testrail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.json.simple.*;
import org.json.simple.parser.*;
import main.java.com.viacomcbs.testrail.Testrail_Enum.TestRailPath;



public class Testrail_Configurations extends Testrail_Service{
	
	private int mstone;
	private int plan;	
	Testrail_Settings LOGIN = new Testrail_Settings(Testrail_Enum.LOGIN);	;
	List<Integer>  list ;
	String TestRailPlan="TestRailPlan";
	private int SectionID;
	ArrayList<Integer> testList = new ArrayList();
	APIClient client;
//	 TestRail Switch
//	 * @param caseID
//	 * @throws ParseException
//	 * @throws APIException
//	 * @throws IOException
	
	public Testrail_Configurations() {
		client = initializeTestRail();
	}
	
	
	/** NOTES -Sets up testrail results*/	
	public void setupTestRailResult(int caseID , boolean results,  String errorMessage,   ArrayList<File> images ,String jiraTicket) throws IOException, APIException, ParseException {
		grabSetting();
		checkComment(errorMessage, jiraTicket);
		getIDList();
		initializeTestRailReporter(caseID, result,  images);			
	}
	
	
	/** NOTES -JSON Converter*/
	public static long helperTestRail(JSONObject convertJSON) throws ParseException  {	
      String convertString = String.valueOf(convertJSON);
      Object Obj1 = new JSONParser().parse(convertString);	    
      JSONObject Obj2 = (JSONObject) Obj1;
      JSONArray Obj3 = (JSONArray) Obj2.get("runs");
      JSONObject first_run = (JSONObject) Obj3.get(0);
      long run_id = (long) first_run.get("id");	
      return run_id;		
}
	
 	/** NOTES -API connection*/
   public  APIClient initializeTestRail() {
	   APIClient c = new APIClient(LOGIN.getTRURL());
       c.setUser(LOGIN.getTREmail());
       c.setPassword(LOGIN.getTRPWD());
   return c;
  }
 
	/** NOTES -Property Files*/
   public void getProperty() {
	   try (InputStream input = new FileInputStream("pathToFile.properties")) {
           Properties prop = new Properties();
           prop.load(input);

//           System.out.println(prop.getProperty("testrail.milestone"));
       } catch (IOException ex) {
           ex.printStackTrace();
       }   
   }
   
	/** NOTES -Gets settings*/  
   public void 	grabSetting() {		
    	   switch("Environment")
		     {
		     case ("STAGE"): 
		       plan = TestRailPath.DTOP_STAGE_PLAN.getNum();
		     break;		
	         case ("PREVIEW"): 
	           plan =TestRailPath.DTOP_PREVIEW_PLAN.getNum();
	         break;
	         case ("PROD"): 
	           plan = TestRailPath.DTOP_PROD_PLAN.getNum();
	         break;
	         case ("SHADOW"): 
	           plan = TestRailPath.DTOP_SHADOW_PLAN.getNum();
	         break;
	         case ("DEV"): 
	           plan = TestRailPath.DTOP_DEV_PLAN.getNum();
	         break;
	        default:
	         break; }		
		     }
         
 	
 	public ArrayList<Integer> getIDList(){
		return testList;
	} 
 	
 	public void getSessionID() {		
		APIClient client = initializeTestRail();
		try {
			JSONArray sectionArrayList = (JSONArray) client.sendGet("get_sections/3&suite_id=7");								
		} catch (IOException | APIException  e) {
			e.printStackTrace();
		}			
 	}

	/** NOTES -Getters*/ 
     public int getPlan() {
    	 grabSetting();
       return plan;
       }
   
    public int getMiles() {
    	grabSetting();
	return mstone;
    }
	
//	NOTES -Testrail Comments
//	 * @param images
    public void checkComment(String errorMessage, String jiraTicket) {
    	error = errorMessage;
    	JiraTicket = jiraTicket;
		if((jiraTicket==null))
		 { 
			JiraTicket = "";}	
		if((errorMessage==null))
		{
			error = "";}  	
       }
       
    
	
	/** NOTES -Sends results to TestRail Settings
	 * @param result */ 
     public void initializeTestRailReporter(int caseID,  int result, ArrayList<File> images) throws IOException, APIException, ParseException {		
     int testID = 0;
	createTestRailResult(result,mstone, plan, testID, error, images, JiraTicket);}}