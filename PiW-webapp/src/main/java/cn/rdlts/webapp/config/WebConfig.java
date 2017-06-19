package cn.rdlts.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

//@Configuration
//@EnableWebMvc
//@ComponentScan(
//		basePackages="cn.rdlts.webapp",
//		includeFilters=@Filter(pattern="org.springframework.stereotype.Controller")
//)
public class WebConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * Apache Tiles 3 视图配置类
	 * 
	 * @return TilesConfigurer
	 */
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfig = new TilesConfigurer();
		tilesConfig.setDefinitions(new String[] {
				// Specify tile definition locations
				"/WEB-INF/config/tiles/tiles-admin.xml"
		});
		
		tilesConfig.setCheckRefresh(true); // Enable refresh
		return tilesConfig;
	}
	
	public ViewResolver tilesViewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		viewResolver.setOrder(0);
		return viewResolver;
	}
	
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		return resolver;
	}
}
