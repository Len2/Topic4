package PDF.Generator.PDFgenerator.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityCardRepo extends JpaRepository<I> {
    
}
