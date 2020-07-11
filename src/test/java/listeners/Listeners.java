package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pageObjects.MainPage;

public class Listeners implements ITestListener {
    private static Logger logger = LogManager.getLogger(MainPage.class);
    @Override
    public void onTestStart(ITestResult iTestResult) {
        //System.out.println("Test started " + iTestResult.getName());
        logger.info("test started "+iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //System.out.println("Wow! = test is passed " + iTestResult.getName());
        logger.info("Yo = test is passed "+iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //System.out.println("HELP - Test FAILED " + iTestResult.getName());
        logger.fatal("HELP - test FAILED " + iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
