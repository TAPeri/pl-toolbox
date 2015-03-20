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


package plt.gui.algorithms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import plt.dataset.TrainableDataSet;
import plt.featureselection.SelectedFeature;
import plt.gui.ExecutionProgress;
import plt.gui.Experiment;
import plt.gui.configurators.PLBackPropagationConfigurator;
import plt.json.JsonObjIO;
import plt.model.Model;
import plt.plalgorithm.backpropagation.NeuralNetwork;
import plt.plalgorithm.neruoevolution.NE.SimpleNeuralNetwork;
import plt.report.NNModelFileData;
import plt.utils.Preference;

/**
 *
 * @author Institute of Digital Games, UoM Malta
 */
public class PLBackPropagation extends PLAlgorithm {
    private PLBackPropagationConfigurator configurator;
    private NeuralNetwork network;
    
    
    public PLBackPropagation(){
    	
    	this(null,new PLBackPropagationConfigurator() {});
    }
    
    
    public PLBackPropagation(TrainableDataSet dataSet, PLBackPropagationConfigurator configurator) {
        super(dataSet);
        
        this.configurator = configurator;
        
    }
    
    @Override
    protected Model run() throws InterruptedException {
        
        Logger.getLogger("plt.logger").log(Level.INFO, "run PLBackPropagation");

        TrainableDataSet dataSet = this.getDataset();
        boolean trained = false;
       
        for (int i=0; i< this.configurator.getMaxNumberOfIterations() && !trained; i++) {
            ExecutionProgress.setTaskSubHeader("MLP Iteration "+(i+1));
            
            double error = 0;
            
            
            for (int j =0; j< dataSet.getNumberOfPreferences() ; j++) {

                Preference instance = this.getDataset().getPreference(j);
                                
                double[] featuresPreferred = this.getFeatureSelection().select( dataSet.getFeatures(instance.getPreferred()));
                double[] featuresOther= this.getFeatureSelection().select( dataSet.getFeatures(instance.getOther()));

                
                network.setInputs(featuresPreferred);
                double fPreferred = network.getOutputs()[0];
                network.setInputs(featuresOther);
                double fOther = network.getOutputs()[0];
                

                network.setInputs(featuresOther);
                error += network.backpropagate(false, fPreferred);
                network.setInputs(featuresPreferred);
                error += network.backpropagate(true, fOther);

            }
            
            error /= dataSet.getNumberOfPreferences()*2;
            trained =  error < this.configurator.getErrorThreeshold();
            
            network.applyDeltas();
            
            
            ExecutionProgress.incrementTaskProgByPerc(1.0f / (this.configurator.getMaxNumberOfIterations() * 1.0f));
            
            if((ExecutionProgress.needToShutdown())||(ExecutionProgress.hasInterruptRequest(1)))
            {
                ExecutionProgress.signalDeactivation(1);
                throw new InterruptedException();
            }
        }
        
        
        return modelForNetwork(network, this.getDataset(), this.getFeatureSelection());

    
    }

    @Override
    protected Model beforeRun() {
        int inputSize = this.getFeatureSelection().getSize();
        this.network = new NeuralNetwork(
                this.configurator.getTopology(inputSize), 
                this.configurator.getActivationsFunctions(), 
                this.configurator.getLearningRate()
                );
    
        return modelForNetwork(network, this.getDataset(), this.getFeatureSelection());
    }
    
    
        static private Model modelForNetwork(final SimpleNeuralNetwork network, TrainableDataSet dataSet, final SelectedFeature selection) {
        Model model = new Model(dataSet, selection) {

            @Override
            protected double calculatePreference(double[] features) {

                network.setInputs(features);
                double a = network.getOutputs()[0];
                return a;
            
            }

            /*@Override
            public void save(File file) throws IOException{
                try {
                    Date date=new Date() ;  
                    //BufferedWriter out = new BufferedWriter( new FileWriter (new File(file, "BP"+date.getTime())));
                    BufferedWriter out = new BufferedWriter(new FileWriter(file));
                    out.write("BP#"+ Arrays.toString(network.weights)+ "#" +Arrays.toString(network.topology));
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(PLNeuroEvolution.class.getName()).log(Level.SEVERE, null, ex);
                    
                    throw ex;
                }

            }*/
            
            @Override
            public void save(File file, Experiment experiment, double accResult_specificModel, double accResult_averageOverFolds) throws IOException{
                try {
                 
                    // Construct file data for chosen model.
                    NNModelFileData objToStore = new NNModelFileData(file.getName(),
                                                                     "Backpropagation",
                                                                     network,
                                                                     this.getDataSet(),
                                                                     this.selectedFeature(),
                                                                     experiment,
                                                                     accResult_specificModel,
                                                                     accResult_averageOverFolds);        
                    
                    // Store data to file as JSON.
                    JsonObjIO jsonRW = new JsonObjIO();
                    jsonRW.writeObjToFile(file.getAbsolutePath(), objToStore);
                }
                catch (Exception ex) {
                   Logger.getLogger(PLNeuroEvolution.class.getName()).log(Level.SEVERE,null,ex);
                   
                   throw ex;
                }
            }
            
        };
        
        return model;        
    }

    @Override
    public ArrayList<Object[]> getProperties() 
    {
        // Multilayer Perceptron Properties:
        
        String subSec1_header = "Multilayer Perceptron";
        ArrayList<String[]> subSec1_content = new ArrayList<>();
        
        String[] inpLayerContentPair = new String[3];
        inpLayerContentPair[0] = "Input Layer:";
        inpLayerContentPair[1] = ""+this.getFeatureSelection().getSize();
        inpLayerContentPair[2] = "N/A";
        subSec1_content.add(inpLayerContentPair);
        
        
        int inputSize = this.getFeatureSelection().getSize();
        int[] fullTopology = configurator.getTopology(inputSize);
        
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
        
        
        
        // Backprop Properties:
        String subSec2_header = "Backpropagation";
        ArrayList<String[]> subSec2_content = new ArrayList<>();
        
        
        String[] errorThresholdContentPair = new String[2];
        errorThresholdContentPair[0] = "Error Threshold:";
        errorThresholdContentPair[1] = ""+configurator.getErrorThreeshold();
        subSec2_content.add(errorThresholdContentPair);
        
        String[] learningRateContentPair = new String[2];
        learningRateContentPair[0] = "Learning Rate:";
        learningRateContentPair[1] = ""+configurator.getLearningRate();
        subSec2_content.add(learningRateContentPair);
        
        String[] maxIterationsContentPair = new String[2];
        maxIterationsContentPair[0] = "Epochs:";
        maxIterationsContentPair[1] = ""+configurator.getMaxNumberOfIterations();
        subSec2_content.add(maxIterationsContentPair);
        
        
        
        
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

    TitledPane[] ui;

	@Override
	public Node getUI() {

		ui = configurator.ui();
        HBox output = new HBox(5);
        for(int counter=0; counter<ui.length; counter++)
        {
            Node tmpContentNode = ui[counter].getContent();
            output.getChildren().add(tmpContentNode);
        }

		return output;
	}
}
