package co.edu.andes.unit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.edu.andes.businessRules.JavaLOCCounter;
import co.edu.andes.entities.Line;

public class JavaLOCCounterJUnit {

	JavaLOCCounter javaLOCCounter;
	
	@Before
	public void loadProjects(){
		javaLOCCounter = new JavaLOCCounter();
	}
	
	@Test
	public void testLogicLines1() {
		List<String> lines = new ArrayList<String>();
		lines.add("line 1;");
		lines.add("line 2;");
		lines.add("line 3;");
		List<Line> linesLogic = javaLOCCounter.getLogicLines(lines);
		assertEquals(3,linesLogic.size());
		assertNotEquals("line 3;",linesLogic.get(0).getContent());
		assertEquals("line 1;",String.valueOf(linesLogic.get(0).getContent()));
	}
	
	@Test
	public void testLogicLines2() {
		List<String> lines = new ArrayList<String>();
		lines.add("line 1");
		lines.add("line 2;");
		lines.add("if(a)");
		lines.add("{");
		lines.add("content;");
		lines.add("}");
		List<Line> linesLogic = javaLOCCounter.getLogicLines(lines);
		assertEquals(6,linesLogic.size());
		assertNotEquals("line 4;",linesLogic.get(0).getContent());
		assertEquals("content;",linesLogic.get(4).getContent());
	}

}
