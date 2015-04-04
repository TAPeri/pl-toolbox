package plt.gui.algorithms;

import plt.plalgorithm.backpropagation.GUIBackpropagationConfigurator;
import plt.plalgorithm.neruoevolution.GUINeuroEvolutionConfigurator;
import plt.plalgorithm.svm.GUIRankSvmConfigurator;




public class SupportedAlgorithms {

	
	static public String[] labels = {"None","Evolving NN","Back propagation","Rank SVM"};

	static public GUIConfigurator getClass(int i){
		switch(i){
			case 1: return new GUINeuroEvolutionConfigurator();
			case 2: return new GUIBackpropagationConfigurator();
			case 3: return new GUIRankSvmConfigurator();
			default: return null;
		}
		
	}
}
