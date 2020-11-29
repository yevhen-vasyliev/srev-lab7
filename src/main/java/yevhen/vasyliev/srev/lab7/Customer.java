package yevhen.vasyliev.srev.lab7;

public class Customer extends AbstractCustomer {
    private String surname;

    public Customer(String name, String surname, String email, Account account) {
        super(name, email, account, CustomerType.PERSON);
        this.surname = surname;
    }

    @Override
    public double getOverdraftDiscount() {
        return 1;
    }

    public String printCustomerDaysOverdrawn() {
        return getFullName() + getAccount().printDaysOverdrawnDescription();
    }

    private String getFullName() {
        return getName() + " " + surname + " ";
    }

    public String printCustomerMoney() {
        return getFullName() + getAccount().printMoneyDescription();
    }

    public String printCustomerAccount() {
        return getAccount().printAccount();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
