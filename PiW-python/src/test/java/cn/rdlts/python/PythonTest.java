package cn.rdlts.python;

import java.io.InputStream;

import org.junit.Test;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import junit.framework.TestCase;

public class PythonTest extends TestCase {
	
	@Test
	public void testAdd() throws Exception {
		System.out.println("add 1 + 2:");
		int x = 1;
		int y = 2;
		
		try (PythonInterpreter interpreter = new PythonInterpreter();
				InputStream fis = this.getClass().getResourceAsStream("/python_script/adder.py");) {
			interpreter.execfile(fis);

			PyFunction funAdd = interpreter.get("add", PyFunction.class);
			PyObject result = funAdd.__call__(new PyInteger(x), new PyInteger(y));
			System.out.println("answer = " + result.toString());
		}
	}
}
