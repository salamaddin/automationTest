package pages;

import org.openqa.selenium.WebElement;

import lib.Util;
import lib.Web;

public class HotelPage extends BasePage {
	public HotelPage(Web web) {
		super(web);
	}

	String hotellLinkXP = "//a[text()='Hotels']";
	String serchByCitySpanXP = "//span[@title=' Search by City']";
	String cityTextXP = "//input[@class='select2-search__field']";
	String serchByCityOptionXP = "//li[contains(text(),'{{City_Name}}')]";

	String checkInDateTbXP = "//input[@name='checkin']";
	String checkInCurrentDateXP = "(//th[@class='switch'])[1]";
	String checkInNextMonthBtnXP = "(//div[@class='datepicker dropdown-menu' and contains(@style,'display: block;')]//th[@class='next'])[1]";
	String selectCheckInDateXP = "//div[@class='datepicker dropdown-menu' and contains(@style,'display: block;')]//td[text()='{{DAY}}' and  not (contains(@class,'old'))]";

	String checkOutCurrentDateXP ="(//th[@class='switch'])[4]";
	String checkOutNextMonthBtnXP = "(//div[@class='datepicker dropdown-menu' and contains(@style,'display: block;')]//th[@class='next'])[1]";
	String selectcheckOutDateXP = "//div[@class='datepicker dropdown-menu' and contains(@style,'display: block;')]//td[text()='{{DAY}}' and  not (contains(@class,'old'))]";
	
	String travellersBtnXP = "//a[@class='dropdown-toggle dropdown-btn travellers waves-effect']";
	String roomInsBtnXP = "(//i[@class='la la-plus'])[1]";
	String adultsBtnXP = "(//i[@class='la la-plus'])[3]";
	String childsBtnXp = "(//i[@class='la la-plus'])[4]";
	String nationalityBtnXP = "//select[@id='nationality']";
	String nationalityOptionBtnXp = "//option[text()='{{NATIONALITY}}']";
	
	String childAgesBtnXP ="//select[@id='ages{{NUMBER}}']";
	String selectChildAgeBtn = "//select[@id='ages{{NUMBER}}']//option[@value='{{AGE}}']";
	
	String searchBtnXP = "//button[@id='submit']";
	
	public WebElement nevigateToHotelPage() {
		return web.getObject(hotellLinkXP);
	}

	public WebElement seachByCity() {
		return web.getObject(serchByCitySpanXP);
	}

	public WebElement cityText() {
		return web.getObject(cityTextXP);
	}

	public String getSearchByCityOption(String cityName) {
		String xp = serchByCityOptionXP.replace("{{City_Name}}", cityName);
		return xp;
	}
	
	public void selectCity(String cityName) {
		seachByCity().click();
		cityText().sendKeys(cityName);

		Util.hold(3000);

		web.getObject(getSearchByCityOption(cityName)).click();
	}

	public WebElement checkInDateTb() {
		return web.getObject(checkInDateTbXP);
	}

	public WebElement currenChechIntDate() {
		return web.getObject(checkInCurrentDateXP);
	}
	public WebElement currenChechOuttDate() {
		return web.getObject(checkOutCurrentDateXP);
	}

	public WebElement nextMonthBtn() {
		return web.getObject(checkInNextMonthBtnXP);
	}

	public String slectDateXpath(String day) {
		String res = selectCheckInDateXP.replace("{{DAY}}", day);
		return res;
	}

	public WebElement getSelectDateElement(String date) {
		return web.explicitlyWaitElement(date);
	//	return web.getObject(slectDateXpath(date));
	}

	public void selecCheckIntDate(String date) {
		
		String dayElement[] = date.split("-");
		String day= dayElement[0];
		String month = dayElement[1];
		String year = dayElement[2];
		String monthYear = month + " " + year;
		
		checkInDateTb().click();

		while (true) {
			String currentDate = currenChechIntDate().getText();

			if (currentDate.equals(monthYear)) {
				break;
			} else {
				nextMonthBtn().click();
			}
		}

	//	Util.hold(3000);

		getSelectDateElement(day).click();

	}
	
	public void selecCheckOuttDate(String date) {
		
		String dayElement[] = date.split("-");
		String day= dayElement[0];
		String month = dayElement[1];
		String year = dayElement[2];
		String monthYear = month + " " + year;

		while (true) {
			String currentDate = currenChechOuttDate().getText();

			if (currentDate.equals(monthYear)) {
				break;
			} else {
				nextMonthBtn().click();
			}
		}

	//	Util.hold(3000);

		getSelectDateElement(day).click();

	}
	

	public WebElement travellersBtn() {
		return web.getObject(travellersBtnXP);
	}
	
	public WebElement roomInsBtn() {
		return web.explicitlyWaitElement(roomInsBtnXP);
	}
	
	public WebElement adultsBtn() {
		return web.explicitlyWaitElement(adultsBtnXP);
	}
	public WebElement childsBtn() {
		return web.getObject(childsBtnXp);
	}
	
	public String getChildAgeXpath(String number) {
		String res = childAgesBtnXP.replace("{{NUMBER}}", number);
		//System.out.println(res);
		return res;
	}
	
	public String getChildAgeOptionXpath(String number, String age) {
		String res = selectChildAgeBtn.replace("{{NUMBER}}", number);
		res = res.replace("{{AGE}}", age);
		//System.out.println("option"+ res);
		return res;
	}
	
	public WebElement nationalityBtn() {
		return web.getObject(nationalityBtnXP);
	}
	public String slectNationalityXpath(String nationality) {
		String res = nationalityOptionBtnXp.replace("{{NATIONALITY}}", nationality);
		return res;
	}
	
	
	public void roomInf(int rooms, int adults, int childAgesInf[]) {
		
		int i=1;
		//Util.hold(2000);
		while(i<rooms) {
			roomInsBtn().click();
			i++;
		}
		//Util.hold(2000);
		int j=2;
		while(j<adults) {
			adultsBtn().click();
			j++;
		}
		
		int k=0;
		while(k < childAgesInf.length) {
			String age = String.valueOf(childAgesInf[k]);
			childsBtn().click();
			k++;
			String number = String.valueOf(k);
			System.out.println(age+ " "+ number);
			//Util.hold(3000);
			web.explicitlyWaitElement(getChildAgeXpath(number)).click();
			//Util.hold(4000);
			web.explicitlyWaitElement(getChildAgeOptionXpath(number,age)).click();
		}
			
		
	}
	
	public void selectNationality(String nationality) {
		nationalityBtn().click();
		//Util.hold(3000);
		web.explicitlyWaitElement(slectNationalityXpath(nationality)).click();
		
	}
	
	public WebElement searchBtn() {
		return web.getObject(searchBtnXP);
	}


}
