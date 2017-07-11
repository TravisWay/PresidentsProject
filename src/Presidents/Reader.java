package Presidents;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	static List<President> presList = new ArrayList<>();

	public static void Reader() {
		BufferedReader bufIn = null;
		try {
			bufIn = new BufferedReader(new FileReader("WEB-INF/presidents.csv"));

			String line;
			//Reads through the csv file and stores the elements from each line into a president object which is part of a List.
			while ((line = bufIn.readLine()) != null) {
				String[] presArr = line.split(", ");
				President newPres = new President();
				
				newPres.setTermNumber(Integer.parseInt(presArr[0]));
				newPres.setFirstName(presArr[1]);
				newPres.setMiddleName(presArr[2] + " ");
				newPres.setLastName(presArr[3]);
				String[] term = presArr[4].split("-");
				newPres.setStartYear(Integer.parseInt(term[0]));
				newPres.setEndYear(Integer.parseInt(term[1]));
				newPres.setParty(presArr[5]);
				newPres.setFact(presArr[6]);

				presList.add(newPres);

			}
			
			
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (bufIn != null) {
				try {
					bufIn.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}
	}

}