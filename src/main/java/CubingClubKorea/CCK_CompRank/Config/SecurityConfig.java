package CubingClubKorea.CCK_CompRank.Config;


import CubingClubKorea.CCK_CompRank.Entity.UserRole;
import CubingClubKorea.CCK_CompRank.Handler.CsrfCookieFilter;
import CubingClubKorea.CCK_CompRank.Handler.LoginFailHandler;
import CubingClubKorea.CCK_CompRank.Handler.LoginSuccessHandler;
import CubingClubKorea.CCK_CompRank.Service.AccountService;
import CubingClubKorea.CCK_CompRank.Service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{
    private final DetailService detailService;
    private static final int ONE_DAY = 86400;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");
        return http
                .csrf(csrf -> csrf
                        .csrfTokenRequestHandler(requestHandler)
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .ignoringRequestMatchers("/", "/login/**", "/logout/**", "/round", "/record", "/join/**")
                )
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/makecomp","/makeround","/addparticipate","/recordcomp","/advance","/deletecomp","/deleterecord","/updateadvance").hasAuthority(UserRole.admin.name())
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin(customizer -> customizer
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("email")
                        .successHandler(new LoginSuccessHandler())
                        .failureHandler(new LoginFailHandler())
                        .permitAll()
                )
                .rememberMe(customizer -> customizer
                        .rememberMeParameter("remember-me")
                        .tokenValiditySeconds(ONE_DAY)
                        .userDetailsService(detailService)
                        .authenticationSuccessHandler(new LoginSuccessHandler())
                )
                .logout(customizer -> customizer
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .deleteCookies("remember-me")
                        .permitAll()
                )
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults())
                .build();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }
}
