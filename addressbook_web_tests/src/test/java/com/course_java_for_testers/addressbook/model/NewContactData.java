package com.course_java_for_testers.addressbook.model;

public class NewContactData {
    private String firstname;
    private String lastname;
    private String nickname;
    private String title;
    private String address;
    private String company;
    private String homePhone;
    private String mobilePhone;
    private String email;
    private String group;

    public NewContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public NewContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public NewContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public NewContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public NewContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public NewContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public NewContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public NewContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public NewContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public NewContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getCompany() {
        return company;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() { return group; }

    @Override
    public String toString() {
        return "NewContactData{" +
                "firstname='" + firstname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewContactData that = (NewContactData) o;

        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        return lastname != null ? lastname.hashCode() : 0;
    }
}
