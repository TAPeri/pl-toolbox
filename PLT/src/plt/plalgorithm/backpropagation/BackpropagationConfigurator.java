package plt.plalgorithm.backpropagation;

import plt.plalgorithm.PLAlgorithm;
import plt.plalgorithm.ANN.ActivationFunction;

public interface BackpropagationConfigurator {

	// @Override
	public abstract int[] getTopology(int inputSize);

	//@Override
	public abstract ActivationFunction[] getActivationsFunctions();

	//  @Override
	public abstract double getLearningRate();

	// @Override
	public abstract double getErrorThreeshold();

	//  @Override
	public abstract int getMaxNumberOfIterations();

	public abstract PLAlgorithm algorithm();
	public abstract String testParameters();

}