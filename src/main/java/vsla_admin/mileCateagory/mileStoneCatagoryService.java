package vsla_admin.mileCateagory;

import java.util.List;

import org.springframework.stereotype.Service;

@Service

public interface mileStoneCatagoryService {

   List<mileStoneCatagory> getMileStoneCatagory();

    
} 
 
// public String getCatagory(int value) {
//     if(value>= 1000 && value < 5000) {
//     return "Bronze Level";
//     } else if(value>= 5000 && value < 10000) {
//         return "Gold Level";
//     } else if (value >= 10000 && value < 30000) {
//        return "silver Level";
//     } else if(value >= 30000) {
//         return "Platinum Level";
//     } else {
//         return "Unknown";
//     }
// }  
