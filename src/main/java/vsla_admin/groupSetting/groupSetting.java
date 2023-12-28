package vsla_admin.groupSetting;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@RequiredArgsConstructor

public class groupSetting {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)

private Long groupSettingId;
private Double minGroupMember;
private Double maxGroupMember;
private Double minPayableAmount;
private Double maxPayableAmount;
private String status;





    
}
