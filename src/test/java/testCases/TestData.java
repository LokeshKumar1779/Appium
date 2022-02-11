package testCases;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="inputData")
	public Object[] getName() {
		Object [][] name = new Object[][]
		{
			{"lkdsfljks"},
		{"^&%kj"}
		};
		
		return name;
		
		
	}

}
