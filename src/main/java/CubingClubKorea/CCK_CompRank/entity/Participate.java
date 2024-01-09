package CubingClubKorea.CCK_CompRank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="CubeEvent")
public class Participate {
    @Id
    @Column(name="Idx")
    private int Idx;

    @Column(name="UserName")
    private String UserName;

    @Column(name="Email")
    private String Email;

    @Column(name = "EventName")
    private String EventName;

    @Column(name="Round")
    private int Round;

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
    private int SingleM;

    @Column(name = "SingleS")
    private float SingleS;

    @Column(name="AvgM")
    private int AvgM;

    @Column(name = "AvgS")
    private float AvgS;

    @Column(name="Checker1")
    private String Checker1;

    @Column(name = "Checker2")
    private String Checker2;

    @Builder
    public Participate(int Idx, String UserName, String Email, String EventName, int Round){
        this.Idx=Idx;
        this.UserName=UserName;
        this.Email=Email;
        this.EventName=EventName;
        this.Round=Round;
    }

    public Participate update( int m1, float s1, int m2, float s2, int m3, float s3, int m4, float s4, int m5, float s5,int SingleM, float SingleS, int AvgM, float AvgS, String Checker1){
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
        this.SingleM=SingleM;
        this.SingleS=SingleS;
        this.AvgM=AvgM;
        this.AvgS=AvgS;
        this.Checker1=Checker1;
        return this;
    }

    public Participate update(String Checker2){
        this.Checker2=Checker2;
        return this;
    }

}
