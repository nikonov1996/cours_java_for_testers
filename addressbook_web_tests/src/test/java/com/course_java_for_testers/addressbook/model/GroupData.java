package com.course_java_for_testers.addressbook.model;


public class GroupData {
    private String grname;
    private String grheader;
    private String grfooter;
    private int id = Integer.MAX_VALUE;;

    public String getGrname() {
        return grname;
    }

    public String getGrheader() {
        return grheader;
    }

    public String getGrfooter() {
        return grfooter;
    }

    public int getId() { return id; }

    public GroupData withId(int id) {
        this.id = id;
        return this;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return grname != null ? grname.equals(groupData.grname) : groupData.grname == null;
    }

    @Override
    public int hashCode() {
        return grname != null ? grname.hashCode() : 0;
    }
}
