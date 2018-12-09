/*
 * Utility Classes Made: 
 * 				sortStringArray - to sort the String Array
 * 				searchStringArray - to search the target String from sorted list
 * Steps:
 * 	Read input from file
 * 	Store the input to String array
 * 	Sort the target and dict array
 * 
 */
import java.io.IOException;
import java.util.*;
public class searchInSortedList {
	public static void main(String []args)  {
		// Open File
		String DictFile ="/media/harry/Data/5th Sem/Java Lab/Lab3/DictInput.txt";
		String TargetFile = "/media/harry/Data/5th Sem/Java Lab/Lab3/TargetInput.txt";
		
		ReadandMakelist readInput = new ReadandMakelist();
		List<String> dictList = readInput.getIntoList(DictFile);
		List<String> targetList = readInput.getIntoList(TargetFile);
		
		sortStringArray sortInput = new sortStringArray();
		sortInput.bubbleSort(dictList, dictList.size());
		sortInput.bubbleSort(targetList,targetList.size());
		
		SearchStringArray search = new SearchStringArray();
		OutputFile output = new OutputFile();
		output.openFile("Output.txt");
		int i=0;
		int cnt = 0;
		String st;
		int dictLen = dictList.size();
		while(i != targetList.size()) {
			if(search.searchWord(dictList, 0, dictLen-1, targetList.get(i)) == -1)
			{
				try {
					output.writeToFile("Keyword not found: "+targetList.get(i));
					cnt ++;
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			i++;
		}
		st = "Number of keywords not found: " + Integer.toString(cnt);
		try {
			output.writeToFile("");
			output.writeToFile(st);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		output.closeFile();
		System.out.println("Completed");
	}
}
