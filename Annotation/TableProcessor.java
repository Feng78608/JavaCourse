package Annotation;

import java.util.List;

import java.io.File;
import org.ddd.annotation.example11.tool.ClassFileLoader;
import org.ddd.annotation.example11.tool.Scanner;
import org.ddd.annotation.example11.tool.TableInfo;
import java.lang.annotation.*;


public class TableProcessor implements IProcessor {

	@Override
	public String process(String url) throws Exception {
		// TODO Auto-generated method stub
		List<File> classFiles=Scanner.getClassFiles(url);
		StringBuilder sql=new StringBuilder();
		for(File file:classFiles) {
			Class<?>clazz=ClassFileLoader.loadClass(file);
			TableInfo table=TableInfo.parse(clazz);
			if(table!=null)
				sql.append(table.toString());
		}
		return null;
	}

}
