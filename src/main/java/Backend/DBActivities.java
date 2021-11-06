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
	private static EmployeeModel loggedUser;
	
	private static EmployeeModel login(String login, String password) {
		EmployeeModel user = null;
		
		try {
			Stream<String[]> users = new CSVReader(new FileReader("users.csv")).readAll().stream();
			String[] userRaw = (String[])users.filter((String[] attr)->attr[3] == login && attr[4] == password).toArray()[0];
		}
		catch(IOException | CsvException e) {
			e.printStackTrace();
		}
		
		
		return user;
	}
}
