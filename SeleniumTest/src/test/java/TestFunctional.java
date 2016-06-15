import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.kpfu.project.selenium.SeleniumExample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by unlim_000 on 13.06.2016.
 */
public class TestFunctional {

    private WebDriver webDriver;
    private SeleniumExample seleniumExample;

    @Before
    public void init() throws MalformedURLException {
        webDriver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
        seleniumExample = new SeleniumExample();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin(){
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        assertTrue(seleniumExample.testLogin(webDriver));
    }

    @Test
    public void testComment(){
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        assertTrue(seleniumExample.testComment(webDriver));
    }

    @After
    public void close(){
        webDriver.close();
    }
}
