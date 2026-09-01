package com.bms.book_my_show.transformers;

import com.bms.book_my_show.dtos.RegisterCompanyDto;
import com.bms.book_my_show.enums.CompanyType;
import com.bms.book_my_show.models.Company;
import com.bms.book_my_show.utilities.SystemUtility;

public class CompanyTransformer {

    public static Company mapRegisterCompanyDtoToCompany(
            RegisterCompanyDto dto,
            CompanyType companyType
    ){

        return Company.builder()
                .companyCode(SystemUtility.generate("COMP"))
                .companyName(dto.getCompanyName())
                .companyType(companyType)
                .legalName(dto.getLegalName())
                .registrationNumber(dto.getRegistrationNumber())
                .gstNumber(dto.getGstNumber())
                .panNumber(dto.getPanNumber())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .website(dto.getWebsite())

                // Address
                .addressLine1(dto.getAddressLine1())
                .addressLine2(dto.getAddressLine2())
                .city(dto.getCity())
                .state(dto.getState())
                .country(dto.getCountry())
                .postalCode(dto.getPostalCode())

                // Branding
                .logoUrl(null)

                //audit
                .createdBy("system")
                .updatedBy("system")

                .build();
    }
}
