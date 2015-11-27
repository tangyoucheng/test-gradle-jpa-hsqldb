package com.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * このメソッドは認証には関係ない。
	 * permitAll()しているURL以外にアクセスされた時、ログインページへ遷移して認証が求められるようにする。
	 * 
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/index", "/input").permitAll() // 認証無しでアクセスできるパスを指定する。
				.anyRequest().authenticated().and().formLogin().loginPage("/login") // ログインフォームのパスを指定する(指定しない場合、デフォルトログインページが表示される)。
				.permitAll().and().logout().logoutUrl("/logout") // ログアウトページ
				.logoutSuccessUrl("/index") // ログアウト成功時の遷移先ハスを指定する(指定しない場合、ログインページが表示される)。
				.permitAll();
	}

	/**
	 * 
	 * 
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}
}