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

    private final CompanyRepository companyRepository;
    private final UserService userService;

    @Autowired
    public CompanyService(CompanyRepository companyRepository,UserService userService){
        this.companyRepository=companyRepository;
        this.userService=userService;
    }

    public Company registerCompany(RegisterCompanyDto registerCompanyDto, CompanyType companyType){

        Company company= CompanyTransformer.mapRegisterCompanyDtoToCompany(registerCompanyDto,companyType);
        log.info("Calling repo layer to save company record in db.");
        company= saveCompany(company);
        userService.createCompanyAdminUser(company);

        return company;
    }
    public Company saveCompany(Company company){
        return this.companyRepository.save(company);
    }
}
