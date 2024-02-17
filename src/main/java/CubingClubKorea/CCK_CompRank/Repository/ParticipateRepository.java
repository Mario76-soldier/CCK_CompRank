package CubingClubKorea.CCK_CompRank.Repository;

import CubingClubKorea.CCK_CompRank.Entity.Participate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipateRepository extends JpaRepository<Participate, Integer> {

    @Query("select u from Participate u where u.round=:round order by (case when u.avgM=0 and u.avgS=0 then 1 else 0 end), u.avgM asc, u.avgS asc")
    List<Participate> findByRoundOrderByAvgMAscAvgSAsc(@Param(value="round")int round);

    @Query("select u from Participate u where u.round=:round and u.userName like %:search%  order by (case when u.avgM=0 and u.avgS=0 then 1 else 0 end), u.avgM asc, u.avgS asc")
    List<Participate> search(@Param(value="round")int round, @Param(value="search")String search);

    @Modifying
    @Query("update Participate p set p.m1=:m1, p.s1=:s1, " +
            "p.m2=:m2, p.s2=:s2," +
            "p.m3=:m3, p.s3=:s3," +
            "p.m4=:m4, p.s4=:s4," +
            "p.m5=:m5, p.s5=:s5," +
            " p.avgM=:avgM, p.avgS=:avgS, " +
            "p.singleM=:singleM, p.singleS=:singleS " +
            "where p.idx=:idx")
    void updateRecord(@Param(value="m1")int m1, @Param(value="s1")double s1,
                      @Param(value="m2")int m2, @Param(value="s2")double s2,
                      @Param(value="m3")int m3, @Param(value="s3")double s3,
                      @Param(value="m4")int m4, @Param(value="s4")double s4,
                      @Param(value="m5")int m5, @Param(value="s5")double s5,
                      @Param(value="avgM")int avgM, @Param(value="avgS")double avgS,
                      @Param(value="singleM")int singleM, @Param(value="singleS")double singleS,
                      @Param(value="idx")int idx);

    void deleteByIdx(int idx);
}
