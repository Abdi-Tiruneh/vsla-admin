package vsla_admin.Tips;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipServiceImpl implements TipsService {
    @Autowired
    private final TipsRepository tipsRepository;;

    @Override
    public List<Tips> getTips() {
        return  tipsRepository.findAll();
     
    }

    @Override
    public Tips getTipsByTipsId(Long TipsId) {
     return tipsRepository.findTipsByTipsId(TipsId);   
}

    @Override
    public Tips editTips(Tips tips) {
      return tipsRepository.save(tips);
    }

  }