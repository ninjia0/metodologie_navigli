package it.uniroma1.fabbricasemantica.servlet.task;

	
import java.util.LinkedList;
import java.util.List;
public class RandomPage {
	enum pages{
		definitionAnnotation,myAnnotation,
		senseAnnotation,senseValidation,
		translationAnnotation,translationValidation,
		wordAnnotation;
		
	}
	private List<String> li;

	public RandomPage() {
		li = new LinkedList<String>();
		for(pages p:pages.values()) {li.add(p+".html");}
	}
	public String getRandomPage(String currentPage) {
		String page=currentPage;
		while(page.equals(currentPage)) {
		int rand=(int)(Math.random()*li.size());
		page=li.get(rand);
		System.out.println(li.get(rand));
		}
		return page;
	}

}
