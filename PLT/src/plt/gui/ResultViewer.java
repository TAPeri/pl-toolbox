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

package plt.gui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import plt.Experiment;
import plt.featureselection.NBest;
import plt.featureselection.SFS;
import plt.gui.customcomponents.ModalPopup;
import plt.plalgorithm.Model;
import plt.report.Report;
import plt.validator.KFoldCV;
import plt.validator.NoValidation;

/**
 * GUI element that shows the summary of an experiment
 * @author Vincent Farrugia
 */
public class ResultViewer {
    Experiment experiment;
    Report report;
    
    public ResultViewer(Experiment experiment, Report report) {
        this.experiment = experiment;
        this.report = report;
    }
    
    public void show(final Stage stage) {
        
        final Parent parent = stage.getScene().getRoot();
         ModalPopup p = new ModalPopup();
         
         
         BorderPane mainBPane = new BorderPane();
         mainBPane.setPadding(new Insets(20));
         
         Font headerFont = Font.font("BirchStd", FontWeight.BOLD, 20);
         Label lblReportHeader = new Label("Experiment Report");
         lblReportHeader.setFont(headerFont);      
         
         Font subsectionHeaderFont = Font.font("BirchStd", FontWeight.BOLD, 15);
         
        // int maxPathStrWidth = 30;
         
         BorderPane bpDatasetUsed = new BorderPane();
         bpDatasetUsed.setStyle("-fx-border-radius: 1; -fx-border-color: black");
         Label lblDatasetUsedHeader = new Label("Dataset Used");
         lblDatasetUsedHeader.setFont(subsectionHeaderFont);
         BorderPane.setAlignment(lblDatasetUsedHeader, Pos.CENTER);
         bpDatasetUsed.setTop(lblDatasetUsedHeader);
         
         VBox innerPaneDatasetUsed = new VBox();
         innerPaneDatasetUsed.setPadding(new Insets(20,10,10,10));
         
         innerPaneDatasetUsed.getChildren().add(new Label(experiment.getDataset().getParsingDetails()));
         
         
         bpDatasetUsed.setCenter(innerPaneDatasetUsed);
         
         
         BorderPane bpFeaturesIncluded = new BorderPane();
         bpFeaturesIncluded.setStyle("-fx-border-radius: 1; -fx-border-color: black");
         Label lblFeaturesIncludedHeader = new Label("User Included Features and Preprocessing");
         lblFeaturesIncludedHeader.setFont(subsectionHeaderFont);
         BorderPane.setAlignment(lblFeaturesIncludedHeader, Pos.CENTER);
         bpFeaturesIncluded.setTop(lblFeaturesIncludedHeader);
         
         VBox innerPaneFeaturesIncluded = new VBox();
         innerPaneFeaturesIncluded.setPadding(new Insets(20,10,10,10));
         GridPane gPaneFeaturesIncluded = new GridPane();
         gPaneFeaturesIncluded.setHgap(20);
         gPaneFeaturesIncluded.setVgap(5);
         
         int currRow = 0;

         for(int i=0; i<experiment.getPreprocessingOperations().size(); i++)
         {
             if(experiment.getPreprocessingOperations().get(i).getIncludeFlag())
             {
                 Label lblFeatureName = new Label(experiment.getDataset().getFeatureName(i));
                 Label lblPreProOp = new Label(experiment.getPreprocessingOperations().get(i).getCurrPreProOpName());
                 
                 gPaneFeaturesIncluded.add(lblFeatureName, 0, currRow);
                 gPaneFeaturesIncluded.add(lblPreProOp, 1, currRow);
                 currRow++;
             }
         }
         
         innerPaneFeaturesIncluded.getChildren().add(gPaneFeaturesIncluded);
         
         bpFeaturesIncluded.setCenter(innerPaneFeaturesIncluded);
         
         
         BorderPane bpFeatureSelection = new BorderPane();
         bpFeatureSelection.setStyle("-fx-border-radius: 1; -fx-border-color: black");
         Label lblFeatureSelectionHeader = new Label("Feature Selection");
         lblFeatureSelectionHeader.setFont(subsectionHeaderFont);
         BorderPane.setAlignment(lblFeatureSelectionHeader, Pos.CENTER);
         bpFeatureSelection.setTop(lblFeatureSelectionHeader);
         
         VBox innerPaneFeatureSelection = new VBox(10);
         innerPaneFeatureSelection.setPadding(new Insets(20,10,10,10));
         
         if(experiment.featureSelectionProperty().get() == null)
         {
             innerPaneFeatureSelection.getChildren().add(new Label("NONE"));
         }
         else
         {
            GridPane gPaneFeatureSelection = new GridPane();
            gPaneFeatureSelection.setHgap(20);
            gPaneFeatureSelection.setVgap(5);

            Label lblFeatureSelectionType = new Label("Feature Selection Type");
            gPaneFeatureSelection.add(lblFeatureSelectionType, 0, 0);

            String fselTName = "Unknown F Selection Type";
            if(experiment.featureSelectionProperty().get() instanceof NBest)
            {
                fselTName = "N-Best";
            }
            else if(experiment.featureSelectionProperty().get() instanceof SFS)
            {
                fselTName = "SFS";
            }

            gPaneFeatureSelection.add(new Label(fselTName), 1, 0);
            
            innerPaneFeatureSelection.getChildren().add(gPaneFeatureSelection);
            
            BorderPane fselPane = new BorderPane();
            Label lblFSelHeader = new Label("Selected Features");
            lblFSelHeader.setFont(subsectionHeaderFont);
            fselPane.setTop(lblFSelHeader);
            
            GridPane gPaneSelections = new GridPane();
            gPaneSelections.setHgap(20);
            gPaneSelections.setVgap(5);
            
            int[] selFeatures = experiment.featureSelectionProperty().get().getResult().getSelectedFeatures();
            for(int i = 0; i<selFeatures.length;i++)
            {
                String tmpFName = experiment.getTrainableDataset().getFeatureName(selFeatures[i]);
                gPaneSelections.add(new Label(tmpFName), 0, i);
            }
            
            fselPane.setCenter(gPaneSelections);
            innerPaneFeatureSelection.getChildren().add(fselPane);
            

            ArrayList<Object[]> reqFSelAlgProperties = experiment.algorithmForFeatureSelectionProperty().get().getProperties();
            for(int k=0; k<reqFSelAlgProperties.size(); k++)
            {
                
                Object[] tmpWrapper = reqFSelAlgProperties.get(k);
                String title = (String) tmpWrapper[0];
                ArrayList<String[]> dataPairs = (ArrayList<String[]>) tmpWrapper[1];

                Label lblTitle = new Label(title);
                lblTitle.setFont(subsectionHeaderFont);
                
                GridPane tmpGPane = new GridPane();
                tmpGPane.setHgap(20);
                tmpGPane.setVgap(5);
                
                for(int counter=0; counter<dataPairs.size(); counter++)
                {
                    String[] tmpDataPair = dataPairs.get(counter);

                    for(int c2=0; c2<tmpDataPair.length; c2++)
                    {
                       tmpGPane.add(new Label(tmpDataPair[c2]), c2, counter);                        
                    }
                }

                BorderPane tmpBPane = new BorderPane();
                BorderPane.setAlignment(lblTitle, Pos.CENTER_LEFT);
                tmpBPane.setTop(lblTitle);
                tmpBPane.setCenter(tmpGPane);
                
                innerPaneFeatureSelection.getChildren().add(tmpBPane);
            }
            
            
            BorderPane validationBPane = new BorderPane();
            Label lblValidationHeader = new Label("Validation");
            lblValidationHeader.setFont(subsectionHeaderFont);
            
            GridPane validationGPane = new GridPane();
            validationGPane.setHgap(20);
            validationGPane.setVgap(5);
            
            
            if(experiment.validatorForFeatureSelectionProperty().get() instanceof KFoldCV)
            {
                validationBPane.setTop(lblValidationHeader);
                        
                validationGPane.add(new Label("Type:"), 0, 0);
                validationGPane.add(new Label("K-Fold"), 1, 0);
                validationGPane.add(new Label("# Folds:"), 0, 1);
                validationGPane.add(new Label(  ""+((KFoldCV)experiment.validatorForFeatureSelectionProperty().get()).k)  , 1, 1);
                validationGPane.add(new Label("Fold size:"), 0, 2);
                
                String foldSizes = "";
                
                for(int f : ((KFoldCV)experiment.validatorForFeatureSelectionProperty().get()).getFolds())
                	foldSizes+= f+" ";
                	
                validationGPane.add(new Label(foldSizes), 1, 2);          
                
                
                validationBPane.setCenter(validationGPane);
            }
            else
            {
                validationGPane.add(lblValidationHeader, 0, 0);
                validationGPane.add(new Label("Training set"), 1, 0);
                
                validationBPane.setCenter(validationGPane);
            }
            innerPaneFeatureSelection.getChildren().add(validationBPane);
         }
                
         bpFeatureSelection.setCenter(innerPaneFeatureSelection);
         
         
         
         BorderPane bpPrefLearningMethods = new BorderPane();
         bpPrefLearningMethods.setStyle("-fx-border-radius: 1; -fx-border-color: black");
         Label lblPrefLearningMethodsHeader = new Label("Preference Learning Methods");
         lblPrefLearningMethodsHeader.setFont(subsectionHeaderFont);
         BorderPane.setAlignment(lblPrefLearningMethodsHeader, Pos.CENTER);
         bpPrefLearningMethods.setTop(lblPrefLearningMethodsHeader);
         
         VBox innerPanePrefLearningMethods = new VBox(10);
         innerPanePrefLearningMethods.setPadding(new Insets(20,10,10,10));
         
         if(experiment.algorithmProperty().get() == null)
         {
             innerPanePrefLearningMethods.getChildren().add(new Label("NONE"));
         }
         else
         {
             GridPane gPanePrefLearningMethods = new GridPane();
             gPanePrefLearningMethods.setHgap(20);
             gPanePrefLearningMethods.setVgap(5);

             
 
              
             ArrayList<Object[]> reqPrefMethodAlgProperties = experiment.algorithmProperty().get().getProperties();
             for(int k=0; k<reqPrefMethodAlgProperties.size(); k++)
             {
                 
 
                 Object[] tmpWrapper = reqPrefMethodAlgProperties.get(k);
                 String title = (String) tmpWrapper[0];
                 ArrayList<String[]> dataPairs = (ArrayList<String[]>) tmpWrapper[1];
 
                 Label lblTitle = new Label(title);
                 lblTitle.setFont(subsectionHeaderFont);
                 
                 GridPane tmpGPane = new GridPane();
                 tmpGPane.setHgap(20);
                 tmpGPane.setVgap(5);
                 
                 for(int counter=0; counter<dataPairs.size(); counter++)
                 {
                     String[] tmpDataPair = dataPairs.get(counter);
 
                     for(int c2=0; c2<tmpDataPair.length; c2++)
                     {
                        tmpGPane.add(new Label(tmpDataPair[c2]), c2, counter);                        
                     }
                 }
 
                 
                 BorderPane tmpBPane = new BorderPane();
                 BorderPane.setAlignment(lblTitle, Pos.CENTER_LEFT);
                 tmpBPane.setTop(lblTitle);
                 tmpBPane.setCenter(tmpGPane);
                
                 innerPanePrefLearningMethods.getChildren().add(tmpBPane);   
             }
             
             BorderPane validationBPane = new BorderPane();
             Label lblValidationHeader = new Label("Validation");
             lblValidationHeader.setFont(subsectionHeaderFont);
            
             GridPane validationGPane = new GridPane();
             validationGPane.setHgap(20);
             validationGPane.setVgap(5);
             
             
             if(experiment.validatorProperty().get() instanceof KFoldCV)
             {
                 validationBPane.setTop(lblValidationHeader);
                         
                 validationGPane.add(new Label("Type:"), 0, 0);
                 validationGPane.add(new Label("K-Fold"), 1, 0);
                 validationGPane.add(new Label("# Folds:"), 0, 1);
                 validationGPane.add(new Label(   ""+((KFoldCV)experiment.validatorProperty().get()).k  ), 1, 1);
                 validationGPane.add(new Label("Fold size:"), 0, 2);
                 String foldSizes = "";
                 
                 for(int f : ((KFoldCV)experiment.validatorProperty().get()).getFolds())
                 	foldSizes+= f+" ";
                 validationGPane.add(new Label(foldSizes), 1, 2);

                 
                 
                 validationBPane.setCenter(validationGPane);
             }
             else
             {
                 validationGPane.add(lblValidationHeader, 0, 0);
                 validationGPane.add(new Label("Training set"), 1, 0);
                 
                 validationBPane.setCenter(validationGPane);
             }
             innerPanePrefLearningMethods.getChildren().add(validationBPane);
             
         }
          
         bpPrefLearningMethods.setCenter(innerPanePrefLearningMethods);
         
         
         
         
         
         BorderPane bpGenModels = new BorderPane();
         bpGenModels.setStyle("-fx-border-radius: 1; -fx-border-color: black");
         Label lblGenModelsHeader = new Label("Generated Models");
         lblGenModelsHeader.setFont(subsectionHeaderFont);
         BorderPane.setAlignment(lblGenModelsHeader, Pos.CENTER);
         bpGenModels.setTop(lblGenModelsHeader);
         
         
         
         Label lblModelAccuracy = new Label("Accuracy Values for Models");
         lblModelAccuracy.setFont(subsectionHeaderFont);
         
         
         ObservableList<ModelTableDataRow> data = FXCollections.observableArrayList();
         
         double averageAccuracy = 0;
         if( experiment.validatorProperty().get() instanceof NoValidation)
         {
             data.add(new ModelTableDataRow(0, "Training Accuracy", this.report.resultAccurancy(0),0.0));
             averageAccuracy = this.report.resultAccurancy(0);
         }
         else
         {
            double tmpSum = 0;
            for (int i=0; i<this.report.numberOfResults();i++)
            {
               data.add(new ModelTableDataRow(i, "Fold "+(i+1), this.report.resultAccurancy(i) * 100, this.report.resultTrainingAccuracy(i)*100 ));
               tmpSum += this.report.resultAccurancy(i);
            }
            
            averageAccuracy = (tmpSum/this.report.numberOfResults());
         }
         averageAccuracy = ((averageAccuracy * 100)  );
         
         
         TableColumn col1 = new TableColumn("Model name");
         col1.setPrefWidth(100);
         col1.setCellValueFactory(new PropertyValueFactory("modelName"));
         TableColumn col2 = new TableColumn("Test accuracy (%)");
         col2.setPrefWidth(350); // Since ScrollPane width is 450.
         col2.setCellValueFactory(new PropertyValueFactory("modelAccuracy"));

         TableColumn col3 = new TableColumn("Training accuracy (%)");
         col3.setPrefWidth(350); // Since ScrollPane width is 450.
         col3.setCellValueFactory(new PropertyValueFactory("modelTrainingAccuracy"));
                  
         
         
         final TableView modelTView = new TableView(data);
         modelTView.setPrefHeight((this.report.numberOfResults() + 1) * 30);
         modelTView.getColumns().addAll(col1,col2,col3);
         
         GridPane gPaneAvrgAccuracy = new GridPane();
         gPaneAvrgAccuracy.setHgap(20);
         gPaneAvrgAccuracy.setVgap(5);
         Label lblAverageAccuracy = new Label("Average Accuracy: ");
         lblAverageAccuracy.setFont(subsectionHeaderFont);
         gPaneAvrgAccuracy.add(lblAverageAccuracy, 0, 0);
         gPaneAvrgAccuracy.add(new Label(""+averageAccuracy+"%"), 1, 0);
         
         VBox innerPaneGenModels = new VBox();
         innerPaneGenModels.setPadding(new Insets(20,10,10,10));
         innerPaneGenModels.getChildren().addAll(lblModelAccuracy, modelTView, gPaneAvrgAccuracy);
         
         bpGenModels.setCenter(innerPaneGenModels);
         
         
         
         
         final Button save = new Button("Save model");
         save.disableProperty().setValue(this.report.numberOfResults() != 1);
         

         modelTView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){

            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                save.disableProperty().setValue(false);               
            }   
         });
         
         save.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               int index = modelTView.getSelectionModel().selectedIndexProperty().get();
               if (index < 0) 
                   index = 0;
            
               Model m = report.getModel(index);
               
               
               
               try
               {
                    FileChooser fChooser = new FileChooser();
                    File file = fChooser.showSaveDialog(stage);
                    //m.save(file);
                    m.save(file,experiment,report.resultAccurancy(index),report.getAVGAccuracy());
                    
                    ModalPopup notification = new ModalPopup();
                    notification.show(new Label("The selected model has been saved."), stage.getScene().getRoot(),null,new Button("Ok"), 200,550,false);  
               }
               catch(IOException ex)
               {
                   ModalPopup notification = new ModalPopup();
                   notification.show(new Label("The selected model COULD NOT be saved!"), stage.getScene().getRoot(),null,new Button("Ok"), 200,550,false);  
               }
               
            }
         
         
         });
         
         
         VBox mContentVBox = new VBox(20);
         mContentVBox.setAlignment(Pos.CENTER);
         mContentVBox.setPadding(new Insets(10,10,10,20));
         mContentVBox.getChildren().add(bpDatasetUsed);
         mContentVBox.getChildren().add(bpFeaturesIncluded);
         mContentVBox.getChildren().add(bpFeatureSelection);
         mContentVBox.getChildren().add(bpPrefLearningMethods);
         mContentVBox.getChildren().add(bpGenModels);
         
         BorderPane cPane = new BorderPane();
         BorderPane.setAlignment(mContentVBox, Pos.CENTER);
         cPane.setCenter(mContentVBox);
         
         ScrollPane sPane = new ScrollPane();
         sPane.setPrefSize(450, 600);
         sPane.setContent(cPane);
         
         mainBPane.setTop(lblReportHeader);
         mainBPane.setCenter(sPane);
         
         //p.show(mainBPane, parent, null, save, new Button("Close"),500,600);
         p.show(mainBPane, parent, null, save, new Button("Close"),500,600,true);
    }
    
    public String adjustPathStrSpacing(String para_srcStr, int para_maxWidthInChars)
    {
        String retStr = "";
        
        if(! para_srcStr.contains(File.pathSeparator)) { return para_srcStr; }
        
        String[] splitStrs = para_srcStr.split(File.pathSeparator);
        int currRowWidth = 0;
        
        for(int i=0; i<splitStrs.length; i++)
        {
            String nxtSubStr = splitStrs[i];
            if( (currRowWidth + (nxtSubStr.length() + 1)) < para_maxWidthInChars )
            {
                // No need to add a newline.
                currRowWidth += (nxtSubStr.length() + 1);
            }
            else
            {
                // Add a newline.
                retStr += System.getProperty("line.separator");
                currRowWidth = 0;
            }
            retStr += (nxtSubStr + File.pathSeparator);
        }
        
        return retStr;
    }
    
    
    
    public static class ModelTableDataRow
    {
        
        private final SimpleIntegerProperty rowID;
        private final SimpleStringProperty modelName;
        private final SimpleDoubleProperty modelAccuracy;
        private final SimpleDoubleProperty modelTrainingAccuracy;
        
        public ModelTableDataRow(int para_rowID,
                                 String para_modelName,
                                 double para_modelAccuracy,
                                 double para_modelTrainingAccuracy)
        {
            this.rowID = new SimpleIntegerProperty(para_rowID);
            this.modelName = new SimpleStringProperty(para_modelName);
            this.modelAccuracy = new SimpleDoubleProperty(para_modelAccuracy);
            this.modelTrainingAccuracy = new SimpleDoubleProperty(para_modelTrainingAccuracy);
        }
        
        public int getRowID()
        {
            return rowID.get();
        }
        
        public String getModelName()
        {
            return modelName.get();
        }
        
        public double getModelAccuracy()
        {
            return modelAccuracy.get();
        }
        public double getModelTrainingAccuracy()
        {
            return modelTrainingAccuracy.get();
        }
        
        
        public void setRowID(int para_rowID)
        {
            rowID.set(para_rowID);
        }
        
        public void setModelName(String para_modelName)
        {
            modelName.set(para_modelName);
        }
        
        public void setModelAccuracy(double para_modelAccuracy)
        {
            modelAccuracy.set(para_modelAccuracy);
        }
        
        public void setModelTrainingAccuracy(double para_modelAccuracy)
        {
            modelTrainingAccuracy.set(para_modelAccuracy);
        }
        
    }
}
