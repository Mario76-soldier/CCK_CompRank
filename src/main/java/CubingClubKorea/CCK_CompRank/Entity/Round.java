package CubingClubKorea.CCK_CompRank.Entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(name="Round")
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Idx")
    private int idx;

    @Column(name="CompIdx")
    private int compIdx;

    @Column(name="Seq")
    private int seq;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EventName")
    private CubeEvent cubeEvent;

    @Column(name="Round")
    private String round;

    @Column(name="EventStart")
    private Date eventStart;

    @Column(name="EventEnd")
    private Date eventEnd;

    @Column(name="Advance")
    private int advance;

    @Builder
    public Round(int Idx, int CompIdx, int Seq, CubeEvent cubeEvent, String Round, Date EventStart, Date EventEnd, int Advance){
        this.idx=Idx;
        this.compIdx=CompIdx;
        this.seq=Seq;
        this.cubeEvent=cubeEvent;
        this.round=Round;
        this.eventStart=EventStart;
        this.eventEnd=EventEnd;
        this.advance=Advance;
    }
}
