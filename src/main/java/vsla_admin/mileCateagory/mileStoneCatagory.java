package vsla_admin.mileCateagory;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import vsla_admin.organization.organization.Organization;

@Entity
@Getter
@Setter
public class mileStoneCatagory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mileStoneCatagoryId;
    private int value;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "organization_id")
    private Organization organization;

}
