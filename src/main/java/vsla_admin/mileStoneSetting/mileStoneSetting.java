package vsla_admin.mileStoneSetting;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class mileStoneSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long mileStoneSettingId;
    private String packageName;
    private Double packageStratValue;
    private Double packageEndValue;
    
}
