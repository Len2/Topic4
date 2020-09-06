package PDF.Generator.PDFgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class IdentityCardController {

    @Autowired
    private IdentityCard

    @GetMapping("/hello")
    @ResponseBody
	public String viewHomePage() {
		return "Test";
	}

}
