package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		System.out.println("TEST 1: seller findById");
		Seller seller = sellerdao.findById(3);
		System.out.println(seller);
		
		System.out.println("\nTEST 2: seller findByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = sellerdao.findByDepartment(department);
		for(Seller obj : list) System.out.println(obj);
		
		System.out.println("\nTEST 3: seller findAll");
		list = sellerdao.findAll();
		for(Seller obj : list) System.out.println(obj);
		
		System.out.println("\nTEST 4: seller insert");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 2000.00, department);
		sellerdao.insert(newSeller);
		System.out.println("Inserted! New Id: " + newSeller.getId());

		System.out.println("\nTEST 5: seller update");
		System.out.println("Before: " + sellerdao.findById(1));
		seller = sellerdao.findById(1);
		seller.setName("Bruce Waine");
		sellerdao.update(seller);
		System.out.println("After: " + sellerdao.findById(1));
		
		System.out.println("\nTEST 6: seller delete");
		sellerdao.deleteById(7);
		System.out.println("Seller deleted");
	}

}
