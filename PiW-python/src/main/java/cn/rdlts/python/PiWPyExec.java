package cn.rdlts.python;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyType;
import org.python.util.PythonInterpreter;

public class PiWPyExec {
	
	/** singleton */
	private static volatile PiWPyExec instance; 
	
	PythonInterpreter interpreter;
	
	public static PiWPyExec getInstance() {
		if (instance == null) {
			synchronized(PiWPyExec.class) {
				if (instance == null) {
					instance = new PiWPyExec();
				}
			}
		}
		return instance;
	}
	
	private PiWPyExec() {
		interpreter = new PythonInterpreter();
	}
	
	public PiWPyExec importPy(String pyFile) {
		interpreter.execfile(pyFile);
		return this;
	}
	
	public PiWPyExec importPy(InputStream is) {
		interpreter.execfile(is);
		return this;
	}
	
	public PiWPyExec reload(String moduleName) {
		interpreter.exec("reload(" + moduleName + ")");
		return this;
	}
	
	public PiWPyExec exec(String method, Object... params) {
		PyFunction func = interpreter.get(method, PyFunction.class);
		
		return this;
	}
}
