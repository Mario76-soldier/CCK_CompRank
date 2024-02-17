package CubingClubKorea.CCK_CompRank.Structure;

import CubingClubKorea.CCK_CompRank.DTO.AccountRequest;
import CubingClubKorea.CCK_CompRank.Entity.Account;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Getter
public class AccountDetail implements UserDetails {
    private final Account account;
    public AccountDetail(Account account){
        this.account=account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        Collection<GrantedAuthority> collections = new ArrayList<>();
        collections.add(() -> {
            return account.getPosition().name();
        });

        return collections;
    }
    @Override
    public String getPassword(){
        return account.getPassword();
    }

    @Override
    public String getUsername(){
        return account.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
