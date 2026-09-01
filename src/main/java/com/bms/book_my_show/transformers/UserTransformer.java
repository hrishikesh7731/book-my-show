package com.bms.book_my_show.transformers;

import com.bms.book_my_show.constants.SystemConstant;
import com.bms.book_my_show.enums.CompanyType;
import com.bms.book_my_show.enums.UserType;
import com.bms.book_my_show.models.Company;
import com.bms.book_my_show.models.Employee;
import com.bms.book_my_show.utilities.SystemUtility;

public class UserTransformer {

    public static Employee transformCompanyToAdminUser(Company company){
        return Employee.builder()
                .userType(company.getCompanyType()== CompanyType.INTERNAL? UserType.INTERNAL : UserType.EMPLOYEE)
                .email(company.getEmail())
                .company(company)
                .employeeCode(SystemUtility.generate("EMP"))
                .fullName(company.getCompanyName()+" "+ SystemConstant.DEFAULT_ADMIN_NAME)
                .mobileNumber(company.getPhoneNumber())
                .designation("admin")
                .passwordHash(SystemUtility.generateRandomPassword(SystemConstant.DEFAULT_PASSWORD_LENGTH))
                .lastLoginAt(null)
                .createdBy("system")
                .updatedBy("system")
                .build();
    }
}
