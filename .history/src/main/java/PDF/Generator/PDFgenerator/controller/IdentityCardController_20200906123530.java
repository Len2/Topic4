package PDF.Generator.PDFgenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class IdentityCardController {

    @Auto
 
    
    // this is a comment 
//-------------------this rout is for starting localhost:8080-----------------------------------
    @GetMapping("/hello")
    @ResponseBody
	public String viewHomePage() {
		return "Test";
	}

}