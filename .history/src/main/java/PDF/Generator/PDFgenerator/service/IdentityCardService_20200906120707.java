package PDF.Generator.PDFgenerator.service;

import antlr.collections.List;
import PDF.Generator.PDFgenerator.model.Identity_card;
import org.springframework.data.domain.Page;

public interface IdentityCardService {
    List<Identity_card> getAllIdentityCard();

    
}
