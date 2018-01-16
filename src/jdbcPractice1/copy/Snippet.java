package jdbcPractice1.copy;

public class Snippet {
	String url=AL.getProperty(SETTINGS_PATH,"URL");
		driver.get(url);
		String strITO=AL.getProperty(SETTINGS_PATH,"ITO");
		long ITO=Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
}

