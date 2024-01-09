package CubingClubKorea.CCK_CompRank.DTO;


import CubingClubKorea.CCK_CompRank.entity.CubeEvent;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CubeEventDTO {
    private String EventName;

    private String AvgCalc;

    public CubeEventDTO(CubeEvent entity){
        this.EventName=entity.getEventName();
        this.AvgCalc=entity.getAvgCalc();
    }
}
