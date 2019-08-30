package it.uniroma1.fabbricasemantica.servlet.task;

public class FilePath {
	
	private static final String VARPATH="/WEB-INF/xml/userValidationAnnotation.xml";
	private static final String INDEXNOUN="/WEB-INF/xml/index.noun";
	private static final String DATANOUN="/WEB-INF/xml/data.noun";
	public static String getVARPath() {
		return VARPATH;
	}
	
	public static String getIndexNounPath() {
		return INDEXNOUN;
	}
	public static String getDataNounPath() {
		return DATANOUN;
	}
	
}
