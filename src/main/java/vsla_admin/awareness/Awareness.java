package vsla_admin.awareness;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import vsla_admin.organization.organization.Organization;

import java.time.LocalDateTime;


@Entity
@Table(name = "awareness")
@SQLDelete(sql = "UPDATE awareness SET deleted = true WHERE awareness_id=?")
@Where(clause = "deleted=false")
@Data
public class Awareness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "awareness_id")
    private Long awarenessId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "video_url", nullable = false)
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    @JsonIgnore
    private Organization organization;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "group_Id")
    private Long group_Id;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @JsonIgnore
    private boolean deleted = Boolean.FALSE;
}
