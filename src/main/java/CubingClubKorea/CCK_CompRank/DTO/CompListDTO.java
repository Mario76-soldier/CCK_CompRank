package CubingClubKorea.CCK_CompRank.DTO;


import CubingClubKorea.CCK_CompRank.entity.CompList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CompListDTO {
    private int Idx;

    private String CompName;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date CompDate;

    private int CountRound;

    public CompListDTO(CompList entity){
        this.Idx=entity.getIdx();
        this.CompName=entity.getCompName();
        this.CompDate=entity.getCompDate();
        this.CountRound=entity.getCountRound();
    }

    public CompList toEntity(){
        return CompList.builder()
                .CompName(CompName)
                .CompDate(CompDate)
                .CountRound(CountRound)
                .build();
    }
}
