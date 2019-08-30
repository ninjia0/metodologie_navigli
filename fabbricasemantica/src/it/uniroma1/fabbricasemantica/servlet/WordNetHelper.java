package it.uniroma1.fabbricasemantica.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.uniroma1.fabbricasemantica.servlet.task.FilePath;

/**
 * 
 * @author NijatParhat
 * with help of BinarySearch this class provides a words for standarddataprovider class 
 */
public class WordNetHelper{
	
	private String wordfile =FilePath.getIndexNounPath();;
	private String desfile=FilePath.getDataNounPath();
	private List<String> wd;
	
	/**
	 * take data from wordnet databse and choose a word and description for translationAnnotation
	 * @return list of String
	 * @throws IOException
	 */
	public List<String> trasnlationAnnotation(){
		wd = new ArrayList<>();
		try {
			BinarySearch bsw = new BinarySearch(wordfile);
			this.wd =new ArrayList<>();
			String[] wordData=bsw.gotoRandomLine().split(" ");
			String word=wordData[0];
			String suffix=wordData[wordData.length-1];
			BinarySearch bsd = new BinarySearch(desfile);
			String des=bsd.search(suffix).split("\\|")[1].split("\\;")[0];
			wd.add(word.trim());
			wd.add(des.trim());
		} catch (Exception e) {
			wd.add("barbu");
			wd.add("found along western Atlantic coast ");
		}

		return wd;
	}
	/**
	 *  take data from wordnet databse and randomly choose a word , shuffle it provide it when
	 *  myAnnotation ask a word
	 * @return String of a word
	 * @throws IOException
	 */
	public String myAnnotation() {
		StringBuilder guessWord=new StringBuilder();
		try {
			BinarySearch bsw = new BinarySearch(wordfile);
			List<Character> word = new ArrayList<>();
			String wo=bsw.gotoRandomLine().split(" ")[0].trim();
			while (wo.contains("_")) {
				wo=bsw.gotoRandomLine().split(" ")[0].trim();
			}
			for(int i=0;i<wo.length();i++) {
				word.add(wo.charAt(i));
			}
			Collections.shuffle(word);
			word.stream().forEach(w->guessWord.append(w));
			return guessWord.toString();
		} catch (Exception e) {
			guessWord.append("nqeue");
		}
		return guessWord.toString();
	}

	
}
