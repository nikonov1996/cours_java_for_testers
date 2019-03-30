package com.course_java_for_testers.addressbook;

public class NewContactData {
    private final String firstname;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String address;
    private final String company;
    private final String homePhone;
    private final String mobilePhone;
    private final String email;

    public NewContactData(String firstname, String lastname, String nickname, String title, String address, String company, String homePhone, String mobilePhone, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.address = address;
        this.company = company;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.email = email;
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
}
