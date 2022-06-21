package com.monster.wiki.pageobjects;

import com.monster.wiki.utils.ElementWeb;
import com.monster.wiki.utils.PropertiesFile;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class IncidencePage extends ElementWeb {
    @FindBy(xpath = "//div[text()='Asunto:']/following-sibling::input")
    private WebElement subjectIncidence;
    @FindBy(xpath = "//div[contains(text(), 'Descrip')]/following-sibling::textarea")
    private WebElement descriptionIncidence;
    @FindBy(xpath = "//h2[text()='Asunto:']/following-sibling::div")
    private WebElement subjectIncidenceCheck;
    @FindBy(xpath = "//h2[contains(text(), 'Descrip')]/following-sibling::div")
    private WebElement descriptionIncidenceCheck;
    @FindBy(xpath = "//button[text()='Enviar']")
    private WebElement buttonSend;
    @FindBy(xpath = "//button[text()='Siguiente']")
    private WebElement buttonNext;
    @FindBy(xpath = "//button[text()='Anterior']")
    private WebElement buttonBack;

    private static final Logger LOG = Logger.getLogger(IncidencePage.class.getName());

    public IncidencePage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill and send the form")
    public boolean fillAndSendFormContact() {
        boolean error = false;

        waitElement(subjectIncidence);
        informField(subjectIncidence, PropertiesFile.readFileProperties("subject_Incidence_1"));
        informField(descriptionIncidence, PropertiesFile.readFileProperties("description_Incidence_1"));
        clickOnWebElement(buttonSend);

        LOG.info("The form is filled and sent correctly");

        return error;
    }

    @Step("Check the incidences")
    public boolean checkIncidences() {
        boolean error = false;

        waitElement(subjectIncidenceCheck);
        waitElement(descriptionIncidenceCheck);
        if (!subjectIncidenceCheck.getText().equals(PropertiesFile.readFileProperties("subject_Incidence_1")) ||
                !descriptionIncidenceCheck.getText().equals(PropertiesFile.readFileProperties("description_Incidence_1"))) {
            error = true;
            LOG.severe("The incidences are not correct");
        }
        clickOnWebElement(buttonNext);
        wait(2000);
        if (!subjectIncidenceCheck.getText().equals(PropertiesFile.readFileProperties("subject_Incidence_2")) ||
                !descriptionIncidenceCheck.getText().equals(PropertiesFile.readFileProperties("description_Incidence_2"))) {
            error = true;
            LOG.severe("The incidences are not correct");
        }
        clickOnWebElement(buttonBack);
        LOG.info("The incidences are correct");

        return error;
    }

}