package cn.rdlts.configurer;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * PiW-core项目 Spring配置参数类。
 * @author Dragon.Wang
 *
 */
public class PiWPropertyConfigurer extends PropertyPlaceholderConfigurer {
	
	private static Log logger = LogFactory.getLog(PiWPropertyConfigurer.class);
	
	private Properties props;
	
	@Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        this.props = props;
        logger.info("Spring 加载属性文件：\n" + props);
    }
	
	public String getProperty(String key){
        return this.props.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return this.props.getProperty(key, defaultValue);
    }

    public Object setProperty(String key, String value) {
        return this.props.setProperty(key, value);
    }

}
