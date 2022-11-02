package oopWithNLayeredApp;

import oopWithNLayeredApp.business.ProductManager;
import oopWithNLayeredApp.core.logging.DatabaseLogger;
import oopWithNLayeredApp.core.logging.FileLogger;
import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.core.logging.MailLogger;
import oopWithNLayeredApp.dataAccess.HibernateProductDao;
import oopWithNLayeredApp.dataAccess.JdbcProductDao;
import oopWithNLayeredApp.entities.Product;

public class Main {

	public static void main(String[] args) throws Exception {
		Product product1 = new Product(1, "iPhone XR", 9000);
		Product product2 = new Product(2, "Mate 20 lite", 4000);

		Logger[] loggers = {new FileLogger(), new DatabaseLogger(), new MailLogger()};
		
		ProductManager productManager1 = new ProductManager(new HibernateProductDao(), loggers);
		ProductManager productManager2 = new ProductManager(new JdbcProductDao(), loggers);
		
		productManager1.add(product1);
		productManager2.add(product2);

	}

}
