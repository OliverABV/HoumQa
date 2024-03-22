package houm.testing.Steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import houm.testing.Context.Context;
import houm.testing.Context.ScenarioContext;
import houm.testing.Page.Base;
import io.cucumber.datatable.DataTable;

public class HomeSteps extends Base {

	private ScenarioContext scenarioContext;

	public HomeSteps() {
		super(driver);
	}

	@FindBy(xpath = "//h1[@class='text-xl font-semibold leading-6']")
	public WebElement title;
	@FindBy(xpath = "//button[text()='Create visit']")
	public WebElement btnCreateVisit;
	@FindBy(xpath = "//button[text()='Create']")
	public WebElement btnCreate;

	// form
	@FindBy(xpath = "//input[@name='address']")
	public WebElement inputAddress;
	@FindBy(xpath = "//input[@name='visitor_name']")
	public WebElement inputVisitorName;
	@FindBy(xpath = "//input[@name='houmer_name']")
	public WebElement inputHoumerName;
	// form edit
	@FindBy(xpath = "//h3[contains(text(), 'Edit visit')]")
	public WebElement formEdit;
	@FindBy(xpath = "//div[contains(@class, 'mt-6')]//button[text()='Edit']")
	public WebElement btnEdit;
	@FindBy(xpath = "//input[@name='resolution_comment']")
	public WebElement inputComment;

	public boolean IsVisibleTitle() {
		waitUntilElementIsVisible(title);
		return isVisible(title);
	}

	public void clickBtnCreateVisit() {
		waitUntilElementIsElementClickable(btnCreateVisit);
		btnCreateVisit.click();
	}

	public void clickBtnCreate() {
		waitUntilElementIsElementClickable(btnCreate);
		btnCreate.click();
	}

	public boolean IsVisibleSatisfactoryPurchase(String nombre) {
		WebElement selector = getDriver()
				.findElement(By.xpath("//p[contains(@class,'text-red-600') and contains(.,'" + nombre + "')]"));
		waitUntilElementIsVisible(selector);
		return isVisible(selector);
	}

	public void completeForm(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			String address = row.get("Address");
			String visitorName = row.get("Visitor name");
			String HoumerName = row.get("Houmer name");
			inputAddress.sendKeys(address);
			inputVisitorName.sendKeys(visitorName);
			inputHoumerName.sendKeys(HoumerName);

		}
	}

	public void sendKeysDate(String date) {
		String[] partes = date.split("T");
		String fecha = partes[0];
		String hora = partes[1];

		WebElement inputDate = driver.findElement(By.name("scheduled_at"));
		inputDate.sendKeys(fecha);
		inputDate.sendKeys(Keys.TAB);
		inputDate.sendKeys(hora);

	}

	public void clickEdit(String name) {
		WebElement nameElement = getDriver().findElement(By.xpath("//h4[contains(text(), '" + name + "')]"));
		WebElement groupElement = nameElement.findElement(By.xpath("./.."));

		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",
				groupElement.findElement(By.xpath(".//button[text()='Edit']")));
		waitUntilElementIsVisible(formEdit);
	}

	public void fistClickEdit() {
		WebElement nameElement = getDriver().findElement(By.xpath("//h4[contains(@class, 'text-xl mb-1')]"));
		WebElement groupElement = nameElement.findElement(By.xpath("./.."));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",
				groupElement.findElement(By.xpath(".//button[text()='Edit']")));
		waitUntilElementIsVisible(formEdit);

	}

	public void cleanCampAndValidateEditVisit() {
		waitUntilElementIsVisible(inputAddress);
		inputAddress.clear();
		btnEdit.click();

	}

	public void sendKeysAddress(String address) {
		waitUntilElementIsVisible(inputAddress);
		inputAddress.sendKeys(address);
		btnEdit.click();

	}

	public boolean IsVisibleNewAddress(String name) {
		WebElement nameElement = getDriver()
				.findElement(By.xpath("//h4[@class='text-xl mb-1' and text()='" + name + "']"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", nameElement);

		waitUntilElementIsVisible(nameElement);
		return isVisible(nameElement);
	}

	public void modificateState(String state) {
		WebElement nameElement = getDriver()
				.findElement(By.xpath("//select[@name='status']/option[text()='" + state + "']"));
		waitUntilElementIsVisible(nameElement);
		nameElement.click();
		btnEdit.click();
	}

	public String capitalizeFirstLetter(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		return str.substring(0, 1).toUpperCase(Locale.getDefault()) + str.substring(1).toLowerCase(Locale.getDefault());
	}

	public void modificateStateAndComment(String state) {
		WebElement nameElement = getDriver()
				.findElement(By.xpath("//select[@name='status']/option[text()='" + state + "']"));
		waitUntilElementIsVisible(nameElement);
		nameElement.click();
	}

	public void sendKeysComment(String comment) {
		inputComment.sendKeys(comment);

	}

}
