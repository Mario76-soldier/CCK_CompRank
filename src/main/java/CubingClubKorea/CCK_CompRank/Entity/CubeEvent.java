package CubingClubKorea.CCK_CompRank.Entity;

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
    private String eventName;

    @Column(name = "AvgCalc")
    private String avgCalc;

    @Builder
    public CubeEvent(String EventName, String AvgCalc){
        this.eventName=EventName;
        this.avgCalc=AvgCalc;
    }
}
