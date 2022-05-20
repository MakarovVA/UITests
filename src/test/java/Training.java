import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Training {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //добавляем конфигурацию
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);

        //изменяем размеры окна на максимум
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
        //изменяем размеры окна на 500 на 500
        driver.manage().window().setSize(new Dimension(500, 500));



        driver.quit();



    }
}