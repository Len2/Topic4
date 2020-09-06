package PDF.Generator.PDFgenerator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name = "identity_card")
public class Identity_card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
}
