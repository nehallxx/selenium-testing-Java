package com.saucedemo.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private By usernameField=By.id("user-name");
    private By passwordField=By.id("password");
    private By loginbuttonField=By.id("login-button") ;
    private By errmsgField= By.xpath("//*[@id=\"login_button_container\"]");

    public void setUsername(String username){
        set(usernameField,username);
    }
    public void setPassword(String password){
        set(passwordField,password);
    }
    public ProductsPage clickLoginButton(){
        click(loginbuttonField);
        return new ProductsPage();
    }
    public ProductsPage GoToApp(String username, String password){
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }
    public String getErrMsg() {
        return find(errmsgField).getText();
    }
}
