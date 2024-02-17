package CubingClubKorea.CCK_CompRank.DTO;

import CubingClubKorea.CCK_CompRank.Entity.Account;
import CubingClubKorea.CCK_CompRank.Entity.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountDTO {
    private String email;

    private String name;

    private String password;
    private String passwordCheck;


    public Account toEntity(String encodedPassword){
        return Account.builder()
                .email(this.email)
                .name(this.name)
                .password(encodedPassword)
                .position(UserRole.customer)
                .build();
    }

}
