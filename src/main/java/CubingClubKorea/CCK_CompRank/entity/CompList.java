package CubingClubKorea.CCK_CompRank.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(name="CompList")
public class CompList {
    @Id
    @GeneratedValue
    @Column(name="Idx")
    private int idx;

    @Column(name = "CompName")
    private String compName;

    @Column(name = "CompDate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date compDate;

    @Builder
    public CompList(int Idx, String CompName, Date CompDate){
        this.idx=Idx;
        this.compName=CompName;
        this.compDate=CompDate;
    }

}
