package CubingClubKorea.CCK_CompRank.integrateTest;

import CubingClubKorea.CCK_CompRank.Repository.CompListRepository;
import CubingClubKorea.CCK_CompRank.entity.CompList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CompListTest {
    @Autowired(required = true)
    private CompListRepository complistRepository;

    @Test
    @DisplayName("날짜 확인 테스트")
    void findComp() throws Exception{
        //given
        Date now=new Date();
        Date comp=new Date(2023,12,3);
        CompList complist=CompList.builder()
                .CompName("CCK2023")
                .CompDate(comp)
                .build();

        CompList saved=complistRepository.save(complist);

        CompList result=complistRepository.findByCompDateAfter(now).get(0);

        Assertions.assertThat(complist).isEqualTo(result);
    }
}
