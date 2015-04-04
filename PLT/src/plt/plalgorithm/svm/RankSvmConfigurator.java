package plt.plalgorithm.svm;

import plt.plalgorithm.PLAlgorithm;

public interface RankSvmConfigurator {

	public abstract String testParameters();

	public abstract String getKernelType();

	public abstract double getGamma();

	public abstract double getDegree();

	public abstract boolean gammaRequired();

	public abstract boolean degreeRequired();

	public abstract PLAlgorithm algorithm();

}