package com.bms.book_my_show.services;

import com.bms.book_my_show.enums.CompanyType;
import com.bms.book_my_show.models.Operation;
import com.bms.book_my_show.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    private final OperationRepository operationRepository;

    @Autowired
    public OperationService(OperationRepository operationRepository){
        this.operationRepository=operationRepository;
    }

    public List<Operation> getOperationsForAdminByCompanyType(CompanyType companyType){
        switch (companyType){
            case INTERNAL :
                return operationRepository.fetchAllOperationsByCategory("INTERNAL_COMPANY");
            case THEATER_COMPANY:
                return operationRepository.fetchAllOperationsByCategory("THEATRE_COMPANY");
            case EVENT_COMPANY:
                return operationRepository.fetchAllOperationsByCategory("EVENT_COMPANY");
            default:
                throw new IllegalArgumentException("Illegal CompanyType Passed i.e,"+ companyType.toString());
        }
    }
}
