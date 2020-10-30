package com.june.book.springboot.config.auth;

import com.june.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private final CustomOAuth2UserService customOAuth2UserService;
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable().headers().frameOptions().disable()//h2-console화면사용하기위해 해당옵션 disable
//                .and().authorizeRequests()
//                .antMatchers("/", "/css/**", "/images/**", "/js/**", "h2-console/**").permitAll()
//                .antMatchers("/api/v1/**").hasRole(Role.USER.name())//andmatchers 권한관리대상 지저오옵션으로 URL,HTTP메소드별 관리가능
//                //"/" 지정된 URL은 전체열람권한주고 POST메소드이면서 "/api/주소가진 user권한사람만가능
//                .anyRequest().authenticated().and().logout().logoutSuccessUrl("/") //로그아웃 성공시 "/"여기로 이동
//                .and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
//                                    //userinfoendpoint 로그인성공이후 사용자 정보 가져올때 설정담당
//    }
private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}
