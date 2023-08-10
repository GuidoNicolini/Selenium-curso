import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Waits {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver();
    }

    @AfterEach
    void tearDown() {
        this.driver.close();
    }

    @Test
    void implicita() {
        /**
         Descripción: Configura una espera global que se aplicará a
         todos los elementos en la página durante un tiempo específico.
         Si un elemento no está inmediatamente disponible,
         Selenium esperará un tiempo determinado antes de lanzar
         una excepción.

         */

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    void explicita() {
        /**
        Descripción: Espera específicamente a que un
         elemento se vuelva visible o interactuable dentro de un
         tiempo límite definido. Puedes usar condiciones
         personalizadas para verificar si un elemento está presente,
         visible, habilitado, etc.
         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
        
    }

    @Test
    void fluent() {
        /**
        Descripción: FluentWait es una espera dinámica y
         flexible que permite definir condiciones
         personalizadas para esperar a que se cumplan
         antes de continuar. Puedes establecer intervalos
          de tiempo y condiciones que deben cumplirse.
         */

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("elementId"));
            }
        });

    }

    @Test
    void personalizada() {

        /*
        Descripción: Puedes crear esperas personalizadas
        para manejar situaciones específicas.
        Esto es útil cuando necesitas verificar condiciones
        más complejas antes de continuar.

         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("elementId"));
            }
        });

    }
}
