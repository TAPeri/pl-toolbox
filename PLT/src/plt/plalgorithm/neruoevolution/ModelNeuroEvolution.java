package plt.plalgorithm.neruoevolution;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import plt.dataset.TrainableDataSet;
import plt.featureselection.SelectedFeature;
import plt.gui.Experiment;
import plt.json.JsonObjIO;
import plt.model.Model;
import plt.plalgorithm.backpropagation.ModelBackpropagation;
import plt.plalgorithm.neruoevolution.NE.SimpleNeuralNetwork;
import plt.report.NNModelFileData;

public class ModelNeuroEvolution extends Model {
	
	SimpleNeuralNetwork network;
	
	public ModelNeuroEvolution(SimpleNeuralNetwork network, TrainableDataSet dataSet,  SelectedFeature selection){
		super(dataSet,selection);
		this.network = network;
	}
	
    /**
     * Only the neural network is cloned; dataset and features only the reference is copied
     */
	@Override
	public Model clone() throws CloneNotSupportedException {
		SimpleNeuralNetwork networkCopy =  (SimpleNeuralNetwork)network.clone();
		return new ModelBackpropagation(networkCopy,this.getDataSet(),this.selectedFeature());
	}

    @Override
    protected double calculatePreference(double[] features) {

        network.setInputs(features);
        double a = network.getOutputs()[0];
        return a;
    
    }

    
    
    @Override
    public void save(File file, Experiment experiment, double accResult_specificModel, double accResult_averageOverFolds) throws IOException{
        try {
         
            // Construct file data for chosen model.
            NNModelFileData objToStore = new NNModelFileData(file.getName(),
                                                             "NeuroEvolution",
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

}
