package com.bms.book_my_show.services;
import com.bms.book_my_show.models.Company;
import com.bms.book_my_show.models.Employee;
import com.bms.book_my_show.models.Role;
import com.bms.book_my_show.repositories.EmployeeRepository;
import com.bms.book_my_show.transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final RoleService roleService;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public UserService(RoleService roleService,EmployeeRepository employeeRepository){
        this.roleService=roleService;
        this.employeeRepository=employeeRepository;
    }

    public Employee createCompanyAdminUser(Company company){

        Employee sysAdmin= UserTransformer.transformCompanyToAdminUser(company);
        Role role= roleService.createAdminUserByCompanyType( company.getCompanyName(), company.getCompanyType());
        sysAdmin.setRoles(List.of(role));
        employeeRepository.save(sysAdmin);
        return sysAdmin;
    }
}
