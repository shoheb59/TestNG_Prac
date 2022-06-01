import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LoginPage {
    @FindBy(className = "login")
    WebElement signInbtnLogin;

    @FindBy(id = "email")
    WebElement signInEmail;

    @FindBy(id = "passwd")
    WebElement signInPass;

    @FindBy(id = "SubmitLogin")
    WebElement signInSubmit;

    @FindBy(className = "logout")
    WebElement signOut;

    @FindBy(className = "header_user_info")
    List<WebElement> lblUserName;

    @FindBy(id = "email_create")
            WebElement txtMailReg;
    @FindBy(id = "SubmitCreate")
            WebElement btnCreateAc;

    //For REGistration Form
    @FindBy(id = "id_gender1")
            WebElement rbGenderMr;
    @FindBy(id = "customer_firstname")
            WebElement txtFristName;
    @FindBy(id = "customer_lastname")
            WebElement txtLastName;
    //pass sign in er box tae use hobe
    @FindBy(id = "days")
            WebElement cbDate;
    @FindBy(id = "months")
            WebElement cbMonths;
    @FindBy(id = "years")
            WebElement cbYears;
    @FindBy(id = "firstname")
            WebElement txt2Fistname;
    @FindBy(id = "lastname")
            WebElement txt2Lastname;
    @FindBy(id = "company")
            WebElement txtCompany;
    @FindBy(id = "address1")
            WebElement txtAddress1;
    @FindBy(id = "address2")
            WebElement txtAddress2;
    @FindBy(id = "city")
            WebElement txtCity;
    @FindBy(name = "id_state")
            WebElement txtState;
    @FindBy(name = "postcode")
            WebElement txtpostcode;
    @FindBy(id = "id_country")
            WebElement txtCountry;
    @FindBy(name= "other")
            WebElement txtOtherInfo;
    @FindBy(id = "phone")
            WebElement txtHomePhn;
    @FindBy(id = "phone_mobile")
            WebElement txtMobile;
    @FindBy(name = "alias")
            WebElement txtAddressAlias;
    @FindBy(id = "submitAccount")
            WebElement btnRegister;


    WebDriver driver;



    //Constructor for Driver
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Steps for REG
    public void doReg(String email, String password)
    {
        signInbtnLogin.click();
        txtMailReg.sendKeys(email);
        btnCreateAc.click();
        rbGenderMr.click();
        txtFristName.sendKeys("Hasnat");
        txtLastName.sendKeys("Shoheb");
        signInPass.sendKeys(password);
        Select date = new Select(cbDate);
        date.selectByValue("5");
        Select month = new Select(cbMonths);
        month.selectByValue("11");
        Select year = new Select(cbYears);
        year.selectByValue("1995");
        txt2Fistname.sendKeys("Rahim");
        txt2Lastname.sendKeys("Karim");
        txtCompany.sendKeys("Brain craft Ltd");
        txtAddress1.sendKeys("19b, Rajbari");
        txtAddress2.sendKeys("Mohakhali");
        txtCity.sendKeys("Dhaka");
        Select state = new Select(txtState);
        state.selectByValue("1");
        txtpostcode.sendKeys("50500");
        txtCountry.sendKeys("Bangladesh");
        txtOtherInfo.sendKeys("Test");
        txtHomePhn.sendKeys("12345678");
        txtMobile.sendKeys("890123");
        txtAddressAlias.sendKeys("Badda");
        btnRegister.click();

    }

    //Steps to Login
    public String doLogin()
    {
        signInbtnLogin.click();
        signInEmail.sendKeys("hasnat@test.com");
        signInPass.sendKeys("559959");
        signInSubmit.click();
        return lblUserName.get(0).getText();

    }
}
