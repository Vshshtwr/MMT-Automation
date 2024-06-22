package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    @SuppressWarnings("deprecation")
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    public void homePage(){
        driver.get("https://www.makemytrip.com/");
    }
    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        String currentURL = driver.getCurrentUrl();
        if(currentURL.contains("makemytrip.")){
        System.out.println("URL contains makemytrip.");
        }else{
            System.out.println("URL does not contains makemytrip.");
        }
        System.out.println("end Test case: testCase01");

    }
    public void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        handlePopUp(wait, driver);

      //  WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
       // WebElement popUp = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        //popUp.click();
       
       // calendar(29);
        Thread.sleep(5000);
        WebElement departureCalendar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='departure']/parent::div")));
        departureCalendar.click();        
        Thread.sleep(2000);

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();

        WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
        from.sendKeys("blr");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Bengaluru']"))).click();

        WebElement toCity = driver.findElement(By.id("toCity"));
        toCity.click();

        WebElement to = driver.findElement(By.xpath("//input[@placeholder='To']"));
        to.sendKeys("del");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='New Delhi']"))).click();
        Thread.sleep(2000);

        WebElement nextMonthCalendar = driver.findElement(By.xpath("//div[@class='DayPicker-Month'][2]//p[text()='29']"));
        nextMonthCalendar.click();


       WebElement searchButton = driver.findElement(By.xpath("//a[text()='Search']"));
       searchButton.click();
        Thread.sleep(5000);

       WebElement flightPrice = driver.findElement(By.xpath("//div[contains(@class,'clusterViewPrice')][1]"));
       String pricePerAdult = flightPrice.getText();
       System.out.println("Flight Price:" + pricePerAdult);
       
}
    public void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement trainButton = driver.findElement(By.xpath("(//a[@href='https://www.makemytrip.com/railways/'])[1]"));
        trainButton.click();
        Thread.sleep(5000);
        
        WebElement fromCity = driver.findElement(By.xpath("//div[@class='rsw_inputBox selectRailCity'][1]"));
        fromCity.click();
        Thread.sleep(2000);
        //fromCity.sendKeys("YBR");
        //Thread.sleep(2000);

        WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
        from.sendKeys("ypr");
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Bangalore']"))).click();

       WebElement to = driver.findElement(By.xpath("//input[@placeholder='To']"));
        to.sendKeys("ndls");
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='New Delhi Railway Station']"))).click();

       WebElement secondTrainCalendar = driver.findElement(By.xpath("(//div[text()='29'])[2]"));
       secondTrainCalendar.click();

       WebElement trainDropdown = driver.findElement(By.xpath("//li[text()='Third AC']"));
       trainDropdown.click();

       Thread.sleep(2000);

       WebElement trainSearch = driver.findElement(By.xpath("//a[text()='Search']"));
       trainSearch.click();
       Thread.sleep(5000);

       WebElement trainPrice = driver.findElement(By.xpath("//div[@class='ticket-price justify-flex-end'][1]"));
       String trainpricePerAdult = trainPrice.getText();
       System.out.println("Train Price:" + trainpricePerAdult);
       

    }
    public void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement busButton = driver.findElement(By.xpath("//a[@href='https://www.makemytrip.com/bus-tickets/']"));
        busButton.click();
        Thread.sleep(2000);

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();

        WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
        from.sendKeys("bangl");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Bangalore, Karnataka']"))).click();
     
        WebElement to = driver.findElement(By.xpath("//input[@placeholder='To']"));
        to.sendKeys("kathma");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Kathmandu, Nepal']"))).click();

       
        WebElement busDate = driver.findElement(By.xpath("(//div[text()='29'])[2]"));
        String busDatetext = busDate.getText();
        busDate.click();
        Thread.sleep(2000);

        WebElement travelDate = driver.findElement(By.xpath("//input[@id='travelDate']"));
        String travelDatetext = travelDate.getText();
        System.out.println(travelDatetext);

        WebElement busSearch = driver.findElement(By.xpath("//button[text()='Search']"));
        busSearch.click();
        Thread.sleep(5000);

      //  String busDatetext = busDate.getText();
        //System.out.println("Bus Date: " + busDatetext);
        //Thread.sleep(2000);

    
        try {
            WebElement noBusesMessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div[1]/span[1]"));
            String noBusesMessagetxt = noBusesMessage.getText();
            System.out.println(noBusesMessagetxt);
            Thread.sleep(2000);
            if (noBusesMessagetxt.contains("No buses found")) {
                System.out.println("Test Passed: 'No buses found' message is displayed ");
            } else {
                System.out.println("Test Failed: 'No buses found' message is either not displayed or does not match expected text.");
            }
        } catch (Exception e) {
            System.out.println("Test Failed due to exception: " + e.getMessage());
            e.printStackTrace();
        }
    
    }
    

public static void handlePopUp(WebDriverWait wait, WebDriver driver) {
    try {
        WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
        popUp.click();
        System.out.println("Pop-up closed successfully.");
    } catch (Exception e) {
        // Pop-up not found, continuing with the test
        System.out.println("No pop-up appeared.");
    }
}


}
    
       







    //public void calendar(int monthDate) throws InterruptedException{

         
      //  WebElement departureCalendar = driver.findElement(By.xpath("//label[@for='departure']/parent::div"));
        //departureCalendar.click();
        //Thread.sleep(2000);
        
       // List<WebElement> elements = driver.findElements(By.xpath("//div[@class='DayPicker-Month'][2]//div[@class='DayPicker-Day']"));
    
       // for(WebElement e : elements){

         //   if (e.getText().equals(String.valueOf(monthDate))) {
         //       e.click();
           // break;
       
    