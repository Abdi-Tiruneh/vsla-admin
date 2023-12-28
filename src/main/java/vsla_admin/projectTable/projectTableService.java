package vsla_admin.projectTable;

import java.util.List;



public interface projectTableService {

    projectTable editProjectTable(projectTable projectTables);
    List<projectTable> getProjectTables();
    projectTable getProjectTableByProjectTableId(Long projectTableId);

 
    
}
