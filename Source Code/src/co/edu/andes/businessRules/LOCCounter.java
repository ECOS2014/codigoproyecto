package co.edu.andes.businessRules;

import java.util.List;

import co.edu.andes.entities.LanguageType;
import co.edu.andes.entities.Line;

/**
 * Abstract class LOC Counter
 * @author Enterprise Gear Set
 *
 */
public abstract class LOCCounter 
{
	public abstract List<Line> getLogicLines(List<String> lines);
	public abstract LanguageType getLanguaje();
}
