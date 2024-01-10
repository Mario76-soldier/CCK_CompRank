package CubingClubKorea.CCK_CompRank.Service;


import CubingClubKorea.CCK_CompRank.DTO.CompListDTO;
import CubingClubKorea.CCK_CompRank.DTO.RoundDTO;
import CubingClubKorea.CCK_CompRank.Repository.RoundRepository;
import CubingClubKorea.CCK_CompRank.entity.CompList;
import CubingClubKorea.CCK_CompRank.entity.Round;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoundService {

    @Autowired
    private final RoundRepository roundRepository;

    /**public int create(RoundDTO roundDTO){
        return roundRepository.save(RoundDTO.toEntity()).getIdx();
    }
     **/

    public List<Round> getRoundNow(Date date, int idx){
        return (List<Round>) roundRepository.findByEventStartBeforeAndEventEndAfterAndCompIdx(date,date,idx);
    }

    public List<Round> getRoundFuture(Date date, int idx){
        return (List<Round>) roundRepository.findByEventStartAfterAndEventEndAfterAndCompIdx(date,date,idx);
    }

    public List<Round> getRoundPast(Date date, int idx){
        return (List<Round>) roundRepository.findByEventStartBeforeAndEventEndBeforeAndCompIdx(date, date, idx);
    }

}
