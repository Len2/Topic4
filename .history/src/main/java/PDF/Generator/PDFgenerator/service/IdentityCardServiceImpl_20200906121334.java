package PDF.Generator.PDFgenerator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PDF.Generator.PDFgenerator.repo.IdentityCardServiceRepo;

@Service
public class IdentityCardServiceImpl implements IdentityCardService {
  
    @Autowired
    private IdentityCardServiceRepo identityCardRepo;

    @Override
    public List

}