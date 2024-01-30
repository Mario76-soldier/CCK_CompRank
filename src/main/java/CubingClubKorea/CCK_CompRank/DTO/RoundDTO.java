package CubingClubKorea.CCK_CompRank.DTO;

import CubingClubKorea.CCK_CompRank.entity.CompList;
import CubingClubKorea.CCK_CompRank.entity.Round;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.sql.Time;

@Getter
@NoArgsConstructor
public class RoundDTO {
    private int Idx;

    private int CompIdx;

    private int Seq;

    private String EventName;

    private String Round;

    private Date eventStart;

    private Date eventEnd;

    private int advance;

    public RoundDTO(Round entity){
        this.Idx=entity.getIdx();
        this.CompIdx=entity.getCompIdx();
        this.Seq=entity.getSeq();
        this.EventName=entity.getEventName();
        this.Round=entity.getRound();
        this.eventStart=entity.getEventStart();
        this.eventEnd=entity.getEventEnd();
        this.advance=entity.getAdvance();
    }
}
