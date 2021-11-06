package Backend;

import Models.ClientModel;
import Models.EmployeeModel;
import Models.OrderModel;
import Models.ProductModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Stream;


public class DBActivities {
	private static ArrayList<ProductModel> productModels;
	private static ArrayList<ClientModel> clientModels;
	private static ArrayList<OrderModel> orderModels;
	private static ArrayList<EmployeeModel> employeeModels;
	private static EmployeeModel loggedUser = null;
	
	public static EmployeeModel login(String login, String password) {
		if(loggedUser != null) {
			return loggedUser;
		}
		EmployeeModel user = null;
		
		try {
			Stream<String[]> users = new CSVReader(new FileReader("users.csv")).readAll().stream();
			String[] userRaw = (String[])users.filter((String[] attr)->attr[3] == login && attr[4] == password).toArray()[0];
			user = new EmployeeModel(Integer.parseInt(userRaw[0]),
					userRaw[1],
					userRaw[2],
					userRaw[3],
					userRaw[4]);
		}
		catch(IOException | CsvException e) {
			e.printStackTrace();
		}
		
		loggedUser = user;
		return user;
	}
	
	public static void logout() {
		loggedUser = null;
	}
}
