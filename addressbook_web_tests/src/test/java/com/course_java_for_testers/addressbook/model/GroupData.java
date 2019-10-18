package com.course_java_for_testers.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("group")
public class GroupData {
    @XStreamOmitField private int id = Integer.MAX_VALUE;
    private String grname;
    private String grheader;
    private String grfooter;

    public int getId() { return id; }

    public String getGrname() {
        return grname;
    }

    public String getGrheader() {
        return grheader;
    }

    public String getGrfooter() {
        return grfooter;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        return grname != null ? grname.equals(groupData.grname) : groupData.grname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (grname != null ? grname.hashCode() : 0);
        return result;
    }

    public GroupData withName(String grname) {
        this.grname = grname;
        return this;

    }

    public GroupData withHeader(String grheader) {
        this.grheader = grheader;
        return this;
    }

    public GroupData withFooter(String grfooter) {
        this.grfooter = grfooter;
        return this;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "grname='" + grname + '\'' +
                ", id=" + id +
                '}';
    }

}
