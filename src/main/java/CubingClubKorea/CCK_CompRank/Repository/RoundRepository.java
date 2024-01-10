package CubingClubKorea.CCK_CompRank.Repository;

import CubingClubKorea.CCK_CompRank.entity.CompList;
import CubingClubKorea.CCK_CompRank.entity.CubeEvent;
import CubingClubKorea.CCK_CompRank.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface RoundRepository extends JpaRepository<Round, Integer> {
    List<Round> findByEventStartBeforeAndEventEndBeforeAndCompIdx(Date date, Date date2, int compIdx);
    List<Round> findByEventStartBeforeAndEventEndAfterAndCompIdx(Date date,Date date2, int compIdx);
    List<Round> findByEventStartAfterAndEventEndAfterAndCompIdx(Date date, Date date2, int compIdx);
}
