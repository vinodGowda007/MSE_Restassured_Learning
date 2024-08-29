package Pages;

public class loginPage {

    public loginPage verifyFieldsInloginpage(String Username, String Password) {
        System.out.println("Verified the fields in login page");
        return this;
    }

    public loginPage verifyInvalidLoginFunctionality(String Username, String Password) {
        System.out.println("invalid login");
        return this;
    }

    public HomePage verifyValidaLogin(String Username, String Password)
    {
        System.out.println("Valid login");
        return new HomePage();
    }

}
