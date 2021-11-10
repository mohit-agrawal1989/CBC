package main.java.com.viacomcbs.testrail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import main.java.com.viacomcbs.testrail.Testrail_Enum.TestRailPath;

    public class Testrail_Service {  
   	protected String JiraTicket;
		int id ;
	   String error ;
	   int result;
    	public static  int  Plan;   
        public static ArrayList<Map<String, Object>> PlanResult = new ArrayList<>();
        public static ArrayList<Object> CaseIDResult = new ArrayList<>();
	  
	/**Notes -> Creates hashmap for testplan**/ 
       
	   public void createTestRailResult(int result, int milestone, int plan, int id, String errorMessage, ArrayList<File> images, String jiraTicket ) throws IOException, APIException, ParseException {			
		   Map<String, Object> CaseResult= new HashMap<String, Object>(){{put("suite_id", TestRailPath.AASUITE.getNum()); put("milestone_id", milestone);
    	    put("case_id", id ); put("status_id", result);  put("comment", errorMessage +"\n"+jiraTicket );   put("attachment_id", 906495 );  
          }};;		
	      PlanResult.add(CaseResult); 
	      CaseIDResult.add(id);
	      Plan = plan;
//  		  System.out.println("TEST RESULT:"+ PlanResult);
          return;}
    	  
    /**Notes -> Sends test plan to Testrail**/  	   
       public  void addResultInTestRail() throws IOException, APIException, ParseException{	   

			/**Calls API**/
			Testrail_Configurations trhelper = new Testrail_Configurations();
			APIClient c = trhelper.initializeTestRail();

			/**Creates new plan**/
		    List<Integer> list =trhelper.getIDList();
		    Map<String, Object> CreateTestPlan = new HashMap<String, Object>(){
			{put("suite_id", 7); 
		     put("include_all", false);put("case_ids", CaseIDResult );}};
		 	
		     /**Converts new plan**/
		    JSONObject convertJSON = (JSONObject) c.sendGet("get_plan/" + Plan);					
			convertJSON = (JSONObject) c.sendPost("add_plan_entry/"+ Plan,  CreateTestPlan ); 		    	
		    long run_id = trhelper.helperTestRail(convertJSON);		
		  //  CreateTestPlan.put("add_attachment_to_result/906495", "/Users/lcren1026/CBS_PICS RESULTS/PURCHASE_FUNNEL_HAPPY/test.png"); 

		    CreateTestPlan.put("results", PlanResult);
  
		     /**Sends plan**/
			c.sendPost("add_results_for_cases/"+run_id,CreateTestPlan);

//	     System.out.println("Test");
            }
       
       public ArrayList<Map<String, Object>> getResult(){
    	   return  PlanResult;
       }
    }