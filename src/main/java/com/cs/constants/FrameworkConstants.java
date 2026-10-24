package com.cs.constants;

public final class FrameworkConstants {

	private FrameworkConstants() {};
	
	private static final String REPORT_PATH = System.getProperty("user.dir")+"/src/test/resources/report/CST5758CCPIndex_"+ System.currentTimeMillis()  + ".html";

	public static String getReportPath() {
		System.out.println("inside getReportPath method");
		return REPORT_PATH;
	}
	
	
	
}
