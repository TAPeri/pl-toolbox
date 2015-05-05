/*                   GNU LESSER GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.


  This version of the GNU Lesser General Public License incorporates
the terms and conditions of version 3 of the GNU General Public
License, supplemented by the additional permissions listed below.

  0. Additional Definitions.

  As used herein, "this License" refers to version 3 of the GNU Lesser
General Public License, and the "GNU GPL" refers to version 3 of the GNU
General Public License.

  "The Library" refers to a covered work governed by this License,
other than an Application or a Combined Work as defined below.

  An "Application" is any work that makes use of an interface provided
by the Library, but which is not otherwise based on the Library.
Defining a subclass of a class defined by the Library is deemed a mode
of using an interface provided by the Library.

  A "Combined Work" is a work produced by combining or linking an
Application with the Library.  The particular version of the Library
with which the Combined Work was made is also called the "Linked
Version".

  The "Minimal Corresponding Source" for a Combined Work means the
Corresponding Source for the Combined Work, excluding any source code
for portions of the Combined Work that, considered in isolation, are
based on the Application, and not on the Linked Version.

  The "Corresponding Application Code" for a Combined Work means the
object code and/or source code for the Application, including any data
and utility programs needed for reproducing the Combined Work from the
Application, but excluding the System Libraries of the Combined Work.

  1. Exception to Section 3 of the GNU GPL.

  You may convey a covered work under sections 3 and 4 of this License
without being bound by section 3 of the GNU GPL.

  2. Conveying Modified Versions.

  If you modify a copy of the Library, and, in your modifications, a
facility refers to a function or data to be supplied by an Application
that uses the facility (other than as an argument passed when the
facility is invoked), then you may convey a copy of the modified
version:

   a) under this License, provided that you make a good faith effort to
   ensure that, in the event an Application does not supply the
   function or data, the facility still operates, and performs
   whatever part of its purpose remains meaningful, or

   b) under the GNU GPL, with none of the additional permissions of
   this License applicable to that copy.

  3. Object Code Incorporating Material from Library Header Files.

  The object code form of an Application may incorporate material from
a header file that is part of the Library.  You may convey such object
code under terms of your choice, provided that, if the incorporated
material is not limited to numerical parameters, data structure
layouts and accessors, or small macros, inline functions and templates
(ten or fewer lines in length), you do both of the following:

   a) Give prominent notice with each copy of the object code that the
   Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the object code with a copy of the GNU GPL and this license
   document.

  4. Combined Works.

  You may convey a Combined Work under terms of your choice that,
taken together, effectively do not restrict modification of the
portions of the Library contained in the Combined Work and reverse
engineering for debugging such modifications, if you also do each of
the following:

   a) Give prominent notice with each copy of the Combined Work that
   the Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the Combined Work with a copy of the GNU GPL and this license
   document.

   c) For a Combined Work that displays copyright notices during
   execution, include the copyright notice for the Library among
   these notices, as well as a reference directing the user to the
   copies of the GNU GPL and this license document.

   d) Do one of the following:

       0) Convey the Minimal Corresponding Source under the terms of this
       License, and the Corresponding Application Code in a form
       suitable for, and under terms that permit, the user to
       recombine or relink the Application with a modified version of
       the Linked Version to produce a modified Combined Work, in the
       manner specified by section 6 of the GNU GPL for conveying
       Corresponding Source.

       1) Use a suitable shared library mechanism for linking with the
       Library.  A suitable mechanism is one that (a) uses at run time
       a copy of the Library already present on the user's computer
       system, and (b) will operate properly with a modified version
       of the Library that is interface-compatible with the Linked
       Version.

   e) Provide Installation Information, but only if you would otherwise
   be required to provide such information under section 6 of the
   GNU GPL, and only to the extent that such information is
   necessary to install and execute a modified version of the
   Combined Work produced by recombining or relinking the
   Application with a modified version of the Linked Version. (If
   you use option 4d0, the Installation Information must accompany
   the Minimal Corresponding Source and Corresponding Application
   Code. If you use option 4d1, you must provide the Installation
   Information in the manner specified by section 6 of the GNU GPL
   for conveying Corresponding Source.)

  5. Combined Libraries.

  You may place library facilities that are a work based on the
Library side by side in a single library together with other library
facilities that are not Applications and are not covered by this
License, and convey such a combined library under terms of your
choice, if you do both of the following:

   a) Accompany the combined library with a copy of the same work based
   on the Library, uncombined with any other library facilities,
   conveyed under the terms of this License.

   b) Give prominent notice with the combined library that part of it
   is a work based on the Library, and explaining where to find the
   accompanying uncombined form of the same work.

  6. Revised Versions of the GNU Lesser General Public License.

  The Free Software Foundation may publish revised and/or new versions
of the GNU Lesser General Public License from time to time. Such new
versions will be similar in spirit to the present version, but may
differ in detail to address new problems or concerns.

  Each version is given a distinguishing version number. If the
Library as you received it specifies that a certain numbered version
of the GNU Lesser General Public License "or any later version"
applies to it, you have the option of following the terms and
conditions either of that published version or of any later version
published by the Free Software Foundation. If the Library as you
received it does not specify a version number of the GNU Lesser
General Public License, you may choose any version of the GNU Lesser
General Public License ever published by the Free Software Foundation.

  If the Library as you received it specifies that a proxy can decide
whether future versions of the GNU Lesser General Public License shall
apply, that proxy's public statement of acceptance of any version is
permanent authorization for you to choose that version for the
Library.*/

