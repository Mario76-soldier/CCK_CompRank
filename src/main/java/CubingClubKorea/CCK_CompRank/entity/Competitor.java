package CubingClubKorea.CCK_CompRank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="Competitor")
public class Competitor {

    @Id
    @Column(name="email")
    private String email;

    @Column(name="username")
    private String username;

    @Column(name="enusername")
    private String enusername;

    @Column(name="nation")
    private String nation;

    @Column(name="sex")
    private String sex;

    @Column(name="compIdx")
    private int compIdx;

    @Column(name="eventname")
    private String eventname;

    @Builder
    public Competitor(String email, String username, String enusername, String nation, String sex, int compIdx, String eventname){
        this.email=email;
        this.username=username;
        this.enusername=enusername;
        this.nation=nation;
        this.sex=sex;
        this.compIdx=compIdx;
        this.eventname=eventname;
    }
}
