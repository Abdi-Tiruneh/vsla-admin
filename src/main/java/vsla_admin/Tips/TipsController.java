package vsla_admin.Tips;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/Tips")

public class TipsController {

    @Autowired
    private final TipsService tipsService;


    @GetMapping("/getTips")
    List<Tips> getTips() {
        return this.tipsService.getTips();
        
    }


    @GetMapping("/{TipsId}")
    Tips geTips(@PathVariable Long TipsId) {
        return tipsService.getTipsByTipsId(TipsId);
    }

    @PutMapping("/edit/{TipsId}")
    Tips edTips(@RequestBody Tips tempTips , @PathVariable Long TipsId) {
        Tips tips = this.tipsService.getTipsByTipsId(TipsId);
        tips.setTitle(tempTips.getTitle());
        tips.setDescription(tempTips.getDescription());
        return tipsService.editTips(tips);
    }
    
}


    
