package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

    /* Add the field for location with validation that ensures it is not empty and has a reasonable length. In addition, add public accessor methods to Employer.

     */
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Must be between 3 and 50 characters")
    private String location;
    public String getLocation() { return location;}
    public void setLocation(String location) { this.location = location;}

    public Employer(){}
    public Employer(String location){ this.location=location;}



}///
