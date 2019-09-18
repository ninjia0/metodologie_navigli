package quickstart;

import java.util.LinkedList;
import java.util.List;

import def.js.Math;
public class RandomPageChooser {
	
	
	private static String web1="definitionAnnotation.html";
	private static String web2="myAnnotation.html";
	private static String web3="senseAnnotation.html";
	private static String web4="senseValidation.html";
	private static String web5="translationAnnotation.html";
	private static String web6="translationValidation.html";
	private static String web7="wordAnnotation.html";
	private List<String> li;

	public RandomPageChooser() {
		li = new LinkedList<String>();
		li.add(web1);
		li.add(web2);
		li.add(web3);
		li.add(web4);
		li.add(web5);
		li.add(web6);
		li.add(web7);
	}
	public String getRandomPage() {
		int rand=(int)(Math.random()*(li.size()+1));
		System.out.println(rand);
		return li.get(rand);
	}


}
