package plt.plalgorithm.backpropagation;

import plt.plalgorithm.neruoevolution.Configurator;
import plt.utils.ANN.ActivationFunction;

public interface BackpropagationConfigurator  extends Configurator{

	public abstract int[] getTopology(int inputSize);

	public abstract ActivationFunction[] getActivationsFunctions();

	public abstract double getLearningRate();

	public abstract double getErrorThreeshold();

	public abstract int getMaxNumberOfIterations();


}