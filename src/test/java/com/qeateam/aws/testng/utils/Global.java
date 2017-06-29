package com.qeateam.aws.testng.utils;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.stream.XMLStreamException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.xerces.util.URI.MalformedURIException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qeateam.aws.testng.utils.GlobalObjects;
import com.qeateam.aws.testng.utils.InvokeBrowser.browsers;
import com.qeateam.aws.testng.utils.ReadConfigProps;

import io.appium.java_client.AppiumDriver;

public class Global implements GlobalObjects {

	public WebElement element;
	public RemoteWebDriver driver;
	// public AppiumDriver appiumDriver;
	public WebElement webelement;
	private List<WebElement> lsElements;
	ReadConfigProps readConfigProperties = new ReadConfigProps();
	
	public static Logger mainLogger = Logger.getLogger(Global.class.getName());

	// Applicable locator types.
	public enum locator {
		ID, XPATH, CLASSNAME, CSSSELECTOR, LINKTEXT, NAME, TAGNAME
	}

	/**
	 * Find elements based on the locator reference and type.
	 * 
	 * @param locatorReference
	 * @param locatorType
	 * @return
	 */
	public WebElement findElementType(String locatorReference, locator locatorType) {

		element = null;
		WebDriverWait wait = new WebDriverWait(driver, 90);

		switch (locatorType) {

		case ID:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorReference)));
			element = driver.findElement(By.id(locatorReference));
			break;

		case XPATH:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorReference)));
			element = driver.findElement(By.xpath(locatorReference));
			break;

		case CLASSNAME:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locatorReference)));
			element = driver.findElement(By.className(locatorReference));
			break;

		case CSSSELECTOR:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locatorReference)));
			element = driver.findElement(By.cssSelector(locatorReference));
			break;

		case LINKTEXT:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locatorReference)));
			element = driver.findElement(By.linkText(locatorReference));
			break;

		case NAME:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locatorReference)));
			element = driver.findElement(By.name(locatorReference));
			break;

		case TAGNAME:
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locatorReference)));
			element = driver.findElement(By.tagName(locatorReference));
			break;

		default:
			throw new IllegalArgumentException("Invalid selection method specified !!!");
		}
		return element;

	}

	/**
	 * This will return a list of elements based on locator type and reference.
	 * 
	 * @param locatorReference
	 * @param locatorType
	 * @return
	 */
	public List<WebElement> findElements(String locatorReference, locator locatorType) {
		switch (locatorType) {

		case ID:
			lsElements = driver.findElements(By.id(locatorReference));
			break;

		case XPATH:
			lsElements = driver.findElements(By.xpath(locatorReference));
			break;

		case CLASSNAME:
			lsElements = driver.findElements(By.className(locatorReference));
			break;

		case CSSSELECTOR:
			lsElements = driver.findElements(By.cssSelector(locatorReference));
			break;

		case LINKTEXT:
			lsElements = driver.findElements(By.linkText(locatorReference));
			break;

		case NAME:
			lsElements = driver.findElements(By.name(locatorReference));
			break;

		case TAGNAME:
			lsElements = driver.findElements(By.tagName(locatorReference));
			break;

		default:
			throw new IllegalArgumentException("Invalid selection method specified !!!");

		}
		return lsElements;

	}

	/**
	 * Get the locator type and value from ObjectMap
	 * 
	 * @param field
	 * @param screenName
	 * @return
	 * @throws XMLStreamException
	 * @throws FileNotFoundException
	 */
	public String[] genGetLocator(String field, String screenName) throws XMLStreamException, FileNotFoundException {

		String[] objectPropertyArray = new String[2];
		String objectProperty;

		try {
			// Call object map parser
			objectProperty = objParser.objectParser(field, screenName);
			// Locator Type
			objectPropertyArray[0] = objectProperty.substring(0, (objectProperty.indexOf("="))).toUpperCase();
			// Locator Value
			objectPropertyArray[1] = objectProperty.substring((objectProperty.indexOf("=") + 1),
					(objectProperty.length()));
		} catch (Exception e) {
			e.printStackTrace();
			mainLogger.error(e);
		}

		return objectPropertyArray;

	}

	/**
	 * Launch application as per user need.
	 */
	public void launchApp() {
		// Initialize log4j
		DOMConfigurator.configure("log4j.xml");
		// read config.properties and get required values
		readConfigProperties.retrieve_configProperties();
		try {
			System.out.println("CONFIG PROPS BROWSER>>>>>>>>>>>>>>>>>>>" + objReadConfigProps.BROWSER);
			objInvokeBrowser.invokeBrowser(browsers.valueOf(objReadConfigProps.BROWSER.toUpperCase()));

		} catch (Exception e) {
			e.printStackTrace();
			mainLogger.error(e);
		}

	}

	// SR 27 June: UPDATED

	/**
	 * segregate element into its locator and locator type and then click the
	 * element onto the app.
	 * 
	 * @param strElement
	 * @param strScreen
	 * @throws Exception
	 */
	public void genericClick(String strElement, String strScreen) throws Exception {
		try {
			// Get the locator for the webelement to be clicked
			String[] objectPropertyArray = genGetLocator(strElement, strScreen);
			System.out.println("Object property element 1 : " + objectPropertyArray[0]);
			System.out.println("Object property element 2: " + objectPropertyArray[1]);

			// Find the element on screen
			webelement = findElementType(objectPropertyArray[1], locator.valueOf(objectPropertyArray[0]));

			// Click the element
			webelement.click();

			// TBC: Add reporting steps

		} catch (Exception e) {
			e.printStackTrace();
			mainLogger.error(e);
		}

	}

	/*
	 * //SR 27 June: UPDATED
	 * 
	 */
	/**
	 * This method will enter values into an element on the app/ webapp.
	 * 
	 * @param strDataRef
	 * @param strDataField
	 * @param strField
	 * @param strScreenName
	 * @throws Exception
	 */
	public void genericEnterText(String strDataRef, String strDataField, String strField, String strScreenName)
			throws Exception {
		try {

			String strTextToBeEntered = obJsonDataReader.getValueFromJSONFile(strDataRef, strDataField);
			// Get the locator for the webelement
			String[] objectPropertyArray = genGetLocator(strField, strScreenName);
			System.out.println("Object property element 1 : " + objectPropertyArray[0]);
			System.out.println("Object property element 2: " + objectPropertyArray[1]);

			// Find the element on screen
			webelement = findElementType(objectPropertyArray[1], locator.valueOf(objectPropertyArray[0]));

			// Enter the desired text
			webelement.sendKeys(strTextToBeEntered);

			// TBC: Add reporting steps

		} catch (Exception e) {
			e.printStackTrace();
			mainLogger.error(e);
		}
	}

	// SR 27 JUN : ADDED

	/**
	 * Select value from dropdown/ Pulldown item
	 * 
	 * @param strDDElement
	 * @param strScreen
	 * @param strSelectionType
	 * @param strOptionToSelect
	 * @throws FileNotFoundException
	 * @throws XMLStreamException
	 */
	public void iSelectValueFromPullDownUsingSelectionType(String strDDElement, String strScreen,
			String strSelectionType, String strOptionToSelect) throws FileNotFoundException, XMLStreamException {

		// Get the locator for the webelement
		String[] objectPropertyArray = genGetLocator(strDDElement, strScreen);
		System.out.println("Object property element 1 : " + objectPropertyArray[0]);
		System.out.println("Object property element 2: " + objectPropertyArray[1]);
		// Find the element on screem
		webelement = findElementType(objectPropertyArray[1], locator.valueOf(objectPropertyArray[0]));
		Select slDropdown = new Select(webelement);

		// select the desired value
		switch (strSelectionType) {
		case "BYVALUE":
			slDropdown.selectByValue(strOptionToSelect);
			break;
		case "BYINDEX":
			slDropdown.selectByIndex(Integer.parseInt(strOptionToSelect));
			break;
		case "BYVISIBLETEXT":
			slDropdown.selectByVisibleText(strOptionToSelect);
			break;

		default:
			throw new IllegalArgumentException("Invalid Selection Method Specified !!!!");

		}
	}

	// SR 27 JUN: ADDED

	/**
	 * Verify static copy text from reference text held in XML against on-screen
	 * 
	 * @param strReferenceText
	 * @param strScreen
	 * @param strElement
	 * @throws Exception
	 */
	public void genericVerifyCopyText(String strReferenceText, String strScreen, String strElement) throws Exception {

		String[] strObjectPropertyArray = new String[2];
		String[] strCopytextArray = new String[3];
		String strOnScreenText, strXMLReferenceText;
		// Call CopyTextMap parser
		strCopytextArray = objParser.copyTextParser(strReferenceText, strElement, strScreen);

		// Get Locator Type
		strObjectPropertyArray[0] = strCopytextArray[0].substring(0, (strCopytextArray[0].indexOf("="))).toUpperCase();
		// Get Locator Value
		strObjectPropertyArray[1] = strCopytextArray[0].substring((strCopytextArray[0].indexOf("=") + 1),
				(strCopytextArray[0].length()));

		// Find the element on screem
		webelement = findElementType(strObjectPropertyArray[1], locator.valueOf(strObjectPropertyArray[0]));

		// Get on screen actual text
		strOnScreenText = webelement.getText().replace("\b", "").replace("\n", "").replace("\t", "");
		System.out.println("strOnScreenText>>>>>>" + strOnScreenText);

		// Get reference text
		strXMLReferenceText = strCopytextArray[1].trim().replace("\b", "").replace("\n", "").replace("\t", "");
		System.out.println("strXMLReferenceText>>>>>>" + strXMLReferenceText);

		// Compare and validate
		if (strXMLReferenceText.equalsIgnoreCase(strOnScreenText)) {
			System.out.println("Copytext matches !!!");
		} else {
			System.out.println("Copytext DOES NOT matches !!!");
			
		}
	}
	
	/**
	 * Close the browser and test.
	 */
	public void endTest(){
		driver.quit();
	}

}
