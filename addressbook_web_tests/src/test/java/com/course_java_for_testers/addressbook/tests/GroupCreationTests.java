package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> listBefore = app.getGroupHelper().getGroupList();
        GroupData createdGroup = new GroupData("test1", "test2", "test3");
        app.getGroupHelper().createGroup(createdGroup);
        List<GroupData> listAfter = app.getGroupHelper().getGroupList();
        Assert.assertEquals(listAfter.size(), listBefore.size() + 1, "Количество групп после создания должно быть больше чем до создания.");

        // Сравнение элементов списков групп после создания новой группы
        createdGroup.setId(listAfter.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        listBefore.add(createdGroup);
        Assert.assertEquals(new HashSet<>(listAfter), new HashSet<>(listBefore), "Элементы  списка (кроме созданного)не должны быть изменены после создания группы");


    }
}
