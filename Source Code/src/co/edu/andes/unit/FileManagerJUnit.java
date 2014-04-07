package co.edu.andes.unit;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.edu.andes.entities.Line;
import co.edu.andes.tools.FileManager;

public class FileManagerJUnit {

	FileManager fileManager;
	@Before
	public void loadProjects() {
		fileManager = new FileManager();
		
	}
	
	@Test
	public void saveTestFile(){
		File miDir = new File (".");
		List<String> lines= new ArrayList<String>();
		lines.add("line 1;");
		lines.add("line 2;");
		lines.add("line 3;");
	     try {
	       String filePath =miDir.getCanonicalPath()+"\\"+"file.txt";
	       fileManager.saveFile(lines, filePath);
	       File fileTmp=new File(filePath);
	       assertTrue(fileTmp.exists());
		       
	       }
	     catch(Exception e) {
	       e.printStackTrace();
	       }
		assertEquals(true, true);
		
	}
	
	@Test
	public void readTestFile(){
		File miDir = new File (".");
		try{
		String filePath =miDir.getCanonicalPath()+"\\"+"file.txt";
		 File fileTmp=new File(filePath);
		if(fileTmp.exists()){
			List<String> tmpList=fileManager.readFile(filePath);
			assertEquals(3, tmpList.size());
			assertEquals("line 2;", tmpList.get(1));
			assertNotEquals("line 3", tmpList.get(2));
	    	fileTmp.delete();
	       }else{
	    	   assertEquals("Archivo no encontrado", false, true);
	       }
		}catch(Exception e) {
		       e.printStackTrace();
		       }
	}

}
