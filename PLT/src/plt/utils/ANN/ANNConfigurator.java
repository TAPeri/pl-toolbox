package plt.utils.ANN;

public interface ANNConfigurator {

	public abstract int[] getTopology(int inputSize);

	public abstract ActivationFunction[] getActivationsFunctions();

	public abstract String testParameters();

}