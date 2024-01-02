package vsla_admin.Tips;

import java.util.List;

import vsla_admin.TermsandConditions.TermsandConditions;

public interface TipsService {

     Tips addTips(Tips tips);
    Tips editTips(Tips tips);
    List<Tips> getTips();
    Tips getTipsByTipsId(Long TipsId); 

    
}




