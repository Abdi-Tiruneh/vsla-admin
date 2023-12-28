package vsla_admin.Tips;

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
public class Tips {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tipsId;
    private String Title;
    private String Description;  
}
