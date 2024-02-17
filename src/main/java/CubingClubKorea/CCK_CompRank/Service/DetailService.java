package CubingClubKorea.CCK_CompRank.Service;

import CubingClubKorea.CCK_CompRank.Entity.Account;
import CubingClubKorea.CCK_CompRank.Handler.LoginCheckFailException;
import CubingClubKorea.CCK_CompRank.Repository.AccountRepository;
import CubingClubKorea.CCK_CompRank.Structure.AccountDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class DetailService implements UserDetailsService {
    private final AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account=accountRepository.findByEmail(email)
                .orElseThrow(()->new LoginCheckFailException());

        return new AccountDetail(account);
    }
}
