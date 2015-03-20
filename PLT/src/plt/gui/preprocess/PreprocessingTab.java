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

package plt.gui.preprocess;


import plt.dataset.preprocessing.FeaturePreprocessingInfo;
import plt.dataset.preprocessing.PreprocessingSelector;
import plt.gui.Experiment;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * GUI functionality to choose how to preprocess each feature (is nominal or numerical? normalisation schemes)
 *
 * @author Vincent Farugia
 * @author Hector P. Martinez
 */
public class PreprocessingTab extends Tab {

    final private Stage stage;
    private Experiment experiment;
    
    TableView<FeaturePreprocessingInfo> tvFeaturePre;
    ObservableList<FeaturePreprocessingInfo> tableDataSet;
    
    FeaturesPreview dataPreview;

    public PreprocessingTab(Stage s, Experiment e) {
        super();
        this.experiment = e;
        this.stage = s;
        dataPreview = new FeaturesPreview();
        
        //Create tab only when the dataset has been loaded
	    experiment.getDataset().addDataLoaderListener(new ChangeListener<Boolean>(){

				@Override
				public void changed(ObservableValue<? extends Boolean> arg0,
						Boolean arg1, Boolean arg2) {
					if(arg2){
						experiment.initialisePreprocessing();					

						setup();
					}
				}
		});
    }
    
    
    private void setup()
    {
        //final Stage localStage = this.stage;
        
        	final BorderPane bp = new BorderPane();
        	this.setContent(bp);
        
        		final VBox tmpVBox = new VBox(10);
        		bp.setCenter(tmpVBox);
        		tmpVBox.setAlignment(Pos.CENTER);
        		
        		 	final ScrollPane sPane = new ScrollPane();
 			        stage.heightProperty().addListener(new ChangeListener<Number>() {

 			            @Override
 			            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1){
 			                
 			                sPane.setPrefHeight(t1.doubleValue() * 0.7);
 			            }
 			            
 			        });
 			        
        		 	tmpVBox.getChildren().addAll(sPane);
        		 	
        		 	 	
        		 	final Pane wPane = new Pane();
        		 	tmpVBox.getChildren().addAll(new Group(wPane));
        		
    		 			final GridPane innerPane = new GridPane();
    		 			innerPane.setVisible(true);
    		 			sPane.setContent(innerPane);
        		 		wPane.getChildren().add(innerPane);
                		    
	
        		 			Pane tmpPane2 = new Pane();
        		 			innerPane.add(tmpPane2, 1, 0);
        		 			
        		 				VBox fPreviewPane = new VBox(10);
        		 				tmpPane2.getChildren().add(fPreviewPane);
        		 				
        		 		        	Label lblFeaturePreview = new Label("Feature preview");
        		 		        
        		 		        	Pane wrapperPane2 = new Pane();
        		 		        
        		 		        		
        		 		        		wrapperPane2.getChildren().add(dataPreview.getContent());
        		 		        		//wrapperPane2.getStyleClass().add("modulePane1Child");
        		 		        
        		 		        		fPreviewPane.getChildren().addAll(lblFeaturePreview,wrapperPane2);
        		 		        		        		 		        		

        		 		              
        	        		 			Pane tmpPane1 = new Pane();
        	        		 			innerPane.add(tmpPane1, 0, 0);
        	        		 			
        	        		 				VBox fListTViewPane = new VBox(10);
        	        		 				tmpPane1.getChildren().add(fListTViewPane);
        	        		 				
        	        		 					HBox padBox = new HBox();

        	        		 					final Label lblTViewHeader = new Label("Available features");
        	        		 					
        	        		 					Pane wrapperPane = new Pane();
        	        		 			        
        	        		 					
        	        		 			        	GridPane effectAllGPane = buildTable();
        	        		 			        			
        	        		 			        	tableDataSet = experiment.getPreprocessingOperations();
        	        		 			        	tvFeaturePre.setItems(tableDataSet);
        	        		 			        	wrapperPane.getChildren().add(tvFeaturePre);
        	        		 			        
        	        		 			        fListTViewPane.getChildren().addAll(lblTViewHeader, effectAllGPane, wrapperPane, padBox);
                		 		        		
