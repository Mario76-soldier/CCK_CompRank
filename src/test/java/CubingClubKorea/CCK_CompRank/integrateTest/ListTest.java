package CubingClubKorea.CCK_CompRank.integrateTest;

import CubingClubKorea.CCK_CompRank.Repository.CompListRepository;
import CubingClubKorea.CCK_CompRank.Service.CompListService;
import CubingClubKorea.CCK_CompRank.entity.CompList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ListTest {
    @Autowired
    private CompListService complistService;

    @Autowired
    private CompListRepository complistRepository;

    @Test
    @DisplayName("리스트 불러오기 테스트")
    void findComp() throws Exception{
        //given
        Date now=new Date();

        List<CompList> compListPast=complistService.getListPast(now);

        for(CompList com: compListPast){
            System.out.println(com.getCompName());
            System.out.println(com.getCompDate());
        }

    }
}
