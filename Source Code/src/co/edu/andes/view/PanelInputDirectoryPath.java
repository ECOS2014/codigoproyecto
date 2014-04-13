package co.edu.andes.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInputDirectoryPath extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JLabel lblIntructions; 
	private JTextField txtFilePath; 
	private JButton btnSetFile;
	private JFileChooser fcDirectoryChooser; 
	
	private File selectedFile;
	
	/**
	 * Crea una nueva instancia del panel para seleccionar un directorio
	 * @param directoryName nombre para poner en la etiqueta
	 * @param suggestedPath directorio inicial del filechooser
	 */
	public PanelInputDirectoryPath(String directoryName, String suggestedPath, boolean directoriesOnly)
	{
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500, 30));
		
		lblIntructions = new JLabel(directoryName);
		lblIntructions.setPreferredSize(new Dimension(140, 30));
		add(lblIntructions, BorderLayout.WEST);
		
		txtFilePath = new JTextField();
		txtFilePath.setEditable(false);
		txtFilePath.setPreferredSize(new Dimension(260, 30));
		add(txtFilePath, BorderLayout.CENTER);
		
		btnSetFile = new JButton("Explorar");
		btnSetFile.setPreferredSize(new Dimension(100, 30));
		btnSetFile.setActionCommand("Explorar");
		btnSetFile.addActionListener(this);
		add(btnSetFile, BorderLayout.EAST);
		
		fcDirectoryChooser = new JFileChooser();
		
		File startDirectory = new File(suggestedPath);
		if (startDirectory.exists())
		{
			fcDirectoryChooser.setCurrentDirectory(startDirectory);
		}
		
		if (directoriesOnly)
		{
			fcDirectoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}
		else
		{
			fcDirectoryChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		}
	}
	
	/**
	 * Devuelve el directorio seleccionado
	 * @return el directorio seleccionado, null si no se ha seleccionado un archivo
	 */
	public File getSelectedFile()
	{
		return selectedFile;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String command = e.getActionCommand();
		
		if (command.equals("Explorar"))
		{
			int selectedOption = fcDirectoryChooser.showOpenDialog(this);
			if (selectedOption == JFileChooser.APPROVE_OPTION)
			{
				selectedFile = fcDirectoryChooser.getSelectedFile();
				txtFilePath.setText(selectedFile.getAbsolutePath());
			}
		}
	}
}
