package plt.validator;


public class SupportedValidations {
	static public String[] labels = {"Training set", "K-Fold"};// "Split",
		
	static public Validator getClass(int i){
		switch(i){
			case 1: return  new KFoldCV();
			default: return new NoValidation();
		}
		
	}
	
	
}
