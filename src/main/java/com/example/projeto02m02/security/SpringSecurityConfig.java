package com.example.projeto02m02.security;

import com.example.projeto02m02.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/usuarios")
                .permitAll()

                .antMatchers(HttpMethod.POST,"/usuarios/**").hasRole("GERENTE")
                .antMatchers(HttpMethod.PUT,"/usuarios/**").hasRole("GERENTE")
                .antMatchers(HttpMethod.GET,"/usuarios/**").hasRole("GERENTE")

                .antMatchers(HttpMethod.POST,"/usuarios/**").hasRole("COLABORADOR")
                .antMatchers(HttpMethod.GET,"/usuarios/**").hasRole("COLABORADOR")

                .antMatchers("/usuarios/**").hasRole("ADMINISTRADOR")
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
