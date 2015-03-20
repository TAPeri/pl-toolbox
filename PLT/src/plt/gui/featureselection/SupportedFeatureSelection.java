package plt.gui.featureselection;

import plt.featureselection.FeatureSelection;
import plt.featureselection.examples.NBest;
import plt.featureselection.examples.SFS;

public class SupportedFeatureSelection {

	static public String[] labels = {"None", "nBest", "SFS"};
	
	static public FeatureSelection[] classes = {null,new NBest(),new SFS()};
	
	
}
