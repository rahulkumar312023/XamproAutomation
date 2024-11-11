package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public String homePageUrl = "https://www.xampro.org";

    public By closeButton= By.xpath("//button[@aria-label='Close']");

    public By signInButton= By.xpath("//span[normalize-space()='Sign In']");
}
