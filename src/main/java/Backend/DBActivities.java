package Backend;

import Models.ClientModel;
import Models.EmployeeModel;
import Models.OrderModel;
import Models.ProductModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DBActivities {
	private static List<ProductModel> productModels = null;
	private static ArrayList<ClientModel> clientModels = null;
	private static ArrayList<OrderModel> orderModels = null;
	private static ArrayList<EmployeeModel> employeeModels = null;
	private static EmployeeModel loggedUser = null;
	
	public static EmployeeModel login(String login, String password) {
		try {
			Stream<String[]> users = new CSVReader(new FileReader("users.csv")).readAll().stream();
			String[] userRaw = (String[])users.filter((String[] attr)->attr[3] == login && attr[4] == password).toArray()[0];
			loggedUser = new EmployeeModel(Integer.parseInt(userRaw[0]),
					userRaw[1],
					userRaw[2],
					userRaw[3],
					userRaw[4]);
		}
		catch(IOException | CsvException e) {
			e.printStackTrace();
		}
		
		return loggedUser;
	}
	
	public static EmployeeModel getLoggedUser() {
		return loggedUser;
	}
	
	public static void logout() {
		loggedUser = null;
	}
	
	public static List<ProductModel> getProducts() {
		if(productModels != null) {
			return productModels;
		}
		
		try {
			List<String[]> productsRaw = new CSVReader(new FileReader("users.csv")).readAll();
			productModels = productsRaw.stream().map((String[] raw)->
					new ProductModel(Integer.parseInt(raw[0]),
						raw[1],
						raw[2],
						Integer.parseInt(raw[3]))).collect(Collectors.toList());
		}
		catch(IOException | CsvException e) {
			e.printStackTrace();
		}
		
		return productModels;
	}
	
	/*public static List<ProductModel> search(String keyword) {
		List<ProductModel> result = getProducts()
				.stream()
				.filter((ProductModel item)-> );
	}*/
}
