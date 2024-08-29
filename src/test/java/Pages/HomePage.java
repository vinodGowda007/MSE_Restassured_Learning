package Pages;

public class HomePage {
        public HomePage verifyHomePage() {
            System.out.println("Verified the home page");
            return this;
        }

        public HomePage verifyLogout() {
            System.out.println("Verified the logout functionality");
            return this;
        }

        public CreateCandiatePage VerifyCreateCandidatePage() {
            System.out.println("Verified the create candidate page");
            return new CreateCandiatePage();
        }

}

