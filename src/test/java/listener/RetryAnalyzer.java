package listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
private int retryCount = 0;
private static final int maxRetryAnalyzer = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount<maxRetryAnalyzer){
            retryCount++;
            return true;}
        return false;
    }
}

