package PDF.Generator.PDFgenerator.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

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
            identity_card = optional.get();
        }else{
            throw new RuntimeException("Is not found for id" + id);
        }
        return identity_card;
    }

    @Override
    public void deleteIdentityCardById(long id){
        this.identityCardRepo.deleteById(id);
    }

    @Override
	public Page<Identity_card> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}

}
