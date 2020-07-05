package listeners;

import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;
import pageObjects.MainPage;

public class Listeners implements ITestListener {
    private static Logger logger = (Logger) LogManager.getLogger(MainPage.class);
    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("test started"+iTestResult.getName());

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Yo - test is passed"+iTestResult.getName());

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.fatal("Help - test FAILED"+iTestResult.getName());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}

