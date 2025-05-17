package com.sep.utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;

public class BrowserUtils {


    /**
     * This method accepts an integer as input and pauses the program for the specified number of seconds.
     * The method uses the Thread.sleep() method to pause the program for the specified number of seconds.
     *
     * @param second the number of seconds to pause the program
     */
    public static void sleep(int second) {
        second *= 1000; // convert seconds to milliseconds
        try {
            Thread.sleep(second); // pause the program for the specified number of milliseconds
        } catch (InterruptedException e) {

        }
    }



    public static void switchWindowAndVerify(String expectedInURL, String expectedInTitle) {

        Set<String> allWindowHandles = DriverUtils.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {

            DriverUtils.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + DriverUtils.getDriver().getCurrentUrl());

            if (DriverUtils.getDriver().getCurrentUrl().contains(expectedInURL)) {
                break;
            }
        }


        String actualTitle = DriverUtils.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle, DriverUtils.getDriver().getTitle());
    }

    public static void verifyTitleContains(String expectedInTitle) {
        Assert.assertTrue(DriverUtils.getDriver().getTitle().contains(expectedInTitle));
    }

    /*
    This method accepts WebElement target,
    and waits for that WebElement not to be displayed on the page
     */
    public static void waitForInvisibilityOf(WebElement target) {
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /*
    This method accepts String title,
    and waits for that Title to contain given String value.
     */
    public static void waitForTitleContains(String title) {
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));
    }

    /**
     * This method accepts a dropdown element and returns a List<String> that contains all options values as String.
     *
     * @param dropdownElement
     * @return actualMonth_as_STRING
     */
    public static List<String> dropdownOptions_as_STRING(WebElement dropdownElement) {

        Select month = new Select(dropdownElement);
        //Storing all the ACTUAL options into a List of WebElements
        List<WebElement> actualMonth_as_WEBELEMENT = month.getOptions();

        //Creating an EMPTY list of String to store ACTUAL <option> as String
        List<String> actualMonth_as_STRING = new ArrayList<>();

        //Looping through the List<WebElement>, getting all options' texts, and storing them into List<String>
        for (WebElement each : actualMonth_as_WEBELEMENT) {

            actualMonth_as_STRING.add(each.getText());

        }

        return actualMonth_as_STRING;

    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {
        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                each.click();
            }
        }
    }

    /**
     * This method will accept a String as expected value and verify actual URL CONTAINS the value.
     *
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL) {
        Assert.assertTrue(DriverUtils.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    public static void verifyURL(String expectedURL) {
        Assert.assertEquals(expectedURL, DriverUtils.getDriver().getCurrentUrl());
    }

    /**
     * Switches to new window by the exact title. Returns to original window if target title not found
     *
     * @param targetTitle
     */
    public static void switchToWindow(String targetTitle) {
        String origin = DriverUtils.getDriver().getWindowHandle();
        for (String handle : DriverUtils.getDriver().getWindowHandles()) {
            DriverUtils.getDriver().switchTo().window(handle);
            if (DriverUtils.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        DriverUtils.getDriver().switchTo().window(origin);
    }

    /**
     * Moves the mouse to given element
     *
     * @param element on which to hover
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(DriverUtils.getDriver());
        actions.moveToElement(element).perform();
    }


    /**
     * Moves the mouse to given element and click on it
     *
     * @param element on which to hover
     */
    public static void hoverAndClick(WebElement element) {
        Actions actions = new Actions(DriverUtils.getDriver());
        actions.moveToElement(element).click(element).perform();
    }

    /**
     * return a list of string from a list of elements
     *
     * @param list of webelements
     * @return list of string
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    /**
     * Extracts text from list of elements matching the provided locator into new List<String>
     *
     * @param locator
     * @return list of strings
     */
    public static List<String> getElementsText(By locator) {

        List<WebElement> elems = DriverUtils.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for the provided element to be visible on the page
     *
     * @param element
     * @param time
     * @return
     */
    public static void waitForVisibility(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForTextToBePresentInElement(WebElement element, String text,int time) {
        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    /**
     * Waits for element matching the locator to be visible on the page
     *
     * @param locator
     * @param time
     * @return
     */
    public static WebElement waitForVisibility(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param time
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for element matching the locator to be clickable
     *
     * @param locator
     * @param time
     * @return
     */
    public static WebElement waitForClickablility(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param time
     */
    public static void waitForPageToLoad(long time) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver DriverUtils) {
                return ((JavascriptExecutor) DriverUtils).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(time));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Verifies whether the element matching the provided locator is displayed on page
     *
     * @param by
     * @throws AssertionError if the element matching the provided locator is not found or not displayed
     */
    public static void verifyElementDisplayed(By by) {
        try {
            Assert.assertTrue("Element not visible: " + by, DriverUtils.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + by);

        }
    }

    /**
     * Verifies whether the element matching the provided locator is NOT displayed on page
     *
     * @param by
     * @throws AssertionError the element matching the provided locator is displayed
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            Assert.assertFalse("Element should not be visible: " + by, DriverUtils.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();

        }
    }


    /**
     * Verifies whether the element is displayed on page
     *
     * @param element
     * @throws AssertionError if the element is not found or not displayed
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }


    /**
     * Waits for element to be not stale
     *
     * @param element
     */
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }


    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) DriverUtils.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) DriverUtils.getDriver()).executeScript("arguments[0].click();", element);
    }


    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) DriverUtils.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(DriverUtils.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Changes the HTML attribute of a Web Element to the given value using JavaScript
     *
     * @param element
     * @param attributeName
     * @param attributeValue
     */
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) DriverUtils.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    /**
     * Highlighs an element by changing its background and border color
     *
     * @param element
     */
    public static void highlight(WebElement element) {
        ((JavascriptExecutor) DriverUtils.getDriver()).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        waitFor(1);
        ((JavascriptExecutor) DriverUtils.getDriver()).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    /**
     * Checks or unchecks given checkbox
     *
     * @param element
     * @param check
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    /**
     * attempts to click on provided element until given time runs out
     *
     * @param element
     * @param timeout
     */
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param element
     */
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) DriverUtils.getDriver();
        jse.executeScript(command, element);

    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param command
     */
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) DriverUtils.getDriver();
        jse.executeScript(command);

    }


    /**
     * This method will recover in case of exception after unsuccessful the click,
     * and will try to click on element again.
     *
     * @param by
     * @param attempts
     */
    public static void clickWithWait(By by, int attempts) {
        int counter = 0;
        //click on element as many as you specified in attempts parameter
        while (counter < attempts) {
            try {
                //selenium must look for element again
                clickWithJS(DriverUtils.getDriver().findElement(by));
                //if click is successful - then break
                break;
            } catch (WebDriverException e) {
                //if click failed
                //print exception
                //print attempt
                e.printStackTrace();
                ++counter;
                //wait for 1 second, and try to click again
                waitFor(1);
            }
        }
    }

    /**
     * checks that an element is present on the DOM of a page. This does not
     * * necessarily mean that the element is visible.
     *
     * @param by
     * @param time
     */
    public static void waitForPresenceOfElement(By by, long time) {
        new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public static List<String> getElementsTextWithAttribute(String attribute, List<WebElement> elements) {

        List<String> texts = new LinkedList<>();

        for (WebElement element : elements) {
            texts.add(element.getAttribute(attribute));
        }

        return texts;

    }

    public static void refresh() {

        DriverUtils.getDriver().navigate().refresh();
    }

    public static String getElementAttribute(String attribute, WebElement element) {

        return element.getAttribute(attribute);

    }

    /**
     * This method will accept WebElement as an argument,
     * and will click on that element.
     *
     * @param webElement the element on which you want to click
     */
    public static void click(WebElement webElement) {
        // wait for page to load
        waitForPageToLoad(20);
        // click on element with a timeout of 20 seconds
        clickWithTimeOut(webElement, 20);
    }

}