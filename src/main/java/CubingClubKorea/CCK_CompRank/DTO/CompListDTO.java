package CubingClubKorea.CCK_CompRank.DTO;


import CubingClubKorea.CCK_CompRank.entity.CompList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import java.util.Date;

@Getter
@NoArgsConstructor
public class CompListDTO {
    private int Idx;

    private String CompName;

    private Date CompDate;

    public CompListDTO(CompList entity){
        this.Idx=entity.getIdx();
        this.CompName=entity.getCompName();
        this.CompDate=entity.getCompDate();
    }

    public CompList toEntity(){
        return CompList.builder()
                .Idx(Idx)
                .CompName(CompName)
                .CompDate(CompDate)
                .build();
    }
}
