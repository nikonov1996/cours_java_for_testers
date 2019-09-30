package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupDeletionTests extends TestBase {

    public void ensurePreconditions() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup(new GroupData(
                    "test1",
                    "test2",
                    "test3"));
        }
    }

    @Test
    public void testGroupDeletion() {
        ensurePreconditions();
        List<GroupData> groupListBefore = app.getGroupHelper().getGroupList();
        int index = groupListBefore.size()-1 ;
        app.getGroupHelper().deleteGroup(index);
        List<GroupData> groupListAfter = app.getGroupHelper().getGroupList();
        Assert.assertEquals(groupListAfter.size(),groupListBefore.size()-1,"После удаление количество групп должно быть меньше на единицу");

        // сравниваем списки групп до удаления и после удаления
        groupListBefore.remove(index);

        Comparator<? super GroupData> byId = (g1,g2)->Integer.compare(g1.getId(),g2.getId());
        groupListBefore.sort(byId);
        groupListAfter.sort(byId);
        Assert.assertEquals(groupListAfter,groupListBefore,"Элементы списка групп (кроме удаляемого) не должны изменятся после удаления группы.");

    }

}
