package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Required field")
    @Size(min = 3, max = 50, message = "Must be between 3 and 50 characters")
    private String location;
    public String getLocation() { return location;}
    public void setLocation(String location) { this.location = location;}

    @OneToMany(mappedBy = "employer")
    @JoinColumn(name = "employer_id")
    private List<Job> jobs = new ArrayList<>();

    //Constructors
    public Employer(){}
    public Employer(String location){ this.location=location;}


    @Override
    public String toString() {
        return location;
    }
}///
