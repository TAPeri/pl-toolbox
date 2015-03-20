package plt.gui.algorithms;



public class SupportedAlgorithms {

	
	static public String[] labels = {"None","Evolving NN","Back propagation","Rank SVM"};
	static public PLAlgorithm[] classes = {null,new PLNeuroEvolution(),new PLBackPropagation(), new PLRankSvm()};


	
}
