package co.edu.andes.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.andes.entities.ChangeLabel;
import co.edu.andes.entities.LanguageType;
import co.edu.andes.entities.ProgramPart;
import co.edu.andes.facade.ProgramComparatorFacade;

/**
 * Panel principal de GUI para el programa
 * @author Enterprise Gear Set
 *
 */
public class ProgramComparatorGUI extends JFrame 
{
	private static final long serialVersionUID = 1L;

	private PanelChangeData panelChangeData;
	private PanelInputVersion panelInputVersion;
	private PanelOutput panelOutput;
	
	public ProgramComparatorGUI()
	{
		setLayout(new BorderLayout());
		setSize(new Dimension(500, 500));
		
		panelChangeData = new PanelChangeData();
		panelInputVersion = new PanelInputVersion();
		panelOutput = new PanelOutput(this);
		
		add(panelChangeData, BorderLayout.NORTH);
		add(panelInputVersion, BorderLayout.CENTER);
		add(panelOutput, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) 
	{
		ProgramComparatorGUI programComparatorGUI = new ProgramComparatorGUI();
		programComparatorGUI.setVisible(true);
		programComparatorGUI.setResizable(false);
	}

	public void comparePrograms() 
	{
		String authorName = panelChangeData.getAuthorName();
		String changeNumber = panelChangeData.getChangeNumber();
		String changeDescription = panelChangeData.getChangeDescription();
		String currentVersionDirectoryPath = panelInputVersion.getCurrentVersionPath();
		String currentVersionHeader = panelInputVersion.getCurrentVersionHeaderPath();
		String lastVersionDirectoryPath = panelInputVersion.getLastVersionPath();
		String outputVersionDirectoryPath = panelOutput.getOutputDirectory();
		
		
		if(canComparePrograms(authorName, "Nombre de autor invalido") && 
			canCompareProgramsNumberInput(changeNumber, "Numero invalido") && 
			canComparePrograms(changeDescription, "Descripción de cambio invalida") && 
			canComparePrograms(currentVersionDirectoryPath, "Ruta del directorio actual invalida") && 
			canComparePrograms(currentVersionHeader, "Ruta del header actual invalida") && 
			canComparePrograms(lastVersionDirectoryPath, "Ruta del directorio anterior invalida"))
		{
			ChangeLabel outChangeLabel = new ChangeLabel(authorName, changeNumber, changeDescription);
			List<ProgramPart> outParts = new ArrayList<ProgramPart>();
			ProgramComparatorFacade.comparePrograms(currentVersionDirectoryPath, currentVersionHeader, lastVersionDirectoryPath, outputVersionDirectoryPath, outChangeLabel, outParts, LanguageType.Java.name());
			panelOutput.setChangeLabel(outChangeLabel.toString());
		}		
	}

	/**
	 * 
	 * @param changeNumber
	 * @param errorMessage
	 * @return
	 */
	private boolean canCompareProgramsNumberInput(String strNumber, String errorMessage) 
	{
		if (isValidInput(strNumber) && isValidNumberInput(strNumber))
		{
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(this, errorMessage, "Dato de entrada incorrecto", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	/**
	 * 
	 * @param input
	 * @param errorMessage
	 * @return
	 */
	private boolean canComparePrograms(String input, String errorMessage)
	{
		if (isValidInput(input))
		{
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(this, errorMessage, "Dato de entrada incorrecto", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}
	
	/**
	 * Define si es una entrada de usuario valida
	 * @param input
	 * @return
	 */
	private boolean isValidInput(String input) 
	{
		boolean isValid = false;
		if (input != null && !input.equals(""))
		{
			isValid = true;
		}
		return isValid;
	}
	
	/**
	 * Define si es una entrada numerica valida
	 * @param strNumber
	 * @return
	 */
	private boolean isValidNumberInput(String strNumber) 
	{
		try
		{
			Integer.parseInt(strNumber);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
		
	}
}
