package co.edu.andes.facade;

import java.util.List;

import co.edu.andes.businessRules.ProgramComparator;
import co.edu.andes.entities.ChangeLabel;
import co.edu.andes.entities.ProgramPart;
import co.edu.andes.view.Main;

public class ProgramComparatorFacade 
{
	public void comparePrograms(String pathCurrentProgram, String pathOldProgram, String pathNewProgram,  ChangeLabel changeLabel, List<ProgramPart>parts, String language,Main mainClass)
	{
		ProgramComparator comparator;
		comparator = new ProgramComparator();
		comparator.comparePrograms(pathOldProgram, pathCurrentProgram, pathNewProgram, changeLabel, parts, language);
	    //mainClass.addResult(comparator.globalPartSumary);
	}
	
}
