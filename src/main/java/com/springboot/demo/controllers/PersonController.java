package com.springboot.demo.controllers;

import com.springboot.demo.entity.Person;
import com.springboot.demo.repository.GuruTasksRepository;
import com.springboot.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;

    @Autowired
    GuruTasksRepository guruRepository;

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("allChefs", personService.getAllChefs());
        model.addAttribute("persons", personService.getAllPerson());
        model.addAttribute("gurutaskschef", personService.getAllChefsInGroup(33));
        model.addAttribute("gurutasksperson", personService.getAllPersonInGroup(33));
        return "welcome";
    }

    @RequestMapping("/person")
    public String getPerson(@RequestParam("id") Integer id, Model model) {
        Person person = personService.getPersonById(id);
        model.addAttribute("person", person);
        model.addAttribute("gurutasks", person.getGuruTasks());
        return "person";
    }

    @RequestMapping("/chefs")
    public String getPerson(Model model) {
        List<Person> listChefs = personService.getAllChefs();
        model.addAttribute("lchefs", listChefs);
        return "chef";
    }

    @RequestMapping(value = "/chef", method = RequestMethod.POST)
    public String update(@Valid Person chef, BindingResult bindingResult) {
        System.out.println(chef);
        personService.updateChef(chef);
        return "redirect:/chefs";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String showUpdate(@RequestParam("id") int personId, Model model) {
        Person personById = personService.getPersonById(personId);
        System.out.println(personById);
        model.addAttribute("chef", personById);
        return "update";
    }
}
 

