package com.dev.site2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;


public class Site2ApplicationTests {
    public static String driverpath = "C:/Users/bhenriquea/drivers/chromedriver/chromedriver.exe";

    WebDriver driver = null;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.firefoxdriver().proxy("proxylatam.indra.es:8080").setup();
    }

    @Before
    public void abrirNavegador() {
        System.out.println("abrindo navegador");
        // setando caminho do driver
        //System.setProperty("webdriver.chrome.driver", driverpath);
        // iniciando webdriver do chrome
        driver = new FirefoxDriver();
        // maximizando o navegador
        driver.manage().window().maximize();
        // acessando uma página no chrome
        driver.get("http://localhost:8080");
    }

    @After
    public void encerrar() {
        System.out.println("fechando navegador");
        driver.quit();
    }

    @Test
	public void preencherFormulario() {
		driver.findElement(By.id("input_name")).sendKeys("Teste");
        driver.findElement(By.id("input_email")).sendKeys("teste@teste.com");
        driver.findElement(By.id("input_assunto")).sendKeys("testando");
        driver.findElement(By.id("input_mensagem")).sendKeys("testando 123");
        driver.findElement(By.id("submit_button")).click();
        String text = driver.findElement(By.id("input_mensagem")).getAttribute("value");
        assertEquals("", text);
	}
}
