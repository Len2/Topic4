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

//PDF Library
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDateTime;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;



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
		Identity_card identity_card = identityCardService.getIdentityCardById(id);
		
		
		// set employee si atribut per ta mbushur formen
		model.addAttribute("identity_card", identity_card);
		return "updateIdCard";
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

	@GetMapping("/genpdf/{id}")
	HttpEntity<byte[]> createPdf(@PathVariable ( value = "id") long id, Model model) throws IOException {

		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();

		/* next, get the Template */
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		ve.init();
		Template t = ve.getTemplate("templates/helloworld.html");
		/* create a context and add data */
		VelocityContext context = new VelocityContext();

		// get employee prej service
		Identity_card employee = employeeService.getEmployeeById(id);
		// set employee si atribut per ta mbushur formen
		//model.addAttribute("employee", employee);

		context.put("name", "World");
		context.put("id", employee.getId());
		context.put("genDateTime", LocalDateTime.now().toString());
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		/* show the World */
		System.out.println(writer.toString());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		baos = generatePdf(writer.toString());

		HttpHeaders header = new HttpHeaders();
	    header.setContentType(MediaType.APPLICATION_PDF);
	    header.set(HttpHeaders.CONTENT_DISPOSITION,
	                   "attachment; filename=" + "testLendrit.pdf".replace(" ", "_"));
	    header.setContentLength(baos.toByteArray().length);

	    return new HttpEntity<byte[]>(baos.toByteArray(), header);

	}

	public ByteArrayOutputStream generatePdf(String html) {

		// String pdfFilePath = "";
		PdfWriter pdfWriter = null;

		// create a new document
		Document document = new Document();
		try {

			document = new Document();
			// document header attributes
			document.addAuthor("Css.de");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("css.de");
			document.addTitle("Identity Card");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);

			// open document
			document.open();

			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(
					html));
			// close the document
			document.close();
			System.out.println("PDF generated successfully");

			return baos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@GetMapping("/msg")
	public String printMesssage(){
		return "PDF";
	}
    


}