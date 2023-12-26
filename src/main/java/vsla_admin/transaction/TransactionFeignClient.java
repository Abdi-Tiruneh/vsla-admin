package vsla_admin.transaction;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "TransactionFeignClient", url = "${VSLA_APP.BASE_URL}" + "Transactions")
public interface TransactionFeignClient {
    @GetMapping("/getAllTransactions/{groupId}")
    ResponseEntity<TransactionsResponse> getTransactions(@PathVariable Long groupId);

    @GetMapping("/getAllTransactionsByProject/{projectId}")
    ResponseEntity<TransactionsResponse> getTransactionsByProjectId(@PathVariable Long projectId);
}
