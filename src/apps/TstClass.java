package apps;

import java.util.Date;

import model.entidades.Department;
import model.entidades.Seller;

public class TstClass {

	public static void main(String[] args) {
		Department obj = new Department(1, "Books");
		Seller seller = new Seller(21, "Ze", "email@email.com", new Date(), 3000.00, obj);
		System.out.println(obj);
		System.out.println(seller);
		

	}

}
