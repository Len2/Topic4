package PDF.Generator.PDFgenerator.service;

import java.util.List;
import PDF.Generator.PDFgenerator.model.Identity_card;
import org.springframework.data.domain.Page;

public interface IdentityCardService {
    List<Identity_card> getAllIdentityCard();
    void saveIdentityCard(Identity_card identityCard);
    Identity_card getIdentityCardById(long id);
    void deleteIdentityCardById(long id);
    Page<I> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
