package plt.gui.featureselection;

import plt.featureselection.FeatureSelection;
import plt.featureselection.NBest;
import plt.featureselection.SFS;


public class SupportedFeatureSelection {

	static public String[] labels = {"None", "nBest", "SFS"};
	
	
	static public FeatureSelection getClass(int i){
		switch(i){
			case 1: return new NBest();
			case 2: return new SFS();
			default: return null;
		}
		
	}
	
}
