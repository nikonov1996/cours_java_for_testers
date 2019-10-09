package com.course_java_for_testers.addressbook.tests;

import com.course_java_for_testers.addressbook.model.GroupData;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

    private void ensurePreconditions() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup(new GroupData()
                    .withName("test1")
                    .withHeader("test2")
                    .withFooter("test3"));
        }
    }

    @Test
    public void testGroupDeletion() {
        ensurePreconditions();
        Set<GroupData> groupListBefore = app.getGroupHelper().getGroupSet();
        GroupData deletedGroup = groupListBefore.iterator().next(); // выбирает любую группу из списка
        app.getGroupHelper().deleteGroupById(deletedGroup);
        Set<GroupData> groupListAfter = app.getGroupHelper().getGroupSet();

        Assert.assertEquals(
                groupListAfter.size(),
                groupListBefore.size() - 1,
                "После удаление количество групп должно быть меньше на единицу");

        // сравниваем списки групп до удаления и после удаления
        groupListBefore.remove(deletedGroup);

        Assert.assertEquals(
                groupListAfter,
                groupListBefore,
                "Элементы списка групп (кроме удаляемого) не должны изменятся после удаления группы.");

    }

}
