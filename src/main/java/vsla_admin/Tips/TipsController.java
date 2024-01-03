package vsla_admin.Tips;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import vsla_admin.Response.createResponse;
import vsla_admin.loanSetting.loanSetting;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/Tips")

public class TipsController {

    @Autowired
    private final TipsService tipsService;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;
    private final TipsRepository tipsRepositories;

    @GetMapping("/getTips")
    List<Tips> getTips() {
        return this.tipsService.getTips();

    }

    @GetMapping("/{TipsId}")
    Tips geTips(@PathVariable Long TipsId) {
        return tipsService.getTipsByTipsId(TipsId);
    }

    @PostMapping("/add")
    // public ResponseEntity<createResponse> addTips (@RequestBody Tips tips){
    // tipsService.addTips(tips);
    // createResponse response = new createResponse("success", "Tips created
    // sucessfully");
    // return new ResponseEntity<>(response, HttpStatus.OK);

    // }

    Tips addTips(@RequestBody Tips tips) {
        Users loggedInUser = currentlyLoggedInUser.getUser();
        tips.setOrganization(loggedInUser.getOrganization());
        tipsService.addTips(tips);
        return tipsService.addTips(tips);

    }

    @PutMapping("/edit/{TipsId}")
    Tips edTips(@RequestBody Tips tempTips, @PathVariable Long TipsId) {
        Tips tips = this.tipsService.getTipsByTipsId(TipsId);
        tips.setTitle(tempTips.getTitle());
        tips.setDescription(tempTips.getDescription());
        return tipsService.editTips(tips);
    }

          @DeleteMapping("/delete/{tipsId}")
  void deleteLoanReason(@PathVariable Long tipsId) {
    this.tipsRepositories.deleteById(tipsId);
  }

}
