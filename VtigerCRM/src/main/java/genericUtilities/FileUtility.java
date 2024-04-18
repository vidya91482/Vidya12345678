package genericUtilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String readDataFromPropertyFile(String key) throws IOException {
	FileInputStream fis=new FileInputStream(IPathConstant.FilePath);
	Properties p=new Properties();
	p.load(fis);
	String value=p.getProperty( key);
	return value;
	

}
}
