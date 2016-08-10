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
        contactId = newContactId;
    }

    public UUID getContactId() {
        return contactId;
    }

    public void setContactId(UUID contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTelNumber() {
        return contactTelNumber;
    }

    public void setContactTelNumber(String contactTelNumber) {
        this.contactTelNumber = contactTelNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getPhotoFileName() {
        return "IMG_" + getContactId().toString() + ".jpg";
    }
}
