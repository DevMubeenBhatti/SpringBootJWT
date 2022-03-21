package spring.security.api.spring.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
//// configure digestAuthenticationEntryPoint
//    private DigestAuthenticationEntryPoint getDigestEntryPoint(){
//        DigestAuthenticationEntryPoint disgestEntryPoint = new DigestAuthenticationEntryPoint();
//        disgestEntryPoint.setRealmName("admin-role");
//        disgestEntryPoint.setKey("demoTest");
//        return disgestEntryPoint;
//    }
////    password encoder
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
////    user authencation manager
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication().withUser("test").password(passwordEncoder().encode("digest")).roles("User")
//                .and().withUser("admin").password(passwordEncoder().encode("admin")).roles("Admin");
//    }
////    user detail service
//    public UserDetailsService userDetailsServiceBean() throws Exception{
//        return super.userDetailsServiceBean();
//    }
////  user configetraion
//    public DigestAuthenticationFilter  getDigestAuthFilter() throws Exception{
//        DigestAuthenticationFilter digestAuthFilter = new DigestAuthenticationFilter();
//        digestAuthFilter.setUserDetailsService(userDetailsServiceBean());
//        digestAuthFilter.setAuthenticationEntryPoint(getDigestEntryPoint());
//        return digestAuthFilter;
//    }
//
////  Notice that we are configuring / admin / * * for securityFilterChain
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/admin/**").
//                addFilter(getDigestAuthFilter()).exceptionHandling()
//                .authenticationEntryPoint(getDigestEntryPoint())
//                .and().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
//    }



        // Configure DigestAuthenticationEntryPoint
        private DigestAuthenticationEntryPoint getDigestEntryPoint() {
        DigestAuthenticationEntryPoint digestEntryPoint = new DigestAuthenticationEntryPoint();
        digestEntryPoint.setRealmName("admin-digest-realm");
        digestEntryPoint.setKey("somedigestkey");
        return digestEntryPoint;
    }


        // PasswordEncoder Bean
        @Bean
        public PasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();

        return NoOpPasswordEncoder.getInstance();
    }


        //Configure authentication manager

        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("TestUser")
                .password(passwordEncoder().encode("digestsecret"))
                .roles("USER")
                .and()
                .withUser("TestAdmin")
                .password(passwordEncoder().encode("adminsecret"))
                .roles("ADMIN");
    }


        //default UserDetailsService configured by  UserDetailsServiceAutoConfiguration

        @Bean
        public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }


        // Configure  DigestAuthenticationFilter.
        // Notice the we are injecting userDetailsService and DigestAuthenticationEntryPoint

        private DigestAuthenticationFilter getDigestAuthFilter() throws Exception {
        DigestAuthenticationFilter digestFilter = new DigestAuthenticationFilter();

        digestFilter.setUserDetailsService(userDetailsServiceBean());


        digestFilter.setAuthenticationEntryPoint(getDigestEntryPoint());
        return digestFilter;
    }


        //Notice that we are configuring / admin/ * * for the SecurityFilterChain
        // added DigestAuthenticationFilter, also configured the EntryPoint authentication.

        @Override
        protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/admin/**").
                addFilter(getDigestAuthFilter()).exceptionHandling()
                .authenticationEntryPoint(getDigestEntryPoint())
                .and().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
    }
}

/*
*/
