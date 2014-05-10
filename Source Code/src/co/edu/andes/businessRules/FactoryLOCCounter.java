package co.edu.andes.businessRules;

import co.edu.andes.entities.LanguageType;

/**
 * Factory to count LOC, evaluate de language 
 * @author EnterpriseGearSet
 *
 */
public class FactoryLOCCounter 
{
	/**
	 * Valida la instancia del locCounter
	 * @param languajeType
	 * @return LOCCounter
	 */
	public static LOCCounter createCounterLOC(LanguageType languajeType)
	{
		LOCCounter locCounter = null;
		switch (languajeType)
		{
			case Java:
				locCounter = new JavaLOCCounter();
				break;
		}
		return locCounter;
	}
}
