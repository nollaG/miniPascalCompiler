package codeGenerator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PreProcessor {
	public static String preProcess(String s) {
		if (s==null) return "";
		String resu="";
		String[] splits=s.split("\n");
		Pattern definePattern = Pattern.compile("^\\s*#define\\s+([A-Za-z0-9_]*)\\s+([A-Za-z0-9_]*)\\s*$");
		Matcher tmp;
		for (int i=0;i<splits.length;++i){
			tmp=definePattern.matcher(splits[i]);
			if (tmp.find()) {
				for (int j=i+1;j<splits.length;++j) {
					splits[j]=splits[j].replace(tmp.group(1), tmp.group(2));
				}
				resu+="\n";
			} else {
				resu+=splits[i]+"\n";
			}
		}
		return resu;
	}
}
