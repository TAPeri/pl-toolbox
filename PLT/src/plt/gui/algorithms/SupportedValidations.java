package plt.gui.algorithms;

import plt.validator.Validator;
import plt.validator.examples.KFoldCV;
import plt.validator.examples.NoValidation;
//import plt.validator.examples.SplitValidation;

public class SupportedValidations {
	static public String[] labels = {"None", "K-Fold"};// "Split",
	
	static public Validator[] classes = {new NoValidation(), new KFoldCV()};//new SplitValidation(),
}
