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

package plt.plalgorithm.neruoevolution;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import plt.gui.Main;
import plt.gui.algorithms.GUIConfigurator;
import plt.gui.component.AdvanceTextField;
import plt.plalgorithm.PLAlgorithm;
import plt.plalgorithm.ANN.ActivationFunction;
import plt.plalgorithm.ANN.HyperbolicTangent;
import plt.plalgorithm.ANN.Linear;
import plt.plalgorithm.ANN.Sigmond;
import plt.plalgorithm.neruoevolution.GA.GeneticAlgorithmConfigurator;
import plt.plalgorithm.neruoevolution.GA.ParentSelection;
import plt.plalgorithm.neruoevolution.GA.genticaloperators.CrossOver;
import plt.plalgorithm.neruoevolution.GA.genticaloperators.CrossOverType;
import plt.plalgorithm.neruoevolution.GA.genticaloperators.GaussianMutation;
import plt.plalgorithm.neruoevolution.GA.genticaloperators.Invertion;
import plt.plalgorithm.neruoevolution.GA.parentselections.RouletteWheelSelection;

/**
 *
 * GUI to set up the parameters for neuroevolution
 *
 * @author Vincent Farrugia
 */
public class GUINeuroEvolutionConfigurator implements GUIConfigurator, NeuroEvolutionConfigurator{// implements plt.plalgorithm.neruoevolution.PLNeuroEvolutionConfigurator {

    
    private ArrayList<TextField> topology;
    private ArrayList<ChoiceBox> choiceBoxTopology;
    private GridPane annGridPane;
    private HBox annBtnPane;
    private Button btnAddHiddenLayer;
    private Button btnRemoveHiddenLayer;
    
    private TextField poulationSize;
    private TextField iterations;
    private TextField mutation;
    private TextField selectionSize;
    private TextField elitSize;
    private TextField crossover;
    private ChoiceBox crossoverType;
    private TextField invertion;
    private ChoiceBox parentsSelection;

