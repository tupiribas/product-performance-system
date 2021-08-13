package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import service.CalculationService;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the source file path: ");
		String path = sc.nextLine();
		// C:\pastaarquivo\product\prod.csv
		
		File file = new File(path);
		String sourceFile = file.getParent();

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

			System.out.println(file.getParent());

			boolean success = new File(sourceFile + "\\out").mkdir();

			String destinationFile = sourceFile + "\\out\\summary.csv";

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile))) {
				for (Product product : list) {
					bw.write(product.getName() + ", " + product.getValue());
					bw.newLine();
				}
				bw.write("\nMost expensive: " + CalculationService.max(list));
				System.out.println("Arquivo " + destinationFile + " criado com sucesso!");
			} 
			catch (IOException e) {
				System.out.println("ERROR Cod.:002>>>" + e.getMessage());
			}

		} 
		catch (IOException e) {
			System.out.println("ERROR Cod.:001>>>" + e.getMessage());
		}
	}
}
