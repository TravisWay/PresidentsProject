package Presidents;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;

public class Reader {
	
	private ServletContext context;
	
	public Reader(ServletContext context){
		this.context = context;
	}

	public List<President> reader(List<President> presList) {
		BufferedReader bufIn = null;
		InputStream is = context.getResourceAsStream("/WEB-INF/presidents.csv");
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {

			String line;
			//Reads through the csv file and stores the elements from each line into a president object which is part of a List.
			while ((line = buf.readLine()) != null) {
//				System.out.println(line);
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
				newPres.setImg(presArr[7]);

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
		return presList;
	}
}