package model;

public class Account {
    private String accountName;
    private String webSite;

    public Account(String accountName, String webSite) {
        this.accountName = accountName;
        this.webSite = webSite;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
