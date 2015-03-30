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

package plt.validator;

import java.util.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import plt.dataset.TrainableDataSet;
import plt.featureselection.SelectedFeature;
import plt.gui.ExecutionProgress;
import plt.gui.component.AdvanceTextField;
import plt.model.Model;
import plt.plalgorithm.PLAlgorithm;
import plt.report.Report;
import plt.utils.Preference;

/**
 *
 * @author Vincent Farrugia
 */
public class KFoldCV extends Validator {
    public int k;
    private StringProperty kProperty;
    private int[] validationSizes;
    
    public KFoldCV(){
    	this(3);
    }
    
    
    public int[] getFolds(){
    	return validationSizes;
    }
    
    public KFoldCV(int _k) {
        this.k = _k;
        

        kProperty = new SimpleStringProperty(""+k);
        kProperty.addListener(new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				try{
					k = Integer.parseInt(arg2);
				}catch(Exception ex){
					k = 3;
					kProperty.set("3");
				}
				
			}
        	
        });
    }
    

    @Override
    public Report runWithValidation(PLAlgorithm algorithm,TrainableDataSet originalDataSet,SelectedFeature features) {
        Report report = new Report();

        validationSizes = new int[k];
        
        List<Set<Integer>> groups = KFoldCV.createGroups(originalDataSet, this.k);
                
        for (int i=0; i<this.k;i++) {
           // Logger.getLogger("plt.logger").log(Level.INFO, "KFoldCV ["+(i+1)+"/"+k+"]");
            ExecutionProgress.signalBeginTask("KFold "+(i+1),(1.0f/(this.k * 1.0f)) * (i+1));
            
            TrainableDataSet validationDataSet = originalDataSet.subSet(groups.get(i));
            validationSizes[i] = validationDataSet.getNumberOfPreferences();
            Set<Integer> inputSet = new HashSet<>();
            for (int j=0; j<this.k;j++) {
                if (j!=i) {
                    inputSet.addAll(groups.get(j));
                }
            }
            
           TrainableDataSet candidateDataSet = originalDataSet.subSet(inputSet);
           
           //algorithm.setDataSet(candidateDataSet);
           Model model = algorithm.createModel(candidateDataSet,features);
           
           if(model == null) { return null; }
           double trainingAccuracy = 0.0;
           
           for (int z=0; z<candidateDataSet.getNumberOfPreferences(); z++) {
               Preference instance = candidateDataSet.getPreference(z);
               if (model.preference(instance.getPreferred(), instance.getOther())) {
            	   trainingAccuracy++;
               }
           }

           trainingAccuracy/=candidateDataSet.getNumberOfPreferences();
           
           
           double correctness = 0;
           for (int z=0; z<validationDataSet.getNumberOfPreferences(); z++) {
               Preference instance = validationDataSet.getPreference(z);
               if (model.preference(instance.getPreferred(), instance.getOther())) {
                   correctness++;
               }
           }
           correctness /= validationDataSet.getNumberOfPreferences();
           report.addExperimentResult(model, trainingAccuracy);
           report.addTestAccuracy(correctness, 0.0);
           ExecutionProgress.signalTaskComplete();
        }

        return report;
        
    }
    
    private static List<Set<Integer>> createGroups(TrainableDataSet t, int k) {
    	
        List<Set<Integer>> groupIDs = new ArrayList<>();
        int[] groupsSize = new int[k];        

        for (int i=0;i<k; i++)
            groupIDs.add(new HashSet<Integer>());

        List<Set<Preference>> atomicGroups = t.atomicGroups();
        for (int i = 0; i< atomicGroups.size();i++) {
            int candidate = 0;
            for (int j=0; j<k; j++)
                if (groupsSize[j] < groupsSize[candidate]) candidate = j;
            
            groupsSize[candidate] += atomicGroups.get(i).size();
            groupIDs.get(candidate).add(i);
        }
        
        return groupIDs;
    }
    
    @Override
    public String toString() {
        return "KFoldCV: {k:"+this.k+"}";
    }


	@Override
	public Node getUI() {
		
		BorderPane kBPane = new BorderPane();
          
      	Label lblCrossValidationHeader = new Label("k-fold cross validation");
      	kBPane.setLeft(lblCrossValidationHeader);
      
      	HBox cntentBx = new HBox(20);
      	kBPane.setRight(cntentBx); 
      	
      		GridPane validatorContentGPane = new GridPane();
      		cntentBx.getChildren().add(validatorContentGPane);
      	
      			Label kLabel = new Label("k:");
      			validatorContentGPane.add(kLabel, 0, 0);
      			//kLabel.visibleProperty().bind(validatorMPane.choiceBox.getSelectionModel().selectedIndexProperty().isEqualTo(1));
	
      			TextField k  = new AdvanceTextField("[0-9]", "3");
      			//k.visibleProperty().bind(kLabel.visibleProperty());
      			validatorContentGPane.add(k, 1, 0);
		
      			this.kProperty.bind(k.textProperty());
		
		//cntentBx.getChildren().addAll(kLabel,k);		
			
//Should move this to CSS   	
kBPane.getStyleClass().add("modulePane2Child");
Font headerFont = Font.font("BirchStd", FontWeight.BOLD, 15);
lblCrossValidationHeader.setFont(headerFont);
BorderPane.setAlignment(lblCrossValidationHeader, Pos.CENTER);        
k.setPrefWidth(30);     			
validatorContentGPane.setPadding(new Insets(20));
validatorContentGPane.setHgap(15);
validatorContentGPane.setVgap(12);
			
		return kBPane;
	}

}
