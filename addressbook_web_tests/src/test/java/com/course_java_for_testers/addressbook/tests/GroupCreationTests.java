package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import com.course_java_for_testers.addressbook.model.GroupsSet;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> paramsForTest() throws IOException {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/test/resources/testdata.txt")));
        String lineWithParams = bufferedReader.readLine();
        while (lineWithParams != null){
            String[] paramsObject = lineWithParams.split(";");
            list.add(new Object[]{new GroupData().withName(paramsObject[0]).withHeader(paramsObject[1]).withFooter(paramsObject[2])});
            lineWithParams = bufferedReader.readLine();
        }

/*  // Если хочется менять тестовые данные вручную в коде:
        list.add(new Object[]{new GroupData().withName("testname1").withHeader("testheader1").withFooter("testfooter1")});
        list.add(new Object[]{new GroupData().withName("testname2").withHeader("testheader2").withFooter("testfooter2")});
        list.add(new Object[]{new GroupData().withName("testname3").withHeader("testheader3").withFooter("testfooter3")});
        list.add(new Object[]{new GroupData().withName("testname4").withHeader("testheader4").withFooter("testfooter4")});
        list.add(new Object[]{new GroupData().withName("testname5").withHeader("testheader5").withFooter("testfooter5")});
*/
        return list.iterator();
    };


    @Test (dataProvider = "paramsForTest")
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
