package at.ac.htlinn.spring_boot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/people")
public class PersonViewController {

    private final PersonRepository repo;

    public PersonViewController(PersonRepository repo) {
        this.repo = repo;
    }
    
    @GetMapping("/view/{id}")
    public String showPerson(@PathVariable Long id, Model model) {

        var person = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));

        model.addAttribute("person", person);

        return "person-view";   // loads person-view.html
    }
    
    @GetMapping("/view")
    public String listPeople(Model model) {

        model.addAttribute("people", repo.findAll());

        return "people-list";  // loads people-list.html
    }
}