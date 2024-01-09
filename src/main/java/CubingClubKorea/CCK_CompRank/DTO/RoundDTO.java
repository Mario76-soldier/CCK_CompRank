package CubingClubKorea.CCK_CompRank.DTO;

import CubingClubKorea.CCK_CompRank.entity.Round;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Getter
@NoArgsConstructor
public class RoundDTO {
    private int Idx;

    private int CompIdx;

    private int Seq;

    private String EventName;

    private String Round;

    private Time EventStart;

    private Time EventEnd;

    public RoundDTO(Round entity){
        this.Idx=entity.getIdx();
        this.CompIdx=entity.getCompIdx();
        this.Seq=entity.getSeq();
        this.EventName=entity.getEventName();
        this.Round=entity.getRound();
        this.EventStart=entity.getEventStart();
        this.EventEnd=entity.getEventEnd();
    }
}
