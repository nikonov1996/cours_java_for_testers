package com.course_java_for_testers.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class GroupsSet extends ForwardingSet<GroupData> {

    private Set<GroupData> delegate;

    public GroupsSet(GroupsSet groupset) {
        this.delegate = new HashSet<GroupData>(groupset.delegate);
    }

    public GroupsSet() {
        this.delegate = new HashSet<GroupData>();
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }

    public GroupsSet withAdded(GroupData groupdata) {
        GroupsSet groups = new GroupsSet(this);
        groups.add(groupdata);
        return groups;
    }

    public GroupsSet without(GroupData groupdata) {
        GroupsSet groups = new GroupsSet(this);
        groups.remove(groupdata);
        return groups;
    }

}
