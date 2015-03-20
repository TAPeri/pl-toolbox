package plt.gui.dataset;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;


/*
 * Legacy code; most likely deprecated
 * 
 */
public class ToolTipCreator implements Runnable
{
	
    Pane customToolTipNode;
    Popup toolTip;
    
    Stage stage;

    long tooltipDelay_ms = 1500;
    Node uiComponent;
    String ttStr;
    
    public ToolTipCreator(Node para_uiComponent, String para_TTTextStr,Stage stage)
    {
        uiComponent = para_uiComponent;
        ttStr = para_TTTextStr;
        this.stage = stage;
    }
    
    @Override
    public void run()
    {
        try 
        {
            Thread.sleep(tooltipDelay_ms);
        }
        catch (InterruptedException ex) 
        {
            Logger.getLogger(DataSetTab.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        if(uiComponent.hoverProperty().getValue())
        {
            // Display Tool Tip.
            
            Platform.runLater(new Runnable() 
            {
                @Override public void run()
                {
                    customToolTipNode = new Pane();
                    double maxToolTipWidth = 260;

                    double tooltipTextWidth = ttStr.length() * 7;

                    double actualToolTipWidth;
                    if(tooltipTextWidth < maxToolTipWidth)
                    {
                        actualToolTipWidth = tooltipTextWidth;
                    }
                    else
                    {
                        actualToolTipWidth = maxToolTipWidth;
                    }

                    int numOfTTLines = (int) (tooltipTextWidth / maxToolTipWidth); 
                    if((tooltipTextWidth % maxToolTipWidth) != 0) {numOfTTLines++;}

                    double actualToolTipHeight = numOfTTLines * 20 + 10;

                    customToolTipNode.setPrefSize(actualToolTipWidth,actualToolTipHeight);
                    customToolTipNode.setId("ToolTipBox");

                    Text ttText = new Text(10,20,ttStr);
                    ttText.setWrappingWidth(actualToolTipWidth);
                    customToolTipNode.getChildren().add(ttText);

                    toolTip.getContent().clear();
                    toolTip.getContent().add(customToolTipNode);
                    


                    Point mousePt = MouseInfo.getPointerInfo().getLocation();


                    toolTip.show(stage.getScene().getWindow(), mousePt.x+10, mousePt.y+10);
                }
            });
           
            
            System.out.println("Displayed Tooltip");
        }
    }
    
}
