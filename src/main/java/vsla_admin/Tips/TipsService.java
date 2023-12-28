package vsla_admin.Tips;

import java.util.List;

public interface TipsService {
    
    Tips editTips(Tips tips);
    List<Tips> getTips();
    Tips getTipsByTipsId(Long TipsId);    
    
}




