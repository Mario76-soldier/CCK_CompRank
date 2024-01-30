package CubingClubKorea.CCK_CompRank.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class ParticipateDTO {

    private int Idx;

    private String UserName;

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
}
