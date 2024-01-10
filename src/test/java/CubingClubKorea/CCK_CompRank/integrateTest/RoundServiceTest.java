package CubingClubKorea.CCK_CompRank.integrateTest;

import CubingClubKorea.CCK_CompRank.Repository.CompListRepository;
import CubingClubKorea.CCK_CompRank.Service.CompListService;
import CubingClubKorea.CCK_CompRank.Service.RoundService;
import CubingClubKorea.CCK_CompRank.entity.CompList;
import CubingClubKorea.CCK_CompRank.entity.Round;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


@SpringBootTest
public class RoundServiceTest {
    @Autowired
    private RoundService roundService;

    @Test
    @DisplayName("라운드 불러오기 테스트")
    void findComp() throws Exception{
        //given
        Date now=new Date();

        List<Round> roundPast=roundService.getRoundPast(now, 1);

        for(Round com: roundPast){
            System.out.println(com.getEventName());
            System.out.println(com.getRound());
            System.out.println(com.getEventStart());
            System.out.println(com.getEventEnd());
        }

    }
}
