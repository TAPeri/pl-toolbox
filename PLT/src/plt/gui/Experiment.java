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

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import plt.dataset.PreprocessedDataSet;
import plt.dataset.TrainableDataSet;
import plt.dataset.datareader.ObjectsOrderFormat;
import plt.dataset.preprocessing.FeaturePreprocessingInfo;
import plt.dataset.preprocessing.Ignoring;
import plt.dataset.preprocessing.PreprocessingOperation;
import plt.featureselection.FeatureSelection;
import plt.gui.algorithms.PLAlgorithm;
import plt.report.Report;
import plt.utils.TimeHelper;
import plt.validator.Validator;


/**
 *
 * Contains all necessary parameters and elements to run (or replicate) the experiment 
 *
 * @author Vincent Farrugia
 * @author Hector P. Martinez
 */
public class Experiment {
    
    
    public class FeaturesDataModel {
        private  SimpleStringProperty name;
        private SimpleBooleanProperty status;

        public FeaturesDataModel(String name, boolean status) {
            this.name = new SimpleStringProperty(name);
            this.status = new SimpleBooleanProperty(status);
        }
        
        public SimpleStringProperty nameProperty() { return this.name; }
        public SimpleBooleanProperty statusProperty() { return this.status; }

    }
    
    /*dataSet & status*/
    private ObjectsOrderFormat dataSet;
//    private ObjectProperty<ObjectsOrderFormat> dataSet;

    
    /* algorithm*/
    private ObjectProperty<PLAlgorithm> algorithm;
    
    /* validation*/
    private ObjectProperty<Validator> validatorSelection;
    //private BooleanProperty useValidator;
    //private StringProperty k;

    
    /* preprocessing*/
    private ObservableList<FeaturePreprocessingInfo> preprocessingOperations;//observable because it is displayed on preprocessing tab
    
    /* feature selection*/
   // private BooleanProperty useValidatorForFeatureSelection;
   // private StringProperty kForFeatureSelection;    
    private ObjectProperty<FeatureSelection> featureSelection;
    private ObjectProperty<PLAlgorithm> algorithmForFeatureSelection;
    private ObjectProperty<Validator> validatorForFeatureSelection;
    
    
    /* meta-data */
    private ObjectProperty<Calendar> expStartTimestamp;
    private ObjectProperty<Calendar> expCompleteTimestamp;
    
    /* property*/


    public ObjectsOrderFormat getDataset() { return this.dataSet; }


   
    public ObjectProperty<PLAlgorithm> algorithmProperty() { return this.algorithm; }
    //public BooleanProperty useValidatorProperty() { return this.useValidator; }
    
    public ObjectProperty<Validator> validatorProperty(){return this.validatorSelection;}
    
    public ObjectProperty<Validator> validatorForFeatureSelectionProperty() { return this.validatorForFeatureSelection; }
    
    //public StringProperty kProperty() { return this.k; }
   // public StringProperty kForFeatureSelectionProperty() {return this.kForFeatureSelection; }
    public ObjectProperty<PLAlgorithm> algorithmForFeatureSelectionProperty() { return this.algorithmForFeatureSelection; }
    public ObjectProperty<FeatureSelection> featureSelectionProperty() { return this.featureSelection; }
    public ObjectProperty<Calendar> expStartTimestampProperty() { return expStartTimestamp; }
    public ObjectProperty<Calendar> expCompleteTimestampProperty() { return expCompleteTimestamp; }

    
    
    
    public ObservableList<FeaturePreprocessingInfo> initialisePreprocessing()
    {
    	preprocessingOperations =  FXCollections.observableArrayList();
        
        int numOfFeatures = dataSet.getNumberOfFeatures();
        
        for(int i=0; i<numOfFeatures; i++)
        {                        
            preprocessingOperations.add(new FeaturePreprocessingInfo(i, true, dataSet.getFeatureName(i), 0, dataSet.isNumeric(i)));
        }
        
        return preprocessingOperations;
    }
    
