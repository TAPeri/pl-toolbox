package plt.gui.dataset;


import plt.gui.component.ModalPopup;

import java.io.File;
import java.util.List;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
import javafx.util.Callback;
import plt.dataset.DataParser;

/*
 * 
 * Pop-up with options to load datasets
 * 
 *  @author Hector P. Martinez
 *  @author Vincent Farrugia
 * 
 */
public class LoadingOptionsPopUp {

	
    TableView<List<String>> preview; //The list represents each of the features (not each of the samples)

	
	
    public  LoadingOptionsPopUp(File file,DataParser parser,EventHandler<MouseEvent> eventHandler,boolean featureNamesOption, Stage stage) {

        BorderPane mainPane = new BorderPane();

        VBox box = new VBox();
        mainPane.setCenter(box);

        	HBox options = new HBox();
        	preview = new TableView<List<String>>();
        	preview.setEditable(false);
	
        	box.getChildren().addAll(options,preview);
        	options.getChildren().addAll(
        			separatorSelector(parser),
        			skipLineSelector(parser),
        			selectID(parser));
        	
        	if(featureNamesOption)
        		options.getChildren().add(featureNames(parser));

        	ModalPopup modalPopup = new ModalPopup();
        	modalPopup.show(mainPane, stage.getScene().getRoot(), eventHandler, null, false);
        	
        	
}
    
	private Node skipLineSelector(final DataParser parser) {

		GridPane selectorGrid = new GridPane();

		selectorGrid.add(new Label("Ignore first rows"), 0, 0);
		selectorGrid.add(new Label("Ignore first columns"), 0, 1);
		
		TextArea rows = new TextArea("0");
		rows.setPrefWidth(10);
		rows.setPrefHeight(1);
		selectorGrid.add(rows, 1, 0);
		
		rows.textProperty().addListener(new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String newValue) {
				
				try{
					int number = Integer.parseInt(newValue);
					parser.skipRows(number);
					updatePreview(parser);
					
				}catch(NumberFormatException ex){;}
			}
			
		});
		

		TextArea columns = new TextArea("0");
		columns.setPrefWidth(10);
		columns.setPrefHeight(1);
		selectorGrid.add(columns,1, 1);

		columns.textProperty().addListener(new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String newValue) {
				
				try{
					int number = Integer.parseInt(newValue);
					parser.skipColumns(number);
					updatePreview(parser);
					
				}catch(NumberFormatException ex){;}
			}
			
		});
		

		return selectorGrid;
	}


    
    
    
	private Node separatorSelector(final DataParser parser){
    	
		VBox separatorBox = new VBox();
	
			separatorBox.getChildren().add(new Label("Separator:"));

			final ToggleGroup tGroup = new ToggleGroup();

				RadioButton rBtn_commaSeparator = new RadioButton("Comma"); 
					rBtn_commaSeparator.setUserData(",");
					rBtn_commaSeparator.setToggleGroup(tGroup);
					separatorBox.getChildren().add(rBtn_commaSeparator);
	
					RadioButton rBtn_tabSeparator = new RadioButton("Tab");		
					rBtn_tabSeparator.setUserData("\t");
					rBtn_tabSeparator.setToggleGroup(tGroup);
					separatorBox.getChildren().add(rBtn_tabSeparator);
	
					RadioButton rBtn_spaceSeparator = new RadioButton("Space"); 
					rBtn_spaceSeparator.setUserData(" ");
					rBtn_spaceSeparator.setToggleGroup(tGroup);
					separatorBox.getChildren().add(rBtn_spaceSeparator);
	
					final RadioButton rBtn_customStrSeparator = new RadioButton();
					rBtn_customStrSeparator.setToggleGroup(tGroup);
					separatorBox.getChildren().add(rBtn_customStrSeparator);
	
					//Customizable label and used data for last item
					final Label lbl_customStrSeparator = new Label("Other");
					final TextField txt_customStrSeparator = new TextField("");
					txt_customStrSeparator.setPrefWidth(100);
	
					rBtn_customStrSeparator.setGraphic(lbl_customStrSeparator);
					rBtn_customStrSeparator.selectedProperty().addListener(new ChangeListener<Boolean>() {//If custom radio button selected,text area displayed
						@Override
						public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean newValue)
						{
							if(newValue) {  rBtn_customStrSeparator.setGraphic(txt_customStrSeparator);
							}else { rBtn_customStrSeparator.setGraphic(lbl_customStrSeparator);}
						}
					});

					txt_customStrSeparator.textProperty().addListener(new ChangeListener<String>(){//If custom text change, change user data

						@Override
						public void changed(ObservableValue<? extends String> arg0, String arg1, String newValue) {
							rBtn_customStrSeparator.setUserData( newValue);
						}
					});
	
					
					tGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){

						@Override
						public void changed( ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle newValue) {
							parser.setSeparator((String) newValue.getUserData());
							updatePreview(parser);
							
						}});
					
					tGroup.selectToggle(rBtn_commaSeparator);     
					return separatorBox;
	
}
	
	
	   private Node featureNames(final DataParser parser){
	    	
	    	VBox selectorBox = new VBox();

	    	CheckBox featuresInclued = new CheckBox("First line are feature names");
	    	selectorBox.getChildren().add(featuresInclued);
	    	
	    	featuresInclued.selectedProperty().addListener(new ChangeListener<Boolean>(){

				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean newValue) {
					parser.setFeaturesIncluded((boolean) newValue);
					updatePreview(parser);
					
				}
	    		
	    	});
	    	
	    	return selectorBox;
	    	
	    }
	    
	    private Node selectID(final DataParser parser) {

	    	VBox selectorBox = new VBox();
			
			final ToggleGroup tGroup = new ToggleGroup();

				RadioButton rBtn_Line = new RadioButton("ID is row number"); 
				rBtn_Line.setUserData(false);
				rBtn_Line.setToggleGroup(tGroup);
				selectorBox.getChildren().add(rBtn_Line);
	    	
				RadioButton rBtn_Column = new RadioButton("ID is first column"); 
				rBtn_Column.setUserData(true);
				rBtn_Column.setToggleGroup(tGroup);
				selectorBox.getChildren().add(rBtn_Column);
				
				tGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){

					@Override
					public void changed( ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle newValue) {
						parser.setIDcolumn((boolean) newValue.getUserData());
						updatePreview(parser);
						
					}});
				
				tGroup.selectToggle(rBtn_Line);    
				
				
	    	
	    	return selectorBox;
	    	
		}




	    
	    
	    private void updatePreview(DataParser parser){
	    	
	    	List<String> features = parser.getFeatureNames();
	    	
	    	ObservableList<List<String>> data = FXCollections.observableArrayList();
	        data.addAll(parser.getPreviewData());
	    	
	        preview.getItems().clear();
	        preview.getColumns().clear();
//	        preview.getItems().removeAll(preview.getItems());
	  //      preview.getColumns().removeAll(preview.getColumns());
	    	
	        for(int i = 0; i< features.size();i++){
	        	TableColumn<List<String>, String> tc = new TableColumn<>(features.get(i));
	        	final int colNo = i;
	        	        	
	        	tc.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
	                 @Override
	                 public ObservableValue<String> call(CellDataFeatures<List<String>, String> p) {
	                     return new SimpleStringProperty((p.getValue().get(colNo)));
	                 }
	             });
	        	 tc.setPrefWidth(90);
	             preview.getColumns().add(tc);
	        }
	    	preview.setItems(data);
	    	
	    }
	    
	    
	
	
	
}
