package cn.rdlts.core.utils;

import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Printer Utility
 * @author Dragon.Wang
 *
 */
public class PrinterUtils {
	
	public static final String EQUAL_SYMBOL = "=";
	
	private static Logger logger = Logger.getLogger(PrinterUtils.class);
	
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
