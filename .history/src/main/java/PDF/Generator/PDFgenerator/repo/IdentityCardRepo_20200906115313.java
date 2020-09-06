package PDF.Generator.PDFgenerator.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import

@Repository
public interface IdentityCardRepo extends JpaRepository<Identity_card, Long> {
    
}
