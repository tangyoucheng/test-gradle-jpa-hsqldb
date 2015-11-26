/**
 * ブラウザからアクセスされたurlによって、表示するページを設定するクラス
 */

package com.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
//		registry.addViewController("/input").setViewName("input");
//		registry.addViewController("/serch").setViewName("serch");
	}

}