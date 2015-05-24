package plt.utils.ANN;

public class InlineANNConfigurator implements ANNConfigurator {

	
	int[] topology;
	ActivationFunction[] activationFunctions;
	
	
	public InlineANNConfigurator(int[] topology,ActivationFunction[] activationFunctions){
		
		this.topology = topology;
		
		this.activationFunctions = activationFunctions;
	}
	

	/* (non-Javadoc)
	 * @see plt.utils.ANN.ANNConfigurator#getTopology(int)
	 */
	@Override
	public int[] getTopology(int inputSize) {
		
		int[] top = new int[topology.length+1];
		top[0] = inputSize;
		for(int i=0;i<topology.length;i++)
			top[i+1] = topology[i];
		return top;
	}
	
	/* (non-Javadoc)
	 * @see plt.utils.ANN.ANNConfigurator#getActivationsFunctions()
	 */
	@Override
	public ActivationFunction[] getActivationsFunctions() {
		return this.activationFunctions;
	}
	
	/* (non-Javadoc)
	 * @see plt.utils.ANN.ANNConfigurator#testParameters()
	 */
	@Override
	public String testParameters() {
		
		for(int i : topology){
			if (i==0)
				return "ANN error: all layers need to have at least one neuron.";
		}

		return "";
	}
	
}
