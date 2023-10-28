package vsla_admin.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import vsla_admin.address.Address;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.Status;

import java.time.LocalDateTime;

@Entity
@Table(name = "companies")
@SQLDelete(sql = "UPDATE companies SET deleted = true WHERE company_id=?")
@Where(clause = "deleted=false")
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Status companyStatus;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "registered_by")
    private Users registeredBy;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @JsonIgnore
    private boolean deleted = Boolean.FALSE;

}
