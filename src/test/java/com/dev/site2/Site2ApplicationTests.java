package com.dev.site2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Site2ApplicationTests {
	WebDriver driver = null;

    @Before
    public void abrirNavegador() {
        System.out.println("abrindo navegador");
        // setando caminho do driver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        // iniciando webdriver do chrome
        driver = new ChromeDriver();
        // maximizando o navegador
        driver.manage().window().maximize();
        // acessando uma página no chrome
        driver.get("http://localhost:8090");
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
