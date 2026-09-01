package com.bms.book_my_show.services;

import com.bms.book_my_show.dtos.RegisterCompanyDto;
import com.bms.book_my_show.enums.CompanyType;
import com.bms.book_my_show.models.Company;
import com.bms.book_my_show.models.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    private CompanyService companyService;

    @Autowired
    public TheaterService(CompanyService companyService){
        this.companyService=companyService;
    }

    public Company registerTheaterCompany(RegisterCompanyDto registerCompanyDto){
        return companyService.registerTheaterCompany(registerCompanyDto, CompanyType.THEATER_COMPANY);
    }
}
