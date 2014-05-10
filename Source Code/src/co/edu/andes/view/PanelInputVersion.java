package co.edu.andes.view;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de inserción acerca de la versión del aplicativo.
 * @author Enterprise Gear Set
 *
 */
public class PanelInputVersion extends JPanel 
{
	private static final long serialVersionUID = 1L;
	
	private PanelInputDirectoryPath currentVersionDirectoryFinder;
	private PanelInputDirectoryPath currentVersionHeaderFileFinder;
	
	private PanelInputDirectoryPath lastVersionDirectoryFinder;
	
	public PanelInputVersion()
	{
		TitledBorder titledBorder = BorderFactory.createTitledBorder("Datos de las versiones");
		setBorder(titledBorder);
		
		setLayout(new GridLayout(3,1));
		
		currentVersionDirectoryFinder = new PanelInputDirectoryPath("Version actual: ", "./data/input", true);
		add(currentVersionDirectoryFinder);
		
		currentVersionHeaderFileFinder = new PanelInputDirectoryPath("Header del programa: ", "./data/input", false);
		add(currentVersionHeaderFileFinder);
		
		lastVersionDirectoryFinder = new PanelInputDirectoryPath("Version anterior: ", "./data/input", true);
		add(lastVersionDirectoryFinder);
	}
	
	/**
	 * Obtiene el directorio de la version actual seleccionado por el usuario
	 * @return el path del directorio, null si no se ha seleccionado o se ha seleccionado uno incorrecto
	 */
	public String getCurrentVersionPath()
	{
		return getFileFromFinder(currentVersionDirectoryFinder);
	}
	
	/**
	 * Obtiene el archivo contenedor del punto de entrada de la version actual seleccionado por el usuario
	 * @return el path del directorio, null si no se ha seleccionado o se ha seleccionado uno incorrecto
	 */
	public String getCurrentVersionHeaderPath()
	{
		return getFileFromFinder(currentVersionHeaderFileFinder);
	}
	
	/**
	 * Obtiene el directorio de la version anterior seleccionado por el usuario
	 * @return el path del directorio, null si no se ha seleccionado o se ha seleccionado uno incorrecto
	 */
	public String getLastVersionPath()
	{
		return getFileFromFinder(lastVersionDirectoryFinder);
	}
	
	/**
	 * Obtiene el archivo seleccionado de un buscador de archivos
	 * @param finder el buscador de archivos
	 * @return el nombre del archivo, si se ha seleccionado uno y este existe, null de lo contrario
	 */
	private String getFileFromFinder(PanelInputDirectoryPath finder)
	{
		String filePath = null;
		File selectedFile = finder.getSelectedFile();
		
		if (selectedFile != null && selectedFile.exists())
		{
			filePath = selectedFile.getAbsolutePath();
		}
		
		return filePath;
	}
}
