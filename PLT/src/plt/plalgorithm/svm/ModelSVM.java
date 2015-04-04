package plt.plalgorithm.svm;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import plt.dataset.TrainableDataSet;
import plt.experiments.Experiment;
import plt.featureselection.SelectedFeature;
import plt.json.JsonObjIO;
import plt.model.Model;
import plt.plalgorithm.svm.libsvm_plt.RankSvmManager;
import plt.plalgorithm.svm.libsvm_plt.SVMDataStore;
import plt.report.SvmModelFileData;

public class ModelSVM extends Model {

	@Override
	public Model clone() throws CloneNotSupportedException {
		RankSvmManager svmMangCopy = (RankSvmManager)svmMang.clone();
		return new ModelSVM(svmMangCopy,this.getDataSet(),this.selectedFeature());
	}
	
	RankSvmManager svmMang;
	public ModelSVM(RankSvmManager para_rSVMMang,TrainableDataSet para_dataSet,  SelectedFeature para_selection){

		super(para_dataSet,para_selection);
		svmMang = para_rSVMMang;
	
	}
	
    @Override
    protected double calculatePreference(double[] features)
    {
        return svmMang.calculateUtility(features);
    }

    
    @Override
    public void save(File file, Experiment experiment, double accResult_specificModel, double accResult_averageOverFolds) throws IOException
    {
        
        try 
        {
         
            SVMDataStore svmDStore = svmMang.getDataForSVsAndAlphas(this.getDataSet());
            
            // Construct file data for chosen model.
            SvmModelFileData objToStore = new SvmModelFileData(file.getName(),
                                                               svmDStore,
                                                               this.getDataSet(),
                                                               this.selectedFeature(),
                                                               experiment,
                                                               accResult_specificModel,
                                                               accResult_averageOverFolds);
            
            // Store data to file as JSON.
            JsonObjIO jsonRW = new JsonObjIO();
            jsonRW.writeObjToFile(file.getAbsolutePath(), objToStore);
        }
        catch (Exception ex)
        {
           Logger.getLogger(RankSvm.class.getName()).log(Level.SEVERE,null,ex);
           throw ex;
        }
    }

}
