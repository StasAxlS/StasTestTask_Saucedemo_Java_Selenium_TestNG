import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

@Listeners({AllureTestNg.class})
public class TestTest {

    @Test
    @Description("Проверка заголовка на странице формы")
    public void testTest() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.selenium.dev/selenium/web/web-form.html"); // ← исправлено
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            WebElement message = driver.findElement(By.className("display-6"));
            verifyPageTitle(message);
        } catch (Exception e) {
            e.printStackTrace(); // ← добавьте это
            throw e; // ← и это, чтобы тест упал явно
        } finally {
            driver.quit();
        }
    }

    @Step("Проверяем, что текст заголовка равен 'Web form'")
    private void verifyPageTitle(WebElement message) {
        assertEquals(message.getText().trim(), "Web form");
    }
}
