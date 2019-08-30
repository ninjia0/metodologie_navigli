package it.uniroma1.fabbricasemantica.servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 
 * @author NijatParhat
 * 
 *
 */
public class BinarySearch {
	
	private long linenumber;
	private Path pa;
	private List<String> content;
	
	/**
	 *constructor of this class read file and put all lines in a List<String> 
	 * @param file to read an used by other methods
	 * @throws IOException
	 */
	
	public BinarySearch(String file) throws IOException {
		this.pa = Paths.get(file);
		this.linenumber = Files.lines(pa).count();
		this.content=Files.readAllLines(pa);
	}
	/**
	 * search the a string inside the file and return entire line of that string
	 * @param key value to search in file
	 * @return entire line that key in it
	 */
	public String search(String key){
		//long start=System.currentTimeMillis();
		int first=0;
		int last=new Long(linenumber).intValue()-1;
		while(first<=last) {
			int middle=(first+last)/2;
			int result = key.compareTo(content.get(middle).split(" ")[0]);
			//System.out.println(content.get(middle).split(" ")[0]);
			if(result==0) {return content.get(middle);}
			else if(result>0) {first=middle+1;}
			else {last=middle-1;}
		}
		//System.out.println("binarysearch: "+(System.currentTimeMillis()-start)/1000F);
	return null;
	}
	/**
	 * use random number generator to return random line
	 * @return random line from a file
	 */
	
	public String gotoRandomLine() {
		int linenumber=getRandomLineNumber();
		return content.get(linenumber);
	}
	/**
	 * generate random integer number max value equals to file's line
	 * @return random integer number
	 */
	private int getRandomLineNumber() {
		int rand=(int)(Math.random()*(new Long(linenumber).intValue()-1));
		return rand;
	}

}
