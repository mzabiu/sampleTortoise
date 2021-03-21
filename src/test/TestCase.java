package test;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class TestCase {

	// username is the name of the variable mentioned in testng xml at test block
	// level
	/*
	 * @Test
	 * 
	 * @Parameters({ "userName", "Password" }) public void test1(String userName,
	 * String password, Method method) {
	 * System.out.println(" The name of the method is " + method.getName());
	 * System.out.println("the username is " + userName + " and the value is " +
	 * password);
	 * 
	 * }
	 */

	@Test(dataProvider = "excelData")
	public void testWithExcel(XmlTest data, Method method, String userName, String Password) {

		System.out.println(" The name of the method is " + method.getName());
		System.out.println("the username is " + data.getParameter("userName") + " and the value is "
				+ data.getParameter("Password"));

		System.out.println("username from Data provider is " + userName + " and the password is " + Password);
	}

	@DataProvider
	public Object[][] myData() {

		Object[][] data = new Object[3][2];

		data[0][0] = "admin";
		data[0][1] = "admin123";

		data[1][0] = "admin";
		data[1][1] = "admin123";

		data[2][0] = "admin";
		data[2][1] = "admin123";

		return data;
	}

	@DataProvider
	public Object[][] excelData() {

		ReadExcel excel = new ReadExcel("./TestData.xlsx", "Data");
		return excel.excelData();
	}

}
