package CubingClubKorea.CCK_CompRank.DTO;

import CubingClubKorea.CCK_CompRank.entity.Competitor;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompetitorDTO {
        private String email;

        private String username;

        private String enusername;

        private String nation;

        private String sex;

        private int compIdx;

        private String eventname;

        public CompetitorDTO(Competitor entity){
            this.email=entity.getEmail();
            this.username=entity.getUsername();
            this.enusername=entity.getEnusername();
            this.nation=entity.getNation();
            this.sex=entity.getSex();
            this.compIdx= entity.getCompIdx();
            this.eventname=entity.getEventname();
        }
}