package plt.plalgorithm.neruoevolution;


import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;






















import plt.dataset.TrainableDataSet;
import plt.featureselection.SelectedFeature;
import plt.model.Model;
import plt.plalgorithm.PLAlgorithm;
import plt.utils.ANN.*;
import plt.utils.GA.DNA;
import plt.utils.GA.GeneticAlgorithm;
import plt.utils.GA.GeneticAlgorithmConfigurator;
import plt.utils.GA.GeneticEncoder;
import plt.utils.GA.genticaloperators.CrossOverType;


/**
 *
 * @author Vincent Farrugia
 */
public class NeuroEvolution extends PLAlgorithm {
    private NeuroEvolutionConfigurator configurator;
    private SigmoidPairwiseFitness nee;
    protected GeneticAlgorithm ga;

    
    
    public NeuroEvolution() {

    	this(new GUINeuroEvolutionConfigurator());
    	
    }
    
    

    public NeuroEvolution( NeuroEvolutionConfigurator configurator) {
        super();
        //final NeuroEvolution self = this;

        this.configurator = configurator;

        this.nee = new SigmoidPairwiseFitness();
        
    }

    @Override
    public Model run(TrainableDataSet dataSet,SelectedFeature features) throws InterruptedException {
      // Logger.getLogger("plt.logger").log(Level.INFO, "run PLNeuroEvolution");
    	
    	this.ga.runFor(this.configurator.iterations(),dataSet,features);
        final SimpleNeuralNetwork resultNetwork = getNeuralNetuork();
        return new ModelNeuroEvolution(resultNetwork, dataSet, features);

    }
    private SimpleNeuralNetwork getNeuralNetuork() {
        return (SimpleNeuralNetwork)ga.getResult();
    }

    

    
    @Override
    protected Model beforeRun(TrainableDataSet dataSet,SelectedFeature features) {
    	
    	
       final SimpleNeuralNetwork n = new SimpleNeuralNetwork(this.configurator.getTopology(features.getSize()), this.configurator.getActivationsFunctions());
        
        final SigmoidPairwiseFitness e = nee;
        
        this.ga = new GeneticAlgorithm(this.configurator.getGeneticAlgorithmConfigurator(), new GeneticEncoder() {

            @Override
            public Object decode(DNA dna) {
                double[] weights = new double[dna.vector.length];
                for (int i=0; i<weights.length;i++) {
                    weights[i] = (dna.vector[i]*10)-5;
                }
                
                n.setWeights(weights);
                return n;
            }

            @Override
            public double evaluationFunction(DNA dna,TrainableDataSet dataset,SelectedFeature featureSelection ) {
                double[] weights = new double[dna.vector.length];
                for (int i=0; i<weights.length;i++) {
                    weights[i] = (dna.vector[i]*10)-5;
                }
                
                n.setWeights(weights);
                
                try {
                    return e.evaluate((SimpleNeuralNetwork)n.clone(),dataset,featureSelection);
                } catch (CloneNotSupportedException ex) {
                    throw new RuntimeException();
                }
            }

            @Override
            public int dnaSize() {
                return n.getNumberOfWeights();
            }
        });
    	
    	
       // this.ne = new NeuroEvolutionAlgorithm(this.configurator, nee,features);
        return new ModelNeuroEvolution( this.getNeuralNetuork(), dataSet, features);
    }
    

    
    @Override
    public ArrayList<Object[]> getProperties()
    {
        // Multilayer Perceptron Properties:
        
        //int inputSize = this.getFeatureSelection().getSize();
    	
    	//if(ne==null)
    	//	System.err.println("Not ready");
        int[] fullTopology = this.getNeuralNetuork().topology;//configurator.getTopology(inputSize);
        
    	
        String subSec1_header = "Multilayer Perceptron";
        ArrayList<String[]> subSec1_content = new ArrayList<>();


        
        String[] inpLayerContentPair = new String[3];
        inpLayerContentPair[0] = "Input Layer:";
        inpLayerContentPair[1] = ""+fullTopology[0];
        inpLayerContentPair[2] = "N/A";
        subSec1_content.add(inpLayerContentPair);
        
        

        
        for(int i=1; i<fullTopology.length-1; i++)
        {
            if(fullTopology[i] > 0)
            {
                String[] nwContentPair = new String[3];
                nwContentPair[0] = "Hidden Layer "+i+":";
                nwContentPair[1] = ""+fullTopology[i];
                nwContentPair[2] = configurator.getActivationsFunctions()[i-1].toString();
                
                subSec1_content.add(nwContentPair);
            }
        }
        
        String[] outLayerContentPair = new String[3];
        outLayerContentPair[0] = "Output Layer:";
        outLayerContentPair[1] = ""+1;
        outLayerContentPair[2] = configurator.getActivationsFunctions()[fullTopology.length-2].toString();
        subSec1_content.add(outLayerContentPair);
        
        
        
        // GA Properties:
        
        String subSec2_header = "GA Properties";
        ArrayList<String[]> subSec2_content = new ArrayList<>();
        
        GeneticAlgorithmConfigurator gaConfig = configurator.getGeneticAlgorithmConfigurator();
        
        String[] popContentPair = new String[2];
        popContentPair[0] = "Population:";
        popContentPair[1] = ""+gaConfig.getPopulationSize();
        subSec2_content.add(popContentPair);
        
        String[] crossoverRateContentPair = new String[2];
        crossoverRateContentPair[0] = "Crossover Probability:";
        crossoverRateContentPair[1] = ""+gaConfig.getCrossOver().getProbability();
        subSec2_content.add(crossoverRateContentPair);
        
        String[] crossoverTypeContentPair = new String[2];
        crossoverTypeContentPair[0] = "Crossover Type:";
        
        String typStr = "";
        if(gaConfig.getCrossOver().getCrossOverType() == CrossOverType.ONEPOINT) { typStr = "OnePoint"; }
        else if(gaConfig.getCrossOver().getCrossOverType() == CrossOverType.TWOPOINT) { typStr = "TwoPoint"; }
        else if(gaConfig.getCrossOver().getCrossOverType() == CrossOverType.UNIFORM) { typStr = "Uniform"; }
        crossoverTypeContentPair[1] = typStr;
        subSec2_content.add(crossoverTypeContentPair);
        
        
        String[] mutationRateContentPair = new String[2];
        mutationRateContentPair[0] = "Mutation Probability:";
        mutationRateContentPair[1] = ""+gaConfig.getMutation().getProbability();
        subSec2_content.add(mutationRateContentPair);
        
        String[] numOfParentsContentPair = new String[2];
        numOfParentsContentPair[0] = "Num of Parents:";
        numOfParentsContentPair[1] = ""+gaConfig.getNumberOfParents();
        subSec2_content.add(numOfParentsContentPair);
        
        String[] parentSelectionContentPair = new String[2];
        parentSelectionContentPair[0] = "Parent Selection:";
        parentSelectionContentPair[1] = ""+gaConfig.getParentSelection().getSelectionName();
        subSec2_content.add(parentSelectionContentPair);
        
        String[] elitismSizeContentPair = new String[2];
        elitismSizeContentPair[0] = "Elitism Size:";
        elitismSizeContentPair[1] = ""+gaConfig.getElitSize();
        subSec2_content.add(elitismSizeContentPair);
        
        String[] iterationsContentPair = new String[2];
        iterationsContentPair[0] = "Generations:";
        iterationsContentPair[1] = ""+gaConfig.getIterations();
        subSec2_content.add(iterationsContentPair);
        
        
        
    
        Object[] wrapper1 = new Object[2];
        wrapper1[0] = subSec1_header;
        wrapper1[1] = subSec1_content;
        
        Object[] wrapper2 = new Object[2];
        wrapper2[0] = subSec2_header;
        wrapper2[1] = subSec2_content;
        
        ArrayList<Object[]> retData = new ArrayList<>();
        retData.add(wrapper1);
        retData.add(wrapper2);
        
        return retData;
    }



	@Override
	public String testParameters() {
		return configurator.testParameters();
	}





}