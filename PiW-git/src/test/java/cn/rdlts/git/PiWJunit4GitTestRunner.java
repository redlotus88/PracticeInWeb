package cn.rdlts.git;

import java.io.FileNotFoundException;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

public class PiWJunit4GitTestRunner extends SpringJUnit4ClassRunner {
	
	static {
		try {
			Log4jConfigurer.initLogging("classpath:config/log4j.properties");
		} catch (FileNotFoundException e) {
			System.err.println("无法找到log4j配置文件");
		}
	}

	public PiWJunit4GitTestRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
	}
}
