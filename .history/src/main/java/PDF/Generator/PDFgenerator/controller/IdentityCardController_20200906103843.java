package PDF.Generator.PDFgenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IdentityCardController {
 
    
    @GetMapping("/")
	public String viewHomePage() {
		return "Test";
	}

}
