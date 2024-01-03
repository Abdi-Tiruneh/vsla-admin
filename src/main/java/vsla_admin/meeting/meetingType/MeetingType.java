package vsla_admin.meeting.meetingType;

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

@Getter
@Setter
@Entity
public class MeetingType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long meetingTypeId;
    private String meetingTypeName;
    private Boolean isActive;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "organization_id")
    private Organization organization;

}
