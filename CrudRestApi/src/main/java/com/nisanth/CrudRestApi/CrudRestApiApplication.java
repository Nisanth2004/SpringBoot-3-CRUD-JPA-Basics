package com.nisanth.CrudRestApi;

import com.nisanth.CrudRestApi.model.Employee;
import com.nisanth.CrudRestApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudRestApiApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudRestApiApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception
	{
		Employee employee=new Employee();
		employee.setFirstName("Nisanth");
		employee.setLastName("Selvaraj");
		employee.setEmailId("nisanthselva2004@gmail.com");
		//employeeRepository.save(employee);


		Employee employee1=new Employee();
		employee1.setFirstName("SUjith");
		employee1.setLastName("Selvaraj");
		employee1.setEmailId("sujithselva2020@gmail.com");
		//employeeRepository.save(employee1);

	}
}
