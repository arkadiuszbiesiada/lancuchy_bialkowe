package pl.globema.lb;

import java.util.HashMap;

public class ChangeCheck {
	
	public boolean changePossible(String s1,String s2) {
		
		//convert string chains to  char arrays
		char[] firstChain=s1.toCharArray();
		char[] secondChain=s2.toCharArray();
		
		//hash map of the first chain string
		HashMap<Character,Integer>chainHashMap=new HashMap<Character,Integer>();
		
		//check if length of both chains in equal
		if(firstChain.length==secondChain.length) {
			
			//convert the char array to hashmap<charValueAsAKey,appearanceCountOfThatCharacter>
			for(int i=0;i<firstChain.length;i++) {
				//set the chain value as a key of the hash map
				char keyValue=firstChain[i];
				
				//if the key doesn't exist yet set it's appearance to 1
				if(chainHashMap.get(keyValue)==null) {
					chainHashMap.put(keyValue, 1);
				}else {//if it already exists increment it's appearance by 1
					int appearanceCount=chainHashMap.get(keyValue);
					chainHashMap.put(keyValue, appearanceCount+1);
				}
			}
			
			//check if every element of the 2nd chain and it's count can be found in 1st chain
			for(int i=0;i<secondChain.length;i++) {
				char keyValue=secondChain[i];
				
				if(chainHashMap.get(keyValue)==null||chainHashMap.get(keyValue)==0) {
					return false;
				}
				
				int appearanceCount=chainHashMap.get(keyValue);
				chainHashMap.put(keyValue, appearanceCount-1);
			}
			return true;
			
		}
		
		return false;
	}

}
