package plt.utils.GA;

import plt.utils.GA.genticaloperators.CrossOver;
import plt.utils.GA.genticaloperators.GaussianMutation;
import plt.utils.GA.genticaloperators.Invertion;

public class InlineGeneticAlgorithmConfigurator implements
		GeneticAlgorithmConfigurator {

	
	int generations;
	int populationSize;
	int numParents;
	int eliteSize;
	ParentSelection parentSelection;
	
	CrossOver crossover;

	GaussianMutation mutation;

	Invertion inversion;
	
	
	public InlineGeneticAlgorithmConfigurator(GeneticAlgorithmConfigurator copy){
		this.generations = copy.getIterations();
		this.populationSize =  copy.getPopulationSize();
		this.numParents = copy.getNumberOfParents();
		this.eliteSize = copy.getElitSize();
		this.parentSelection = copy.getParentSelection();
		
		this.crossover = copy.getCrossOver();

		this.mutation = copy.getMutation();

		this.inversion = copy.getInvertion();
		
	}
	
	
	public InlineGeneticAlgorithmConfigurator(int generations,
												int populationSize,
												int numParents,
												int eliteSize,
												ParentSelection parentSelection,
												CrossOver crossover,
												GaussianMutation mutation,
												Invertion inversion){
		
		this.generations = generations;
		this.populationSize =  populationSize;
		this.numParents = numParents;
		this.eliteSize = eliteSize;
		this.parentSelection = parentSelection;
		
		this.crossover = crossover;

		this.mutation = mutation;

		this.inversion = inversion;
		
	}
	
	
	@Override
	public int getIterations() {
		return this.generations;
	}

	@Override
	public int getPopulationSize() {
		return this.populationSize;
	}

	@Override
	public int getNumberOfParents() {
		return this.numParents;
	}

	@Override
	public int getElitSize() {
		return this.eliteSize;
	}

	@Override
	public ParentSelection getParentSelection() {
		return this.parentSelection;
	}
	
	@Override
	public CrossOver getCrossOver() {
		return this.crossover;
	}

	@Override
	public GaussianMutation getMutation() {
		return this.mutation;
	}

	@Override
	public Invertion getInvertion() {
		return this.inversion;
	}
	
	public String testParameters() {
        
        int numParents = getNumberOfParents();
        int popSize = getPopulationSize();
        if(numParents > popSize)
        {
            return "GA error: The number of parents is greater than the GA population size.";

        }
        
        if(getElitSize() > getPopulationSize())
        {
            return "GA error: The elitism size is greater than the GA population size.";

        } 
		
		return "";
		
	}

}
