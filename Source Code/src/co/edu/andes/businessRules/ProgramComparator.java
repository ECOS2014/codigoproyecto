package co.edu.andes.businessRules;

import java.util.List;

import co.edu.andes.entities.ChangeLabel;
import co.edu.andes.entities.ProgramPart;

public class ProgramComparator 
{
	private PartComparator partComparator;
	private LOCCounter locCounter; 
	
	public void comparePrograms(String pathOldProgram, String pathNewProgram, String pathResultProgram, ChangeLabel changeLabel, List<ProgramPart> parts, String language)
	{
		
	}

	private void compareFiles(String pathOldFile, String pathNewFile, List<String> partWithChanges, ProgramPart part)
	{
		
	}
	
	private void saveFile(List<String> part, String path)
	{
		
	}
	
}
