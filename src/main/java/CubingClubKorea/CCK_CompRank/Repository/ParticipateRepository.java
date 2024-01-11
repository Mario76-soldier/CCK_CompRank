package CubingClubKorea.CCK_CompRank.Repository;

import CubingClubKorea.CCK_CompRank.entity.Participate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipateRepository extends JpaRepository<Participate, Integer> {
    List<Participate> findByRoundOrderByAvgMAscAvgSAsc(int round);
}
