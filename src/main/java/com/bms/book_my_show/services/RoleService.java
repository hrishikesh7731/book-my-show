package com.bms.book_my_show.services;

import com.bms.book_my_show.constants.SystemConstant;
import com.bms.book_my_show.enums.CompanyType;
import com.bms.book_my_show.models.Operation;
import com.bms.book_my_show.models.Role;

import java.util.List;

public class RoleService {

    private final OperationService operationService;

    public RoleService(OperationService operationService){
        this.operationService=operationService;
    }

    public Role createAdminUserByCompanyType(String companyName, CompanyType companyType){
        List<Operation>operations=operationService.getOperationsForAdminByCompanyType(companyType);

        return Role.builder()
                .roleName(companyName+"_"+ SystemConstant.DEFAULT_ADMIN_ROLE_NAME)
                .operations(operations)
                .createdBy("system")
                .updatedBy("system")
                .build();
    }
}
