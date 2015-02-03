package plt.gui;

import java.util.List;

import plt.dataset.preprocessing.PreprocessingOperation;
import javafx.beans.property.SimpleStringProperty;

public class PreprocessingSelector {

	//List<PreprocessingOperation> options;//need  copy for the parameters
	private boolean isNumeric;
    
    private PreprocessingOperation preprocessing;
    
    private final SimpleStringProperty selectedText;

	
	public PreprocessingSelector(int selected,boolean numeric){
		
		this.isNumeric = numeric;
		preprocessing = this.getOptions().get(selected);
		selectedText = new SimpleStringProperty(preprocessing.getOperationName());

	}
	
	public SimpleStringProperty getPreProName(){
		return selectedText;
	}
	
	
	public String getCurrent(){
		return selectedText.get();
	}

	
	public List<PreprocessingOperation> getOptions(){
		return PreprocessingOperation.getAvailableOperations(isNumeric);
		//return options;
	}
	
	public void setSelected(int s){
		preprocessing = getOptions().get(s);
		selectedText.set(preprocessing.getOperationName() );
	}
	
	public PreprocessingOperation getSelected(){
		return preprocessing;
	}
	
	public boolean getIsNumeric(){
		return isNumeric;
	}
	
}
