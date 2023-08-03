package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\nTEST 1: department insert");
		Department department = new Department(null, "Clothes");
		departmentDao.insert(department);
		System.out.println("Inserted! New Id: " + department.getId()); 

		System.out.println("\nTEST 2: department update");
		department = new Department(5, "Clothes");
		departmentDao.update(department);
		System.out.println("Updated!");
		
		System.out.println("\nTEST 3: department delete");
		departmentDao.deleteById(6);
		System.out.println("Deleted!");
		
		System.out.println("\nTEST 4: department findById");
		Department dep = departmentDao.findById(3);
		System.out.println("Department found: " + dep);
		
		System.out.println("\nTEST 5: department findAll");
		List<Department> list = departmentDao.findAll();
		System.out.println("All departments: ");
		for(Department d : list) {
			System.out.println(d);
		}
	}

}
