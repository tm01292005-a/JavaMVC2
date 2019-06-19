package com.example.jpademo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
        // セキュリティ設定を無視するリクエスト設定
        // 静的リソース(images、css、javascript)に対するアクセスはセキュリティ設定を無視する
        web.ignoring().antMatchers(
                            "/js/**",
                            "/css/**",
                            "/img/**",
                            "/webjars/**");
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/user", "/user.*", "/user/**").hasRole("USER")
			.antMatchers("/admin", "/admin.*", "/admin/**").hasRole("ADMIN")
			.anyRequest().authenticated(); // 全てのパスに対して「認証済み」のアクセス制御をおこなう
/*
		// ログイン設定
		http.formLogin()
			.loginPage("/login") // ログイン画面
			.successForwardUrl("/") // ログイン成功時に表示するURL
			.usernameParameter("username") // ログイン名
			.passwordParameter("password") // パスワード
			.permitAll();

		// ログアウト設定
		http.logout() //
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // logoutUrl()はPOSTに対応していない
			.logoutSuccessUrl("/login") // ログアウト成功時に表示するURL
			.deleteCookies("JSESSIONID").invalidateHttpSession(true).permitAll();
*/
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*
		// LADP認証有効化
		auth.ldapAuthentication()
			// ユーザーの識別名(DN)パターンを指定
			// {0}にはログインフォームで入力したusernameが埋め込まれる
			.userDnPatterns("uid={0},ou=people")
			// グループ(ロール)を検索するユニットを指定
			.groupSearchBase("ou=groups")
			// LDAPのデータソースを指定
			.contextSource()
				// 接続URLを指定
				.url("ldap://192.168.99.100:10389/dc=example,dc=com")
				// LDAPに接続するためのユーザ識別名を指定
				.managerDn("cn=admin,dc=example,dc=com")
				// LDAPに接続するためのパスワードを指定
				.managerPassword("password")
			.and()
			// UserDetailsを生成するオブジェクトを指定
			.userDetailsContextMapper(new PersonContextMapper());
*/
	}

}
