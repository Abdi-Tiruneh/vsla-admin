package vsla_admin.transaction;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
@Tag(name = "Group API.")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/by-group/{groupId}")
    ResponseEntity<TransactionsResponse> getTransactions(@PathVariable Long groupId) {
        return ResponseEntity.ok(transactionService.getTransactionsByGroup(groupId));
    }

    @GetMapping("/by-project/{projectId}")
    ResponseEntity<TransactionsResponse> getTransactionsByProjectId(@PathVariable Long projectId) {
        return ResponseEntity.ok(transactionService.getTransactionsByProject(projectId));
    }

}


