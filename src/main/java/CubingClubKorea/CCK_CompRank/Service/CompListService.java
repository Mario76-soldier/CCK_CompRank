package CubingClubKorea.CCK_CompRank.Service;

import CubingClubKorea.CCK_CompRank.DTO.CompListDTO;
import CubingClubKorea.CCK_CompRank.Repository.CompListRepository;
import CubingClubKorea.CCK_CompRank.entity.CompList;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompListService {
    @Autowired
    private final CompListRepository complistRepository;

    public int create(CompListDTO compDTO){
        return complistRepository.save(compDTO.toEntity()).getIdx();
    }

    public List<CompList> getListToday(Date date){
        return (List<CompList>) complistRepository.findByCompDate(date);
    }

    public List<CompList> getListPast(Date date){
        return (List<CompList>) complistRepository.findByCompDateAfter(date);
    }

    public List<CompList> getListFuture(Date date){
        return (List<CompList>) complistRepository.findByCompDateBefore(date);
    }

}
