package spring.security.api.spring.jwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void  configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests().anyRequest().authenticated()
                .and().httpBasic();
    }
}
