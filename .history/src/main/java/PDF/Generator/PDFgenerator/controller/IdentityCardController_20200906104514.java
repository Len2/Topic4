package PDF.Generator.PDFgenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IdentityCardController {
 
    
    @GetMapping("/")
    @ResponseBody
	public String viewHomePage() {
		return "Test";
	}

}
