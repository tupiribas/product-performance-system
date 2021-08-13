package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;
import service.CalculationService;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		String path = "C:\\pastaarquivo\\product\\prod.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Product> list = new ArrayList<>();
			String line = br.readLine();

			while (line != null) {
				String[] i = line.split(",");

				String name = i[0];
				double value = Double.parseDouble(i[1]);

				list.add(new Product(name, value));
				
				line = br.readLine();
			}
			
			for (Product product : list) {
				System.out.println(product);
			}
			System.out.println("Most expensive: " + CalculationService.max(list));

		} 
		catch (IOException e) {
			System.out.println("ERROR >>>" + e.getMessage());
		}

	}
}
