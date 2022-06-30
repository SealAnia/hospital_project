package com.example.hospital.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.hospital.service.impl.UserServiceImpl;

@Configuration
public class AppConfiguration extends WebSecurityConfigurerAdapter  {
	
	private UserServiceImpl userService;
	
	@Autowired
	public AppConfiguration(UserServiceImpl userService) {
        this.userService = userService;
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		var authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			
			.antMatchers(HttpMethod.GET, "/adminpage")
			.hasRole("ADMIN")
			
			.antMatchers(HttpMethod.GET, "/main")
			.hasAnyRole("DOCTOR", "NURSE")
			
			.antMatchers("/medicines", "/procedures", "/operations",
					"/prescriptions", "/patients", "/showpatientform", 
					"/showoperationform", "showprocedureform", 
					"/showmedicineform", "/showprescriptionform", 
					"/showeditmedicine/{id}", "/showeditoperation/{id}", 
					"/showeditprocedure/{procedureid}", "/showeditpatient/{patientid}",
					"/deletemedicine/{id}", "/deleteoperation/{id}", 
					"/deletepatientinfo/{patientid}", "/deleteprocedure/{procedureid}")
			.hasAnyRole("DOCTOR", "NURSE")
			
			.antMatchers("/showoperationform")
			.hasRole("DOCTOR")
			
			.antMatchers("/showdepartmentform", "/showworkerform", 
					"/showeditworker/{userid}", "/showeditdepartment/{id}", 
					"/deleteworkerinfo/{userid}", "/deletedepartment/{id}")
			.hasRole("ADMIN")
			
			.and()
		    .exceptionHandling().accessDeniedPage("/not_enough_authorities")
			
			.and()
			.formLogin()
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/main");
	}

}
