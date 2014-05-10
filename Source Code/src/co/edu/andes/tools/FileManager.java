package co.edu.andes.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import co.edu.andes.entities.Line;
import co.edu.andes.entities.ProgramPart;

/**
 * Clase encargada de desarrollar las operaciones de I/O de ficheors y directorios
 * @author Enterprise Gear Set
 *
 */
public class FileManager 
{
	/**
	 * Lee un archivo
	 * @param filePath
	 * @return
	 */
	public static List<String> readFile(String filePath)
	{
		List<String> lines = new LinkedList<String>();
		
		if (filePath != null)
		{
			BufferedReader buffer=null;
			InputStream inputStream;
			InputStreamReader inputStreamReader;
			try
			{
				inputStream=new FileInputStream(filePath); 
				inputStreamReader = new InputStreamReader(inputStream);
				buffer=new BufferedReader(inputStreamReader);
				String line;
				line = buffer.readLine();
				while (line != null)
				{
					lines.add(line);
					line = buffer.readLine();
				}
			}       
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
			finally
			{
				if(buffer!=null)
				{
					try 
					{
						buffer.close();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		
		return lines;
	}

	/**
	 * Guarda un archivo
	 * @param lines
	 * @param filePath
	 */
	public static void saveFile(List<String> lines, String filePath)
	{
		FileWriter fileWriter;
		File file;
		BufferedWriter bufferedWriter;
		int size=0;
		file= new File(filePath);
		try {
			if (!file.exists()) 
				file.createNewFile();

			fileWriter= new FileWriter(file.getAbsoluteFile());
			bufferedWriter = new BufferedWriter(fileWriter);
			size = lines.size();

			for(int i=0; i<size; i++){
				bufferedWriter.write(lines.get(i));
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (IOException e1) {
			System.out.print("error al guardar el archivo "+filePath);
		}
	}

	/**
	 * 
	 * @param filePath
	 * @param part
	 */
	public static void saveFile(String currentVersionFilepath, String outputFilePath, ProgramPart part, List<Line> comparsionLines) 
	{
		System.out.print("Creating a file: " + outputFilePath);
		Line.printArray("Lines to save", comparsionLines); 
		File outputFile = new File(outputFilePath);
		File currentVersionFile = new File(currentVersionFilepath);
		try 
		{
			outputFile.getParentFile().mkdir();			
			outputFile.createNewFile();
			FileWriter fileWriter= new FileWriter(outputFile.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			FileReader fileReader = new FileReader(currentVersionFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			bufferedWriter.write(part.toString());
			
			int location = 0;
			int comparsionLineIndex = 0;
			String line = bufferedReader.readLine();
			
			while(line!=null)
			{
				Line tempLine = null;
				if (comparsionLineIndex < comparsionLines.size())
					tempLine = comparsionLines.get(comparsionLineIndex);
							
				while (tempLine != null && tempLine.getLocation() == location)
				{
					bufferedWriter.write(FileManager.getStringWithTabs(FileManager.getTabsAtLine(line)) + tempLine.toLineLabel() + "\n");
						
					comparsionLineIndex++;
					if (comparsionLineIndex < comparsionLines.size())
					{
						tempLine = comparsionLines.get(comparsionLineIndex);
					}
					else
					{
						tempLine = null;
					}
				}
				
				bufferedWriter.write(line + "\n");
				line = bufferedReader.readLine();			
				location++;
			}
			
			bufferedReader.close();
			fileReader.close();
			
			bufferedWriter.close();
			fileWriter.close();			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param line
	 * @return
	 */
	private static int getTabsAtLine(String line)
	{
		int index = 0;
		
		while (index < line.length() && line.charAt(index) == '\t')
		{
			index++;
		}
		
		return index;
	}

	/**
	 * 
	 * @param numberOfTabs
	 * @return
	 */
	private static String getStringWithTabs(int numberOfTabs)
	{
		String tabs = "";
		int added = 0;
		
		while (added < numberOfTabs)
		{
			tabs += "\t";
			added++;
		}
		
		return tabs;
	}

	/**
	 * Prints the change log ont he header
	 * @param pathHeaderNewProgram
	 * @param string
	 */
	public static void printChangeLogOnHeader(String pathHeaderNewProgram, String changeLabel) 
	{
		List<String> fileLines = readFile(pathHeaderNewProgram);
		
		File outputFile = new File(pathHeaderNewProgram);
		
		try 
		{
			FileWriter fileWriter= new FileWriter(outputFile.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(changeLabel.toString());
			
			for (String line:fileLines)
			{
				bufferedWriter.write(line + "\n");
			}
			
			bufferedWriter.close();
			fileWriter.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
