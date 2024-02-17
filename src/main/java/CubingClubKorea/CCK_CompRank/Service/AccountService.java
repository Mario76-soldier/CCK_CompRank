package CubingClubKorea.CCK_CompRank.Service;

import CubingClubKorea.CCK_CompRank.DTO.AccountDTO;
import CubingClubKorea.CCK_CompRank.DTO.AccountRequest;
import CubingClubKorea.CCK_CompRank.Entity.Account;
import CubingClubKorea.CCK_CompRank.Handler.LoginCheckFailException;
import CubingClubKorea.CCK_CompRank.Repository.AccountRepository;
import CubingClubKorea.CCK_CompRank.Structure.AccountDetail;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder encoder;

    public boolean checkEmailDuplicate(String email){
        return accountRepository.existsByEmail(email);
    }
    public void join(AccountDTO accountDTO){
        accountRepository.save(accountDTO.toEntity(encoder.encode(accountDTO.getPassword())));
    }

    public Account login(AccountRequest accountRequest){
        Optional<Account> account=accountRepository.findByEmail(accountRequest.getEmail());

        if(account.isEmpty()){
            return null;
        }

        Account account1=account.get();

        if(!account1.getPassword().equals(accountRequest.getPassword())){
            return null;
        }

        return account1;
    }


    public Account getLoginUserByLoginId(String email) {
        if(email == null) return null;

        Optional<Account> optionalUser = accountRepository.findByEmail(email);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }
}
