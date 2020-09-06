package PDF.Generator.PDFgenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import PDF.Generator.PDFgenerator.model.Identity_card;
import PDF.Generator.PDFgenerator.service.IdentityCardService;



@Controller
public class IdentityCardController {

    @Autowired
    private IdentityCardService identityCardService;

    @GetMapping("/")
	public String viewHomePage(Model model) {
        //return findPaginated(1, "firstName", "asc", model);	
        // return "Test";
        List<Identity_card> identity_card = identityCardService.getAllIdentityCard();
        model.addAttribute("identity_card", identity_card);
        return "index";
    } 
    
    @GetMapping("/newIdCard")
	public String showNewEmployeeForm(Model model) {
		Identity_card identity_card = new Identity_card();
		model.addAttribute("identity_card", identity_card);
		return "newIdCard";
    }
    
    @PostMapping("/saveIdCard")
	public String saveEmployee(@ModelAttribute("identity_card") Identity_card identity_card) {
		// Ruan employee ne databaze
		identityCardService.saveIdentityCard(identity_card);
		return "redirect:/";
    }

    

    @GetMapping("/updateIdCard/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee prej service
		Employee employee = employeeService.getEmployeeById(id);
		
		
		// set employee si atribut per ta mbushur formen
		model.addAttribute("employee", employee);
		return "update_employee";
	}
    
    

    @GetMapping("/deleteIdCard/{id}")
	public String deleteIdentityCardById(@PathVariable (value = "id") long id) {
		
		// thirr metoden delete employee
		this.identityCardService.deleteIdentityCardById(id);
		return "redirect:/";
	}


    // @GetMapping("/page/{pageNo}")
	// public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
	// 		@RequestParam("sortField") String sortField,
	// 		@RequestParam("sortDir") String sortDir,
	// 		Model model) {
	// 	int pageSize = 1;
		
	// 	Page<Identity_card> page = identityCardService.findPaginated(pageNo, pageSize, sortField, sortDir);
	// 	List<Identity_card> listEmployees = page.getContent();
		
	// 	// model.addAttribute("currentPage", pageNo);
	// 	// model.addAttribute("totalPages", page.getTotalPages());
	// 	// model.addAttribute("totalItems", page.getTotalElements());
		
	// 	// model.addAttribute("sortField", sortField);
	// 	// model.addAttribute("sortDir", sortDir);
	// 	// model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
	// 	model.addAttribute("listEmployees", listEmployees);
	// 	return "index";
	// }
    


}
