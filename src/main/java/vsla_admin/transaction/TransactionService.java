package vsla_admin.transaction;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    private final TransactionFeignClient transactionFeignClient;

    public TransactionService(TransactionFeignClient transactionFeignClient) {
        this.transactionFeignClient = transactionFeignClient;
    }

    public TransactionsResponse getTransactionsByGroup(Long groupId) {
        TransactionsResponse transactionsResponse = transactionFeignClient.getTransactions(groupId).getBody();
        Map<String, Map<String, Object>> transactionsAnalytics = processTransactions(transactionsResponse.getAllTransactions());
        transactionsResponse.setTransactionsAnalytics(transactionsAnalytics);

        return transactionsResponse;
    }

    public TransactionsResponse getTransactionsByProject(Long projectId) {
        TransactionsResponse transactionsResponse = transactionFeignClient.getTransactionsByProjectId(projectId).getBody();
        Map<String, Map<String, Object>> transactionsAnalytics = processTransactions(transactionsResponse.getAllTransactions());
        transactionsResponse.setTransactionsAnalytics(transactionsAnalytics);

        return transactionsResponse;
    }

    public Map<String, Map<String, Object>> processTransactions(List<TransactionsResponse.Transaction> transactions) {
        Map<String, Map<String, Object>> aggregatedData = new HashMap<>();

        for (TransactionsResponse.Transaction transaction : transactions) {
            // Extract month and year from the transaction date
            String[] dateParts = transaction.getDate().split("-");
            String yearMonthKey = dateParts[0] + "-" + dateParts[1];

            // Update or create an entry for the month and year
            aggregatedData.compute(yearMonthKey, (key, value) -> {
                if (value == null) {
                    value = new HashMap<>();
                    value.put("totalTransaction", 0);
                    value.put("totalAmount", 0.0);
                }

                // Update the values for the entry
                int totalTransaction = (int) value.get("totalTransaction") + 1;
                double totalAmount = (double) value.get("totalAmount") + Double.parseDouble(transaction.getAmount());

                value.put("totalTransaction", totalTransaction);
                value.put("totalAmount", totalAmount);

                return value;
            });
        }

        // Add entries for months with zero transactions
        for (int month = 1; month <= 12; month++) {
            String yearMonthKey = "2023-" + String.format("%02d", month);
            aggregatedData.putIfAbsent(yearMonthKey, new HashMap<>());
            aggregatedData.get(yearMonthKey).putIfAbsent("totalTransaction", 0);
            aggregatedData.get(yearMonthKey).putIfAbsent("totalAmount", 0.0);
        }

        return aggregatedData;
    }


}



