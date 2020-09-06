package PDF.Generator.PDFgenerator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import PDF.Generator.PDFgenerator.model.Identity_card;

import PDF.Generator.PDFgenerator.repo.IdentityCardServiceRepo;

@Service
public class IdentityCardServiceImpl implements IdentityCardService {
  
    @Autowired
    private IdentityCardServiceRepo identityCardRepo;

    @Override
    public List<Identity_card> getAllIdentityCard (){
        return identityCardRepo.findAll();
    }

    @Override
    public void saveIdentityCard (Identity_card identityCard){
        this.identityCardRepo.save(identityCard);
    }

    @Override
    public Identity_card getIdentityCardById(long id){
        Optional<Identity_card> optional = identityCardRepo.findById(id);
        Identity_card identity_card = null;
        if(optional.isPresent()){
            
        }
    }

}
