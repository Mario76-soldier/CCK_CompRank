package CubingClubKorea.CCK_CompRank.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="CubeEvent")
public class CubeEvent {
    @Id
    @Column(name="EventName")
    private String EventName;

    @Column(name = "AvgCalc")
    private String AvgCalc;

    @Builder
    public CubeEvent(String EventName, String AvgCalc){
        this.EventName=EventName;
        this.AvgCalc=AvgCalc;
    }
}
