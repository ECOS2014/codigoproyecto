package co.edu.andes.businessRules;

import co.edu.andes.tools.LanguageType;

public class FactoryLOCCounter 
{
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
