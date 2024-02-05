package CubingClubKorea.CCK_CompRank.DTO;

import CubingClubKorea.CCK_CompRank.entity.Account;
import CubingClubKorea.CCK_CompRank.entity.CompList;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountDTO {
    private int id;

    private String email;

    private String name;

    private String password;

    private String position;

    public AccountDTO(Account entity){
        this.id=entity.getId();
        this.email= entity.getEmail();
        this.name= entity.getName();
        this.password= entity.getPassword();
        this.position= entity.getPosition();
    }

    public Account toEntity(){
        return Account.builder()
                .id(id)
                .email(email)
                .name(name)
                .password(password)
                .position(position)
                .build();
    }

}