    public ObservableList<FeaturePreprocessingInfo> getPreprocessingOperations(){
    	return preprocessingOperations;
    };

    
    public Experiment() {
        
      //  final Experiment self = this;
        

        
       // this.dataSet = new SimpleObjectProperty<>();
        //self.dataSet.set(new ObjectsOrderFormat());
        this.dataSet = new ObjectsOrderFormat();
        
       // this.preprocessingOperations = new SimpleObjectProperty<>();
       // this.ignoredFeatures = new SimpleObjectProperty<>();
        this.algorithm = new SimpleObjectProperty<>();
       // this.useValidator = new SimpleBooleanProperty(false);
       // this.useValidatorForFeatureSelection = new SimpleBooleanProperty(false);
     //   this.k = new SimpleStringProperty();
       // this.kForFeatureSelection = new SimpleStringProperty();
        this.validatorForFeatureSelection = new SimpleObjectProperty<>();
        this.featureSelection = new SimpleObjectProperty<>();
        this.algorithmForFeatureSelection = new SimpleObjectProperty<>();
        
        this.validatorSelection =  new SimpleObjectProperty<>();
        
        this.expStartTimestamp = new SimpleObjectProperty<>();
        this.expCompleteTimestamp = new SimpleObjectProperty<>();
        

        
        
        System.err.println("Removed parsing listeners from here");
        /*this.isReadyToParseIdata.addListener(new ChangeListener<Boolean>() {
                
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue)
            {
                if(newValue)
                {
                    ObjectsOrderFormat internalDataSet = self.dataSet.get();
                    internalDataSet.setIData(self.idata.getValue(),self.idataSeparator.getValue());
                    
                    DataFileParseStatus updatedParseStatus = internalDataSet.parseIData();
                    
                    if(internalDataSet.containsOrderData())
                    {
                        updatedParseStatus = internalDataSet.parseOrderData();
                    }
                    
                    self.dataSetParseStatus.set(updatedParseStatus); 
                    
                    self.dataSet.set(internalDataSet);
                    
                    self.hasPerformedAParseStage.setValue(true);
                    
                    if((internalDataSet.containsIData())&&(internalDataSet.containsOrderData()))
                    {
                        self.hasParsedBothIdataNOrder.setValue(true);
                    }
                }
            }
        });
        
        this.isReadyToParseOrder.addListener(new ChangeListener<Boolean>() {
            
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue)
            {
                if(newValue)
                {
                    ObjectsOrderFormat internalDataSet = self.dataSet.get();
                    internalDataSet.setOrderData(self.order.getValue(),
                                                 self.orderSeparator.getValue(),
                                                 self.orderSkipLines.getValue(),
                                                 self.orderSkipColumns.getValue());
                    
                    DataFileParseStatus updatedParseStatus = internalDataSet.parseOrderData();
                    self.dataSetParseStatus.set(updatedParseStatus);
                    
                    self.dataSet.set(internalDataSet);
                    
                    self.hasPerformedAParseStage.setValue(true);
                    
                    if((internalDataSet.containsIData())&&(internalDataSet.containsOrderData()))
                    {
                        self.hasParsedBothIdataNOrder.setValue(true);
                    }
                }
            }
        });
        
        
        
        
        this.hasParsedBothIdataNOrder.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                if (newValue) 
                {
                    self.hasParsedBothIdataNOrder.set(false);
                    
                    self.isReadyToUseDataSet.set(false);
                    self.isParsing.set(true);
                    
                    Task<Boolean> task = new Task<Boolean>() {

                        @Override
                        protected Boolean call() throws Exception {

                            boolean result;               
                            
                            
                            // Assumes parsing has been done previously.
                            // This part only checks if the parsing was successful.
                            

                            result = self.dataSetParseStatus.get().overallParseResult;
                                

                            if (result) {
                                PreprocessingOperation[] po = new PreprocessingOperation[self.dataSet.get().getNumberOfFeatures()];
                                boolean[] ignored = new boolean[self.dataSet.get().getNumberOfFeatures()];

                                for (int i=0; i<po.length; i++) {
                                    if (!self.dataSet.get().isNumeric(i)) 
                                        po[i] = new Nominal(self.dataSet.get(),i);
                                    else 
                                        po[i] = new Numeric(self.dataSet.get(), i);
                                    
                                    ignored[i] = false;
                                }
                                
                                self.preprocessingOperations.set(po);
                                self.ignoredFeatures.set(ignored);
                            }
                            return result;
                        }
                    };
                    
                    task.valueProperty().addListener(new ChangeListener<Boolean>() {
                        @Override
                        public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                            self.isParsing.set(false);
                            self.isReadyToUseDataSet.set(t1);
                        }
                    });
                    new Thread(task).start();
               }
            }
        });
        */
   }
    
  

    
  
    
    
   
   public Report start() {
       // Record Experiment Start Timestamp
       this.expStartTimestamp.setValue(Calendar.getInstance());
       Logger.getLogger("plt.logger").log(Level.INFO, "Execution Start: "+ TimeHelper.createTimestampStr(this.expStartTimestamp.get()));
       
       ExecutionProgress.reset();
       ExecutionProgress.signalBeginTask("Setting Dataset",1.0f/10.0f);
               
       PreprocessingOperation[] ops = new PreprocessingOperation[this.preprocessingOperations.size()];
       
       
       for (int i=0; i < ops.length ; i++)
           if (preprocessingOperations.get(i).getIncludeFlag()) 
               ops[i] = preprocessingOperations.get(i).getPreprocessingOptions().getSelected();
           else
               ops[i] = new Ignoring( i);

       TrainableDataSet t = new PreprocessedDataSet(this.dataSet, ops);
       
       
       this.algorithm.get().setDataSet(t);

       ExecutionProgress.incrementTaskProgByPerc(1.0f);
       ExecutionProgress.signalTaskComplete();
       
       
       
      /* Validator validator = new NoValidation();
          
       if (this.useValidator.get()) {
        int d = Integer.parseInt(this.k.get());
        validator = new KFoldCV(d);
       }*/
       
       String tmpTName = "";
       if(this.featureSelectionProperty().get() != null) { tmpTName = "Feature Selection"; }
       ExecutionProgress.signalBeginTask(tmpTName,1.0f/9.0f);
      
       if (this.featureSelectionProperty().get() != null) {
           
           
           Logger.getLogger("plt.logger").log(Level.INFO, "running feature selection");

           FeatureSelection f = this.featureSelectionProperty().get();
          // Validator validatorForFS = new NoValidation();
          // if (this.useValidatorForFeatureSelection.get()) {
          //     int d = Integer.parseInt(this.kForFeatureSelection.get());
          //     validatorForFS = new KFoldCV(d);
          // }
           
           PLAlgorithm algoFS = this.algorithmForFeatureSelection.get();
           algoFS.setDataSet(t);
           
           f.run(validatorForFeatureSelection.get(), algoFS);
           
            Logger.getLogger("plt.logger").log(Level.INFO, "selected feature: \n"+f.getResult());

           this.algorithm.get().setSelectedFeature(f.getResult());
       }
       
       ExecutionProgress.incrementTaskProgByPerc(1.0f);
       ExecutionProgress.signalTaskComplete();
       
       
       
       ExecutionProgress.signalBeginTask("Experiment",1);
       Logger.getLogger("plt.logger").log(Level.INFO, "running experiment - dataset: \n"+t);
       Report retRep = this.algorithm.get().createModelWithValidation(validatorSelection.get());     
       ExecutionProgress.signalTaskComplete();
       
       
       // Record Experiment Complete Timestamp
       this.expCompleteTimestamp.setValue(Calendar.getInstance());
       
       
       Logger.getLogger("plt.logger").log(Level.INFO, "Execution End: "+TimeHelper.createTimestampStr(this.expCompleteTimestamp.get()));
       Logger.getLogger("plt.logger").log(Level.INFO, "Total Duration: "+TimeHelper.calculateDuration(this.expStartTimestamp.get(),this.expCompleteTimestamp.get()));
       Logger.getLogger("plt.logger").log(Level.INFO, "Average Accuracy Over Folds: "+((Math.round(retRep.getAVGAccuracy() * 100) * 1000) / 1000)+"%");
       
       return retRep;
   }
   

    
}
