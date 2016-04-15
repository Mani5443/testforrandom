package package1;

import static org.junit.Assert.fail;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import jxl.Workbook;


public class ramdom {
	  private static  WebDriver driver;
	  private static String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();
      public static enum Mode {
		 ALPHA, ALPHANUMERIC, NUMERIC 
	}
	  public static String generateRandomString(int length, Mode mode) throws Exception {
      StringBuffer buffer = new StringBuffer();
	  String characters = "";
      switch(mode){	
	  case ALPHA:
	  characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	  break;
   	  case ALPHANUMERIC:
	  characters = "abcdefghijklmnopqrstuvwxyz1234567890";
	  break;
	  case NUMERIC:
	  characters = "1234567890";
	  break;
	}
	  int charactersLength = characters.length();
      for (int i = 0; i < length; i++) {
	  double index = Math.random() * charactersLength;
	  buffer.append(characters.charAt((int) index));
	}
	  return buffer.toString();
		}

@Test
	public static void main(String[] args) throws Exception {
	    driver = new FirefoxDriver();
	    Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\software\\eclipse\\workspace\\test for random\\src\\package1\\config.properties");
        prop.load(ip);
        String url=prop.getProperty("url");
        String username=prop.getProperty("username");
        String password=prop.getProperty("password");	    
        driver.get(url);
        baseUrl = url;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
	    driver.get(baseUrl + "/");
        driver.manage().window().maximize();
        driver.findElement(By.id("wm_login-username")).clear();
        driver.findElement(By.id("wm_login-username")).sendKeys(username);
        driver.findElement(By.id("wm_login-password")).clear();
        driver.findElement(By.id("wm_login-password")).sendKeys(password);
        driver.findElement(By.id("submit_login")).click();
	    FileInputStream fsIP= new FileInputStream(new File("C:\\software\\eclipse\\workspace\\test for random\\src\\package1\\Input\\To Create EO.xls")); 
	    @SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook(fsIP); 
        HSSFSheet worksheet = wb.getSheetAt(0); 
        Cell cell = null; 
        cell = worksheet.getRow(1).getCell(15);
        String randnum1 =	generateRandomString(5,Mode.NUMERIC);
        String s="Rad-"+randnum1;
        cell.setCellValue(s);  
        fsIP.close();    
        FileOutputStream output_file =new FileOutputStream(new File("C:\\software\\eclipse\\workspace\\test for random\\src\\package1\\Input\\To Create EO.xls"));  
        wb.write(output_file); 
        output_file.close();
        File src=new File("C:\\software\\eclipse\\workspace\\test for random\\src\\package1\\Input\\To Create EO.xls");
        Workbook wb1=Workbook.getWorkbook(src);
	    String data00 =wb1.getSheet(0).getCell(15, 1).getContents();
	try{
	    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	    Document doc = docBuilder.parse(new File("C:\\software\\eclipse\\workspace\\test for random\\src\\package1\\Input\\To Create Eo.xml"));
	    NodeList nodes1 =  doc.getElementsByTagName("aex:AEX_ServiceOrder");
	    for(int j=0;j<((NodeList) nodes1).getLength();j++){
	    Node nodes = doc.getElementsByTagName("aex:OrderDetail").item(j);
	    NodeList list = nodes.getChildNodes();
	    for (int i = 0; i != list.getLength(); ++i){
	    Node child = list.item(i);
	    if (child.getNodeName().equals("aex:ServiceOrderNumber")){
	    child.getFirstChild().setNodeValue(data00) ;
	    System.out.println("data is "+data00);
	    }
        }
        }
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(doc);
	    StreamResult result = new StreamResult("C:\\software\\eclipse\\workspace\\test for random\\src\\package1\\Input\\To Create Eo.xml");
	    transformer.transform(source, result);
	    }
	    catch (Exception e){
	    e.printStackTrace();
	    }
        String TestFile = "C:\\software\\eclipse\\workspace\\test for random\\src\\package1\\Input\\To Create Eo.xml";
	    File FC = new File(TestFile);
	    FC.createNewFile();
	    FileReader FR = new FileReader(TestFile);
	    BufferedReader BR = new BufferedReader(FR);
	    StringBuffer fileContents = new StringBuffer();
	    String line = BR.readLine();
	    while (line != null) {
	    fileContents.append(line);
	    line = BR.readLine();
	    }
	    BR.close();
	    driver.findElement(By.id("wmp4981:__rowu_002f_metau_002f_defaultu_002f_wm_xt_fabricfolderu_002f_0000005449:hotspot")).click();
	    driver.findElement(By.id("jsfwmp5565:defaultForm:htmlInputTextarea")).clear();
	    ((RemoteWebDriver) driver).executeScript("var t = document.getElementById('jsfwmp5565:defaultForm:htmlInputTextarea'); "+"t.value = arguments[0];",fileContents.toString());
	    Thread.sleep(3000);
	    driver.findElement(By.id("jsfwmp5565:defaultForm:htmlCommandButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("wmp4981:__rowu_002f_metau_002f_defaultu_002f_wm_xt_fabricfolderu_002f_0000005393:hotspot")).click();
        Thread.sleep(6000);
        Select select = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div/div/div/div[3]/div/div[2]/div[6]/div/div/form[1]/div[3]/div/div/div/div[2]/div/div[1]/fieldset[1]/div/div[2]/span/ol/li[2]/span/div/div[1]/select")));
        select.selectByVisibleText("Document ID");
        Thread.sleep(3000);
        Select select1 = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div/div/div/div[3]/div/div[2]/div[6]/div/div/form[1]/div[3]/div/div/div/div[2]/div/div[1]/fieldset[1]/div/div[2]/span/ol/li[2]/span/div/div[2]/span/span/span/div/div[1]/select")));
        select1.selectByVisibleText("Equals");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div/div/div/div[3]/div/div[2]/div[6]/div/div/form[1]/div[3]/div/div/div/div[2]/div/div[1]/fieldset[1]/div/div[2]/span/ol/li[2]/span/div/div[2]/span/span/span/div/div[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div/div/div/div[3]/div/div[2]/div[6]/div/div/form[1]/div[3]/div/div/div/div[2]/div/div[1]/fieldset[1]/div/div[2]/span/ol/li[2]/span/div/div[2]/span/span/span/div/div[2]/input")).sendKeys(data00);
        driver.findElement(By.id("jsfwmp5465:searchBarForm:searchBarControl:refinedSearchGoButton")).click();
        Thread.sleep(6000);
        WebElement we_table = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div/div/div/div[4]/div/div[2]/div[6]/div/div/form[1]/div[2]/div/table/tbody"));
		List<WebElement> a1 = we_table.findElements(By.tagName("tr"));
		for (int i = 1; i <= a1.size(); i++) {
		FileInputStream fsIP1= new FileInputStream(new File("C:\\software\\eclipse\\workspace\\test for random\\src\\package1\\Output\\Result.xls")); 
		@SuppressWarnings("resource")
		HSSFWorkbook wb2 = new HSSFWorkbook(fsIP1); 
	    HSSFSheet worksheet1 = wb2.getSheetAt(0); 
	    Cell cell1 = null; 
	    Thread.sleep(6000);
	    String text = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div/div/div/div[4]/div/div[2]/div[6]/div/div/form[1]/div[2]/div/table/tbody/tr["+i+"]")).getText();
	    if(text.contains("AEX_ServiceOrder_Component" ) && text.contains("DONE" ) && !text.contains("DONE W/ ERRORS" ) && text.contains(data00)){
		cell1 = worksheet1.getRow(1).getCell(1);   
	    cell1.setCellValue(data00);
		cell1 = worksheet1.getRow(1).getCell(2);
	    cell1.setCellValue("pass");
		}	
		else{
		cell1 = worksheet1.getRow(1).getCell(1);   
		cell1.setCellValue(data00);
		cell1 = worksheet1.getRow(2).getCell(1);
		cell1.setCellValue("Fail");
	    }
		fsIP1.close(); 
	    FileOutputStream output_file1 =new FileOutputStream(new File("C:\\software\\eclipse\\workspace\\test for random\\src\\package1\\Output\\Result.xls")); 
	    wb2.write(output_file1); 
	    output_file1.close();
		}
		Thread.sleep(6000);
        driver.close();
        driver.quit();
   	    }
	    @After
	    public void tearDown() throws Exception {
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	    fail(verificationErrorString);
	    }

	}

}
