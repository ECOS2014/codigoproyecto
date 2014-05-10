package co.edu.andes.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

/**
 * Clase para ingresar la información del auto, chagne number y descripción
 * @author Enterprise Gear Set
 *
 */
public class PanelChangeData extends JPanel 
{
	private static final long serialVersionUID = 1L;
	
	private JLabel lblAuthorName;
	private JTextField txtAuthorName;
	
	private JLabel lblChangeNumber;
	private JTextField txtChangeNumber;
	
	private JLabel lblDescription;
	private JTextArea txtAChangeDescription;
	
	public PanelChangeData()
	{
		TitledBorder titledBorder = BorderFactory.createTitledBorder("Datos del cambio");
		setBorder(titledBorder);
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500,150));
		
		JPanel panelUserData = new JPanel();
		panelUserData.setLayout(new BorderLayout());
		
		lblAuthorName = new JLabel("Autor: ");
		panelUserData.add(lblAuthorName, BorderLayout.WEST);
		
		txtAuthorName = new JTextField();
		panelUserData.add(txtAuthorName, BorderLayout.CENTER);
		
		JPanel numberPanel = new JPanel();
		numberPanel.setLayout(new BorderLayout());
		numberPanel.setPreferredSize(new Dimension(150,30));
		
		lblChangeNumber = new JLabel("Numero cambio:");
		lblChangeNumber.setHorizontalAlignment(JLabel.RIGHT);
		numberPanel.add(lblChangeNumber, BorderLayout.CENTER);
		
		txtChangeNumber = new JTextField();
		txtChangeNumber.setPreferredSize(new Dimension(38, 30));
		numberPanel.add(txtChangeNumber, BorderLayout.EAST);
		
		panelUserData.add(numberPanel, BorderLayout.EAST);
		
		add(panelUserData, BorderLayout.NORTH);
		
		
		JPanel panelDescription = new JPanel();
		panelDescription.setLayout(new BorderLayout());
		
		lblDescription = new JLabel("Descripcion:");
		panelDescription.add(lblDescription, BorderLayout.NORTH);
		
		txtAChangeDescription = new JTextArea();
		
		JScrollPane textAreaScroll = new JScrollPane(txtAChangeDescription);
		textAreaScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		panelDescription.add(textAreaScroll, BorderLayout.CENTER);
		
		add(panelDescription, BorderLayout.CENTER); 
	}
	
	/**
	 * Devuelve el nombre del autor ingresado por usuario
	 * @return el nombre del autor ingresado por usuario
	 */
	public String getAuthorName()
	{
		return txtAuthorName.getText();
	}
	
	public String getChangeNumber()
	{
		return txtChangeNumber.getText();
	}
	
	/**
	 * Devuelve la descripcion del cambio ingresada por el usuario
	 * @return la descripcion del cambio ingresada por el usuario
	 */
	public String getChangeDescription()
	{
		return txtAChangeDescription.getText();
	}
}
