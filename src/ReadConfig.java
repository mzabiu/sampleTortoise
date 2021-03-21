import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	static String configPath = "./config1.properties";

	public static String getConfigValue(String Key) throws Exception {

		Properties prop = new Properties();

		prop.load(new FileInputStream(configPath));

		return prop.getProperty(Key);
	}

	public static void main(String[] args) throws Exception {
		
		String key = "pilot.appUrl";

		String key1 = "iat.appUrl";

		System.out.println("The key is " + key + " and the value is " + getConfigValue(key));

		System.out.println("The key is " + key1 + " and the value is " + getConfigValue(key1));
	}

}
