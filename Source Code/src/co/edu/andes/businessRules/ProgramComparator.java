package co.edu.andes.businessRules;

import java.util.ArrayList;
import java.util.List;

import co.edu.andes.entities.ChangeLabel;
import co.edu.andes.entities.LanguageType;
import co.edu.andes.entities.Line;
import co.edu.andes.entities.ProgramPart;
import co.edu.andes.tools.FileManager;

public class ProgramComparator 
{
	private PartComparator partComparator;
	private LOCCounter locCounter;
	public ProgramPart globalPartSumary;
		


	public ProgramComparator() {
		partComparator = new PartComparator();

	}
	/**
	 * Compara dos programas y crea un tercero
	 * @param pathOldProgram
	 * @param pathNewProgram
	 * @param pathResultProgram
	 * @param changeLabel
	 * @param parts
	 * @param language
	 */
	public void comparePrograms(String pathOldProgram, String pathNewProgram, String pathResultProgram, ChangeLabel changeLabel, List<ProgramPart> parts, String language)
	{
		locCounter = FactoryLOCCounter.createCounterLOC(getTypeLanguage(language));
		List<String> newFile;
		ProgramPart part;
		newFile = new ArrayList<String>();
		part = new  ProgramPart();
		this.compareFiles(pathOldProgram, pathNewProgram, newFile, part);
		
		System.out.print(part.toString());
		this.saveFile(newFile, pathResultProgram);
		globalPartSumary = part;
	}

	/**obtiene las lineas de un archivo
	 * @param pathFile
	 * @return
	 */


	/**
	 * Compara dos archvivos
	 * @param pathOldFile
	 * @param pathNewFile
	 * @param partWithChanges
	 * @param part
	 */
	private void compareFiles(String pathOldFile, String pathNewFile, List<String> partWithChanges, ProgramPart part)
	{
		List<Line> linesOld;
		List<Line> linesNew;
		linesOld = locCounter.getLogicLines(FileManager.readFile(pathOldFile)); 
		linesNew = locCounter.getLogicLines(FileManager.readFile(pathNewFile));
		partComparator.compareParts(linesOld, linesNew, part, partWithChanges);
	}

	/**
	 * Guarda un archivo
	 * @param part
	 * @param path
	 */
	private void saveFile(List<String> part, String path)
	{
		FileManager.saveFile(part, path);
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
