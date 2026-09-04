package com.bms.book_my_show.repositories;

import com.bms.book_my_show.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OperationRepository extends JpaRepository<Operation, UUID> {

    @Query(value = "SELECT * FROM public.operations " +
                    "WHERE operation_category = :operationCategory " +
                    "OR operation_category = 'COMMON_OPERATION'",
            nativeQuery = true
    )
        List<Operation> fetchAllOperationsByCategory(String operationCategory);

}
