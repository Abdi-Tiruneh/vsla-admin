package vsla_admin.projectTable;

import org.springframework.data.jpa.repository.JpaRepository;


public interface projectTableRepository extends JpaRepository < projectTable, Long> {
    projectTable findProjectTableByProjectTableId( Long projectTableId);

    
} 