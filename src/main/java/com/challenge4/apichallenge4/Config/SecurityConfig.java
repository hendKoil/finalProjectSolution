package com.challenge4.apichallenge4.Config;

import com.challenge4.apichallenge4.Services.Impl.UserLoginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public final UserDetailsService userDetailsService;
    public final UserLoginServiceImpl userLoginService;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

//uncomment when deploy to heroku
//    private CorsConfigurationSource configurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader(config.ALL);
//        config.addAllowedHeader(config.ALL);
//        config.addAllowedMethod(config.ALL);
//        source.registerCorsConfiguration("/**", config);
//        return source;
//    }
    //uncomment when deploy to heroku

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        //uncomment when deploy to heroku
//        http.cors().configurationSource(configurationSource()).and()
//                .requiresChannel()
//                .anyRequest()
//                .requiresSecure();
        //uncomment when deploy to Heroku

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/registration",
                "/swagger-ui.html/**","/refresh-token", "/registration-select/{roleId}", "/registration-default", "/regisv2").permitAll();
        http.authorizeRequests().antMatchers("/login/**").permitAll();
        //endpoint user
        http.authorizeRequests().antMatchers(
                "/user/submit",
                "/user/display-all",
                "/user/update/{userId}",
                "/user/display-by-id/{userId}",
                "/user/user-delete-by-id/{userId}");
        //endpoint kategory
        http.authorizeRequests().antMatchers(
                "/api/kategori/submit",
                "/api/kategori/select-all",
                "/api/kategori/select-by-id/{id}",
                "/api/kategori/update/{id}",
                "/api/kategori/delete/{id}");
//        endpoint penawaran
        http.authorizeRequests().antMatchers(
                "/api/penawaran/submit");
        http.authorizeRequests().anyRequest().authenticated();

        //get get token dari endpoint login ke endpoint lainnya
        http.addFilterBefore(new CustomizeAuthorFilterConfig(), UsernamePasswordAuthenticationFilter.class);
        http.addFilter(new CustomizeFilterConfig(authenticationManagerBean(), userLoginService));
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**");
    }
}



