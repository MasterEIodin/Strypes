package config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static config.LocalThreadManager.getDriver;
import static config.LocalThreadManager.setWebDriver;

public class BaseSetup {
    private static final String OS = System.getProperty("os.name").toLowerCase();

    @BeforeSuite
    public void readPropFile() {
        //Read the properties file.
        PropertyFileReader propertyFileReader = new PropertyFileReader();
        propertyFileReader.readConfiguration();
    }

    @BeforeMethod
    public void createInstance() throws Exception {
        String browserName = System.getProperty("browser");
        String basePath = System.getProperty("user.dir");

        if (browserName == null || !browserName.equalsIgnoreCase("remotech")) {
            String geckoDriverPath;
            String chromeDriverPath;
            if (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0) {
                // Linux
                chromeDriverPath = basePath + "/bin/linux/chromedriver";
                geckoDriverPath = basePath + "/bin/linux/geckodriver";
            } else if (OS.contains("win")) {
                // Win
                chromeDriverPath = basePath + "\\chromedriver.exe";
                geckoDriverPath = basePath + "\\geckodriver.exe";
            } else {
                throw new Exception("Could not detect OS");
            }
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            System.setProperty("webdriver.gecko.driver", geckoDriverPath);
        }

        if ((browserName == null) || (browserName.equalsIgnoreCase("chrome"))) {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--auto-open-devtools-for-tabs");
            setWebDriver(new ChromeDriver(options));
            getDriver().manage().window().maximize();
            
        } else if (browserName.equalsIgnoreCase("firefox")) {
            setWebDriver(new FirefoxDriver());
            getDriver().manage().window().maximize();

        } else {
            System.out.println("Your Browser is not supported. The supported browser parameters are: chrome, firefox, remoteff, remotech");
        }
    }

    // Quitting the driver.
    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        getDriver().quit();
    }

}
