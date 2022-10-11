package com.alura.appium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class FeatureRegister {
    @Test
    public void shouldNotSignInAnUserWithPasswordThatDoNotMatch() throws MalformedURLException {
        AppiumDriverConfig driver = new AppiumDriverConfig();

        WebElement registerButton = (WebElement) driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario"));
        registerButton.click();

        WebElement nameField = (WebElement) driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/input_nome"));
        WebElement passwordField = (WebElement) driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha"));
        WebElement confirmPasswordField = (WebElement) driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/input_confirmar_senha"));

        nameField.sendKeys("Evellyn");
        passwordField.sendKeys("123");
        confirmPasswordField.sendKeys("456");

        WebElement confirmRegister = (WebElement) driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar"));
        confirmRegister.click();

        WebElement incorrectRegisterMessage = (WebElement) driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/erro_cadastro"));
        Assert.assertEquals("Senhas não conferem", incorrectRegisterMessage.getText());
    }
}
