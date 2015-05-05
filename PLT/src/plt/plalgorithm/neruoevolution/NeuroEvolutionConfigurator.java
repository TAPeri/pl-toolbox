package plt.plalgorithm.neruoevolution;

import plt.utils.ANN.ActivationFunction;
import plt.utils.GA.GeneticAlgorithmConfigurator;

public interface NeuroEvolutionConfigurator extends Configurator {

	// @Override
	public abstract int[] getTopology(int inputSize);

	// @Override
	public abstract int iterations();

	// @Override
	public abstract GeneticAlgorithmConfigurator getGeneticAlgorithmConfigurator();

	// @Override
	public abstract ActivationFunction[] getActivationsFunctions();

}