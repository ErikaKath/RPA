package com.co.rpa.ica.logica.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target TXT_ID = Target.the("enter the cart id ")
            .locatedBy("//*[@id='reg_username']");
}
