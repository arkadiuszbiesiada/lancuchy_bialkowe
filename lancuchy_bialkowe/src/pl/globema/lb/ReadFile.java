package pl.globema.lb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	
	private ArrayList<String>chainList;
	
	public ArrayList<String> getChainList() {
		return chainList;
	}

	public void readFile(String fileName) {
//		if(fileName==null) {
//			System.out.println("Wywo³anie programu: Main nazwa_pliku");
//			return;
//		}
		
		BufferedReader brIn=null;
		try {
			brIn=new BufferedReader(
				new FileReader(fileName)
			);
		}catch(FileNotFoundException e) {
			System.out.println("Nie moge odnalezc wskazanego pliku.");
			System.out.println("Wywo³anie programu: java -jar program.jar nazwa_pliku.txt");
			return;
		}
		chainList=new ArrayList<String>();
		String line="";
		
		try {
			while((line=brIn.readLine())!=null) {
				chainList.add(line);
			}
			brIn.close();
		}catch(IOException e) {
			System.out.println("\nBlad wejscia-wyjscia.");
		}
		
	}

}
