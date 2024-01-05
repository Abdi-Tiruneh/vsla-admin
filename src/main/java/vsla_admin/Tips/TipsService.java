package vsla_admin.Tips;

import java.util.List;


public interface TipsService {

     Tips addTips(Tips tips);
    Tips editTips(Tips tips);
    List<Tips> getTips();
    List<Tips> getTipsForApp(Long organizationId);
    Tips getTipsByTipsId(Long TipsId); 
    Tips deleteTips (Long tipsId);

    
}




