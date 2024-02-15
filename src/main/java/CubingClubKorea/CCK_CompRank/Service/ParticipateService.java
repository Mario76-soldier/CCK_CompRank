package CubingClubKorea.CCK_CompRank.Service;


import CubingClubKorea.CCK_CompRank.Repository.ParticipateRepository;
import CubingClubKorea.CCK_CompRank.entity.Participate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import special.Recorder;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ParticipateService {
    @Autowired
    private final ParticipateRepository participateRepository;

    public List<Participate> getParticipate(int round){
        return participateRepository.findByRoundOrderByAvgMAscAvgSAsc(round);
    }

    public List<Participate> getSearchedParticipate(int round, String search){
        return participateRepository.search(round, search);
    }

    public Integer updateRecordAo5(Recorder recorder, int idx){
        int m1,m2,m3,m4,m5,singleM,avgM;
        double s1,s2,s3,s4,s5,singleS,avgS;
        double f,s,t,o,i;

        m1=recorder.getFirst()/10000;
        s1=((double) recorder.getFirst()%10000)/100;
        f=m1*60+s1;
        m2=recorder.getSecond()/10000;
        s2=((double) recorder.getSecond()%10000)/100;
        s=m2*60+s2;
        m3=recorder.getThird()/10000;
        s3=((double) recorder.getThird()%10000)/100;
        t=m3*60+s3;
        m4=recorder.getFourth()/10000;
        s4=((double) recorder.getFourth()%10000)/100;
        o=m4*60+s4;
        m5=recorder.getFifth()/10000;
        s5=((double) recorder.getFifth()%10000)/100;
        i=m5*60+s5;

        double record[]={f,s,t,o,i};
        Arrays.sort(record);

        double single=36000;

        int dnfCounter=0;

        for(int j=0; j<5; j++){
            if(record[j]==0){
                dnfCounter++;
                continue;
            }
            else{
                if(record[j]<single){
                    single=record[j];
                }
            }
        }

        if(single==36000){
            single=0;
        }

        if(dnfCounter>=2){
            avgM=0;
            avgS=0;
        }
        else{
            avgM=(((int)record[1]+(int)record[2]+(int)record[3])/3)/60;
            avgS=Math.floor((((record[1]+record[2]+record[3])/3)%60)*100)/100;
        }

        singleM=(int)single/60;
        singleS=single%60;

        if(s1>=0 && s1<60 && s2>=0 && s2<60 &&s3>=0 && s3<60 &&s4>=0 && s4<60 && s5>=0 && s5<60) {
            participateRepository.updateRecord(m1, s1, m2, s2, m3, s3, m4, s4, m5, s5, avgM, avgS, singleM, singleS, idx);
            return idx;
        }
        else{
            return -1;
        }
    }

    public Integer updateRecordMo3(Recorder recorder, int idx){
        int m1,m2,m3,singleM,avgM;
        double s1,s2,s3,singleS,avgS;
        double f,s,t;

        m1=recorder.getFirst()/10000;
        s1=((double) recorder.getFirst()%10000)/100;
        f=m1*60+s1;
        m2=recorder.getSecond()/10000;
        s2=((double) recorder.getSecond()%10000)/100;
        s=m2*60+s2;
        m3=recorder.getThird()/10000;
        s3=((double) recorder.getThird()%10000)/100;
        t=m3*60+s3;

        double record[]={f,s,t};
        Arrays.sort(record);

        singleM=(int)record[0]/60;
        singleS=record[0]%60;

        avgM=(((int)record[0]+(int)record[1]+(int)record[2])/3)/60;
        avgS=Math.floor((((record[0]+record[1]+record[2])/3)%60)*100)/100;

        if(s1>=0 && s1<60 && s2>=0 && s2<60 &&s3>=0 && s3<60) {
            participateRepository.updateRecord(m1, s1, m2, s2, m3, s3, 0, 0, 0, 0, avgM, avgS, singleM, singleS, idx);
            return idx;
        }
        else{
            return -1;
        }
    }

    public void deleteParticipate(int idx){
        participateRepository.deleteByIdx(idx);
    }

    public int addParticipate(Participate participate){
        return participateRepository.save(participate).getIdx();
    }

    public void goAdvance(List<Participate> participate, int advance){
        for(int i=0; i<advance; i++){
            participateRepository.save(participate.get(i));
        }
    }
}
