package restmock.currencyConverter;

import java.math.BigDecimal;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class RESTCurrencyRate implements CurrencyRate {
	
	private final String uri;
	
	public RESTCurrencyRate(String uri) {
		this.uri = uri;
	}
	
	public BigDecimal getCurrentRate() {
	    try {
	    	DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(uri);
            XPath xPath = XPathFactory.newInstance().newXPath();
            return new BigDecimal(xPath.compile("/double").evaluate(xmlDocument));
	    } catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
