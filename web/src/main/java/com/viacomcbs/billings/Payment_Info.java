package main.java.com.viacomcbs.billings;

//
//import org.springframework.beans.factory.annotation.Value;
//
///** NOTES -> This class is used to for account types and information
//*/
//
public class Payment_Info {
}
//	
//	/** NOTES -> New Account Information**/
//
//	private final String ADDRESS = "2900 W Alameda Ave";
//	public final String BDAY ="11221963";
//	public final String GENDER = "Prefer Not To Say";
//	public final String CITY = "Burbank";
//	public final String STATE = "CA";
//	public final String ZIP = "90501";
//	public final String NAME = "CBS AUTOMATION";
//	private String email;	
//	private String pwd ;
//	//Time time = new Time();
//	
//	/** NOTES -> Credit Card Information**/	
//	
//    @Value("${ccn:41111111111111111}")
//	private String cc_n;
//    
//    @Value("${ccm:09}")
//	private String cc_m;
//    
//    @Value("${ccy:2022}")
//	private String cc_y;
//    
//    @Value("${cc_cvv:234}")
//	private String cc_cvv;
//    
//    @Value("${env:stage}")
//    private String env;
//	
//	
//	/** NOTES -> Configuration of Credit Information**/		
//	private void setCreditSetup() {
//		if(env.toUpperCase().equals("STAGE") ||env.toUpperCase().equals("DEV")
//		    ) {
//			cc_n ="41111111111111111";
//			cc_m = "09";
//			cc_y="2022";
//			cc_cvv= "234";
//		}return  ;
//	}
//
//	/** NOTES -> Configuration of Email**/	
//	private String setEmailConfig() {
//		//email="CBSAutomation"+time.getTimeStamp()+"@cbs.com";	
//		return email;
//	}
//
//
//	/** NOTES -> Setters**/
//	
//	
//	public void setPWD() {
//		pwd = "aaaaaa";
//	}
//	
//		
//	/**Getters**/
//	
//	public String getEmail() {
//		this.setEmailConfig();
//		return email;
//	}
//	
//	public String getPassword() {
//		this.setPWD();
//		return pwd;
//	}
//	
//	public String getAddress() {
//		return ADDRESS;
//	}
//	
//	public String getCCN() {
//		this.setCreditSetup();
//		return cc_n;
//	}
//	
//	public String getCCM() {
//		this.setCreditSetup();
//		return cc_m;
//	}
//	
//	public String getCCY() {
//		this.setCreditSetup();
//		return cc_y;
//	}
//	
//	public String getCVV() {
//		this.setCreditSetup();
//		return cc_cvv;
//	}
//}
//	