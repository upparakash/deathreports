package deathreports;
import java.io.*;
import java.util.*;

public class Deathreports {
	String hname;
    String pname;
    String agroup;
    int age;
    String cause;
    String loc;
    String dist;
	

	public static void main(String[] args) throws IOException {
		
		FileInputStream fin=new FileInputStream("D:\\a.txt");    
		FileInputStream fin2=new FileInputStream("D:\\b.txt");    
		FileInputStream fin3=new FileInputStream("D:\\c.txt");     
		FileOutputStream fin5=new FileOutputStream("D:\\t2.txt"); 
		
		Vector v=new Vector();   
		v.add(fin);    
		v.add(fin2);    
		v.add(fin3);    
		Enumeration e1=v.elements();           
		SequenceInputStream bin=new SequenceInputStream(e1);    
		int i=0;      
		while((i=bin.read())!=-1)
		{ 	
		System.out.print((char)i);
		fin5.write(i);
		} 
		bin.close();    
		fin.close();    
		fin2.close();  
		fin3.close();  
		fin5.close();
		BufferedReader reader;
		BufferedWriter writer;
		
		
		int count=1;
				
		try {
			
			reader = new BufferedReader(new FileReader("D:\\t2.txt"));
			writer= new BufferedWriter(new FileWriter("D:\\t3.txt"));
			HashMap<String, ArrayList<String>> viols = new HashMap<>();
			
			String Line = reader.readLine();

			while (Line != null) {		
				                  
				String[] sd1=Line.split(",");
				
				String hname=(sd1[0]);
			    String pname=(sd1[1]);
			    String agroup=(sd1[2]);
			    int age=Integer.parseInt(sd1[3]);
			    String cause=(sd1[4]);
			    String loc=(sd1[5]);
			    String dist=(sd1[6]);
                

				ArrayList<String> list=new ArrayList<String>();                
				System.out.println(Line);				
				ArrayList<String> vs =  viols.get(dist);			
				 if ( vs == null)
				 {
				 	vs = new ArrayList<>();
				 	vs.add(Line);
				 }
				 else {
					 vs.add(Line);					 
				 }
				 viols.put(dist, vs);				 	
				 if ( vs.size() > count) 
				 {
				 	count = vs.size();
				 }
				
				 Line = reader.readLine();
			
			}
			for ( int i1=1;i1<count+1; i1++)
			{
				writer.write("dist wise listed below");	
				writer.newLine();
				Set<String> keySet = viols.keySet();
				for( String key: keySet)
			{
				ArrayList<String> viols1 = viols.get(key);
				if (( viols1 !=null) && (viols1.size()==i1)) 
				{
					for ( String s:viols1)
					{
						
					writer.write(s);
					writer.newLine();
					
					}
					
					
				}
					
						
			}
				
			}
			
			
			
			
			
			reader.close();
			writer.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		int count1=1;
		
		try {
			
			reader = new BufferedReader(new FileReader("D:\\t2.txt"));
			writer= new BufferedWriter(new FileWriter("D:\\t4.txt"));
			HashMap<String, ArrayList<String>> viols = new HashMap<>();
			
			String Line = reader.readLine();

			while (Line != null) {		
				                  
				String[] sd1=Line.split(",");
				
				String hname=(sd1[0]);
			    String pname=(sd1[1]);
			    String agroup=(sd1[2]);
			    int age=Integer.parseInt(sd1[3]);
			    String cause=(sd1[4]);
			    String loc=(sd1[5]);
			    String dist=(sd1[6]);
                

				ArrayList<String> list=new ArrayList<String>();                
				System.out.println(Line);				
				ArrayList<String> vs =  viols.get(agroup);			
				 if ( vs == null)
				 {
				 	vs = new ArrayList<>();
				 	vs.add(Line);
				 }
				 else {
					 vs.add(Line);					 
				 }
				 viols.put(agroup, vs);				 	
				 if ( vs.size() > count1) 
				 {
					 count1 = vs.size();
				 }
				
				 Line = reader.readLine();
			
			}
			for ( int i1=1;i1<count1+1; i1++)
			{
				writer.newLine();
				Set<String> keySet = viols.keySet();
				for( String key: keySet)
			{
				ArrayList<String> viols1 = viols.get(key);
				if (( viols1 !=null) && (viols1.size()==i1)) 
				{
					for ( String s:viols1)
					{
						
					writer.write(s);
					writer.newLine();
					
					}
					
					
				}
					
						
			}
				
			}
			
			
			
			
			
			reader.close();
			writer.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		 

		}    
		}    

