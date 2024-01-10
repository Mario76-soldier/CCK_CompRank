package CubingClubKorea.CCK_CompRank.Repository;

import CubingClubKorea.CCK_CompRank.entity.CompList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface CompListRepository extends JpaRepository<CompList, Integer> {
    CompList findByIdx(Integer idx);
    List<CompList> findAll();
    List<CompList> findByCompDateBefore(Date date);
    List<CompList> findByCompDate(Date date);
    List<CompList> findByCompDateAfter(Date date);
}
