/*
 * 
 */
import java.io.*;
import java.util.*;
public class ReadandMakelist {
	
	private BufferedReader bufferRead;
	private File file;
	private FileInputStream fileInput;
	private InputStreamReader inputStream;
	
	public List<String> getIntoList(String fileName) {
	
		openFile(fileName);
		List<String> fileContent = new ArrayList<String>();
		
		if(bufferRead == null) return fileContent;
		
		// Read file into List
		String st;
		try {
			while((st = bufferRead.readLine()) != null)
			{
				fileContent.add(st);
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + fileName);
			e.printStackTrace();
			closeFile();
			System.exit(-1);
		}
		closeFile();
		return fileContent;
		
	}
	
	private void openFile(String fileName) {
		file = new File(fileName);
		bufferRead = null;
		try {
			fileInput = new FileInputStream(file);
			inputStream = new InputStreamReader(fileInput);
			bufferRead = new BufferedReader(inputStream);
		}
		catch(IOException e) {
			System.out.println("Operation Terminated: "+ fileName);
			bufferRead = null;
		}
	}
	
	private void closeFile() {
		try {
			bufferRead.close();
			inputStream.close();
			fileInput.close();
		}
		catch(IOException e) {
			System.out.println("Operation Terminated");
			System.exit(-1);
		}
	}
}
