package com.tenalic.site.testBdd;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, String> {

}
