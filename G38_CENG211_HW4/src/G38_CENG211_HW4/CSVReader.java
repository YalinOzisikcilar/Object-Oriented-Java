package G38_CENG211_HW4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
	public ArrayList<String> productsReader() throws IOException {
		ArrayList<String> lineArray = new ArrayList<String>();
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("products.csv"));

			String line;
			while ((line = csvReader.readLine()) != null) {
				lineArray.add(line);
			}
			csvReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lineArray;
	}

	public ArrayList<String> usersReader() throws IOException {
		ArrayList<String> lineArray = new ArrayList<String>();
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("users.csv"));

			String line;
			while ((line = csvReader.readLine()) != null) {
				lineArray.add(line);
			}
			csvReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lineArray;
	}
}
