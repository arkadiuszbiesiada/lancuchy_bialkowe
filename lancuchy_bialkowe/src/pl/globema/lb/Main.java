package pl.globema.lb;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		//Reading Data From Input File.
		String fileName;
		ReadFile file=new ReadFile();
		
		if(args.length==0) {
			System.out.println("Wywo³anie programu: java -jar program.jar nazwa_pliku.txt");
			return;
		}else {
			fileName=args[0];
		}
		
		file.readFile(fileName);
		
		ArrayList<String> chainList=file.getChainList();
		ChangeCheck changeCheck=new ChangeCheck();
		
		//check and print the result
		for(int i=0;i<chainList.size();i+=2) {
			if(changeCheck.changePossible((String)chainList.get(i),(String)chainList.get(i+1))) {
				System.out.println((String)chainList.get(i)+"::"+(String)chainList.get(i+1)+"::true");
			}else {
				System.out.println((String)chainList.get(i)+"::"+(String)chainList.get(i+1)+"::false");
			}
		}
	}

}
