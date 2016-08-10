package com.example.therdsak.contectpp.Model;


import java.util.UUID;

public class Contact {
    protected UUID contactId;
    protected String contactName;
    protected String contactTelNumber;
    protected String contactEmail;

    public Contact(){
        this(UUID.randomUUID());
    }

    public Contact(UUID newContactId){
        this.contactId = newContactId;
    }

    public UUID getContactId() {
        return contactId;
    }
    public String getPhotoFileName() {return "IMG_" + getContactId().toString() + ".jpg";}
    public String getContactName() {
        return contactName;
    }
    public String getContactTelNumber() {
        return contactTelNumber;
    }
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactId(UUID contactId) {
        this.contactId = contactId;
    }
    public void setContactName(String contactName) {this.contactName = contactName;}
    public void setContactTelNumber(String contactTelNumber) {this.contactTelNumber = contactTelNumber;}
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
