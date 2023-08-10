import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Los localizadores web son elementos clave en Selenium para identificar y acceder a los elementos de una página web. Ayudan a localizar y manipular elementos como botones, enlaces, campos de entrada, etc. Aquí hay algunos tipos comunes de localizadores web en Selenium:
 * <p>
 * ID:
 * Descripción: Selecciona un elemento por su atributo id.
 * Uso: driver.findElement(By.id("elementId"));
 * <p>
 * Name:
 * Descripción: Selecciona un elemento por su atributo name.
 * Uso: driver.findElement(By.name("elementName"));
 * <p>
 * Class Name:
 * Descripción: Selecciona un elemento por su atributo class.
 * Uso: driver.findElement(By.className("className"));
 * <p>
 * Tag Name:
 * Descripción: Selecciona elementos por el nombre de su etiqueta HTML.
 * Uso: driver.findElement(By.tagName("tagName"));
 * <p>
 * Link Text:
 * Descripción: Selecciona enlaces (<a>) por el texto exacto del enlace.
 * Uso: driver.findElement(By.linkText("linkText"));
 * <p>
 * Partial Link Text:
 * Descripción: Selecciona enlaces (<a>) por una parte del texto del enlace.
 * Uso: driver.findElement(By.partialLinkText("partialLinkText"));
 * <p>
 * CSS Selector:
 * Descripción: Selecciona elementos utilizando selectores CSS.
 * Uso: driver.findElement(By.cssSelector("cssSelector"));
 * <p>
 * XPath:
 * Descripción: Selecciona elementos utilizando expresiones XPath.
 * Uso: driver.findElement(By.xpath("xpathExpression"));
 */


public class Selectores {

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
    void selectores() {

        driver.get("https://www.example.com");

        // Ejemplo usando diferentes localizadores
        WebElement elementById = driver.findElement(By.id("elementId"));
        WebElement elementByName = driver.findElement(By.name("elementName"));
        WebElement elementByClass = driver.findElement(By.className("className"));
        WebElement elementByLinkText = driver.findElement(By.linkText("linkText"));
        WebElement elementByPartialLink = driver.findElement(By.partialLinkText("partialLinkText"));
        WebElement elementByCSS = driver.findElement(By.cssSelector("cssSelector"));
        WebElement elementByXPath = driver.findElement(By.xpath("xpathExpression"));

    }

    /** cssSelector */

    /**
     El selector CSS es una forma poderosa de localizar elementos en una página web
     utilizando reglas de estilo CSS. Puedes usar diferentes atributos y
     relaciones entre elementos para definir el selector adecuado.
     */

    /**

     Aquí hay algunas técnicas y ejemplos para trabajar con selectores CSS en Selenium:

     Selección por ID:
     Selector: #elementId
     Ejemplo: driver.findElement(By.cssSelector("#username"));

     Selección por Clase:
     Selector: .className
     Ejemplo: driver.findElement(By.cssSelector(".button-primary"));

     Selección por Atributo:
     Selector: [attribute='value']
     Ejemplo: driver.findElement(By.cssSelector("[name='email']"));

     Selección por Jerarquía:
     Puedes usar espacios para indicar una jerarquía de elementos.
     Ejemplo: driver.findElement(By.cssSelector("div.container > p"));

     Selección por Clases Anidadas:
     Selector: .parentClass .childClass
     Ejemplo: driver.findElement(By.cssSelector(".header .logo"));

     Selección por Pseudo-Clases:
     Selector: element:pseudo-class
     Ejemplo: driver.findElement(By.cssSelector("input:checked"));

     Selección por Índice:
     Puedes usar :nth-child(n) para seleccionar el n-ésimo elemento.
     Ejemplo: driver.findElement(By.cssSelector("ul li:nth-child(3)"));

     Selección por Contenido de Texto:
     Selector: :contains(text)
     Ejemplo: driver.findElement(By.cssSelector("p:contains('Lorem ipsum')"));

     Selección por Atributos Comenzados, Terminados o Contenidos:
     [attribute^='value'] selecciona atributos que comienzan con 'value'.
     [attribute$='value'] selecciona atributos que terminan con 'value'.
     [attribute*='value'] selecciona atributos que contienen 'value'.
     Ejemplo: driver.findElement(By.cssSelector("input[name^='user']"));

     */
    @Test
    void cssSelector() {


        driver.get("https://www.example.com");

        WebElement elementByCSS = driver.findElement(By.cssSelector("#username"));
        WebElement elementByClass = driver.findElement(By.cssSelector(".button-primary"));
        WebElement elementByAttribute = driver.findElement(By.cssSelector("[name='email']"));


    }
}
