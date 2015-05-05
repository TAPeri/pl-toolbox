package plt.plalgorithm.svm;

import plt.plalgorithm.neruoevolution.Configurator;

public interface RankSvmConfigurator extends Configurator {


	public abstract String getKernelType();

	public abstract double getGamma();

	public abstract double getDegree();

	public abstract boolean gammaRequired();

	public abstract boolean degreeRequired();


}