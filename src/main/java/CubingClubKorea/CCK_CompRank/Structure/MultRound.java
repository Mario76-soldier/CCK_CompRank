package CubingClubKorea.CCK_CompRank.Structure;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MultRound {
    List<Integer> compIdx=new ArrayList<>();
    List<Integer> seq=new ArrayList<>();
    List<String> eventName=new ArrayList<>();
    List<String> round=new ArrayList<>();
    String[] eventStart;
    String[] eventEnd;
    List<Integer> advance=new ArrayList<>();
}
