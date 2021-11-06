package Backend;

import Models.ClientModel;
import Models.EmployeeModel;
import Models.OrderModel;
import Models.ProductModel;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DBActivities {
	private static List<ProductModel> productModels = null;
	private static final ArrayList<ClientModel> clientModels = null;
	private static final ArrayList<OrderModel> orderModels = null;
	private static final ArrayList<EmployeeModel> employeeModels = null;
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
			List<String[]> productsRaw = new CSVReader(new FileReader("src/main/java/Backend/products.csv")).readAll();
			productModels = productsRaw.stream().map((String[] raw)->
					new ProductModel(Integer.parseInt(raw[0]),
							raw[1],
							Float.parseFloat(raw[2]),
							Integer.parseInt(raw[3])))
					.collect(Collectors.toList());
		}
		catch(IOException | CsvException e) {
			e.printStackTrace();
		}
		
		return productModels;
	}
	
	public static List<ProductModel> searchProducts(String keyword) {
		List<ProductModel> result = getProducts()
				.stream()
				.filter((ProductModel item)->
						item.getName().substring(0,keyword.length()).equalsIgnoreCase(keyword)
				)
				.collect(Collectors.toList());
		return result;
	}
	
	public static ProductModel getProduct(int id) {
		List<ProductModel> products = getProducts();
		return products.get(id);
	}
	
	public static void addProduct(ProductModel product) {
		List<ProductModel> products = getProducts();
		product.setId(products.get(products.size()-1).getId()+1);
		products.add(product);
	}
	
	//	TODO naprawić modyfikację
	public static void modifyProduct(ProductModel product) {
		List<ProductModel> products = getProducts();
		products.set(product.getId(),product);
	}
	
	//	TODO dodać usuwanie
	
	
	public static void saveChangesProduct() {
		List<ProductModel> products = getProducts();
		try {
			ICSVWriter writer = new CSVWriterBuilder(new FileWriter("src/main/java/Backend/products.csv")).build();
			List<String[]> rawProducts = products.stream().map((ProductModel product)->{
				String[] rawProduct = new String[4];
				rawProduct[0] = String.valueOf(product.getId());
				rawProduct[1] = product.getName();
				rawProduct[2] = String.valueOf(product.getPrice());
				rawProduct[3] = String.valueOf(product.getAmount());
				return rawProduct;
			}).collect(Collectors.toList());
			writer.writeAll(rawProducts);
			writer.flushQuietly();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
