package com.example.therdsak.contectpp.Model;


import java.util.UUID;

public class Contact {
    private UUID contactId;
    private String contactName;
    private String contactTelNumber;
    private String contactEmail;

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
