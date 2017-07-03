package cn.rdlts.shiro.configurer;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import cn.rdlts.common.configurer.PiWPropertyConfigurer;
import cn.rdlts.shiro.ciper.CiperUtils;
import cn.rdlts.shiro.constant.PiWShiroConst;

public class PiWShiroPropertyConfigurer extends PiWPropertyConfigurer {
	
	protected static Logger log = Logger.getLogger(PiWShiroPropertyConfigurer.class);
	
	@Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        
        // Shiro properties设置
        String strHashIterations = this.getProperty(PiWShiroConst.PROPERTY_SHIRO_HASH_ITERATIONS);
        if (StringUtils.isNumeric(strHashIterations)) {
        	 int hashIterations = Integer.parseInt(strHashIterations);
        	 if (hashIterations < 1) {
        		 hashIterations = 1;
        	 }
             CiperUtils.setShiroHashIterations(hashIterations);
             log.info("修改Shiro配置hashIterations的值为：" + hashIterations);
        } else {
        	log.error("不能读取Shiro配置hashIterations的值");
        }
    }
	
	@Override
	public String getProperty(String key){
        return super.getProperty(key);
    }

	@Override
    public String getProperty(String key, String defaultValue) {
        return super.getProperty(key, defaultValue);
    }

	@Override
    public Object setProperty(String key, String value) {
        return super.setProperty(key, value);
    }
}
