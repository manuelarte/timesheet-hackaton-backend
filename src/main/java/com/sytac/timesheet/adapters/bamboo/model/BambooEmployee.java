package com.sytac.timesheet.adapters.bamboo.model;

import lombok.Value;

@Value
public class BambooEmployee {
    private String id;
    private String displayName;
    private String firstName;
    private String lastName;
    private String preferredName;
    private String gender;
    private String jobTitle;
    private String workPhone;
    private String mobilePhone;
    private String workEmail;
    private String department;
    private String location;
    private String division;
    private String linkedIn;
    private String workPhoneExtension;
    private String photoUploaded;
    private String photoUrl;
    private String canUploadPhoto;
}
