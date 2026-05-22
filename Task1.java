import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        
    }

    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

        // FIX: Initialize result list to avoid NullPointerException
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Added null check for accounts list
        if (accounts == null) {
            return result;
        }

        for (LoanAccount account : accounts) {

            // FIX: Added null check for account and dueDate
            if (account != null && account.getDueDate() != null) {

                if (account.getDueDate().before(new Date())) {

                    // FIX: Only overdue accounts with outstanding balance > 0
                    if (account.getOutstandingBalance() > 0) {
                        result.add(account);
                    }
                }
            }
        }

        return result;
    }
}
class LoanAccount {

    private Date dueDate;
    private double outstandingBalance;
    private String accountId;

    public Date getDueDate() {
        return dueDate;
    }

    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public String getAccountId() {
        return accountId;
    }
}