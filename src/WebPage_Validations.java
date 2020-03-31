import org.testng.Assert;

public class WebPage_Validations {

	public static void main(String[] args)  {
		Browser Navegador = new Browser();
		String baseUrl = "https://www.facebook.com/";
		String expectedTitle = "Facebook - Log In or Sign Up";
		String expectedtext = "Connect with friends and the world around you on Facebook.";
		String expectedtext2 = "Find Your Account";
		String expectedtext3 = "No Search Results";
		String currenttext = "";	
		String currenttext2 = "";
		String currenttext3 = "";
		
		//1. Go to facebook.com.
		Navegador.goTo(baseUrl);
		
		//2. Validate that URL is correct.
		Assert.assertEquals(Navegador.currenurl(), baseUrl);
		
		//3. Validate the Title of the page, should be : Facebook - Log In or Sign Up.
		Assert.assertEquals(Navegador.title(), expectedTitle);
		
		//4. Fill all Sign Up section (do not click on Sign Up button).
		//5 .hoose a different Birthday not the default one.
		//6. Click on Female.
		//7. Validate following text is present: Connect with friends and the world around you on Facebook.
		currenttext = Navegador.fillform ();
		Assert.assertEquals(currenttext, expectedtext);
		
		//8. Click on Forgot Account?
		//9. Validate following text is displayed: “Find Your Account”.
		currenttext2 = Navegador.forgotacct();
		Assert.assertEquals(currenttext2, expectedtext2);
		
		//10. Enter a valid email but non existing one and click on search.
		//11. Validate Error message is displayed (No search Results).
		currenttext3 = Navegador.search();
		Assert.assertEquals(currenttext3, expectedtext3);
		
		Navegador.close();
		
	}

}
