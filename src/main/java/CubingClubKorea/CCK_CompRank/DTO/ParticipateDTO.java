package CubingClubKorea.CCK_CompRank.DTO;

import CubingClubKorea.CCK_CompRank.Entity.Participate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ParticipateDTO {

    private int Idx;

    private String UserName;

    private String EventName;

    private String Email;

    private int Round;

    private int m1;

    private float s1;

    private int m2;

    private float s2;

    private int m3;

    private float s3;

    private int m4;

    private float s4;

    private int m5;

    private float s5;

    private int SingleM;

    private float SingleS;

    private int AvgM;

    private float AvgS;

    private String Checker1;

    private String Checker2;


    public ParticipateDTO(Participate entity){
        this.Idx=entity.getIdx();
        this.UserName=entity.getUserName();
        this.EventName=entity.getEventName();
        this.Email=entity.getEmail();
        this.Round=entity.getRound();
        this.m1=entity.getM1();
        this.s1=entity.getS1();
        this.m2=entity.getM2();
        this.s2=entity.getS2();
        this.m3=entity.getM3();
        this.s3=entity.getS3();
        this.m4=entity.getM4();
        this.s4=entity.getS4();
        this.m5=entity.getM5();
        this.s5=entity.getS5();
        this.SingleM=entity.getSingleM();
        this.SingleS=entity.getSingleS();
        this.AvgM=entity.getAvgM();
        this.AvgS=entity.getAvgS();
        this.Checker1=entity.getChecker1();
        this.Checker2=entity.getChecker2();
    }

    public Participate toEntity(){
        return Participate.builder()
                .UserName(UserName)
                .EventName(EventName)
                .Email(Email)
                .Round(Round)
                .build();
    }
}
