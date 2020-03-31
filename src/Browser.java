import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Browser {
	String Url = "url";
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,10);
	
	public void goTo(String Url) {
		// launch Chrome and direct it to the Base URL
		driver.get(Url);
		driver.findElement(By.xpath("//*[@id='pageFooter']/ul/li[2]/a")).click();
	}
	
	public String currenurl() {
		// Get the current URL of the page
		return driver.getCurrentUrl();
	}
	
	public String title() {
		// Get the Title of the page
		return driver.getTitle();
	}
	
	public String fillform() {
		//Filling name field
		driver.findElement(By.xpath("//*[@id='u_0_m']")).sendKeys("Cristina");
		
		//Filling lastname field
	    driver.findElement(By.xpath("//*[@id=\'u_0_o\']")).sendKeys("Cabrera");
	    
	    //Filling Mobile number field
	    driver.findElement(By.xpath("//*[@id=\'u_0_r\']")).sendKeys("4771390913");
	    
	    //Filling Password field
	    driver.findElement(By.xpath("//*[@id=\'u_0_w\']")).sendKeys("Password");  
		
	    //Filling Birthday
	    //Month
	    WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
	    Select select1 = new Select(month);
	    select1.selectByVisibleText("Sep");
	    
	    //day
	    WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
	    Select select2 = new Select(day);
	    select2.selectByVisibleText("29");
	    
	    //year
	    WebElement year = driver.findElement(By.xpath("//*[@id=\"year\"]"));
	    Select select3 = new Select(year);
	    select3.selectByVisibleText("1982");
	    
	    //Filling the gender
	    List<WebElement> radioButtons = driver.findElements(By.name("sex"));
	    radioButtons.get(0).click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/h2")));
	    return driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/h2")).getText();
	}

	public String forgotacct() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login_form\"]/table/tbody/tr[3]/td[2]/div/a")));
		driver.findElement(By.xpath("//*[@id=\"login_form\"]/table/tbody/tr[3]/td[2]/div/a")).click();
		return driver.findElement(By.xpath("//*[@id=\"identify_yourself_flow\"]/div/div[1]/div/div[2]/h2")).getText();
	}

	public String search() {
		
		driver.findElement(By.xpath("//*[@id=\"identify_email\"]")).sendKeys("cabrera.cabrera@cabrera.com");
		driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"identify_yourself_flow\"]/div/div[2]/div[1]/div[1]")));
		return driver.findElement(By.xpath("//*[@id=\"identify_yourself_flow\"]/div/div[2]/div[1]/div[1]")).getText();
		
	}

	public void close()  {
		driver.close();
	}
	
		
	
}
