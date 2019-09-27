package com.course_java_for_testers.addressbook.appmanager;

import com.course_java_for_testers.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returntoGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGrname());
        type(By.name("group_header"),groupData.getGrheader());
        type(By.name("group_footer"),groupData.getGrfooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    //выбор группы по индексу
    public void selectGroup(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void createGroup(GroupData groupdata) {
        initGroupCreation();
        fillGroupForm(groupdata);
        submitGroupCreation();
        returntoGroupPage();
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    // метод пробегает по списку групп и вытаскивает инфу о группах (в данный момент имя группы)
    public List<GroupData> getGroupList() {
        List<GroupData> group = new ArrayList<GroupData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement elem: elements) {
            String name = elem.getText();
            GroupData groupData = new GroupData(name,null,null);
            group.add(groupData);
        }
        return group;
    }
}
