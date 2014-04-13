package co.edu.andes.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

public class PanelOutput extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private PanelInputDirectoryPath outputDirectoryPath;
	private JButton btnCompare;
	private JLabel labelResultado;
	private JTextArea txtAChangeLabel;
	
	private ProgramComparatorGUI parent;
	
	public PanelOutput(ProgramComparatorGUI parent)
	{
		this.parent = parent;
		TitledBorder titledBorder = BorderFactory.createTitledBorder("Resultado");
		setBorder(titledBorder);
		setPreferredSize(new Dimension(500, 200));
		setLayout(new BorderLayout());
		
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new BorderLayout());
		outputDirectoryPath = new PanelInputDirectoryPath("Directorio resultado:", "./data", true);
		panelNorth.add(outputDirectoryPath, BorderLayout.NORTH);
				
		btnCompare = new JButton("Comparar versiones");
		btnCompare.addActionListener(this);
		btnCompare.setActionCommand("Comparar");
		panelNorth.add(btnCompare, BorderLayout.SOUTH);
				
		add(panelNorth, BorderLayout.NORTH);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout());
		
		labelResultado = new JLabel("Resultado:");
		panelCenter.add(labelResultado, BorderLayout.NORTH);
		
		txtAChangeLabel = new JTextArea();
		txtAChangeLabel.setEditable(false);
		JScrollPane textAreaScroll = new JScrollPane(txtAChangeLabel);
		textAreaScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textAreaScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		panelCenter.add(textAreaScroll, BorderLayout.CENTER);
		
		add(panelCenter, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String command = e.getActionCommand();
		
		if(command.equals("Comparar"))
		{
			parent.comparePrograms();
		}
	}
	
	/**
	 * Imprime en el campo de texto el change label resultado de la comparacion
	 * @param changeLabel el reporte resultado de la comparacion
	 */
	public void setChangeLabel(String changeLabel)
	{
		txtAChangeLabel.setText(changeLabel);
	}

	public String getOutputDirectory() 
	{
		return outputDirectoryPath.getSelectedFile().getAbsolutePath();
	}
}