        	        		 			        if(dataPreview.table.getItems().size() != 0)
                		 		        		{
                		 		        			tvFeaturePre.getSelectionModel().select(0);
                		 		        		}		
        	        		 			        
        	        		 			        tvFeaturePre.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FeaturePreprocessingInfo>(){

        	        		 			            @Override
        	        		 			            public void changed(ObservableValue<? extends FeaturePreprocessingInfo> ov, FeaturePreprocessingInfo t, FeaturePreprocessingInfo t1) {
        	        		 			            	if(t1!=null)
        	        		 			            		dataPreview.refreshTable(experiment.getDataset(), t1.getPreprocessingOptions().getSelected(),t1.getFeatureIdx());
        	        		 			            	else
        	        		 			            		System.err.println("SelectedItem == null");
        	        		 			            }
        	        		 			            
        	        		 			        });
        		 		        		
        	        		 		
        		 		 
innerPane.setAlignment(Pos.CENTER);
        		 
fListTViewPane.setPadding(new Insets(10));
fListTViewPane.setAlignment(Pos.CENTER);
fListTViewPane.getStyleClass().add("modulePane1");   
        		        
fPreviewPane.setPadding(new Insets(5));
fPreviewPane.setAlignment(Pos.CENTER);
fPreviewPane.getStyleClass().add("modulePane1");    		        
        		        
innerPane.setHgap(100);
sPane.setStyle("-fx-background-color: transparent;"); // Hide the scrollpane gray border.
sPane.setPrefSize(880,600);
        
        
padBox.setAlignment(Pos.CENTER);
padBox.setPadding(new Insets(5));
        
        
effectAllGPane.setPadding(new Insets(10,2,10,0));
effectAllGPane.setStyle("-fx-border-radius: 1; -fx-border-color: black");

//GridPane.setHalignment(chkIncludeAll, HPos.CENTER);
//GridPane.setValignment(chkIncludeAll, VPos.CENTER);
              
Font headerFont = Font.font("BirchStd", FontWeight.BOLD, 15);        
lblTViewHeader.setFont(headerFont);
 
lblFeaturePreview.setFont(headerFont);

//lblAllFeatures.setFont(headerFont);
//GridPane.setHalignment(lblAllFeatures, HPos.CENTER);
//GridPane.setValignment(lblAllFeatures, VPos.CENTER);
        
//GridPane.setHalignment(btnPreProTypeAll, HPos.LEFT);
//GridPane.setValignment(btnPreProTypeAll, VPos.CENTER);
 
