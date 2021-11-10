package main.java.com.viacomcbs.testrail;
public class Testrail_Settings {
	
	 private String EMAIL ;
	 private String PWD ;
	 private String URL;
	 public String SMOKETEST;
	 public String SIGNIN;
	 
	
		public Testrail_Settings(Testrail_Enum login) {			
		       switch (login) {
		       case LOGIN:
		            EMAIL = "entqa-test-cases@cbsinteractive.com";
		            PWD =  "4cFwrns9LgrK/Ld/8fCZ-B2zYRGw4vXxXS/LtZUsk";
		            URL = "https://cbsientqa.testrail.io/";
		            break;
		       }}
			// TODO Auto-generated constructor stub
		


		public String getTREmail() {
			return EMAIL;
		}
		
		public String getTRPWD() {
			return PWD;
		}
		
		public String getTRURL() {
			return URL;
		}	
	}