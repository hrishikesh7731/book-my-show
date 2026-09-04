package com.bms.book_my_show.repositories;

import com.bms.book_my_show.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
