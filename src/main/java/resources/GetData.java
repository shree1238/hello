package resources;

import org.testng.annotations.DataProvider;

public class GetData {
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "test.test@example.com";
		data[0][1] = "test123";
		data[1][0] = "test.test1@example.com";
		data[1][1] = "test123";
		return data;
	}


}
