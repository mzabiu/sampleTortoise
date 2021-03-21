package com.sample.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListener implements ITestListener {

	public void onTestStart(ITestResult result) {

		System.out.println("======= Test case " + result.getName() + " is started");
		Reporter.log("======= Test case " + result.getName() + " is started");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("======= Test case " + result.getName() + " is Failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("======= Test case " + result.getName() + " is Skipped");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("======= Test case " + result.getName() + " is Passed");
		Reporter.log("======= Test case " + result.getName() + " is Passed");
	}
}
