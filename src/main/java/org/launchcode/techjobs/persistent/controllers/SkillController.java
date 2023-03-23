package org.launchcode.techjobs.persistent.controllers;


import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("skill")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    /* Add an index method that responds at /employers with a list of all employers in the database. This method should use the template employers/index.
     */
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("employers", skillRepository.findAll());
        return"employers/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewSkill(Model model, @PathVariable int employerId) {

//        Optional optEmployer = null;
        Optional<Skill> optEmployer = skillRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Skill skill = (Skill) optEmployer.get();
            model.addAttribute("employer", skill);
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }
}
