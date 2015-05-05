package plt.plalgorithm.backpropagation;

import plt.plalgorithm.PLAlgorithm;
import plt.utils.ANN.ANNConfigurator;
import plt.utils.ANN.ActivationFunction;
import plt.utils.ANN.InlineANNConfigurator;

public class InlineBackpropagationConfigurator implements
		BackpropagationConfigurator {

	ANNConfigurator ann;

	double learningRate;
	double errorThreshold;
	int epochs;
	
	public InlineBackpropagationConfigurator(BackpropagationConfigurator copy){

		int topologyWithInput[] = copy.getTopology(0);
		int[] tmp = new int[topologyWithInput.length-1];
		for(int i=0;i<tmp.length;i++){
			tmp[i] = topologyWithInput[i+1];
			
		}
		
		ann = new InlineANNConfigurator(tmp,copy.getActivationsFunctions());
		this.learningRate = copy.getLearningRate();
		this.errorThreshold = copy.getErrorThreeshold();
		this.epochs = copy.getMaxNumberOfIterations();

}

	
	public InlineBackpropagationConfigurator(ANNConfigurator ann,
												double learningRate,
												double errorThreshold,
												int epochs){
		
		this.ann = ann;
		this.learningRate = learningRate;
		this.errorThreshold = errorThreshold;
		this.epochs = epochs;
		
	}
	
	@Override
	public int[] getTopology(int inputSize) {
		
		return ann.getTopology(inputSize);
	}

	@Override
	public ActivationFunction[] getActivationsFunctions() {
		return ann.getActivationsFunctions();
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

			return ""+ann.testParameters();
	}

}
