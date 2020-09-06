package PDF.Generator.PDFgenerator.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PDF.Generator.PDFgenerator.model.Identity_card;


@Repository
public interface IdentityCardServiceRepo extends JpaRepository<Identity_card, Long> {
    
}
