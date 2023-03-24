package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @Size(max = 500, message = "Limit 500 characters")
    private String description;
    public String getDescription() { return description;}
    public void setDescription(String description){this.description=description;}

    @ManyToMany(mappedBy="skills")
    private List<Job> jobs  = new ArrayList<>();
    public Skill(){};
    public Skill(String description){this.description=description;}

    @Override
    public String toString() {
        return  description;
    }

    public List<Job> getJobs() { return jobs;
    }

    public void setJob(List<Job> jobs) { this.jobs = jobs;}
}