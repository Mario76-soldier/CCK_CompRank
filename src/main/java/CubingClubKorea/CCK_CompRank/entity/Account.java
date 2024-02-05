package CubingClubKorea.CCK_CompRank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(name="Account")
public class Account {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="position")
    private String position;

    @Builder
    public Account(int id, String email, String name,String password, String position){
        this.id=id;
        this.email=email;
        this.name=name;
        this.password=password;
        this.position=position;
    }
}
