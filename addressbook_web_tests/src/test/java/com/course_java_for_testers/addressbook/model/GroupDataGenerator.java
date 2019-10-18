package com.course_java_for_testers.addressbook.model;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    @Parameter(names = "-count", description = "Group count which you want to create")
    private int count;

    @Parameter(names = "-file", description = "File path to file,in which generated data save")
    private String file;

    @Parameter(names = "-format", description = "File format, in which you want to save you file")
    private String format;

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
        switch (format) {
            case "txt":
                saveInFile(groups, new File(file));
                break;
            case "xml":
                saveInXML(groups, new File(file));
                break;
            case "json":
                saveInJSON(groups,new File(file));
                break;
            default:
                System.out.println("Unrecognized format");
                break;
        }
    }

    private void saveInJSON(List<GroupData> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(groups);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();

    }

    private void saveInXML(List<GroupData> groups, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(GroupData.class);
        String xml = xstream.toXML(groups);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();

    }

    private void saveInFile(List<GroupData> groupData, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (GroupData group: groupData){
            writer.write(String.format("%s;%s;%s\n",group.getGrname(),group.getGrheader(),group.getGrfooter()));
        }
        writer.close();
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
}
