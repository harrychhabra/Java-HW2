

import java.io.*;
public class OutputFile {
	private BufferedWriter bufferWrite;
	private File file;
	private FileOutputStream fileOutput;
	private OutputStreamWriter outputStream;
	
	public void openFile(String fileName){
		file = new File(fileName);
		try {
			fileOutput = new FileOutputStream(file);
			outputStream = new OutputStreamWriter(fileOutput);
			bufferWrite = new BufferedWriter(outputStream);
		}
		catch(IOException e)
		{
			System.out.println("File not found: "+ fileName);
			System.exit(-1);
		}
	}
	public void closeFile()
	{
		try {
			bufferWrite.close();
			outputStream.close();
			fileOutput.close();
		}
		catch(IOException e)
		{
			System.out.println("File error");
			System.exit(-1);
		}
	}
	public void writeToFile(String output) throws IOException{
		bufferWrite.write(output);
		bufferWrite.newLine();
	}
}
