package com.course_java_for_testers.addressbook.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "dataFromXML") // тестовые данные беруться из xml файла
    public Iterator<Object[]> dataFromXML() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testdata.xml")));
        StringBuilder xml = new StringBuilder("");
        String line = reader.readLine();
        while (line != null){
            xml.append(line);
            line = reader.readLine();
        }
        XStream xStream = new XStream();
        xStream.processAnnotations(GroupData.class);
        List<GroupData> groups = (List<GroupData>) xStream.fromXML(xml.toString());
        return groups.stream()
                .map((g) -> new Object[]{g})
                .collect(Collectors.toList())
                .iterator();
    }

    @DataProvider(name = "dataFromJSON") // тестовые данные беруться из xml файла
    public Iterator<Object[]> dataFromJSON() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testdata.json")));
        StringBuilder json = new StringBuilder("");
        String line = reader.readLine();
        while (line != null){
            json.append(line);
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<GroupData> groups = gson.fromJson(json.toString(), new TypeToken<List<GroupData>>(){}.getType());
        return groups.stream()
                .map((g) -> new Object[]{g})
                .collect(Collectors.toList())
                .iterator();
    }

    @DataProvider(name = "dataFromFile") // тестовые данные берутся из текстового файла
    public Iterator<Object[]> dataFromFile() throws IOException {
        ArrayList<Object[]> list = new ArrayList<Object[]>();

        //Если нужно читать данные из файла
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/test/resources/testdata.txt")));
        String lineWithParams = bufferedReader.readLine();
        while (lineWithParams != null){
            String[] paramsObject = lineWithParams.split(";");
            list.add(new Object[]{new GroupData().withName(paramsObject[0]).withHeader(paramsObject[1]).withFooter(paramsObject[2])});
            lineWithParams = bufferedReader.readLine();
        }
        return list.iterator();
    };

    @DataProvider(name = "dataFromManual") // ручной ввод тестовых данных
    public Iterator<Object[]> dataFromManual() throws IOException {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new GroupData().withName("testname1").withHeader("testheader1").withFooter("testfooter1")});
        list.add(new Object[]{new GroupData().withName("testname2").withHeader("testheader2").withFooter("testfooter2")});
        list.add(new Object[]{new GroupData().withName("testname3").withHeader("testheader3").withFooter("testfooter3")});
        list.add(new Object[]{new GroupData().withName("testname4").withHeader("testheader4").withFooter("testfooter4")});
        list.add(new Object[]{new GroupData().withName("testname5").withHeader("testheader5").withFooter("testfooter5")});
        return list.iterator();
    };
}
