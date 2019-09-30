package com.course_java_for_testers.addressbook.model;


public class GroupData {
    private final String grname;
    private final String grheader;
    private final String grfooter;
    private int id;


    public GroupData(String grname, String grheader, String grfooter) {
        this.grname = grname;
        this.grheader = grheader;
        this.grfooter = grfooter;
        this.id = Integer.MAX_VALUE;
    }

    public GroupData(String grname, String grheader, String grfooter, int id) {
        this.grname = grname;
        this.grheader = grheader;
        this.grfooter = grfooter;
        this.id = id;
    }

    public String getGrname() {
        return grname;
    }

    public String getGrheader() {
        return grheader;
    }

    public String getGrfooter() {
        return grfooter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
