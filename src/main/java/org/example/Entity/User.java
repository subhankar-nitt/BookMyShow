package org.example.Entity;

import java.util.concurrent.atomic.AtomicLong;

public class User {

    private  static final AtomicLong count = new AtomicLong(1);
    private Long id;
    private String name ;

    private String password;
    private String phNo;

    public User(String name, String password, String phNo, String emailId, String address) {
        this.id=count.incrementAndGet();
        this.name = name;
        this.password = password;
        this.phNo = phNo;
        this.emailId = emailId;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String emailId;

    private String address;


}