effectAllGPane.getColumnConstraints().add(new ColumnConstraints(70));
effectAllGPane.getColumnConstraints().add(new ColumnConstraints(180));
effectAllGPane.getColumnConstraints().add(new ColumnConstraints(148));
    
     
    }
    
    
    private GridPane buildTable(){
    	
    	System.out.println("experiment.ignoredFeaturesProperty().get()[rowNum] = !newValue; is not updated");
    	
    	GridPane output = new GridPane();

     		CheckBox chkIncludeAll = new CheckBox();
     		chkIncludeAll.setSelected(true);
     		output.add(chkIncludeAll, 0, 0);
     	
     		Label lblAllFeatures = new Label("Include all");
     		output.add(lblAllFeatures, 1, 0);
             
     		final Button btnPreProTypeAll = new Button("Preprocess all");
     		btnPreProTypeAll.setPrefWidth(180);
     		output.add(btnPreProTypeAll, 2, 0);  
     		
    	
     		tvFeaturePre =	new TableView<FeaturePreprocessingInfo>();
     		tvFeaturePre.setPrefSize(400, 400);
     		tvFeaturePre.setEditable(true);        

     			TableColumn<FeaturePreprocessingInfo, Boolean> includeSel = new TableColumn<FeaturePreprocessingInfo, Boolean>("Include?");
     			TableColumn<FeaturePreprocessingInfo,String> featureName = new TableColumn<FeaturePreprocessingInfo,String>("Feature");
     			TableColumn<FeaturePreprocessingInfo,PreprocessingSelector> preprocOperator = new TableColumn<FeaturePreprocessingInfo,PreprocessingSelector>("Preprocessing type");
     			tvFeaturePre.getColumns().addAll(includeSel,featureName,preprocOperator); 
		
		
     			includeSel.setPrefWidth(70);
     			//The values all the column (all the same)
     			includeSel.setCellValueFactory(new PropertyValueFactory<FeaturePreprocessingInfo, Boolean>("includeFlag"));//before rowID
     			
     			includeSel.setCellFactory(CheckBoxTableCell.forTableColumn(includeSel));
     			
     			includeSel.setEditable(true);
     			
     		
	        
	    featureName.setPrefWidth(180);
	    featureName.setCellValueFactory(new PropertyValueFactory<FeaturePreprocessingInfo,String>("featureName"));
	      
	        preprocOperator.setPrefWidth(148);
	        preprocOperator.setCellValueFactory(new PropertyValueFactory<FeaturePreprocessingInfo,PreprocessingSelector>("preprocessingOptions"));
	        preprocOperator.setCellFactory(new Callback<TableColumn<FeaturePreprocessingInfo,PreprocessingSelector>,TableCell<FeaturePreprocessingInfo,PreprocessingSelector>>(){       

	            @Override
	            public TableCell<FeaturePreprocessingInfo, PreprocessingSelector> call(TableColumn<FeaturePreprocessingInfo, PreprocessingSelector> p)
	            {
	            	
	            	
	                TableCell<FeaturePreprocessingInfo, PreprocessingSelector> cell = new TableCell<FeaturePreprocessingInfo, PreprocessingSelector>(){

	                	@Override
	                	public void updateItem(final PreprocessingSelector item, boolean empty) 
	                    {
	                        	if(item!=null)
	                        	{
	                        		
	                        		final Button btnPreProSelection;

	                        		btnPreProSelection = new Button();
	                        		
	                        		btnPreProSelection.textProperty().bind(item.getPreProName());
	                           
	                        		btnPreProSelection.setPrefWidth(150);
	                        		btnPreProSelection.setOnAction(new EventHandler<ActionEvent>() {

	                        			@Override
	                        			public void handle(ActionEvent t) {
	                                	
	                        				ProcessingPopup p = new ProcessingPopup(item);//rowNum, btnPreProSelection, experiment);
	                                    //!experiment.getDataset().isNumeric(item
	                        				p.show(stage.getScene().getRoot(), new EventHandler<MouseEvent>() {

	                        					@Override
	                        					public void handle(MouseEvent t) {

	                        						tvFeaturePre.getSelectionModel().select( getTableRow().getIndex());
	                        						dataPreview.refreshTable(experiment.getDataset(),tableDataSet.get( getTableRow().getIndex()).getPreprocessingOptions().getSelected(),getTableRow().getIndex());

	                        					}
	                        				});
	                        			}
	                        		});
	                           	                           
	                        		setGraphic(btnPreProSelection);                                       
	                        	}
	                    }
	                };
	                cell.setAlignment(Pos.CENTER);
	                return cell;
	            }


	        });
	        
	     
	        chkIncludeAll.selectedProperty().addListener(new ChangeListener<Boolean>() {
	                                
	            @Override
	            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean newValue) 
	            {
	            	if(newValue)
	            	for(FeaturePreprocessingInfo feature : tableDataSet){
	            		
	            		feature.setIncludeFlag(true);
	            	}

	            }
	       });
	        
	        
	        
	        btnPreProTypeAll.setOnAction(new EventHandler<ActionEvent>()
	        {

	            @Override
	            public void handle(ActionEvent t) 
	            {
	                        
	                ProcessingAllPopup p = new ProcessingAllPopup();//btnPreProTypeAll, experiment,tableDataSet);
	                p.show(stage.getScene().getRoot(), new EventHandler<MouseEvent>()
	                {

	                    @Override
	                    public void handle(MouseEvent t)
	                    {
	                        
	                        tvFeaturePre.getSelectionModel().select(0);
	                        dataPreview.refreshTable(experiment.getDataset(),tableDataSet.get(0).getPreprocessingOptions().getSelected(), 0);
	                    }
	                },tableDataSet);
	                
	                
	            }
	        });    
	        
	        return output;
    }
    
}
   