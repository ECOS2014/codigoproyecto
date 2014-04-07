package co.edu.andes.view;
import info.clearthought.layout.TableLayout;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import co.edu.andes.entities.ChangeLabel;
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
	private JLabel lblCurrentProy;
	private JLabel lblOldProy;
	private JLabel lblNewProy;
	private JLabel lblName;
	private JLabel lblDate;
	private JTextField pathOldProy;
	private JButton btnCompare;
	private JTextField pathNewProy;
	private JTextField pathCurrentProy;
	private JTextField nameUser;
	private JButton btnChooseOldProy;
	private JButton btnChooseNewProy;
	private JButton btnChooseCurrentProy;
	private JDatePickerImpl widgetDate;

	private String pathOld;
	private String pathNew;
	private String pathCurrent;
	private String userName;
	private Date dateObject;
	private JFileChooser fileChooser;
	public static void main(String[] args) {
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
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		initGUI();
	}

	private void initGUI() {
		try {
			
		    TableLayout thisLayout = new TableLayout(new double[][] {{304.0, TableLayout.FILL, TableLayout.FILL}, {30.0, 31.0, 33.0, 57.0,57.0,70,57.0,70,57.0,70,57.0,70,57.0,70,57.0,70,57.0,70, TableLayout.FILL}});
			thisLayout.setHGap(10);
			thisLayout.setVGap(10);
			getContentPane().setLayout(thisLayout);
			//getContentPane().setLayout(new FlowLayout());
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
			lblName = new JLabel();
			getContentPane().add(lblName, "0, 0");
			lblName.setText("Nombre de autor");
			
			lblDate = new JLabel();
			getContentPane().add(lblDate, "1, 0");
			lblDate.setText("Fecha");
			
			nameUser = new JTextField();
			getContentPane().add(nameUser, "0, 1");

			UtilDateModel model = new UtilDateModel();
			JDatePanelImpl datePanel = new JDatePanelImpl(model);
			widgetDate = new JDatePickerImpl(datePanel);
			 
			getContentPane().add(widgetDate,"1,1");
			
			lblOldProy = new JLabel();
			getContentPane().add(lblOldProy, "0, 2");
			lblOldProy.setText("Ruta version anterior");
			
			pathOldProy = new JTextField();
			getContentPane().add(pathOldProy, "0, 3");

			
			btnChooseOldProy = new JButton();
			getContentPane().add(btnChooseOldProy, "1, 3");
			btnChooseOldProy.setText("Buscar");
			btnChooseOldProy.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnChooseOldProyMouseClicked(evt);
				}
			});


			lblCurrentProy = new JLabel();
			getContentPane().add(lblCurrentProy, "0, 4");
			lblCurrentProy.setText("Proyecto actual");
			
			pathCurrentProy = new JTextField();
			getContentPane().add(pathCurrentProy, "0, 5");

			btnChooseCurrentProy = new JButton();
			getContentPane().add(btnChooseCurrentProy, "1, 5");
			btnChooseCurrentProy.setText("buscar");
			btnChooseCurrentProy.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnChooseCurrentProyMouseClicked(evt);
				}
			});
			
			lblNewProy = new JLabel();
			getContentPane().add(lblNewProy, "0, 6");
			lblNewProy.setText("Proyecto nuevo");

			pathNewProy = new JTextField();
			getContentPane().add(pathNewProy, "0, 7");

			btnChooseNewProy = new JButton();
			getContentPane().add(btnChooseNewProy, "1, 7");
			btnChooseNewProy.setText("Buscar");
			btnChooseNewProy.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					btnChooseNewProyMouseClicked(evt);
				}
			});

				btnCompare = new JButton();
				getContentPane().add(btnCompare, "0, 8");
				btnCompare.setText("Comparar");
				btnCompare.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						btnCompareMouseClicked(evt);
					}
				});

			pack();
			this.setSize(547, 705);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

	private void btnChooseOldProyMouseClicked(MouseEvent evt) {
		int option = fileChooser.showOpenDialog(this);
		if(option == JFileChooser.APPROVE_OPTION)
		{
			pathOld = fileChooser.getSelectedFile().getPath();
			pathOldProy.setText(pathOld);
		}
	}
	
	private void btnChooseCurrentProyMouseClicked(MouseEvent evt) {
		int option = fileChooser.showOpenDialog(this);
		if(option == JFileChooser.APPROVE_OPTION)
		{
			pathCurrent = fileChooser.getSelectedFile().getPath();
			pathCurrentProy.setText(pathCurrent);
		}
	}
	
	private void btnChooseNewProyMouseClicked(MouseEvent evt) {
		int option = fileChooser.showOpenDialog(this);
		if(option == JFileChooser.APPROVE_OPTION)
		{
			pathNew = fileChooser.getSelectedFile().getPath();
			pathNewProy.setText(pathNew);
		}
	}
	
	private void btnCompareMouseClicked(MouseEvent evt) {
		String msj="";
		ProgramComparatorFacade facade;
		ChangeLabel label;
		List<ProgramPart> parts;
		try{
			boolean proccesForm=true;
		if(nameUser.getText()==null || nameUser.getText().equals("")){
			msj="- Ingrese nombre de Usuario.\n";
			proccesForm = false;
		}else{
			userName=nameUser.getText();
		}
		
		dateObject= (Date) widgetDate.getModel().getValue();
		if(dateObject==null){
			msj=msj+"- Ingrese nombre de Usuario.\n";
			proccesForm = false;
		}
		
		if(pathCurrent==null || pathNew==null || pathOld==null){
			msj=msj+"- Debe seleccionar las 3 rutas.\n";
			proccesForm = false;
		}
		
		if(proccesForm){
			label = new ChangeLabel();
			parts = new LinkedList<ProgramPart>();
			facade = new  ProgramComparatorFacade();
			if(pathCurrent.length()>0 && pathNew.length()>0 && pathOld.length()>0){				
			   facade.comparePrograms(pathCurrent, pathOld, pathNew, label, parts, "Java",this);	
			   
			}
		}else{
			JOptionPane.showMessageDialog(null,msj, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
		}
	}
	
	public void addResult(ProgramPart programPart){
		JOptionPane.showMessageDialog(null, "Total LOC:"+programPart.getTotalLOC()+
											"\nTotal agregadas: "+programPart.getTotalLOCAdded()+
											"\nTotal eliminadas: "+programPart.getTotalLOCDeleted(), "Error", JOptionPane.INFORMATION_MESSAGE);
	}

}
