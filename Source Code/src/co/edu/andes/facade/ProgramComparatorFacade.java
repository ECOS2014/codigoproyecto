package co.edu.andes.facade;

import java.util.List;

import co.edu.andes.businessRules.ProgramComparator;
import co.edu.andes.entities.ChangeLabel;
import co.edu.andes.entities.ProgramPart;

public class ProgramComparatorFacade 
{
	public static void comparePrograms(String pathCurrentProgram, String currentVersionHeader, String pathOldProgram, String pathNewProgram,  ChangeLabel changeLabel, List<ProgramPart>parts, String language)
	{
		ProgramComparator comparator;
		comparator = new ProgramComparator();
		comparator.comparePrograms(pathOldProgram, pathCurrentProgram, currentVersionHeader, pathNewProgram, changeLabel, parts, language);
	}
	
}
