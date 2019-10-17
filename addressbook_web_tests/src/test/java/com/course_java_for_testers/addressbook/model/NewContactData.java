package com.course_java_for_testers.addressbook.model;

import java.io.File;

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
    private File photo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewContactData that = (NewContactData) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NewContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

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

    public NewContactData withPhoto(File photo) {
        this.photo = photo;
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

    public File getPhoto() { return photo; }

}
