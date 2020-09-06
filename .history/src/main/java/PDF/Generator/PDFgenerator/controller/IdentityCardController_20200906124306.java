package PDF.Generator.PDFgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import PDF.Generator.PDFgenerator.service.IdentityCardService;



@Controller
public class IdentityCardController {

    @Autowired
    private IdentityCardService identityCardService;

    @GetMapping("/")
    @ResponseBody
	public String viewHomePage(Model) {
		return "Test";
	}

}
