package co.edu.andes.unit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.edu.andes.businessRules.FactoryLOCCounter;
import co.edu.andes.businessRules.ProgramComparator;
import co.edu.andes.businessRules.PartComparator;
import co.edu.andes.entities.Line;
import co.edu.andes.entities.ProgramPart;
import co.edu.andes.tools.FileManager;

public class ProgramComparatorJUnit {
	
	//class
	ProgramComparator programComparator;
	PartComparator partComparator;
	
	//Lists
	List<Line> oldVersion;
	List<Line> currentVersion;
	
	@Before 
	public void loadProjects(){
		partComparator = new PartComparator();
	}

	@Test
	public void testCompareParts1() {
		Line lineOldVersion1 = new Line("linea 1",0);
		Line lineOldVersion2 = new Line("linea 2",0);
		Line lineOldVersion3 = new Line("linea 3",0);
		Line lineOldVersion4 = new Line("linea 4",0);
		
		oldVersion =new ArrayList<Line>();
		oldVersion.add(lineOldVersion1);
		oldVersion.add(lineOldVersion2);
		oldVersion.add(lineOldVersion3);
		oldVersion.add(lineOldVersion4);
		
		Line lineCurrentVersion1 = new Line("linea 34",0);
		Line lineCurrentVersion2 = new Line("linea 2",0);
		Line lineCurrentVersion3 = new Line("linea 5",0);
		Line lineCurrentVersion4 = new Line("linea 4",0);
		
		currentVersion =new ArrayList<Line>();
		currentVersion.add(lineCurrentVersion1);
		currentVersion.add(lineCurrentVersion2);
		currentVersion.add(lineCurrentVersion3);
		currentVersion.add(lineCurrentVersion4);
		
		List<String> newFile;
		ProgramPart part;
		newFile = new ArrayList<String>();
		part = new  ProgramPart();
		part.setPartName("functionTest");
		//partComparator.compareParts(oldVersion, currentVersion, part, newFile);
		assertEquals(4, part.getTotalLOC());
		assertEquals(2, part.getTotalLOCAdded());
		assertEquals(2, part.getTotalLOCDeleted());
		assertEquals("functionTest", part.getPartName());
	}
	
	@Test
	public void testCompareParts2() {
		Line lineOldVersion1 = new Line("linea 1",0);
		Line lineOldVersion2 = new Line("linea 2",1);
		Line lineOldVersion3 = new Line("linea 3",2);
		Line lineOldVersion4 = new Line("linea 4",4);
		
		oldVersion =new ArrayList<Line>();
		oldVersion.add(lineOldVersion1);
		oldVersion.add(lineOldVersion2);
		oldVersion.add(lineOldVersion3);
		oldVersion.add(lineOldVersion4);
		
		Line lineCurrentVersion1 = new Line("linea 1",1);
		Line lineCurrentVersion2 = new Line("linea 3",2);
		Line lineCurrentVersion3 = new Line("linea 3",0);
		Line lineCurrentVersion4 = new Line("linea4",4);
		
		currentVersion =new ArrayList<Line>();
		currentVersion.add(lineCurrentVersion1);
		currentVersion.add(lineCurrentVersion2);
		currentVersion.add(lineCurrentVersion3);
		currentVersion.add(lineCurrentVersion4);
		
		List<String> newFile;
		ProgramPart part;
		newFile = new ArrayList<String>();
		part = new  ProgramPart();
		part.setPartName("functionTest2");
		//partComparator.compareParts(oldVersion, currentVersion, part, newFile);
		assertEquals(4, part.getTotalLOC());
		assertEquals(1, part.getTotalLOCAdded());
		assertEquals(1, part.getTotalLOCDeleted());
		assertEquals("functionTest2", part.getPartName());
	}
	
	@Test
	public void testCompareParts3() {
		Line lineOldVersion1 = new Line("linea 6",0);
		Line lineOldVersion2 = new Line("linea 10;",1);
		Line lineOldVersion3 = new Line("linea 5",2);
		Line lineOldVersion4 = new Line("linea ",3);
		
		oldVersion =new ArrayList<Line>();
		oldVersion.add(lineOldVersion1);
		oldVersion.add(lineOldVersion2);
		oldVersion.add(lineOldVersion3);
		oldVersion.add(lineOldVersion4);
		
		Line lineCurrentVersion1 = new Line("linea 6;",0);
		Line lineCurrentVersion2 = new Line("linea 10",1);
		Line lineCurrentVersion3 = new Line("linea5",2);
		Line lineCurrentVersion4 = new Line("linea 4",3);
		
		currentVersion =new ArrayList<Line>();
		currentVersion.add(lineCurrentVersion1);
		currentVersion.add(lineCurrentVersion2);
		currentVersion.add(lineCurrentVersion3);
		currentVersion.add(lineCurrentVersion4);
		
		List<String> newFile;
		ProgramPart part;
		newFile = new ArrayList<String>();
		part = new  ProgramPart();
		part.setPartName("functionTest3");
		//partComparator.compareParts(oldVersion, currentVersion, part, newFile);
		assertEquals(4, part.getTotalLOC());
		assertEquals(4, part.getTotalLOCAdded());
		assertEquals(4, part.getTotalLOCDeleted());
		assertEquals("functionTest3", part.getPartName());
	}
	
	

	

}
