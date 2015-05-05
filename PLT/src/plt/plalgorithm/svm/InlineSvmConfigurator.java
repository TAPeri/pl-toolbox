package plt.plalgorithm.svm;

import plt.plalgorithm.PLAlgorithm;

public class InlineSvmConfigurator implements RankSvmConfigurator {

	
	String kernelType;
	double gamma;
	double degree;
	boolean requireGamma;
	boolean requireDegree;
	
	
	public InlineSvmConfigurator(String kernelType,
								double gamma,
								double degree,
								boolean requireGamma,
								boolean requireDegree){
		
		this.kernelType = kernelType;
		this.gamma = gamma;
		this.degree = degree;
		this.requireGamma = requireGamma;
		this.requireDegree = requireDegree;
		
	}
	
	public InlineSvmConfigurator(RankSvmConfigurator copy){
		this.kernelType = copy.getKernelType();
		this.gamma = copy.getGamma();
		this.degree = copy.getDegree();
		this.requireGamma = copy.gammaRequired();
		this.requireDegree = copy.degreeRequired();
		
	}
	
	
	public String testParameters() {
		
		
        if((this.gammaRequired())
        &&(this.getGamma() == 0))
        {
            return "SVM error: Gamma cannot be set to 0.";
            
        } else
        	return "";

	}

	@Override
	public String getKernelType() {
		return this.kernelType;
	}

	@Override
	public double getGamma() {
		return this.gamma;
	}

	@Override
	public double getDegree() {
		return this.degree;
	}

	@Override
	public boolean gammaRequired() {
		return this.requireGamma;
	}

	@Override
	public boolean degreeRequired() {
		return this.requireDegree;
	}

	@Override
	public PLAlgorithm algorithm() {
		return new RankSvm(this);
	}

}
