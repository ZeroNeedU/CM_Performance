package xingneng.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunShellTools {
	
	String str="";
	public void RunShell(String command,String processname) throws IOException{
		Process process=Runtime.getRuntime().exec(command);
		BufferedReader buff=new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line=null;
		DecimalFormat df   = new DecimalFormat("######0.00"); 
		int linenum=0;
		Double size;
		while((line=buff.readLine())!=null){
			//System.out.println(line);
			if(linenum==50){
				break;

			}else{
				if( line.indexOf("TOTAL")!=-1){
					line=line.trim();
					String regEx = "[' ']+"; // 一个或多个空格  
					Pattern p = Pattern.compile(regEx);  
					Matcher m = p.matcher(line);
					line=m.replaceAll(" ");
					//System.out.println(line);
					line=line.replaceFirst("TOTAL.*?(\\d+).*", "$1");
					size=Double.parseDouble(line);
					size=size/1024;
					System.out.println(processname+"的内存消耗："+df.format(size)+"M");	
				}
			}
			linenum++;
		}


    }
		
}

