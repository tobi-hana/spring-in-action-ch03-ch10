package burgers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    what I got according to book
//    it does not work - probably because of login form page???
//    when it has resource server dependency????
//    error creating webSecurity
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeRequests()
////                    .antMatchers(HttpMethod.POST, "/ingredients").hasRole("ADMIN")
////                    .antMatchers(HttpMethod.DELETE, "/ingredients/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.POST, "/api/ingredients").hasAuthority("SCOPE_writeIngredients")
//                .antMatchers(HttpMethod.DELETE, "/api/ingredients").hasAuthority("SCOPE_deleteIngredients")
//                .antMatchers("/design", "/orders").access("hasRole('USER')")
//                .antMatchers("/", "/**").access("permitAll()")
//                .and()
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt())
//                .formLogin()
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/design", true)
//                .and()
//                    .oauth2Login()
//                    .loginPage("/login")
//                .and()
//                    .logout()
//                    .logoutSuccessUrl("/")
//                .and()
//                    .csrf()
//                    .disable();
//
//
//    }
    @Override // took from someones solution, not the book
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll() // needed for Angular/CORS
                .antMatchers(HttpMethod.POST, "/api/ingredients").hasAuthority("SCOPE_writeIngredients")
                .antMatchers(HttpMethod.DELETE, "/api/ingredients").hasAuthority("SCOPE_deleteIngredients")
                .antMatchers("/design", "/orders").access("hasRole('USER')")
                .antMatchers("/", "/**").access("permitAll()")
                .and()
                .oauth2ResourceServer(oauth2 -> oauth2.jwt())
                .httpBasic()
                .realmName("Burger Cloud")

                .and()
                .logout()
                .logoutSuccessUrl("/")

                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**", "/api/**")

                // Allow pages to be loaded in frames from the same origin; needed for H2-Console
                .and()
                .headers()
                .frameOptions()
                .sameOrigin();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

    }

}
