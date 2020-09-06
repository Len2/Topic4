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
		// krijon modelin per ti lidhur te dhenat me formen
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
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
