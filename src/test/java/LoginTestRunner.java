import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestRunner extends SetUp {
//    @Test
//    public void userReg()
//    {
//        driver.get("http://automationpractice.com");
//        LoginPage loginPage = new LoginPage(driver);
//        int id = (int) (Math.random()*(1000-1)+1);
//        String email = "user"+id+"@test.com";
//        loginPage.doReg(email);


    @Test
    public  void userRegistration() throws IOException, ParseException {
        driver.get("http://automationpractice.com");
        LoginPage loginPage = new LoginPage(driver);
        int id = (int) (Math.random()*(1000-1)+1);
        String email = "user"+id+"@test.com";
        String password = "password"+id;
        loginPage.doReg(email,password);
        Assert.assertEquals(loginPage.signOut.isDisplayed(),true);

        Utils utils = new Utils();
        utils.saveData(email,password);



    }

    public void userLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://automationpractice.com");
        String name = loginPage.doLogin();
        System.out.println(name);

        //IF we want to match value
        //Assert.assertEquals(name, "Hasnat shoheb");

        //If we want to match boolean value
        //Assert.assertTrue(true, name);

        Assert.assertTrue(name.contains("Hasnat shoheb"), String.valueOf(true));

        //signout Button display assertion
        Assert.assertEquals(loginPage.signOut.isDisplayed(),true);

        //Logout
        Thread.sleep(5000);
        loginPage.signOut.click();
    }

}
