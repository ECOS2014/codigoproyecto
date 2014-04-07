package co.edu.andes.entities;

import java.util.ArrayList;
import java.util.Hashtable;

public class Program 
{
	private ArrayList<String> partNames;
	private Hashtable<String, String> partPaths;
	
	public Program()
	{
		partNames = new ArrayList<String>();
		partPaths = new Hashtable<String, String>();
	}
	
	/**
	 * Agrega una nueva parte al programa
	 * @param partName nombre de la parte
	 * @param partFilePath file path del archivo fuente de la parte
	 */
	public void addPart(String partName, String partFilePath)
	{
		partNames.add(partName);
		partPaths.put(partName, partFilePath);
	}
	
	/**
	 * Busca el file path de una clase, por su nombre
	 * @param partName nombre de la clase
	 * @return el file path, o null si la clase no pertenece al programa
	 */
	public String getFilePathOf(String partName)
	{
		return partPaths.get(partName);
	}
	
	/**
	 * Obtiene el nombre de una parte, dado el indice
	 * @param index
	 * @return el nombre de la parte, o null si el indice esta desfazado
	 */
	public String getPartNameAt(int index)
	{
		if (index >= 0 && index < partNames.size())
		{
			return partNames.get(index);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Entrega el numero de partes que componen el programa
	 * @return el numero de clases que componen el programa
	 */
	public int partsCount()
	{
		return partNames.size();
	}
}
