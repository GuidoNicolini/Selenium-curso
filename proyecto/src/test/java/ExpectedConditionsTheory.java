import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ExpectedConditionsTheory {
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
    void waits() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));

        // Espera a que un elemento esté presente en la página y sea clickeable
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("elementId")));

        // Espera a que un elemento esté presente en la página
        WebElement presentElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("elementId")));

        // Espera a que un elemento no esté visible en la página
        boolean elementNotVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("elementId")));

        // Espera a que un elemento contenga un texto específico
        boolean textPresent = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("elementId"), "Expected Text"));

        // Espera a que aparezca un cuadro de alerta
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Verifica si un elemento está seleccionado y asigna el resultado a una variable
        boolean isElementSelected = wait.until(ExpectedConditions.elementSelectionStateToBe(By.id("elementId"), true));


        // Espera a que un elemento desaparezca de la página
        boolean elementNotPresent = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("elementId")));

        // Espera a que una ventana emergente (popup) aparezca y cambia a la ventana emergente
        String mainWindowHandle = driver.getWindowHandle();
        WebElement popupElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("popupButton")));
        popupElement.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Espera a que una URL contenga un texto específico
        boolean urlContainsText = wait.until(ExpectedConditions.urlContains("example"));

        // Espera a que un elemento sea seleccionable y selecciona un valor
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown")));
        dropdown.click();
        WebElement optionToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'Option')]")));
        optionToSelect.click();
    }
}
