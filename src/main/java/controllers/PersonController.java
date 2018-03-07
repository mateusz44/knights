package controllers;
 
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import domain.Chef;
import domain.GuruTasks;
import domain.Person;
import repository.ChefRepository;
import repository.GuruTasksRepository;
import service.PersonService;
 
@Controller
public class PersonController { 
	@Autowired
	PersonService personService;
	@Autowired
	GuruTasksRepository guruRepository;
	@Autowired
	ChefRepository chefRepository;
	@RequestMapping("/welcome")
	public String welcome(Model model){
		model.addAttribute("allChefs", personService.getAllChefs(1));
		model.addAttribute("persons", personService.getAllPerson());
		model.addAttribute("gurutaskschef", personService.getAllChefsInGroup(33));
		model.addAttribute("gurutasksperson", personService.getAllPersonInGroup(33));
		return "welcome";
	}
	
    @RequestMapping("/person")
    public String getPerson(@RequestParam("id") Integer id, Model model) {
    	Person persons = personService.getPersonById(id);
    	model.addAttribute("persons", persons);
    	List<GuruTasks> gurutasks = guruRepository.getGuruTasks();
    	System.out.println(gurutasks.toString());
    	model.addAttribute("gurutasks", gurutasks);
		return "person";
    	
    }
    @RequestMapping("/chef")
    public String getPerson(Model model) {
    	List<Chef> listChefs = personService.getAllChefs(1);
  
    	model.addAttribute("lchefs", listChefs);
		return "chef";
    }
    @RequestMapping("/update")
    public String updateChef(@RequestParam("id") Integer id, Model model){
    	Chef chef = chefRepository.getChefById(id);
    	model.addAttribute("lchefs", chef);
    	System.out.println(chef.getId()+":"+chef.getName()+" gg2222222222222222222222222222ggggggggggggggggggggggggggggggggggggggggggggggg");

    	return "update";
    }
    @RequestMapping(value = "/chef", method = RequestMethod.POST)
    public String update(@Valid Chef chef, BindingResult bindingResult){
    	System.out.println(chef.getId()+1+":"+chef.getName()+" ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");

    	personService.updateChef( chef.getId()+1, chef);
    	return "redirect:/chef";
    }
}
 

