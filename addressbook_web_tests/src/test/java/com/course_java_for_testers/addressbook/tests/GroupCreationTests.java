package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> groupListBefore = app.getGroupHelper().getGroupList();
        GroupData createdGroup = new GroupData()
                .withName("test1")
                .withHeader("test2")
                .withFooter("test3");
        app.getGroupHelper().createGroup(createdGroup);
        List<GroupData> groupListAfter = app.getGroupHelper().getGroupList();
        Assert.assertEquals(groupListAfter.size(), groupListBefore.size() + 1, "Количество групп после создания должно быть больше чем до создания.");

        // Сравнение элементов списков групп после создания новой группы
      //  createdGroup.setId(groupListAfter.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        groupListBefore.add(createdGroup);

        Comparator<? super GroupData> byId = (g1,g2)->Integer.compare(g1.getId(),g2.getId());
        groupListBefore.sort(byId);
        groupListAfter.sort(byId);
        Assert.assertEquals(groupListAfter, groupListBefore, "Элементы  списка (кроме созданного)не должны быть изменены после создания группы");


    }
}
