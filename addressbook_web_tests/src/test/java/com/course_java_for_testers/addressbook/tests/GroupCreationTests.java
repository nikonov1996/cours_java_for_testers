package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import com.course_java_for_testers.addressbook.model.GroupsSet;
import com.course_java_for_testers.addressbook.model.TestDataProvider;
import com.thoughtworks.xstream.XStream;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test (dataProvider = "dataFromXML")
    public void testGroupCreation(GroupData group) {
        app.getNavigationHelper().gotoGroupPage();
        GroupsSet groupListBefore = app.getGroupHelper().getGroupSet();
        app.getGroupHelper().createGroup(group);
        GroupsSet groupListAfter = app.getGroupHelper().getGroupSet();
        Assert.assertEquals(
                groupListAfter.size(),
                groupListBefore.size() + 1,
                "Количество групп после создания должно быть больше чем до создания.");

        // Сравнение элементов списков групп после создания новой группы
//        assertThat(
//                groupListAfter,
//                equalTo(groupListBefore
//                        .withAdded(createdGroup.withId(groupListAfter.stream().mapToInt((g) -> g.getId()).max().getAsInt())))); // библиотека hamcrest

        Assert.assertEquals(
                groupListAfter,
                groupListBefore
                        .withAdded(group.withId(groupListAfter.stream().mapToInt((g) -> g.getId()).max().getAsInt())),
                "Элементы  списка (кроме созданного)не должны быть изменены после создания группы");

    }

}
