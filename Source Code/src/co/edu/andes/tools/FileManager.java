package co.edu.andes.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import co.edu.andes.entities.ProgramPart;

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
	public static void saveFile(String filePath, ProgramPart part) 
	{
		System.out.print("Creating a file: " + filePath);
		
		File newFile = new File(filePath);
		try 
		{
			newFile.getParentFile().mkdir();			
			newFile.createNewFile();
			FileWriter fileWriter= new FileWriter(newFile.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(part.toString());
			
			bufferedWriter.close();
			fileWriter.close();			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
