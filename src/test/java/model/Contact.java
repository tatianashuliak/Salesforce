package model;

public class Contact {

    private String lastName;
    private String accountName;
    private String firstName;

    public Contact(String lastName, String accountName, String firstName) {
        this.lastName = lastName;
        this.accountName = accountName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
