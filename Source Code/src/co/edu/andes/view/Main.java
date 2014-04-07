package co.edu.andes.view;
import info.clearthought.layout.TableLayout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import co.edu.andes.businessRules.PartComparator;
import co.edu.andes.entities.ChangeLabel;
import co.edu.andes.entities.Line;
import co.edu.andes.entities.ProgramPart;
import co.edu.andes.facade.ProgramComparatorFacade;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Main extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblCurrentProy;
	private JLabel lblOldProy;
	private JLabel lblNewProy;
	private JTextField pathOldProy;
	private JButton btnCompare;
	private JTextField pathNewProy;
	private JTextField pathCurrentProy;
	private JButton btnChooseOldProy;
	private JButton btnChooseNewProy;
	private JButton btnChooseCurrentProy;

	private String pathOld;
	private String pathNew;
	private String pathCurrent;
	private JFileChooser fileChooser;
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main inst = new Main();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Main() {
		super();
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("data/input"));
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		initGUI();
		//testMethod();
	}

	//TODO delete this after test
	public void testMethod() 
	{
		PartComparator partComparator = new PartComparator();
		
		ArrayList<Line> oldPart = new ArrayList<Line>();
		oldPart.add(new Line("Ejemplo 1", 1));
		oldPart.add(new Line("Ejemplo 2", 2));
		oldPart.add(new Line("Ejemplo 3", 3));
		oldPart.add(new Line("Ejemplo 4", 4));
		oldPart.add(new Line("Ejemplo 5", 5));
		oldPart.add(new Line("Ejemplo 6", 6));
		oldPart.add(new Line("Ejemplo 7", 7));
		oldPart.add(new Line("Ejemplo 8", 8));
		oldPart.add(new Line("Ejemplo 9", 9));
		oldPart.add(new Line("Ejemplo 10", 10));
		oldPart.add(new Line("Ejemplo 11", 11));
		oldPart.add(new Line("Ejemplo 12", 12));
						
		ArrayList<Line> newPart = new ArrayList<Line>();
		newPart.add(new Line("Ejemplo 1", 1));
		newPart.add(new Line("Ejemplo 2", 2));
		newPart.add(new Line("Ejemplo 13", 3));
		newPart.add(new Line("Ejemplo 4", 4));
		newPart.add(new Line("Ejemplo 5", 5));
		newPart.add(new Line("Ejemplo 6", 6));
		newPart.add(new Line("Ejemplo 14", 7));
		newPart.add(new Line("Ejemplo 8", 8));
		newPart.add(new Line("Ejemplo 9", 9));
		newPart.add(new Line("Ejemplo 10", 10));
		newPart.add(new Line("Ejemplo 15", 11));
		newPart.add(new Line("Ejemplo 12", 12));
		newPart.add(new Line("Ejemplo 12", 13));
		newPart.add(new Line("Ejemplo 12", 14));
		newPart.add(new Line("Ejemplo 12", 15));
				
		ProgramPart partSummary = new ProgramPart();
		
		ArrayList<String> partWithChanges = new ArrayList<String>();
		
		partComparator.compareParts(oldPart, newPart, partSummary, partWithChanges);
		
		System.out.println(partSummary);
		//System.out.println(partWithChanges);
		Line.printArray("oldPart", oldPart);
		Line.printArray("newPart", newPart);
	}

	private void initGUI() {
		try {
			TableLayout thisLayout = new TableLayout(new double[][] {{104.0, TableLayout.FILL, TableLayout.FILL}, {30.0, 31.0, 33.0, 57.0, TableLayout.FILL}});
			thisLayout.setHGap(5);
			thisLayout.setVGap(5);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			lblCurrentProy = new JLabel();
			getContentPane().add(lblCurrentProy, "0, 1");
			lblCurrentProy.setText("Proyecto actual");

			lblOldProy = new JLabel();
			getContentPane().add(lblOldProy, "0, 0");
			lblOldProy.setText("Proyecto anterior");

			btnChooseCurrentProy = new JButton();
			getContentPane().add(btnChooseCurrentProy, "2, 1");
			btnChooseCurrentProy.setText("buscar");
			btnChooseCurrentProy.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnChooseCurrentProyMouseClicked(evt);
				}
			});

			btnChooseNewProy = new JButton();
			getContentPane().add(btnChooseNewProy, "2, 2");
			btnChooseNewProy.setText("Buscar");
			btnChooseNewProy.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnChooseNewProyMouseClicked(evt);
				}
			});

			lblNewProy = new JLabel();
			getContentPane().add(lblNewProy, "0, 2");
			lblNewProy.setText("Proyecto nuevo");

			btnChooseOldProy = new JButton();
			getContentPane().add(btnChooseOldProy, "2, 0");
			btnChooseOldProy.setText("Buscar");
			btnChooseOldProy.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnChooseOldProyMouseClicked(evt);
				}
			});


			pathCurrentProy = new JTextField();
			getContentPane().add(pathCurrentProy, "1, 1");

			pathNewProy = new JTextField();
			getContentPane().add(pathNewProy, "1, 2");
			{
				btnCompare = new JButton();
				getContentPane().add(btnCompare, "0, 3");
				btnCompare.setText("Comparar");
				btnCompare.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						btnCompareMouseClicked(evt);
					}
				});
			}
			{
				pathOldProy = new JTextField();
				getContentPane().add(pathOldProy, "1, 0");
			}

			pack();
			this.setSize(547, 305);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

	private void btnChooseOldProyMouseClicked(MouseEvent evt) {
		fileChooser.setCurrentDirectory(new File("data/input"));
		int option = fileChooser.showOpenDialog(this);
		if(option == JFileChooser.APPROVE_OPTION)
		{
			pathOld = fileChooser.getSelectedFile().getPath();
			pathOldProy.setText(pathOld);
		}
	}
	
	private void btnChooseCurrentProyMouseClicked(MouseEvent evt) {
		fileChooser.setCurrentDirectory(new File("data/input"));
		int option = fileChooser.showOpenDialog(this);
		if(option == JFileChooser.APPROVE_OPTION)
		{
			pathCurrent = fileChooser.getSelectedFile().getPath();
			pathCurrentProy.setText(pathCurrent);
		}
	}
	
	private void btnChooseNewProyMouseClicked(MouseEvent evt) {
		fileChooser.setCurrentDirectory(new File("data/output"));
		int option = fileChooser.showOpenDialog(this);
		if(option == JFileChooser.APPROVE_OPTION)
		{
			pathNew = fileChooser.getSelectedFile().getPath();
			pathNewProy.setText(pathNew);
		}
	}
	
	private void btnCompareMouseClicked(MouseEvent evt) {
		ProgramComparatorFacade facade;
		ChangeLabel label;
		List<ProgramPart> parts;
		if(pathCurrent.length()>0 && pathNew.length()>0 && pathOld.length()>0){
			facade = new  ProgramComparatorFacade();
			label = new ChangeLabel();
			parts = new LinkedList<ProgramPart>();
			facade.comparePrograms(pathCurrent, pathOld, pathNew, label, parts, "Java");
			
		}
	}

}
