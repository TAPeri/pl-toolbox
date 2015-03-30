package plt.gui.algorithms;



public class SupportedAlgorithms {

	
	static public String[] labels = {"None","Evolving NN","Back propagation","Rank SVM"};

	static public GUIConfigurator getClass(int i){
		switch(i){
			case 1: return new PLNeuroEvolutionConfigurator();
			case 2: return new PLBackPropagationConfigurator();
			case 3: return new PLRankSvmConfigurator();
			default: return null;
		}
		
	}
}
