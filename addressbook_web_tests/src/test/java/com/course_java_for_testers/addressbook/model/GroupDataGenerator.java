package com.course_java_for_testers.addressbook.model;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    @Parameter(names = "-grcount", description = "Group count which you want to create")
    public int count;

    @Parameter(names = "-file", description = "File path to file,in which generated data save")
    public String file;

    public static void main(String[] args) throws IOException {
        GroupDataGenerator generator = new GroupDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        }catch (ParameterException ex){
            jCommander.usage();   // выводит информацию о параметрах, когда пользователь ввел неправильные параметры или не знает как запускать генератор
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<GroupData> groups = generateGroups(count);
        saveGeneratedGroupsInFile(groups, new File(file));
    }

    private List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
            int random = (int) (Math.random() * count);
            groups.add(new GroupData()
                    .withName(String.format("testname%s", random))
                    .withHeader(String.format("testheader%s", random))
                    .withFooter(String.format("testfooter%s", random)));
        }
        return groups;
    }

    private void saveGeneratedGroupsInFile(List<GroupData> groupData, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (GroupData group: groupData){
            writer.write(String.format("%s;%s;%s\n",group.getGrname(),group.getGrheader(),group.getGrfooter()));
        }
        writer.close();
    }
}
