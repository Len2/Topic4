package PDF.Generator.PDFgenerator.service;

import java.util.List;
import PDF.Generator.PDFgenerator.model.Identity_card;
import org.springframework.data.domain.Page;

public interface IdentityCardService {
    List<Identity_card> getAllIdentityCard();

    
}
