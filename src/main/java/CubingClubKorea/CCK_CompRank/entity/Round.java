package CubingClubKorea.CCK_CompRank.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private int Idx;
    @Column(name="CompIdx")
    private int CompIdx;

    @Column(name="Seq")
    private int Seq;

    @Column(name="EventName")
    private String EventName;

    @Column(name="Round")
    private String Round;

    @Column(name="EventStart")
    private Time EventStart;

    @Column(name="EventEnd")
    private Time EventEnd;

    @Builder
    public Round(int Idx, int CompIdx, int Seq, String EventName, String Round, Time EventStart, Time EventEnd){
        this.Idx=Idx;
        this.CompIdx=CompIdx;
        this.Seq=Seq;
        this.EventName=EventName;
        this.Round=Round;
        this.EventStart=EventStart;
        this.EventEnd=EventEnd;
    }
}
