package plt.plalgorithm.backpropagation;

import plt.plalgorithm.PLAlgorithm;
import plt.plalgorithm.ANN.ActivationFunction;

public class InlineBackpropagationConfigurator implements
		BackpropagationConfigurator {

	
	int[] topology;
	ActivationFunction[] activationFunctions;
	double learningRate;
	double errorThreshold;
	int epochs;
	
	public InlineBackpropagationConfigurator(BackpropagationConfigurator copy){

		int[] tmp = copy.getTopology(0);
		this.topology = new int[tmp.length-1];
		
		for(int i=1;i<tmp.length;i++){
			this.topology[i-1] = tmp[i];
		}
		
		this.activationFunctions = copy.getActivationsFunctions();
		this.learningRate = copy.getLearningRate();
		this.errorThreshold = copy.getErrorThreeshold();
		this.epochs = copy.getMaxNumberOfIterations();

}

	
	public InlineBackpropagationConfigurator(int[] topology,
												ActivationFunction[] activationFunctions,
												double learningRate,
												double errorThreshold,
												int epochs){
		
		this.topology = topology;
		this.activationFunctions = activationFunctions;
		this.learningRate = learningRate;
		this.errorThreshold = errorThreshold;
		this.epochs = epochs;
		
	}
	
	@Override
	public int[] getTopology(int inputSize) {
		
		int[] top = new int[topology.length+1];
		top[0] = inputSize;
		for(int i=0;i<topology.length;i++)
			top[i+1] = topology[i];
		return top;
	}

	@Override
	public ActivationFunction[] getActivationsFunctions() {
		return this.activationFunctions;
	}

	@Override
	public double getLearningRate() {
		return this.learningRate;
	}

	@Override
	public double getErrorThreeshold() {
		return this.errorThreshold;
	}

	@Override
	public int getMaxNumberOfIterations() {
		return this.epochs;
	}

	@Override
	public PLAlgorithm algorithm() {
		return new Backpropagation(this);

	}

	@Override
	public String testParameters() {

			return "";
	}

}
