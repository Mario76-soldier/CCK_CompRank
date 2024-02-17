package CubingClubKorea.CCK_CompRank.Service;

import CubingClubKorea.CCK_CompRank.Handler.LoginCheckFailException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountAuthenticationProvider implements AuthenticationProvider {
    private final DetailService detailService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        UserDetails memberDetails = detailService.loadUserByUsername(email);

        String rawPassword = authentication.getCredentials().toString();
        String hashPassword = memberDetails.getPassword();
        checkPassword(rawPassword, hashPassword);

        return new UsernamePasswordAuthenticationToken(email, rawPassword, memberDetails.getAuthorities());
    }

    private void checkPassword(String rawPassword, String hashPassword) {
        boolean isPasswordMatch = passwordEncoder.matches(rawPassword, hashPassword);
        if(isPasswordMatch == false){
            throw new LoginCheckFailException();
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
