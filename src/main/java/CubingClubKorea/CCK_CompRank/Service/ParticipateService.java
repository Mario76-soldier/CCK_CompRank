package CubingClubKorea.CCK_CompRank.Service;


import CubingClubKorea.CCK_CompRank.Repository.ParticipateRepository;
import CubingClubKorea.CCK_CompRank.entity.Participate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ParticipateService {
    @Autowired
    private final ParticipateRepository parcitipateRepository;

    public List<Participate> getParticipate(int round){
        return parcitipateRepository.findByRoundOrderByAvgMAscAvgSAsc(round);
    }
}
