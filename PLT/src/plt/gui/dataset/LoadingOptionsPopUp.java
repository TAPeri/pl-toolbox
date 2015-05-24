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


package plt.gui.dataset;


import plt.gui.customcomponents.ModalPopup;

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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import plt.dataset.DataParser;

/**
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
 
        
        VBox box = new VBox();

        	HBox options = new HBox();
        	
        	options.getStyleClass().add("popUpOptions");
        	
        	preview = new TableView<List<String>>();
        	preview.getStyleClass().add("popUpPreview");

        	box.getChildren().addAll(options,preview);
        	
        		preview.setEditable(false);
	
        		options.getChildren().addAll(
        			separatorSelector(parser),
        			skipLineSelector(parser),
        			selectID(parser));
        	
        	if(featureNamesOption)
        		options.getChildren().add(featureNames(parser));

        	ModalPopup modalPopup = new ModalPopup();
        	modalPopup.show(box, stage.getScene().getRoot(), eventHandler, null, false);
        	
        	
}
    
	private Node skipLineSelector(final DataParser parser) {

		GridPane selectorGrid = new GridPane();

		selectorGrid.add(new Label("Ignore first  "), 0, 0);
		selectorGrid.add(new Label("Ignore first  "), 0, 1);
		
		TextArea rows = new TextArea("0");
		rows.setPrefWidth(1);
		rows.setPrefHeight(0.5);
		
		selectorGrid.add(rows, 1, 0);
		selectorGrid.add(new Label("  rows"), 2, 0);
		selectorGrid.add(new Label("  columns"), 2, 1);
		
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
		
		columns.setPrefWidth(2);
		columns.setPrefHeight(2);
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
