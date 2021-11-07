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
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DBActivities {
	private static TreeMap<Integer,ProductModel> productModels = null;
	private static final ArrayList<ClientModel> clientModels = null;
	private static final ArrayList<OrderModel> orderModels = null;
	private static final ArrayList<EmployeeModel> employeeModels = null;
	private static EmployeeModel loggedUser = null;
	
	public static EmployeeModel login(String login, String password) {
		try {
			List<String[]> users = new CSVReader(new FileReader("src/main/java/Backend/users.csv"))
					.readAll()
					.stream()
					.filter((String[] attr)->attr[3].equals(login) && attr[4].equals(password))
					.collect(Collectors.toList());
			if(users.isEmpty()) {
				return null;
			}
			String[] userRaw = users.get(0);
			loggedUser = new EmployeeModel(
					Integer.parseInt(userRaw[0]),
					userRaw[1],
					userRaw[2],
					userRaw[3],
					userRaw[4]
			);
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
	
	public static TreeMap<Integer,ProductModel> getProducts() {
		if(productModels != null) {
			return productModels;
		}
		
		try {
			List<String[]> productsRaw = new CSVReader(new FileReader("src/main/java/Backend/products.csv")).readAll();
			productModels = productsRaw.stream()
					.map((String[] raw)->
							new ProductModel(
									Integer.parseInt(raw[0]),
									raw[1],
									Float.parseFloat(raw[2]),
									Integer.parseInt(raw[3])
							))
					.collect(Collectors.toMap(
							ProductModel::getId,
							Function.identity(),
							(a, b)-> a,
							TreeMap::new));
		}
		catch(IOException | CsvException e) {
			e.printStackTrace();
		}
		
		return productModels;
	}
	
	public static TreeMap<Integer,ProductModel> searchProducts(String keyword) {
		TreeMap<Integer,ProductModel> result = getProducts().values().stream()
				.filter((ProductModel item)->
						item.getName().substring(0,keyword.length()).equalsIgnoreCase(keyword))
				.collect(Collectors.toMap(
						ProductModel::getId,
						Function.identity(),
						(a, b)-> a,
						TreeMap::new));
		return result;
	}
	
	public static ProductModel getProduct(int id) {
		return getProducts().get(id);
	}
	
	public static void addProduct(ProductModel product) {
		TreeMap<Integer,ProductModel> products = getProducts();
		product.setId(products.lastKey()+1);
		products.put(product.getId(), product);
	}
	
	public static void modifyProduct(ProductModel product) {
		getProducts().replace(product.getId(), product);
	}
	
	
	public static void deleteProduct(ProductModel product) {
		getProducts().remove(product.getId());
	}
	
	public static void deleteProduct(int id) {
		getProducts().remove(id);
	}
	
	public static void saveChangesProduct() {
		TreeMap<Integer,ProductModel> products = getProducts();
		try {
			ICSVWriter writer = new CSVWriterBuilder(new FileWriter("src/main/java/Backend/products.csv")).build();
			List<String[]> rawProducts = products.values().stream()
					.map((ProductModel product)->{
						String[] rawProduct = new String[4];
						rawProduct[0] = String.valueOf(product.getId());
						rawProduct[1] = product.getName();
						rawProduct[2] = String.valueOf(product.getPrice());
						rawProduct[3] = String.valueOf(product.getAmount());
						return rawProduct;
					})
					.collect(Collectors.toList());
			
			writer.writeAll(rawProducts);
			writer.flushQuietly();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//	TODO CRUD identyczny z powyższym dla każdego modelu
}
