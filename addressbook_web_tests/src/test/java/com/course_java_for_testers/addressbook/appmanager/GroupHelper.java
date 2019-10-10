package com.course_java_for_testers.addressbook.appmanager;

import com.course_java_for_testers.addressbook.model.GroupData;
import com.course_java_for_testers.addressbook.model.GroupsSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void selectGroup(int index) { driver.findElements(By.name("selected[]")).get(index).click(); }

    private void selectGroupById(int id) { driver.findElement(By.cssSelector("input[value='"+ id +"']")).click(); }

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
        groupCache = null;
        returntoGroupPage();
    }

    public void modifyGroup(GroupData group) {
        selectGroupById(group.getId()); // выбрали  элемент из списка по id
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returntoGroupPage();
    }

    public void deleteGroup(int index) {
        selectGroup(index); //выбрали последний элемент из списка
        deleteSelectedGroups();
        groupCache = null;
        returntoGroupPage();
    }

    public void deleteGroupById (GroupData group){
        selectGroupById(group.getId()); //выбрали группу по id
        deleteSelectedGroups();
        groupCache = null;
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
            int id = Integer.parseInt(elem.findElement(By.tagName("input")).getAttribute("value"));
            group.add(new GroupData().withName(name).withId(id));
        }
        return group;
    }

    private GroupsSet  groupCache = null;  // кэширование

    public GroupsSet getGroupSet() {
        if (groupCache != null ){
            return new GroupsSet(groupCache);

        }
        groupCache = new GroupsSet();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement elem: elements) {
            String name = elem.getText();
            int id = Integer.parseInt(elem.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withName(name).withId(id));
        }
        return new GroupsSet(groupCache);
    }
}
