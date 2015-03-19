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

import java.util.ArrayList;
import java.util.Arrays;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import plt.featureselection.examples.NBest;
import plt.gui.component.ModalPopup;
import plt.gui.configurators.PLRankSvmConfigurator;
import plt.gui.dataset.DataSetTab;
import plt.plalgorithm.neruoevolution.PLNeuroEvolutionConfigurator;
import plt.gui.help.Tab1Help;
import plt.gui.help.Tab2Help;
import plt.gui.help.Tab3Help;
import plt.gui.help.Tab4Help;
import plt.plalgorithm.neruoevolution.GA.GeneticAlgorithmConfigurator;
import plt.plalgorithm.neruoevolution.PLNeuroEvolution;
import plt.plalgorithm.svm.libsvm_plt.PLRankSvm;

/**
 *
 * GUI controller
 * 
 * Initialises the Experiment object and the 4 tabs with the main processing steps
 *
 * @author Vincent Farrugia
 * @author Hector P. Martinez
 */
public class MasterGUI extends BorderPane
{
    Stage parentStage;
    Experiment experiment;
    
    TabPane tabPane;
    Text helpText;
    final Button btnNext;
    
    final String DEFAULT_TOOLTIP_HELPTEXT = "HELP:      Mouse over the program's components for helpful tips.";
    
