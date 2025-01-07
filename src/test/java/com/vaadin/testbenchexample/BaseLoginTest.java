package com.vaadin.testbenchexample;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.textfield.testbench.PasswordFieldElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.testbench.HasStringValueProperty;
import com.vaadin.testbench.IPAddress;
import com.vaadin.testbench.Parameters;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.TestBenchTestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hpsf.Date;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class BaseLoginTest extends TestBenchTestCase {
/*

	@Before
	public void setUp() {
    //ChromeOptions options = new ChromeOptions();
    //options.addArguments("--headless", "--disable-gpu");
    //setDriver(new ChromeDriver(options));
		setDriver(new ChromeDriver());
		performLogin();

		Parameters.setScreenshotReferenceDirectory( "src/test/screenshots");
		Parameters.setScreenshotComparisonTolerance(1.0);
		driver.manage().window().setSize( new Dimension( 1024, 768));
		Parameters.setScreenshotRetryDelay(10);
		Parameters.setScreenshotComparisonCursorDetection(true);
        String downloadFilepath = "C:\\Users\\MariiaCherniak\\Documents\\GitHub\\new\\downloadFiles";
	Map<String, Object> prefs = new HashMap<>();
	prefs.put("download.default_directory", downloadFilepath);
	prefs.put("download.prompt_for_download", false); // Disable download prompts
	prefs.put("safebrowsing.enabled", true); // Disable safety warnings for downloads

	}


*/


	/*	@After
	public void tearDown() throws Exception {
			getDriver().quit();
	}
*/
	@Before
	public void setUp() {
		// Configure WebDriverManager
		WebDriverManager.chromedriver().setup();

		// Configure Chrome options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--disable-gpu"); // Headless mode for EC2
		setDriver(new ChromeDriver(options));

		// Perform login or other initial setup
		performLogin();

		// Set TestBench parameters for screenshot comparison
		Parameters.setScreenshotReferenceDirectory(System.getProperty("user.dir") + "/reference-screenshots");
		Parameters.setScreenshotComparisonTolerance(1.0);
		Parameters.setScreenshotRetryDelay(10);
		Parameters.setScreenshotComparisonCursorDetection(true);

		// Ensure error-screenshots directory exists
		File errorScreenshotDir = new File("error-screenshots");
		if (!errorScreenshotDir.exists()) {
			errorScreenshotDir.mkdirs();
		}

		// Set the browser window size
		getDriver().manage().window().setSize(new Dimension(1024, 768));
	}


	// Your login method

	private void performLogin() {
	//	getDriver().get("http://localhost:8080/everlake_webui_war/");
	//	getDriver().get( "http://" + IPAddress.findSiteLocalAddress() + ":8080/navy_webui/");


	//	$( TextFieldElement.class).first().setValue( "jBond");
	//	$( PasswordFieldElement.class).first().setValue( "JBond007");
	//	$( ButtonElement.class).first().click();
		getDriver().get("https://test.everlake.calcfocus.net/achieve/oauth2/login/code/cognito");

		WebElement usernameFieldElement = findElement( By.id( "signInFormUsername" ));
		usernameFieldElement.click();
		usernameFieldElement.sendKeys( "helpdesk" );
		WebElement passwordFieldElement = findElement( By.id( "signInFormPassword" ));
		passwordFieldElement.click();
		passwordFieldElement.sendKeys( "JBond007$" );

	//	WebElement buttonElement = findElement( By.id( "signInSubmitButton" ));
		TestBenchElement loginButton = ( TestBenchElement )findElement( By.name( "signInSubmitButton" ));
		loginButton.click();





	}
}

