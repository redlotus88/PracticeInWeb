package cn.rdlts.core.utils;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Printer Utility
 * @author Dragon.Wang
 *
 */
public class PrinterUtils {
	
	public static final String EQUAL_SYMBOL = "=";
	
	private static Log logger = LogFactory.getLog(PrinterUtils.class);
	
	private PrinterUtils() {
	}
	
	public static void print(Properties props) {
		logger.info(props);
	}
	
	public static void main(String[] args) {
//		Properties props = new Properties();
//		props.setProperty("a", "b");
//		props.setProperty("C", "D");
//		
//		System.out.println(props);
		System.out.println();
	}
}
