package vsla_admin.mileCateagory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class mileStoneCatagory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mileStoneCatagoryId;
    private int value;

    
}






