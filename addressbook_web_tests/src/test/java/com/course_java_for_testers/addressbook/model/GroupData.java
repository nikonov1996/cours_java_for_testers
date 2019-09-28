package com.course_java_for_testers.addressbook.model;

public class GroupData {
    private final String grname;
    private final String grheader;
    private final String grfooter;

    public GroupData(String grname, String grheader, String grfooter) {
        this.grname = grname;
        this.grheader = grheader;
        this.grfooter = grfooter;
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

    @Override
    public String toString() {
        return "GroupData{" +
                "grname='" + grname + '\'' +
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
