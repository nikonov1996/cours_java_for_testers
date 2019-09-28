package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {
    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();

        if (!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup(new GroupData(
                    "test1",
                    "test2",
                    "test3"));}
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1); //выбрали последний элемент из списка
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returntoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size()-1,"После удаление количество групп должно быть меньше на единицу");
        // сравниваем списки групп до удаления и после удаления
        before.remove(before.size()-1);
        Assert.assertEquals(after,before,"Список после удаления изменился.");

    }
}
