package plt.gui.dataset;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;


/*
 * 
 * Deprecated
 * 
 */
public class UramakiMouseEventHandler implements EventHandler<MouseEvent>
{

    @Override
    public void handle(MouseEvent mouseEvent)
    {
        String eTypeName = mouseEvent.getEventType().getName();
        
       /* if(((eTypeName).equals("MOUSE_ENTERED"))
        ||((eTypeName).equals("MOUSE_EXITED")))
        {
        	
            Node uiComponent = (Node) mouseEvent.getSource();
            
            
            
            
            if((eTypeName).equals("MOUSE_ENTERED"))
            {
                final String tooltipHelpText = "";//helpStore.getToolTip(uiComponent_id);

                

                
                ToolTipCreator nwTTCjob = new ToolTipCreator(uiComponent,tooltipHelpText);
                Thread nwTTThread = new Thread(nwTTCjob);
                nwTTThread.start();
                
                       
                System.out.println("Testing");
                
                
            }
            else if((eTypeName).equals("MOUSE_EXITED"))
            {
                
                toolTip.hide();
            }
        }*/
        
        
        
    }
}
