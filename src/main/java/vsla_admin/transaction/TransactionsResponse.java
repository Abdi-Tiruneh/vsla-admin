package vsla_admin.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TransactionsResponse {

    @JsonProperty("roundPayment")
    private String roundPayment;

    @JsonProperty("loanDespersal")
    private String loanDespersal;

    @JsonProperty("loanRepaymnet")
    private String loanRepayment;

    @JsonProperty("total")
    private String total;

    private Map<String, Map<String, Object>> transactionsAnalytics;

    @JsonProperty("allTransactions")
    private List<Transaction> allTransactions;

    @Data
    public static class Transaction {

        private String name;
        private String gender;
        private String status;
        private String amount;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
        private String date;
    }
}
