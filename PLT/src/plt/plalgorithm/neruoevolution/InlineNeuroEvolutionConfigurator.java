package plt.plalgorithm.neruoevolution;

import plt.plalgorithm.PLAlgorithm;
import plt.utils.ANN.ANNConfigurator;
import plt.utils.ANN.ActivationFunction;
import plt.utils.GA.GeneticAlgorithmConfigurator;

public class InlineNeuroEvolutionConfigurator implements
		NeuroEvolutionConfigurator {

	ANNConfigurator ann;
	GeneticAlgorithmConfigurator ga;
	
	
	
	public InlineNeuroEvolutionConfigurator(ANNConfigurator ann,GeneticAlgorithmConfigurator ga){
		this.ann = ann;
		this.ga = ga;
		
	}
	
	@Override
	public int[] getTopology(int inputSize) {
		return ann.getTopology(inputSize);
	}

	@Override
	public int iterations() {
		return ga.getIterations();
	}

	@Override
	public GeneticAlgorithmConfigurator getGeneticAlgorithmConfigurator() {
		return ga;
	}

	@Override
	public String testParameters() {
		return ga.testParameters()+ann.testParameters();

	}

	@Override
	public ActivationFunction[] getActivationsFunctions() {
		return ann.getActivationsFunctions();
	}

	@Override
	public PLAlgorithm algorithm() {
		return new NeuroEvolution(this);
	}

}
