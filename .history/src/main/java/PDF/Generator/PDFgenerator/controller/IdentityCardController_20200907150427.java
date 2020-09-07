package PDF.Generator.PDFgenerator.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
		List<Identity_card> identity_card = identityCardService.getAllIdentityCard();
		model.addAttribute("identity_card", identity_card);
		return "index";
	}

	@GetMapping("/newIdCard")
	public String showNewEmployeeForm(Model model) {
		Identity_card identity_card = new Identity_card();
		model.addAttribute("identity_card", identity_card);
		return "addNew";
	}

	@PostMapping("/saveIdCard")
	public String saveEmployee(@ModelAttribute("identity_card") @Valid Identity_card identity_card, Errors errors) {
		if(errors.hasErrors()){
			return "addNew"
		}
		identityCardService.saveIdentityCard(identity_card);
		return "redirect:/";
	}

	@GetMapping("/updateIdCard/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Identity_card identity_card = identityCardService.getIdentityCardById(id);
		model.addAttribute("identity_card", identity_card);
		return "update";
	}

	@GetMapping("/deleteIdCard/{id}")
	public String deleteIdentityCardById(@PathVariable(value = "id") long id) {
		this.identityCardService.deleteIdentityCardById(id);
		return "redirect:/";
	}

	@GetMapping("/pdf/{id}")
	HttpEntity<byte[]> createPdf(@PathVariable(value = "id") long id, Model model) throws IOException {

		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		Template t = ve.getTemplate("templates/PDF_template.html");
		/* create a context and add data */
		VelocityContext context = new VelocityContext();
		Identity_card identity_card = identityCardService.getIdentityCardById(id);
		context.put("id", identity_card.getId());
		context.put("firstName", identity_card.getFirstName());
		context.put("lastName", identity_card.getLastName());
		context.put("placeOfBirthday", identity_card.getPlaceOfBirthday());
		context.put("dateOfBirthday", identity_card.getDateOfBirthday());
		context.put("dateOfExpiry", identity_card.getDateOfExpiry());
		context.put("dateOfIssue", identity_card.getDateOfIssue());
		context.put("dateOfExpiry", identity_card.getDateOfExpiry());
		context.put("dateOfIssue", identity_card.getDateOfIssue());
		context.put("gender", identity_card.getGender());
		context.put("issuedBy", identity_card.getIssuedBy());
		context.put("nationality", identity_card.getNationality());
		context.put("personalNumber", identity_card.getPersonalNumber());
		context.put("residence", identity_card.getResidence());
		context.put("genDateTime", LocalDateTime.now().toString());
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		System.out.println(writer.toString());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos = generatePdf(writer.toString());
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_PDF);
		header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "Identity Card.pdf".replace(" ", "_"));
		header.setContentLength(baos.toByteArray().length);
		return new HttpEntity<byte[]>(baos.toByteArray(), header);
	}

	public ByteArrayOutputStream generatePdf(String html) {
		PdfWriter pdfWriter = null;
		// create a new document
		Document document = new Document();
		try {
			document = new Document();
			document.addAuthor("Css.de");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("css.de");
			document.addTitle("Identity Card");
			document.setPageSize(PageSize.LETTER);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);
			document.open();
			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(html));
			document.close();
			System.out.println("PDF generated successfully");
			return baos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	// @GetMapping("/msg")
	// public String printMesssage() {
	// 	return "test";
	// }
}
