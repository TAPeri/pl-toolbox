package plt.utils.GA;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import plt.gui.component.AdvanceTextField;
import plt.utils.GA.genticaloperators.CrossOver;
import plt.utils.GA.genticaloperators.CrossOverType;
import plt.utils.GA.genticaloperators.GaussianMutation;
import plt.utils.GA.genticaloperators.Invertion;
import plt.utils.GA.parentselections.RouletteWheelSelection;

public class GUIGeneticAlgorithmConfigurator implements GeneticAlgorithmConfigurator{

	

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
    
    

    public GUIGeneticAlgorithmConfigurator() {
        
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


	public int iterations()
    {
        return parseOrFailWithZero(iterations);
    }


    @Override
    public int getIterations() {
        return parseOrFailWithZero(iterations);
    }
    
    @Override
    public int getPopulationSize() {
        return parseOrFailWithZero(poulationSize);
    }

    @Override
    public int getNumberOfParents() {
        return parseOrFailWithZero(selectionSize);
    }

    @Override
    public int getElitSize() {
        return parseOrFailWithZero(elitSize);
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
                result = new CrossOver(parseDoubleOrFailWithZero(crossover), CrossOverType.ONEPOINT);
                break;

            case 1:
                result = new CrossOver(parseDoubleOrFailWithZero(crossover), CrossOverType.TWOPOINT);
                break;

            case 2:
                result = new CrossOver(parseDoubleOrFailWithZero(crossover), CrossOverType.UNIFORM);
                break;


            default:
                result = new CrossOver(parseDoubleOrFailWithZero(crossover), CrossOverType.ONEPOINT);
                break;
        }

        return result;
    }

    @Override
    public GaussianMutation getMutation() {
        return new GaussianMutation(parseDoubleOrFailWithZero(mutation));
    }

    @Override
    public Invertion getInvertion() {
        return new Invertion(parseDoubleOrFailWithZero(invertion));
    }    
    
    private Node ui;
    

    public Node ui() {
    	        
        Font headerFont = Font.font("BirchStd", FontWeight.BOLD, 15);
                                                  
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
       // Label invertionLabel = new Label("Invertion probability:");
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
        
        
        gaPropPane.getStyleClass().add("modulePane1Child");
         

        ui=		new TitledPane("Genetic Algorithm", gaPropPane);

        return ui;
	}
	

	/* (non-Javadoc)
	 * @see plt.gui.algorithms.NeuroEvolutionConfigurator#testParameters()
	 */
	public String testParameters() {
        
		
		
		InlineGeneticAlgorithmConfigurator test = new InlineGeneticAlgorithmConfigurator(this);
		return test.testParameters();
		
      
	}

}
