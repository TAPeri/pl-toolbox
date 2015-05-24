package plt.dataset.preprocessing;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;



/**
*
* Preprocessing options selected for an input feature
*
* @author Vincent Farrugia
* @author Luca Querella
*/
public class FeaturePreprocessingInfo
{
    private int featureIdx;
    private final BooleanProperty includeFlag;
    private final SimpleStringProperty featureName;
    private final SimpleObjectProperty<PreprocessingSelector> preprocessingOptions;
    
    public FeaturePreprocessingInfo(int para_rowID,
                                   boolean para_includeFlag,
                                   String para_featureName,
                                   int para_currPreProOpName,
                                   boolean isNumeric)
    {
        this.featureIdx = para_rowID;
        this.includeFlag = new SimpleBooleanProperty(para_includeFlag);
        this.featureName = new SimpleStringProperty(para_featureName);

        this.preprocessingOptions = new SimpleObjectProperty<PreprocessingSelector>(new PreprocessingSelector(para_currPreProOpName,isNumeric));
    
    }
    
    public int getFeatureIdx()
    {
        return featureIdx;
    }
    
    public boolean getIncludeFlag()
    {
        return includeFlag.get();
    }
    
    public String getFeatureName()
    {
        return featureName.get();
    }
    
    public PreprocessingSelector getPreprocessingOptions()
    {
        return preprocessingOptions.get();
    }
    
    public String getCurrPreProOpName()
    {
        return preprocessingOptions.get().getCurrent();
    }
    
    public BooleanProperty includeFlagProperty(){
    	return includeFlag; 
    }
    
    
    public void setFeatureID(int para_rowID)
    {
        featureIdx = para_rowID;
    }
    
    public void setIncludeFlag(boolean para_applyPreProFlag)
    {
        includeFlag.set(para_applyPreProFlag);
    }
    
    public void setFeatureName(String para_featureName)
    {
        featureName.set(para_featureName);
    }
    
    public void setPreprocessingOptions(PreprocessingSelector para_currPreProOpName)
    {
        preprocessingOptions.set(para_currPreProOpName);
    }
    
    public void setCurrPreProOpName(int para_currPreProOpName)
    {
        preprocessingOptions.get().setSelected(para_currPreProOpName);
    }
}