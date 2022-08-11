package pages;

import org.openqa.selenium.WebElement;

import lib.Util;
import lib.Web;

public class DatePicker extends BasePage {

	public DatePicker(Web web) {
		super(web);
	}

	String checkInDateTbXP = "//input[@name='checkin']";
	String currentDateXP = "//th[@class='switch'][1]";
	String nextMonthBtnXP = "//i[@class='icon mdi mdi-long-arrow-right']";
	String selectDateXP ="//div[@class='datepicker dropdown-menu' and contains(@style,'display: block;')]//td[text()='{{DAY}}' and  not (contains(@class,'old'))]";
	
	public WebElement checkInDateTb() {
		return web.getObject(checkInDateTbXP);
	}

	public WebElement currentDate() {
		return web.getObject(currentDateXP);
	}

	public WebElement nextMonthBtn() {
		return web.getObject(nextMonthBtnXP);
	}
	
	public String slectDateXpath(String date) {
		String res = selectDateXP.replace("{{DAY}}", date);
		return res;
	}
	
	public WebElement getSelectDateElement(String date) {
		return web.getObject(slectDateXpath(date));
	}

	public void selectDate(String month, String date) {
		checkInDateTb().click();

		while (true) {
			String currentDate = currentDate().getText();

			if (currentDate.equals(month)) {
				break;
			} else {
				nextMonthBtn().click();
			}
		}
		
		Util.hold(3000);
		
		getSelectDateElement(date).click();

	}
	
	public void checkInDate(String month, String date) {
		selectDate(month,date);
	}
	
	public void checkOutDate(String month, String date) {
		selectDate(month,date);
	}

}
