package vsla_admin.TermsandConditions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class TermsandConditions {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long termsandConditionsId;
    private String title;
    private String description;



    
}
