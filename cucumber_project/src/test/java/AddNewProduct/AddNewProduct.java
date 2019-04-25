package AddNewProduct;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddNewProduct {
	@FindBy(how=How.ID,using="userName")
	public static WebElement userName;
	@FindBy(how=How.ID,using="password")
	public static WebElement password;
	@FindBy(how=How.CSS,using="input[value='Login']")
	public static WebElement Login;
	@FindBy(how=How.XPATH,using="/html/body/main/div/div/div/div[1]/button/h4")
	public static WebElement addProduct;
	@FindBy(how=How.ID,using="categorydropid")
	public static WebElement CategoryName;
	public static void selectCat()
	{
		Select category=new Select(catname);
		category.selectByIndex(2);
	}
	@FindBy(how=How.ID,using="subcategorydropid")
	public static WebElement SubCategoryName;
	@FindBy(how=How.ID,using="prodid")
	public static WebElement productname;
	@FindBy(how=How.ID,using="priceid")
	public static WebElement price;
	@FindBy(how=How.ID,using="quantityid")
	public static WebElement quantity;
	@FindBy(how=How.ID,using="brandid")
	public static WebElement brand;
	@FindBy(how=How.ID,using="description")
	public static WebElement description;
	@FindBy(how=How.CSS,using="input[value='Add Product']")
	public static WebElement Add_Product;
}