    public MasterGUI(Stage stage)
    {
        parentStage = stage;
     
        experiment = new Experiment();

        //Main steps in tabs
        tabPane = new TabPane();
        this.setCenter(tabPane);
        
        	final Tab tab1 = new DataSetTab(parentStage, experiment.getDataset());
        	tab1.setText("Dataset");

        	final Tab tab2 = new PreprocessingTab(parentStage, experiment);
        	tab2.setText("Preprocessing");

        	final Tab tab3 = new FeatureSelectionTab(parentStage, experiment);
        	tab3.setText("Feature Selection");

        	final Tab tab4 = new AlgorithmTab(parentStage, experiment);
        	tab4.setText("Preference Learning Methods");        
        
        	tabPane.tabClosingPolicyProperty().set(TabPane.TabClosingPolicy.UNAVAILABLE);
        	tabPane.getTabs().addAll(tab1, tab2, tab3 ,tab4);

        
        
        
        //Next, back and help buttons
        BorderPane bottomPane = new BorderPane();
        this.setBottom(bottomPane);
        bottomPane.setPadding(new Insets(10, 10, 10, 10));
        bottomPane.setStyle("-fx-background-color: #336699;");        
        
        	HBox navBtnBox = new HBox(10);
        	bottomPane.setRight(navBtnBox);

        		btnNext = new Button();
        		navBtnBox.getChildren().add(btnNext);

        		btnNext.setPrefSize(200, 20);
        		btnNext.disableProperty().setValue(true);
        		
        			BorderPane nextBtnInnerBPane = new BorderPane();
        			btnNext.setGraphic(nextBtnInnerBPane);
        			
        				Label lblNextBtn = new Label("Next");
        				nextBtnInnerBPane.setCenter(lblNextBtn);
        				
        				ImageView imgViewNextBtn = new ImageView(new Image(DataSetTab.class.getResourceAsStream("nxtButton.png")));
        				nextBtnInnerBPane.setRight(imgViewNextBtn);
        			
        		final Button btnBack = new Button();
        		navBtnBox.getChildren().add(btnBack);

        		btnBack.setPrefSize(200, 20);
        		btnBack.setVisible(false);
        		
        			BorderPane backBtnInnerBPane = new BorderPane();
        			btnBack.setGraphic(backBtnInnerBPane); 
        			
        			    Label lblBackBtn = new Label("Back");
        			    backBtnInnerBPane.setCenter(lblBackBtn);
        			    
        			    ImageView imgViewBkBtn = new ImageView(new Image(DataSetTab.class.getResourceAsStream("bkButton.png")));
        			    backBtnInnerBPane.setLeft(imgViewBkBtn);
        		
        			     			
        	
            Button helpButton = new Button();
            bottomPane.setLeft(helpButton);
            helpButton.setVisible(true);
            helpButton.setGraphic(new ImageView(new Image(DataSetTab.class.getResourceAsStream("helpButton.png"))));
        	
            
            
        btnBack.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                
                if(tabPane.getSelectionModel().getSelectedIndex() > 0)
                {
                    tabPane.selectionModelProperty().get().select(tabPane.selectionModelProperty().get().getSelectedIndex() - 1);
                }
            }
            
        });
        
   
        
        //Enable tabs only when dataset is loaded
        experiment.getDataset().addDataLoaderListener(new ChangeListener<Boolean>(){

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0,
					Boolean arg1, Boolean arg2) {
				if(arg2){
					
					enableTabs();
				}
				
			}
		});
        
        
        //tabPane.selectionModelProperty();
  
        
        
        //Change label of 'next button' when at tab 4
        tab4.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                if (t1)
                {
                    
                    Label lblNextBtn = new Label("Run experiment");
                    ImageView imgViewNextBtn = new ImageView(new Image(DataSetTab.class.getResourceAsStream("runExperimentButton.png")));
                    BorderPane nextBtnInnerBPane = new BorderPane();
                    nextBtnInnerBPane.setCenter(lblNextBtn);
                    nextBtnInnerBPane.setRight(imgViewNextBtn);
                    btnNext.setGraphic(nextBtnInnerBPane);
                }
                else
                {
                    Label lblNextBtn = new Label("Next");
                    ImageView imgViewNextBtn = new ImageView(new Image(DataSetTab.class.getResourceAsStream("nxtButton.png")));
                    BorderPane nextBtnInnerBPane = new BorderPane();
                    nextBtnInnerBPane.setCenter(lblNextBtn);
                    nextBtnInnerBPane.setRight(imgViewNextBtn);
                    btnNext.setGraphic(nextBtnInnerBPane);
                }
            }
        });
        
        
        //Hide back button when tab1 is selected
        tab1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                
                if(t1)
                {
                    btnBack.setVisible(false);
                    btnNext.setVisible(true);
                }
                else
                {
                    btnBack.setVisible(true);
                }
            }
        });
        
        
        
        

        
        helpButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if(tab1.selectedProperty().get())
                {
                    Tab1Help h = new Tab1Help();
                    h.show(parentStage.getScene().getRoot(), null);
                }
                else if(tab2.selectedProperty().get())
                {
                    Tab2Help h = new Tab2Help();
                    h.show(parentStage.getScene().getRoot(), null);
                }
                else if(tab3.selectedProperty().get())
                {
                    Tab3Help h = new Tab3Help();
                    h.show(parentStage.getScene().getRoot(), null);
                }
                else if(tab4.selectedProperty().get())
                {
                    Tab4Help h = new Tab4Help();
                    h.show(parentStage.getScene().getRoot(), null);
                }
            }
            
        });
        
        /*helpButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (tab1.selectedProperty().get()) {
                    ArrayList<String> itemsToInclude = new ArrayList<String>();
                    itemsToInclude.add("Loading a dataset");
                    itemsToInclude.add("Button: Import Object File");
                    itemsToInclude.add("Button: Import Ranking File");
                    
                    String reqHTML = dataSetTab_HelpStore.constructHtml(itemsToInclude);
                    HelpPopup hPopup = new HelpPopup(reqHTML);
                    hPopup.show(parentStage.getScene().getRoot(), null);
                    
                    //Tab1Help h = new Tab1Help();
                    //h.show(parentStage.getScene().getRoot(), null);
                }
                
                if (tab2.selectedProperty().get()) {
                    Tab2Help h = new Tab2Help();
                    h.show(parentStage.getScene().getRoot(), null);
                }
                
            }
        });*/
        
        
        
        
        btnNext.setOnAction(new EventHandler<ActionEvent>() {//Next tab or start experiment

            @Override
            public void handle(ActionEvent t) {
                
                if(! tab4.selectedProperty().get())
                {
                    tabPane.selectionModelProperty().get().select(tabPane.selectionModelProperty().get().getSelectedIndex() + 1);
                }
                else if(tab4.selectedProperty().get())
                {
                	
                	System.err.println("These checks should be moved somewhere else");
                    // Perform safety checks.
                    boolean allClear = true;


                    int numOfIgnoredFeatures = 0;

                    for(int i=0; i<experiment.getPreprocessingOperations().size(); i++)
                    {
                        if(!experiment.getPreprocessingOperations().get(i).getIncludeFlag()) { numOfIgnoredFeatures++; }
                    }


                    if(numOfIgnoredFeatures == experiment.getDataset().getNumberOfFeatures())
                    {
                        // You must include at least one feature.

                        ModalPopup notification = new ModalPopup();
                        notification.show(new Label("ERROR: You must include at least one feature from the dataset."), parentStage.getScene().getRoot(),null,new Button("OK"), 200,550,false);  

                        allClear = false;
                    }
                    else if(experiment.featureSelectionProperty().get() != null)
                    {
                        if(experiment.featureSelectionProperty().get() instanceof NBest)
                        {
                            NBest castNBest = (NBest) experiment.featureSelectionProperty().get();

                            int numOfUserIncludedFeatures = (experiment.getDataset().getNumberOfFeatures() - numOfIgnoredFeatures);

                            if(castNBest.getN() > numOfUserIncludedFeatures)
                            {
                                // N val should always be less than or equal to the number of user included features.

                                ModalPopup notification = new ModalPopup();
                                notification.show(new Label("ERROR: N-Best N value cannot be greater than the number of included features. \n Current N Value = "+castNBest.getN()+" \n Current Num of Included Features = "+numOfUserIncludedFeatures), parentStage.getScene().getRoot(),null,new Button("OK"), 200,600,false);  

                                allClear = false;
                            }
                        }


                        if(experiment.algorithmForFeatureSelectionProperty().get() == null)
                        {
                            // You cannot select a feature selection type without stating an algorithm.

                            ModalPopup notification = new ModalPopup();
                            notification.show(new Label("ERROR: You must state an algorithm to work with "+experiment.featureSelectionProperty().get().getFSelName()+"."), parentStage.getScene().getRoot(),null,new Button("OK"), 200,550,false);  

                            allClear = false;
                        }

                    }

                    if(experiment.algorithmForFeatureSelectionProperty().get() != null)
                    {
                        if(experiment.algorithmForFeatureSelectionProperty().get() instanceof PLNeuroEvolution)
                        {
                            PLNeuroEvolution castPLNE = (PLNeuroEvolution) experiment.algorithmForFeatureSelectionProperty().get();
                            PLNeuroEvolutionConfigurator neConfig = castPLNE.getConfigurator();
                            GeneticAlgorithmConfigurator gaConfig = neConfig.getGeneticAlgorithmConfigurator();
                            
                            if(gaConfig.getNumberOfParents() > gaConfig.getPopulationSize())
                            {
                                ModalPopup notification = new ModalPopup();
                                notification.show(new Label("GA ERROR: The number of parents is greater than the GA population size."), parentStage.getScene().getRoot(),null,new Button("OK"), 200,550,false);  

                                allClear = false;
                            }

                            if(gaConfig.getElitSize() > gaConfig.getPopulationSize())
                            {
                                ModalPopup notification = new ModalPopup();
                                notification.show(new Label("GA ERROR: The elitism size is greater than the GA population size."), parentStage.getScene().getRoot(),null,new Button("OK"), 200,550,false);  

                                allClear = false;
                            }
                        }
                        
                        if(experiment.algorithmProperty().get() instanceof PLRankSvm)
                        {
                            PLRankSvm castPLRS = (PLRankSvm) experiment.algorithmProperty().get();
                            PLRankSvmConfigurator svmConfig = castPLRS.getConfigurator();

                            if((svmConfig.gammaRequired())
                            &&(svmConfig.getGamma() == 0))
                            {
                                ModalPopup notification = new ModalPopup();
                                notification.show(new Label("SVM ERROR: Gamma cannot be set to 0."), parentStage.getScene().getRoot(),null,new Button("OK"), 200,550,false);  
                                
                                allClear = false;
                            }        
                        }
                    }
                    
                    if(experiment.algorithmProperty().get() instanceof PLNeuroEvolution)
                    {
                        PLNeuroEvolution castPLNE = (PLNeuroEvolution) experiment.algorithmProperty().get();
                        PLNeuroEvolutionConfigurator neConfig = castPLNE.getConfigurator();
                        GeneticAlgorithmConfigurator gaConfig = neConfig.getGeneticAlgorithmConfigurator();
                        
                        int numParents = gaConfig.getNumberOfParents();
                        int popSize = gaConfig.getPopulationSize();
                        if(numParents > popSize)
                        {
                            ModalPopup notification = new ModalPopup();
                            notification.show(new Label("GA ERROR: The number of parents is greater than the GA population size."), parentStage.getScene().getRoot(),null,new Button("OK"), 200,550,false);  

                            allClear = false;
                        }
                        
                        if(gaConfig.getElitSize() > gaConfig.getPopulationSize())
                        {
                            ModalPopup notification = new ModalPopup();
                            notification.show(new Label("GA ERROR: The elitism size is greater than the GA population size."), parentStage.getScene().getRoot(),null,new Button("OK"), 200,550,false);  

                            allClear = false;
                        } 
                    }
                    
                    if(experiment.algorithmProperty().get() instanceof PLRankSvm)
                    {
                        PLRankSvm castPLRS = (PLRankSvm) experiment.algorithmProperty().get();
                        PLRankSvmConfigurator svmConfig = castPLRS.getConfigurator();
                        
                        if((svmConfig.gammaRequired())
                        &&(svmConfig.getGamma() == 0))
                        {
                            ModalPopup notification = new ModalPopup();
                            notification.show(new Label("SVM ERROR: Gamma cannot be set to 0."), parentStage.getScene().getRoot(),null,new Button("OK"), 200,550,false);  
                            
                            allClear = false;
                        }        
                    }
                    

                    if(allClear)
                    {
                        Execution e = new Execution(experiment);
                        e.show(parentStage);
                    }
                }
            }
        });
        
        
        
        
        //helpButton.visibleProperty().bind(tab1.selectedProperty().or(tab2.selectedProperty()));
  
        
        disableTabs(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        
        
        
        
        
        
        
        
        
    }
    
    private void enableTabs()
    {
    	
    	btnNext.disableProperty().setValue(false);
        for(int i=1; i<4; i++)
        {
            tabPane.getTabs().get(i).setDisable(false);
        }
    }
    
    public void disableTabs(ArrayList<Integer> para_tabsToEnable)
    {
        for(int i=0; i<para_tabsToEnable.size(); i++)
        {
            tabPane.getTabs().get(para_tabsToEnable.get(i)).setDisable(true);
        }
    }
    
    
    
    
    
    
}
