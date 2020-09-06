package PDF.Generator.PDFgenerator.controller;

import org.springframework.stereotype.Controller;

@Controller
public class IdentityCardController {
 
    
    @GetMapping("/")
	public String viewHomePage() {
		return "Tw"
	}

}
