package CubingClubKorea.CCK_CompRank.Service;

import CubingClubKorea.CCK_CompRank.Entity.CubeEvent;
import CubingClubKorea.CCK_CompRank.Repository.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class EventService {
    @Autowired
    private final EventRepository eventRepository;
    public CubeEvent findByEventName(String eventName){
        return eventRepository.findByEventName(eventName);
    }
}
