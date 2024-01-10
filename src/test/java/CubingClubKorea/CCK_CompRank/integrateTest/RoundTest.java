package CubingClubKorea.CCK_CompRank.integrateTest;

import CubingClubKorea.CCK_CompRank.Repository.RoundRepository;
import CubingClubKorea.CCK_CompRank.entity.Round;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RoundTest {
    @Autowired(required = true)
    private RoundRepository roundRepository;

    Date now=new Date();

    @Test
    @DisplayName("라운드 출력 테스트")
    void findRound() throws Exception{
        //given
        List<Round> roundbefore=roundRepository.findByEventStartBeforeAndEventEndBeforeAndCompIdx(now, now,3);

        for(Round round: roundbefore){
            System.out.println(round.getEventName());
            System.out.println(round.getRound());
            System.out.println(round.getEventStart());
            System.out.println(round.getEventEnd());
        }
    }
}
