package vsla_admin.mileStoneSetting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class mileController {

    @GetMapping("/category")
    public String getCategory(@RequestParam("value") int value) {
        if (value > 1000) {
            return "Bronze";
        } else if (value >= 10000 && value <= 50000) {
            return "Gold";
        } else {
            return "Unknown";
        }
    }
}
    

