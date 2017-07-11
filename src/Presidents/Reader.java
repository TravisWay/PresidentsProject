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
			bufIn = new BufferedReader(new FileReader("presidents.csv"));

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

	public static void makeFile(List<President> p, String party) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			StringBuilder content = new StringBuilder();
			for (int i = 0; i < makePartyList(p, party).size(); i++){
			content.append(makePartyList(p, party).get(i).getFirstName() + " " + makePartyList(p, party).get(i).getLastName()+ "\n");
			}
			String content2 = content.toString();
			fw = new FileWriter(party);
			bw = new BufferedWriter(fw);
			bw.write(content2);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
	
	//Takes an arraylist of presidents and returns an arraylist of presidents of the same party.
	public static List<President> makePartyList(List<President> p, String party) {
		List<President> presParty = new ArrayList<>(); 
		for (int i = 0; i < p.size(); i++) {
			if (presList.get(i).getParty().equals(party)) {
				presParty.add(p.get(i));
			}
		}
		return presParty;
	}
	
	//Takes an arraylist of presidents and returns an arraylist of presidents who dont have middle names
	public static List<President> makeMiddleNameList(List<President> p) {
		List<President> presParty = new ArrayList<>(); 
		for (int i = 0; i < p.size(); i++) {
			if (! presList.get(i).getMiddleName().equals(" ")) {
				presParty.add(p.get(i));
			}
		}
		return presParty;
	}
	
	//Takes arraylist and returns an arraylist of presidents with terms less than 4 years.
	public static List<President> makeTermList(List<President> p) {
		List<President> presParty = new ArrayList<>(); 
		for (int i = 0; i < p.size(); i++) {
			if ((presList.get(i).getEndYear()) - (presList.get(i).getStartYear()) < 4) {
				presParty.add(p.get(i));
			}
		}
		return presParty;
	}
	//Takes arraylist and string and returns arraylist of presidents with last name starting with that key
	public static List<President> makeLastNameList(List<President> p, String key) {
		List<President> presParty = new ArrayList<>(); 
		for (int i = 0; i < p.size(); i++) {
			if ((presList.get(i).getLastName().startsWith(key))) {
				presParty.add(p.get(i));
			}
		}
		return presParty;
	}
}
