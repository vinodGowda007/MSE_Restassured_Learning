package Pages;

public class FBLogin {

    public static void main(String[] args) {

        new loginPage()
                .verifyFieldsInloginpage("UserName", "password");
    }
}
