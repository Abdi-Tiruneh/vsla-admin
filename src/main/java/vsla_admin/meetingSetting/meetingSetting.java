package vsla_admin.meetingSetting;

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
public class meetingSetting {
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)

 private Long meetingSettingId;
 private Double minTime;
 private Double maxTime;
 private Double meetingInterval;
 private String status;

}
