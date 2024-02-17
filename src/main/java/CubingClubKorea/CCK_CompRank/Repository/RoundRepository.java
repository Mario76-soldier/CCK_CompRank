package CubingClubKorea.CCK_CompRank.Repository;

import CubingClubKorea.CCK_CompRank.Entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RoundRepository extends JpaRepository<Round, Integer> {
    Round findByIdx(Integer idx);
    List<Round> findByEventStartBeforeAndEventEndBeforeAndCompIdx(Date date, Date date2, int compIdx);
    List<Round> findByEventStartBeforeAndEventEndAfterAndCompIdx(Date date,Date date2, int compIdx);
    List<Round> findByEventStartAfterAndEventEndAfterAndCompIdx(Date date, Date date2, int compIdx);

    List<Round> findByCompIdx(int compIdx);

    @Modifying
    @Query("update Round u set u.advance=:advance where u.idx=:idx")
    void updateAdvance(@Param(value="idx")int idx, @Param(value = "advance")int advance);

    void deleteByCompIdx(int compIdx);

}
