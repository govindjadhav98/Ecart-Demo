package E_commerse.Abstractcomponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterng {

	public static ExtentReports getreportObject() {
		String path = System.getProperty("user.dir")+"//reports//index1.html";

		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Results");

		ExtentReports extenetreport = new ExtentReports();
		extenetreport.attachReporter(reporter);
		extenetreport.setSystemInfo("Tester", "Govind Jadhav");

		return extenetreport;


	}
}
