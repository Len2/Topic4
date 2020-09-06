package PDF.Generator.PDFgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import PDF.Generator.PDFgenerator.service.IdentityCardService;



@Controller
public class IdentityCardController {

    @Autowired
    private IdentityCardService identityCardService;

    @GetMapping("/")

	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);	
    }
    


}
