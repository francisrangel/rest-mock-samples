package restmock.sample.selenium;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import restmock.RestMock;

public class SeleniumExampleTest {

	@BeforeClass
	public static void configure() {
		setupServer();
		setupWebDriver();
	}

	private static void setupServer() {
		List<Client> clients = new ArrayList<Client>();

		clients.add(new Client("Test", "Test St."));
		clients.add(new Client("Other Test", "Other Test Av."));

		RestMock.whenGet("/clients").thenReturnJSON(clients);

		RestMock.startServer();
	}
	
	private static void setupWebDriver() {
		System.setProperty("webdriver.chrome.driver", SeleniumExampleTest.class.getResource("/chromedriver.exe").getPath());
	}

	@AfterClass
	public static void stopServer() {
		RestMock.stopServer();
	}
	
	WebDriver driver = new ChromeDriver();		
	
	@After
	public void closeWebDriver() {
		driver.quit();
	}

	@Test
	public void clientListShouldBeAvailabe() throws Exception {
		driver.navigate().to("file://" + getClass().getResource("/ClientsList.html").getPath());

		WebElement button = driver.findElement(ById.id("button"));
		button.click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("client")));

		List<WebElement> clients = driver.findElements(By.className("client"));
		
		assertEquals(2, clients.size());
		assertEquals("Test @ Test St.", clients.get(0).getText());
		assertEquals("Other Test @ Other Test Av.", clients.get(1).getText());
	}

}
