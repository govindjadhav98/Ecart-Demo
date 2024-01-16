package E_commersetest.AbstratctCopmponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import E_commerse.Abstractcomponents.ExtentReporterng;

public class Testnglistners extends Basetest implements ITestListener {
	ExtentTest test ;
	ExtentReports	extentreport=ExtentReporterng.getreportObject();
ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extentreport.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Pass");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		extenttest.get().fail(result.getThrowable());
		String path = null;
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			path = getscreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}
	@Override
	public void onTestSkipped(ITestResult result) {

	}
	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();
	}
}
