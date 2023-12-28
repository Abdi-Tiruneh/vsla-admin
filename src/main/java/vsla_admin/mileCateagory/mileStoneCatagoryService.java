package vsla_admin.mileCateagory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class mileStoneCatagoryService {
    private  final mileStoneCatagoryRepository mileStoneCatagoryRepositories;

    @Autowired
    public mileStoneCatagoryService(mileStoneCatagoryRepository mileStoneCatagoryRepositories) {
        this.mileStoneCatagoryRepositories = mileStoneCatagoryRepositories;
}
 
public String getCatagory(int value) {
    if(value>= 1000 && value < 5000) {
    return "Bronze Level";
    } else if(value>= 5000 && value < 10000) {
        return "Gold Level";
    } else if (value >= 10000 && value < 30000) {
       return "silver Level";
    } else if(value >= 30000) {
        return "Platinum Level";
    } else {
        return "Unknown";
    }
}  
}