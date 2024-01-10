package CubingClubKorea.CCK_CompRank.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(name="Round")
public class Round {
    @Id
    @Column(name="Idx")
    private int idx;
    @Column(name="CompIdx")
    private int compIdx;

    @Column(name="Seq")
    private int seq;

    @Column(name="EventName")
    private String eventName;

    @Column(name="Round")
    private String round;

    @Column(name="EventStart")
    private Date eventStart;

    @Column(name="EventEnd")
    private Date eventEnd;

    @Builder
    public Round(int Idx, int CompIdx, int Seq, String EventName, String Round, Time EventStart, Time EventEnd){
        this.idx=Idx;
        this.compIdx=CompIdx;
        this.seq=Seq;
        this.eventName=EventName;
        this.round=Round;
        this.eventStart=EventStart;
        this.eventEnd=EventEnd;
    }
}
