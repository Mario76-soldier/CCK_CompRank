package CubingClubKorea.CCK_CompRank.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@NoArgsConstructor
@DynamicInsert
@Table(name="Participate")
public class Participate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idx")
    private int idx;

    @Column(name="UserName")
    private String userName;

    @Column(name="EventName")
    private String eventName;

    @Column(name="Email")
    private String email;

    @Column(name="Round")
    private int round;

    @Column(name="m1")
    private int m1;

    @Column(name = "s1")
    private float s1;

    @Column(name="m2")
    private int m2;

    @Column(name = "s2")
    private float s2;

    @Column(name="m3")
    private int m3;

    @Column(name = "s3")
    private float s3;

    @Column(name="m4")
    private int m4;

    @Column(name = "s4")
    private float s4;

    @Column(name="m5")
    private int m5;

    @Column(name = "s5")
    private float s5;

    @Column(name="SingleM")
    private int singleM;

    @Column(name = "SingleS")
    private float singleS;

    @Column(name="AvgM")
    private int avgM;

    @Column(name = "AvgS")
    private float avgS;

    @Column(name="ranking")
    private Integer ranking;

    @Column(name="Checker1")
    private String checker1;

    @Column(name = "Checker2")
    private String checker2;

    @Builder
    public Participate(String UserName, String Email, String EventName, int Round){
        this.userName=UserName;
        this.eventName=EventName;
        this.email=Email;
        this.round=Round;
    }

    public Participate update( int m1, float s1, int m2, float s2, int m3, float s3, int m4, float s4, int m5, float s5,int SingleM, float SingleS, int AvgM, float AvgS, Integer Ranking, String Checker1){
        this.m1=m1;
        this.s1=s1;
        this.m2=m2;
        this.s2=s2;
        this.m3=m3;
        this.s3=s3;
        this.m4=m4;
        this.s4=s4;
        this.m5=m5;
        this.s5=s5;
        this.singleM=SingleM;
        this.singleS=SingleS;
        this.avgM=AvgM;
        this.avgS=AvgS;
        this.ranking=Ranking;
        this.checker1=Checker1;
        return this;
    }

    public Participate update(String Checker2){
        this.checker2=Checker2;
        return this;
    }

}
