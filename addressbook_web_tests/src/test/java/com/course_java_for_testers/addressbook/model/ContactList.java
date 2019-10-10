package com.course_java_for_testers.addressbook.model;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.ForwardingList;

import java.util.ArrayList;
import java.util.List;

public class ContactList extends ForwardingList<NewContactData> {

    private ArrayList<NewContactData> delegate;

    public ContactList() {
        this.delegate = new ArrayList<NewContactData>();
    }

    public ContactList(ContactList contact){
        this.delegate = new ArrayList<NewContactData>(contact.delegate);
    }

    @Override
    protected ArrayList<NewContactData> delegate(){
        return delegate;
    }


    public ContactList withAdded(NewContactData contactlist) {
        ContactList contacts = new ContactList(this);
        contacts.add(contactlist);
        return contacts;
    }

    public ContactList without(NewContactData contactlist) {
        ContactList contacts = new ContactList(this);
        contacts.remove(contactlist);
        return contacts;
    }
}
