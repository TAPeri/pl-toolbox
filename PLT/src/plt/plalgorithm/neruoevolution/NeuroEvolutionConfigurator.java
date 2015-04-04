package plt.plalgorithm.neruoevolution;

import plt.plalgorithm.PLAlgorithm;
import plt.plalgorithm.ANN.ActivationFunction;
import plt.plalgorithm.neruoevolution.GA.GeneticAlgorithmConfigurator;

public interface NeuroEvolutionConfigurator {

	// @Override
	public abstract int[] getTopology(int inputSize);

	// @Override
	public abstract int iterations();

	// @Override
	public abstract GeneticAlgorithmConfigurator getGeneticAlgorithmConfigurator();

	public abstract String testParameters();

	// @Override
	public abstract ActivationFunction[] getActivationsFunctions();

	public abstract PLAlgorithm algorithm();

}