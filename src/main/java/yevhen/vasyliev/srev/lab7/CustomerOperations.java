package yevhen.vasyliev.srev.lab7;

public class CustomerOperations {
    public static void withdraw(AbstractCustomer customer, double sum, String currency) {
        Account account = customer.getAccount();
        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }
        withdraw(account, sum, customer.getOverdraftDiscount());
    }

    private static void withdraw(Account account, double sum, double companyOverdraftDiscount) {
        double left = account.getMoney() - sum;

        // we are in overdraft
        // 50 percent discount for overdraft for premium account
        // no discount for overdraft for not premium account
        account.setMoney(account.getMoney() < 0
                ? left - sum * account.overdraftFee() * companyOverdraftDiscount
                : left);
    }
}