    private static int parseOrFailWithZero(TextField t) {
        try {
            return Integer.parseInt(t.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    private static double parseDoubleOrFailWithZero(TextField t) {
        try {
            return Double.parseDouble(t.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public GUINeuroEvolutionConfigurator() {
        
        // Section 1: ANN
        
        topology = new ArrayList<TextField>();
        choiceBoxTopology = new ArrayList<ChoiceBox>();
        
        

        
        // Section 2: Evolution
        
        poulationSize = new AdvanceTextField("[0-9]", "200");
        iterations = new AdvanceTextField("[0-9]", "50");
        selectionSize = new AdvanceTextField("[0-9]", "40");
        elitSize = new AdvanceTextField("[0-9]", "20");
        crossoverType = new ChoiceBox(FXCollections.observableArrayList("One point", "Two point", "Uniform"));
        crossover = new AdvanceTextField("[0-9.]", "0.8");
        crossoverType.getSelectionModel().selectLast();
        parentsSelection = new ChoiceBox(FXCollections.observableArrayList("Roulette wheel"));
        parentsSelection.getSelectionModel().selectFirst();
        invertion = new AdvanceTextField("[0-9.]", "0");
        mutation = new AdvanceTextField("[0-9.]", "0.1");
        
        poulationSize.setPrefWidth(30);
        iterations.setPrefWidth(30);
        selectionSize.setPrefWidth(30);
        elitSize.setPrefWidth(30);
        crossoverType.setPrefWidth(150);
        crossover.setPrefWidth(30);
        parentsSelection.setPrefWidth(150);
        invertion.setPrefWidth(30);
        mutation.setPrefWidth(30);
    }

   // @Override
    /* (non-Javadoc)
	 * @see plt.gui.algorithms.NeuroEvolutionConfigurator#getTopology(int)
	 */
    @Override
	public int[] getTopology(int inputSize)
    {
        int j = 0;
        for (int i = 0; i < topology.size(); i++) 
        {
            int n = parseOrFailWithZero(topology.get(i));
            if (n > 0) 
            {
                j++;
            }
        }
        int[] result = new int[j + 2];
        result[0] = inputSize;
        j = 1;
        for (int i = 0; i < topology.size(); i++)
        {
            int n = parseOrFailWithZero(topology.get(i));
            if (n > 0)
            {
                result[j++] = n;
            }
        }
        result[j] = 1;
        return result;
    }

   // @Override
    /* (non-Javadoc)
	 * @see plt.gui.algorithms.NeuroEvolutionConfigurator#iterations()
	 */
    @Override
	public int iterations()
    {
        return parseOrFailWithZero(iterations);
    }

   // @Override
    /* (non-Javadoc)
	 * @see plt.gui.algorithms.NeuroEvolutionConfigurator#getGeneticAlgorithmConfigurator()
	 */
    @Override
	public GeneticAlgorithmConfigurator getGeneticAlgorithmConfigurator() {
        final GUINeuroEvolutionConfigurator self = this;
        return new GeneticAlgorithmConfigurator() {
            
            @Override
            public int getIterations() {
                return parseOrFailWithZero(self.iterations);
            }
            
            @Override
            public int getPopulationSize() {
                return parseOrFailWithZero(self.poulationSize);
            }

            @Override
            public int getNumberOfParents() {
                return parseOrFailWithZero(self.selectionSize);
            }

            @Override
            public int getElitSize() {
                return parseOrFailWithZero(self.elitSize);
            }

            @Override
            public ParentSelection getParentSelection() {
                int i = crossoverType.getSelectionModel().getSelectedIndex();
                ParentSelection result;

                switch (i) {
                    case 0:
                        result = new RouletteWheelSelection();
                        break;

                    default:
                        result = new RouletteWheelSelection();
                        break;
                }

                return result;
            }

            @Override
            public CrossOver getCrossOver() {
                int i = crossoverType.getSelectionModel().getSelectedIndex();
                CrossOver result;

                switch (i) {
                    case 0:
                        result = new CrossOver(parseDoubleOrFailWithZero(self.crossover), CrossOverType.ONEPOINT);
                        break;

                    case 1:
                        result = new CrossOver(parseDoubleOrFailWithZero(self.crossover), CrossOverType.TWOPOINT);
                        break;

                    case 2:
                        result = new CrossOver(parseDoubleOrFailWithZero(self.crossover), CrossOverType.UNIFORM);
                        break;


                    default:
                        result = new CrossOver(parseDoubleOrFailWithZero(self.crossover), CrossOverType.ONEPOINT);
                        break;
                }

                return result;
            }

            @Override
            public GaussianMutation getMutation() {
                return new GaussianMutation(parseDoubleOrFailWithZero(self.mutation));
            }

            @Override
            public Invertion getInvertion() {
                return new Invertion(parseDoubleOrFailWithZero(self.invertion));
            }
        };
    }
    
    
    private Node ui;
    
	@Override
    public Node ui() {
    	
    	
        ui = new HBox(5);


        annGridPane = new GridPane();
        annGridPane.setPadding(new Insets(20));
        annGridPane.setHgap(15);
        annGridPane.setVgap(12);

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(20));
        grid2.setHgap(10);
        grid2.setVgap(12);
        
        Font headerFont = Font.font("BirchStd", FontWeight.BOLD, 15);
        
        

        // Section 1: (ANN)
        Label lblAnnSectionHeader = new Label("Multilayer Perceptron");
        
        Label lblAnnLayerHeader = new Label("ANN Layer");
        Label lblNumOfNeuronsInLayerHeader = new Label("Neurons");
        Label lblActivationFuncHeader = new Label("Activation Function");
        Label lblHiddenLayerHandler = new Label("Hidden Layer");
        
        lblAnnSectionHeader.setFont(headerFont);
        lblAnnLayerHeader.setFont(headerFont);
        lblNumOfNeuronsInLayerHeader.setFont(headerFont);
        lblActivationFuncHeader.setFont(headerFont);
        lblHiddenLayerHandler.setFont(headerFont);
        
        
        
        btnAddHiddenLayer = new Button();
        btnAddHiddenLayer.setVisible(true);
        btnAddHiddenLayer.setFont(new Font(0));
        btnAddHiddenLayer.setPrefWidth(30);
        btnAddHiddenLayer.setPrefHeight(30);
        btnAddHiddenLayer.setGraphic(new ImageView(new Image(Main.class.getResourceAsStream("plus_small.png"))));
        btnAddHiddenLayer.setStyle("-fx-background-color: transparent");
        btnAddHiddenLayer.setOnAction(new AddANNLayerHandler());
        
        
        
        btnRemoveHiddenLayer = new Button();
        btnRemoveHiddenLayer.setVisible(true);
        btnRemoveHiddenLayer.setFont(new Font(0));
        btnRemoveHiddenLayer.setPrefWidth(30);
        btnRemoveHiddenLayer.setPrefHeight(30);
        btnRemoveHiddenLayer.setGraphic(new ImageView(new Image(Main.class.getResourceAsStream("minus_small.png"))));
        btnRemoveHiddenLayer.setStyle("-fx-background-color: transparent");
        btnRemoveHiddenLayer.setOnAction(new RemoveANNLayerHandler());
        
        
        
        annBtnPane = new HBox();
        BorderPane.setAlignment(annBtnPane, Pos.CENTER);
        annBtnPane.getChildren().add(btnAddHiddenLayer);
        
        
        BorderPane hiddenLayerControlPane = new BorderPane();
        hiddenLayerControlPane.setPadding(new Insets(0,20,0,20));
        
        BorderPane tmpBPane = new BorderPane();
        tmpBPane.setLeft(lblHiddenLayerHandler);
        tmpBPane.setRight(annBtnPane);
        tmpBPane.setStyle("-fx-border-radius: 1; -fx-border-color: black");
        
        hiddenLayerControlPane.setCenter(tmpBPane);
        
        
        annGridPane.add(lblAnnLayerHeader, 0, 0);
        annGridPane.add(lblNumOfNeuronsInLayerHeader, 1, 0);
        annGridPane.add(lblActivationFuncHeader, 2, 0);
        annGridPane.getColumnConstraints().add(new ColumnConstraints(110));
        
        
        int currGridRow = 1;
                
        int numOfLayers = topology.size();
        for(int i=0; i<(numOfLayers); i++)
        {
            Label lblLayerName = null;
            
            lblLayerName = new Label("Hidden Layer "+i);
                       
            annGridPane.add(lblLayerName, 0, currGridRow);
            annGridPane.add(topology.get(i), 1, currGridRow);
            annGridPane.add(choiceBoxTopology.get(i), 2, currGridRow);
            
            currGridRow++;
        }
        
        
        
        
        GridPane outputLayerGPane = new GridPane();
        outputLayerGPane.setPadding(new Insets(20));
        outputLayerGPane.setHgap(15);
        outputLayerGPane.setVgap(12);
        outputLayerGPane.add(new Label("Output Layer   "), 0, 0);
        outputLayerGPane.getColumnConstraints().add(new ColumnConstraints(110));
        TextField tfOutputLayer = new AdvanceTextField("[0-9]", "1");
        tfOutputLayer.setDisable(true);
        tfOutputLayer.setPrefWidth(60);
        ChoiceBox outputLayerActivationFuncCBox = new ChoiceBox(FXCollections.observableArrayList("Sigmoid", "Hyperbolic Tangent", "Linear"));
        outputLayerActivationFuncCBox.getSelectionModel().selectFirst();
        choiceBoxTopology.add(outputLayerActivationFuncCBox);
        outputLayerGPane.add(tfOutputLayer, 1, 0);
        outputLayerGPane.add(outputLayerActivationFuncCBox, 2, 0);
        
        VBox tmpVBox = new VBox();
        tmpVBox.getChildren().addAll(annGridPane,hiddenLayerControlPane,outputLayerGPane);
        
        
        BorderPane annPane = new BorderPane();
        BorderPane.setAlignment(lblAnnSectionHeader, Pos.CENTER);
        annPane.setTop(lblAnnSectionHeader);
        annPane.setCenter(tmpVBox);
        
        
        
        // Section 2: (GA)
                                                  
        Label gaPropertiesHeaderLabel = new Label("Genetic Algorithm Parameters");
        gaPropertiesHeaderLabel.setFont(headerFont);
        
        Label lblGaPopulationParams = new Label("GA Population");
        Label lblGaOperatorsParams = new Label("GA Operators");
        Label lblGaSelectionParams = new Label("GA Selection");
        Label lblGaStrategyParams = new Label("GA Strategies");
        Label lblGaTerminationParams = new Label("GA Termination");
        
        lblGaPopulationParams.setFont(headerFont);
        lblGaOperatorsParams.setFont(headerFont);
        lblGaSelectionParams.setFont(headerFont);
        lblGaStrategyParams.setFont(headerFont);
        lblGaTerminationParams.setFont(headerFont);
        
        Label poulationSizeLabel = new Label("Population size:");
        Label iterationsLabel = new Label("Generations:");
        Label selectionSizeLabel = new Label("Parents:");
        Label elitSizeLabel = new Label("Elitism size:");
        Label crossoverLabel = new Label("Crossover probability:");
        Label crossoverTypeLabel = new Label("Crossover type:");
        Label mutationLabel = new Label("Mutation probability:");
        Label invertionLabel = new Label("Invertion probability:");
        Label parentsSelectionLabel = new Label("Selection scheme:");
        
        
        double inputColWidth = 200;
        poulationSize.setPrefWidth(inputColWidth);
        iterations.setPrefWidth(inputColWidth);
        mutation.setPrefWidth(inputColWidth);
        selectionSize.setPrefWidth(inputColWidth);
        elitSize.setPrefWidth(inputColWidth);
        crossover.setPrefWidth(inputColWidth);
        crossoverType.setPrefWidth(inputColWidth);
        invertion.setPrefWidth(inputColWidth);
        parentsSelection.setPrefWidth(inputColWidth);
        
        
        VBox gaPopulationBox = new VBox(0);
        GridPane gaPopulationGPane = new GridPane();
        gaPopulationGPane.setPadding(new Insets(5,20,5,20));
        gaPopulationGPane.setHgap(10);
        gaPopulationGPane.setVgap(12);
        gaPopulationGPane.getColumnConstraints().add(new ColumnConstraints(160));
        gaPopulationGPane.add(poulationSizeLabel, 0, 0);
        gaPopulationGPane.add(poulationSize, 1, 0);
        gaPopulationBox.getChildren().addAll(lblGaPopulationParams,gaPopulationGPane);
        
        VBox gaOperatorsBox = new VBox(0);
        GridPane gaOperatorsGPane = new GridPane();
        gaOperatorsGPane.setPadding(new Insets(5,20,5,20));
        gaOperatorsGPane.setHgap(10);
        gaOperatorsGPane.setVgap(12);
        gaOperatorsGPane.getColumnConstraints().add(new ColumnConstraints(160));
        gaOperatorsGPane.add(crossoverLabel, 0, 0);
        gaOperatorsGPane.add(crossover, 1, 0);
        gaOperatorsGPane.add(crossoverTypeLabel, 0, 1);
        gaOperatorsGPane.add(crossoverType, 1, 1);
        gaOperatorsGPane.add(mutationLabel, 0, 2);
        gaOperatorsGPane.add(mutation, 1, 2);
        gaOperatorsBox.getChildren().addAll(lblGaOperatorsParams,gaOperatorsGPane);
        
        VBox gaSelectionParamsBox = new VBox(0);
        GridPane gaSelectionParamsGPane = new GridPane();
        gaSelectionParamsGPane.setPadding(new Insets(5,20,5,20));
        gaSelectionParamsGPane.setHgap(10);
        gaSelectionParamsGPane.setVgap(12);
        gaSelectionParamsGPane.getColumnConstraints().add(new ColumnConstraints(160));
        gaSelectionParamsGPane.add(selectionSizeLabel, 0, 0);
        gaSelectionParamsGPane.add(selectionSize, 1, 0);
        gaSelectionParamsGPane.add(parentsSelectionLabel, 0, 1);
        gaSelectionParamsGPane.add(parentsSelection, 1, 1);
        gaSelectionParamsBox.getChildren().addAll(lblGaSelectionParams,gaSelectionParamsGPane);
        
        VBox gaStrategyParamsBox = new VBox(0);
        GridPane gaStrategyParamsGPane = new GridPane();
        gaStrategyParamsGPane.setPadding(new Insets(5,20,5,20));
        gaStrategyParamsGPane.setHgap(10);
        gaStrategyParamsGPane.setVgap(12);
        gaStrategyParamsGPane.getColumnConstraints().add(new ColumnConstraints(160));
        gaStrategyParamsGPane.add(elitSizeLabel, 0, 0);
        gaStrategyParamsGPane.add(elitSize, 1, 0);
        gaStrategyParamsBox.getChildren().addAll(lblGaStrategyParams,gaStrategyParamsGPane);
        
        VBox gaTerminationParamsBox = new VBox(0);
        GridPane gaTerminationParamsGPane = new GridPane();
        gaTerminationParamsGPane.setPadding(new Insets(5,20,5,20));
        gaTerminationParamsGPane.setHgap(10);
        gaTerminationParamsGPane.setVgap(12);
        gaTerminationParamsGPane.getColumnConstraints().add(new ColumnConstraints(160));
        gaTerminationParamsGPane.add(iterationsLabel, 0, 0);
        gaTerminationParamsGPane.add(iterations, 1, 0);
        gaTerminationParamsBox.getChildren().addAll(lblGaTerminationParams,gaTerminationParamsGPane);
        
        
        VBox gaContentBox = new VBox(10);
        gaContentBox.setPadding(new Insets(20));
        gaContentBox.getChildren().addAll(gaPopulationBox,
                                          gaOperatorsBox,
                                          gaSelectionParamsBox,
                                          gaStrategyParamsBox,
                                          gaTerminationParamsBox);
        
        
        
        
        
        
        BorderPane gaPropPane = new BorderPane();
        BorderPane.setAlignment(gaPropertiesHeaderLabel, Pos.CENTER);
        gaPropPane.setTop(gaPropertiesHeaderLabel);
        gaPropPane.setCenter(gaContentBox);
        
        

        annPane.getStyleClass().add("modulePane1Child");
        gaPropPane.getStyleClass().add("modulePane1Child");
        
        
       // annPane.setPrefSize(490, 470);
       // gaPropPane.setPrefSize(470, 470);
        
        
        TitledPane tmp=		new TitledPane("Artificial neural network", annPane);
        ((HBox)ui).getChildren().add(tmp.getContent());
        HBox.setHgrow(tmp.getContent(), Priority.ALWAYS);
        TitledPane tmp2=		new TitledPane("Genetic Algorithm", gaPropPane);
        ((HBox)ui).getChildren().add(tmp2.getContent());
        HBox.setHgrow(tmp2.getContent(), Priority.ALWAYS);

        
        return ui;
	}
	

	/* (non-Javadoc)
	 * @see plt.gui.algorithms.NeuroEvolutionConfigurator#testParameters()
	 */
	@Override
	public String testParameters() {


        GeneticAlgorithmConfigurator gaConfig = this.getGeneticAlgorithmConfigurator();
        
        int numParents = gaConfig.getNumberOfParents();
        int popSize = gaConfig.getPopulationSize();
        if(numParents > popSize)
        {
            return "GA error: The number of parents is greater than the GA population size.";

        }
        
        if(gaConfig.getElitSize() > gaConfig.getPopulationSize())
        {
            return "GA error: The elitism size is greater than the GA population size.";

        } 
		
		return "";
		
		
	}

    
    

   // @Override
    /* (non-Javadoc)
	 * @see plt.gui.algorithms.NeuroEvolutionConfigurator#getActivationsFunctions()
	 */
    @Override
	public ActivationFunction[] getActivationsFunctions()
    {
        int j = 0;
        for (int i = 0; i < topology.size(); i++)
        {
            int n = parseOrFailWithZero(topology.get(i));
            if (n > 0) 
            {
                j++;
            }
        }
        ActivationFunction[] result = new ActivationFunction[j + 1];
        j = 0;
        for (int i = 0; i < topology.size(); i++)
        {
            int n = parseOrFailWithZero(topology.get(i));
            if (n > 0)
            {

                switch (this.choiceBoxTopology.get(i).getSelectionModel().getSelectedIndex())
                {
                    case 0:
                        result[j++] = new Sigmond();
                        break;
                    case 1:
                        result[j++] = new HyperbolicTangent();
                        break;
                    case 2:
                        result[j++] = new Linear();
                        break;
                    default:
                        result[j++] = new Sigmond();
                        break;
                }
            }
        }

        
        switch (this.choiceBoxTopology.get(choiceBoxTopology.size()-1).getSelectionModel().getSelectedIndex())
        {
            case 0:
                result[j] = new Sigmond();
                break;
            case 1:
                result[j] = new HyperbolicTangent();
                break;
            case 2:
                result[j] = new Linear();
                break;
        }
        
        return result;
             
    }
    
    public void refreshANNLayerPane()
    {
        Font headerFont = Font.font("BirchStd", FontWeight.BOLD, 15);
        
        
        
        Label lblAnnLayerHeader = new Label("ANN Layer");
        Label lblNumOfNeuronsInLayerHeader = new Label("Neurons");
        Label lblActivationFuncHeader = new Label("Activation Function");
        
        
        lblAnnLayerHeader.setFont(headerFont);
        lblNumOfNeuronsInLayerHeader.setFont(headerFont);
        lblActivationFuncHeader.setFont(headerFont);
        
        annGridPane.getChildren().clear();
        
        annGridPane.add(lblAnnLayerHeader, 0, 0);
        annGridPane.add(lblNumOfNeuronsInLayerHeader, 1, 0);
        annGridPane.add(lblActivationFuncHeader, 2, 0);
        
        
        
        int currGridRow = 1;
                
        int numOfLayers = topology.size();
        for(int i=0; i<numOfLayers; i++)
        {
            Label lblLayerName = null;
            
            lblLayerName = new Label("Hidden Layer "+i);
                        
            annGridPane.add(lblLayerName, 0, currGridRow);
            annGridPane.add(topology.get(i), 1, currGridRow);
            annGridPane.add(choiceBoxTopology.get(i), 2, currGridRow);
            
            currGridRow++;
        }
    }
    
    public void updateRemLayerBtnVisibility()
    {
        annBtnPane.getChildren().clear();
        
        if(topology.size() > 0)
        {
            annBtnPane.getChildren().addAll(btnAddHiddenLayer,btnRemoveHiddenLayer);
        }
        else
        {
            annBtnPane.getChildren().addAll(btnAddHiddenLayer);
        }
    }
    
    class AddANNLayerHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent t) 
        {
            
            
            AdvanceTextField nwNumNeuronTxtField = new AdvanceTextField("[0-9]", "0");
            nwNumNeuronTxtField.setPrefWidth(30);
            
            ArrayList<TextField> nwTopologyList = new ArrayList<TextField>();
            for(int i=0; i<topology.size(); i++)
            {
                nwTopologyList.add(topology.get(i));
            }
            nwTopologyList.add(nwNumNeuronTxtField);
            
            
            topology = nwTopologyList;
            
            
            
            
            
            ChoiceBox nwActivationFuncCBox = new ChoiceBox(FXCollections.observableArrayList("Sigmoid", "Hyperbolic Tangent", "Linear"));
            nwActivationFuncCBox.getSelectionModel().selectFirst();
            
            ArrayList<ChoiceBox> nwChoiceBoxTop = new ArrayList<ChoiceBox>();
            for(int i=0; i<choiceBoxTopology.size()-1; i++)
            {
                nwChoiceBoxTop.add(choiceBoxTopology.get(i));
            }
            nwChoiceBoxTop.add(nwActivationFuncCBox);
            nwChoiceBoxTop.add(choiceBoxTopology.get(choiceBoxTopology.size()-1));
            
            
            choiceBoxTopology = nwChoiceBoxTop;
            
            
            updateRemLayerBtnVisibility();
            refreshANNLayerPane();
        }
    }
    
    class RemoveANNLayerHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent t) 
        {
            // Remove a hidden layer.
            topology.remove(topology.size()-1);
            choiceBoxTopology.remove(choiceBoxTopology.size()-1);
            
            updateRemLayerBtnVisibility();
            refreshANNLayerPane();
        }
    }

	/* (non-Javadoc)
	 * @see plt.gui.algorithms.NeuroEvolutionConfigurator#algorithm()
	 */
	@Override
	public PLAlgorithm algorithm() {
		return new NeuroEvolution(this);
	}
        
}