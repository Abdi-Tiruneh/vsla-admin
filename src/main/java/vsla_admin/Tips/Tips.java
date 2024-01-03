package vsla_admin.Tips;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import vsla_admin.organization.organization.Organization;

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
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
