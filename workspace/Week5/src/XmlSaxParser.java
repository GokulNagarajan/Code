import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class XmlSaxParser {

	public static void main(String[] args) {
		try {	
	         File inputFile = new File("C:\\Users\\M1037562\\Desktop\\xml\\userdtd.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         UserParseHandler uph = new UserParseHandler();
	         saxParser.parse(inputFile, uph);     
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}   
}
