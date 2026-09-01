package com.bms.book_my_show.services;

import com.bms.book_my_show.dtos.RegisterCompanyDto;
import com.bms.book_my_show.enums.CompanyType;
import com.bms.book_my_show.models.Company;
import com.bms.book_my_show.repositories.CompanyRepository;
import com.bms.book_my_show.transformers.CompanyTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }

    public Company registerTheaterCompany(RegisterCompanyDto registerCompanyDto, CompanyType companyType){

        Company company= CompanyTransformer.mapRegisterCompanyDtoToCompany(registerCompanyDto,companyType);
        log.info("Calling repo layer to save company record in db.");
        company= saveCompany(company);

        return company;

    }
    public Company saveCompany(Company company){
        return this.companyRepository.save(company);
    }
}
