package vsla_admin.projectTable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/projectTable")
@RequiredArgsConstructor

public class projectTableController {
    @Autowired
    private final projectTableService projectTableServices;

    @GetMapping("/getProjectTables")
    List<projectTable> getProjectTable() {
        return this.projectTableServices.getProjectTables();
    }

    @GetMapping("/{projectTableId}")
    projectTable getProjectTable(@PathVariable Long projectTableId){
        return projectTableServices.getProjectTableByProjectTableId(projectTableId) ;
    }

    @PutMapping("/edit/{projectTableId}")
    projectTable editProjectTable(@RequestBody projectTable tempProjectTable, @PathVariable Long projectTableId) {
        projectTable projectTables = this.projectTableServices.getProjectTableByProjectTableId(projectTableId);
        projectTables.setProjectArea(tempProjectTable.getProjectArea());
        projectTables.setProjectDescription(tempProjectTable.getProjectDescription());
        projectTables.setProjectEndDate(tempProjectTable.getProjectEndDate());
        projectTables.setProjectExtendedDate(tempProjectTable.getProjectExtendedDate());
        projectTables.setProjectName(tempProjectTable.getProjectName());
        projectTables.setProjectStartDate(tempProjectTable.getProjectStartDate());
        projectTables.setProjectStatus(tempProjectTable.getProjectStatus());
        return projectTableServices.editProjectTable(projectTables);
        
    }

    



    
}
