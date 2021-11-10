package main.java.com.viacomcbs.testrail;

public enum Testrail_Enum {	
	   NAME,
	   LOGIN;

	public enum TestRailPath {	
		DESKTOP_MSTONE(179),
		MOBILE_MSTONE(180),
		DTOP_STAGE_PLAN(5766),
		DTOP_PREVIEW_PLAN(2011),
		DTOP_PROD_PLAN(2010),
		DTOP_SHADOW_PLAN(5767),
		DTOP_DEV_PLAN(1789),	
		MWEB_STAGE_PLAN(5759),
		MWEB_PREVIEW_PLAN(2011),
		MWEB_PROD_PLAN(2010),
		MWEB_SHADOW_PLAN(5767),
		MWEB_DEV_PLAN(1789),
		SESSION_ID_SIGININ(64282),
		PASS(1),
		BLOCKED(2),
		UNTESTED(3),
		RETESTED(4),
		FAIL(5),
		AASUITE(7);
		
		 private int num;
		 
		 TestRailPath(int n) {
		        this.num = n;
		    }
		    public int getNum() {
		        return num;
		    }
	    }
	  }