package vsla_admin.projectTable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
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

public class projectTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long projectTableId;
    private String projectName;

     @JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
    @Column(name="project_Startdate")
    private String projectStartDate;

     @JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
    @Column(name="project_EndDate")
    private String projectEndDate;

     @JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
    @Column(name="project_ExtendedDate")
    private String projectExtendedDate;

    private String projectDescription;
    private String projectStatus;
    private String projectArea;
    
}
