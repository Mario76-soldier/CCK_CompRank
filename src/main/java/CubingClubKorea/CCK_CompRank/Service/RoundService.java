package CubingClubKorea.CCK_CompRank.Service;


import CubingClubKorea.CCK_CompRank.Repository.RoundRepository;
import CubingClubKorea.CCK_CompRank.Entity.Round;
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

    public Round getOne(int idx){
        return roundRepository.findByIdx(idx);
    }

    public List<Round> getCompRound(int idx){
        return (List<Round>) roundRepository.findByCompIdx(idx);
    }
    public List<Round> getRoundNow(Date date, int idx){
        return (List<Round>) roundRepository.findByEventStartBeforeAndEventEndAfterAndCompIdx(date,date,idx);
    }

    public List<Round> getRoundFuture(Date date, int idx){
        return (List<Round>) roundRepository.findByEventStartAfterAndEventEndAfterAndCompIdx(date,date,idx);
    }

    public List<Round> getRoundPast(Date date, int idx){
        return (List<Round>) roundRepository.findByEventStartBeforeAndEventEndBeforeAndCompIdx(date, date, idx);
    }

    public int newRound(Round round){
        roundRepository.save(round);

        return round.getIdx();
    }

    public void deleteRound(int idx){
        roundRepository.deleteByCompIdx(idx);
    }

    public void deleteByRoundIdx(int idx){
        roundRepository.deleteByIdx(idx);
    }
    public void updateAdvance(int idx, int advance){
        roundRepository.updateAdvance(idx, advance);
    }
}
