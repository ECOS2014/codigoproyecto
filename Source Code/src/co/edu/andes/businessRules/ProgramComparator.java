package co.edu.andes.businessRules;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import co.edu.andes.entities.ChangeLabel;
import co.edu.andes.entities.LanguageType;
import co.edu.andes.entities.Line;
import co.edu.andes.entities.Program;
import co.edu.andes.entities.ProgramPart;
import co.edu.andes.tools.FileManager;

public class ProgramComparator 
{
	private PartComparator partComparator;
	private LOCCounter locCounter; 

	private Program currentVersion;
	private Program lastVersion;
	//TODO: use or remove
	public ProgramPart globalPartSumary;

	public ProgramComparator() 
	{
		partComparator = new PartComparator();
		
		currentVersion = new Program();
		lastVersion =  new Program();
	}
	/**
	 * Compara dos programas y crea un tercero
	 * @param pathOldProgram
	 * @param pathNewProgram
	 * @param pathResultProgram
	 * @param outChangeLabel
	 * @param parts
	 * @param language
	 */
	public void comparePrograms(String pathOldProgram, String pathNewProgram, String pathHeaderNewProgram, String pathResultProgram, ChangeLabel outChangeLabel, List<ProgramPart> parts, String language)
	{
		locCounter = FactoryLOCCounter.createCounterLOC(getTypeLanguage(language));
				
		File currentVersionDirectory = new File(pathNewProgram); 
		GetClassFilesFromDir(currentVersion, currentVersionDirectory, currentVersionDirectory.getAbsolutePath());
		
		File lastVersionDirectory  = new File(pathOldProgram);
		GetClassFilesFromDir(lastVersion, lastVersionDirectory, lastVersionDirectory.getAbsolutePath());
		
		compareNewAndModifiedParts(pathResultProgram, outChangeLabel);
		compareDeletedParts(outChangeLabel);
		
		
		String programHeaderOutputPath = pathResultProgram + pathHeaderNewProgram.substring(pathNewProgram.length());
		System.out.println(programHeaderOutputPath);
		//FileManager.printChangeLogOnHeader(programHeaderOutputPath, outChangeLabel.toString());
	}
	
	/**
	 * Compara el proyecto nuevo vs la version antigua en busca de las clases nuevas y las clases modificadas.
	 * @param outputProgramDirectory ruta del directorio de salida donde se debe generar la copia del proyecto con los headers.
	 */
	private void compareNewAndModifiedParts(String outputProgramDirectory, ChangeLabel outChangeLabel) 
	{
		int m = currentVersion.partsCount();
		
		for (int i=0; i<m; i++)
		{
			String currentVersionName = currentVersion.getPartNameAt(i);
			System.out.println(currentVersionName);
			String currentVersionFilePtah = currentVersion.getFilePathOf(currentVersionName);
			String lastVersionFilePtah = lastVersion.getFilePathOf(currentVersionName);
			
			List<Line> partWithChanges = new ArrayList<Line>();
			ProgramPart part = new ProgramPart();
			part.setChangeAuthor(outChangeLabel.getChangeAuthor());
			part.setChangeNumber(outChangeLabel.getChangeNumber());
			part.setChangeDescription(outChangeLabel.getChangeDescription());
			
			compareFiles(lastVersionFilePtah, currentVersionFilePtah, partWithChanges, part);
			
			System.out.println(part.toString());
			
			saveFile(currentVersionFilePtah, outputProgramDirectory + currentVersionName, part, partWithChanges);
			outChangeLabel.addPart(part);
		}
	}
	
	private void compareDeletedParts(ChangeLabel outChangeLabel) 
	{
		int m = lastVersion.partsCount();
		
		for (int i=0; i<m; i++)
		{
			String lastVersionPartName = lastVersion.getPartNameAt(i);
			String currentVersionFilePath = currentVersion.getFilePathOf(lastVersionPartName);
			if (currentVersionFilePath == null)
			{
				String lastVersionFilePath = lastVersion.getFilePathOf(lastVersionPartName);
				
				List<Line> partWithChanges = new ArrayList<Line>();
				ProgramPart part = new ProgramPart();
				part.setChangeAuthor(outChangeLabel.getChangeAuthor());
				part.setChangeNumber(outChangeLabel.getChangeNumber());
				part.setChangeDescription(outChangeLabel.getChangeDescription());
				
				compareFiles(lastVersionFilePath, currentVersionFilePath, partWithChanges, part);
				
				System.out.println(part.toString());
				
				outChangeLabel.addPart(part);
			}
		}
	}
	
	/**
	 * Guarda el archivo de salida con el resultado de las comparaciones.
	 * @param currentVersionFilePath
	 * @param outputFilePath
	 * @param part
	 * @param comparsionLines
	 */
	private void saveFile(String currentVersionFilePath, String outputFilePath, ProgramPart part, List<Line> comparsionLines) 
	{
		FileManager.saveFile(currentVersionFilePath, outputFilePath, part, comparsionLines);
	}
	
	/**
	 * Recorre recursivamente el directorio del codigo fuente en busca de las clases.
	 * @param program clase contenedora de los archivos de la clase
	 * @param candidateFile directorio a explorar o archivo a agregar en cada recursion
	 */
	private void GetClassFilesFromDir(Program program, File candidateFile, String directoryRoot)
	{
		if (!candidateFile.isDirectory())
		{
			String fileName = candidateFile.getName();
			if(fileName.endsWith(getFileSufix()))
			{
				//System.out.println(" - " + fileName + " added");
				//System.out.println(" - Absolute path: " + candidateFile.getAbsolutePath());
				String relativePath = candidateFile.getPath().substring(directoryRoot.length());
				System.out.println(" - Path: " + relativePath);
				program.addPart(relativePath, candidateFile.getAbsolutePath());
			}
		}
		else
		{
			File[] dirFiles = candidateFile.listFiles();
			int m = dirFiles.length;
			
			for (int i = 0; i < m; i++)
			{
				GetClassFilesFromDir(program, dirFiles[i], directoryRoot);
			}
		}
	}

	private String getFileSufix() 
	{
		String fileSufix = "";
		
		switch (locCounter.getLanguaje())
		{
			case Java:
				fileSufix = ".java";
				break;
		}
		
		return fileSufix;
	}
	
	/**
	 * Compara dos archvivos
	 * @param pathOldFile
	 * @param pathNewFile
	 * @param partWithChanges
	 * @param part
	 */
	private void compareFiles(String pathOldFile, String pathNewFile, List<Line> partWithChanges, ProgramPart part)
	{
		List<Line> linesOld = locCounter.getLogicLines(FileManager.readFile(pathOldFile));
		List<Line> linesNew = locCounter.getLogicLines(FileManager.readFile(pathNewFile));
		
		partComparator.compareParts(linesOld, linesNew, part, partWithChanges);
	}

	/**
	 * Obtiene el tipo de lenguaje que se va comparar
	 * @param language
	 * @return
	 */
	private LanguageType getTypeLanguage(String language){
		//if(language.equals("Java"))
		return LanguageType.Java;

	}
}
