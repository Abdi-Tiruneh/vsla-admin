package vsla_admin.projectTable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class projectTableServiceImpl implements projectTableService{
    @Autowired
    private final projectTableRepository projectTableRepositories;

    @Override
    public projectTable editProjectTable(projectTable projectTables) {
        return projectTableRepositories.save(projectTables);
      
    }

    @Override
    public List<projectTable> getProjectTables() {
       return projectTableRepositories.findAll();
    }

    @Override
    public projectTable getProjectTableByProjectTableId(Long projectTableId) {
       return projectTableRepositories.findProjectTableByProjectTableId(projectTableId);
    }
    
}
