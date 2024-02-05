package CubingClubKorea.CCK_CompRank.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@DynamicInsert
@Table(name="CompList")
public class CompList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idx")
    private int idx;

    @Column(name = "CompName")
    private String compName;

    @Column(name = "CompDate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date compDate;

    @Column(name = "CountRound")
    private int countRound;
    @Builder
    public CompList(String CompName, Date CompDate, int CountRound){
        this.compName=CompName;
        this.compDate=CompDate;
        this.countRound=CountRound;
    }

}
