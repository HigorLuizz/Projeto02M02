package com.example.projeto02m02.security;

import com.example.projeto02m02.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
                .antMatchers(HttpMethod.GET, "/medicamentos")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/farmacias")
                .permitAll()
                .antMatchers(HttpMethod.POST,"/medicamentos/**").permitAll()
                .antMatchers(HttpMethod.POST,"/farmacias/**").permitAll()
                .antMatchers(HttpMethod.POST,"/usuarios/**").permitAll()

                .antMatchers(HttpMethod.PUT,"/medicamentos").hasAnyRole("ADMINISTRADOR","GERENTE")
                .antMatchers(HttpMethod.PUT,"/farmacias").hasAnyRole("ADMINISTRADOR","GERENTE")
                .antMatchers(HttpMethod.PUT,"/usuarios").hasAnyRole("ADMINISTRADOR","GERENTE")
//
                .antMatchers(HttpMethod.DELETE,"/usuarios/**").hasRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.DELETE,"/medicamentos/**").hasRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.DELETE,"/farmacias/**").hasRole("ADMINISTRADOR")

                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                /*Filtrar as requisições de login para fazer autenticação*/
                .addFilterBefore(new JwtLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtApiAutenticacaoFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Service que irá consultar o usuário no banco de dados
        auth.userDetailsService(usuarioService)

                // definir a codificação de senha
                .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // configura URLs para não passar pelos filtros de segurança
        web.ignoring().antMatchers("/**.html",
                "/v2/api-docs",
                "/webjars/**");
    }
}
