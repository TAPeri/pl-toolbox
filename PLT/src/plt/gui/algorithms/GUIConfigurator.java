package plt.gui.algorithms;

import plt.plalgorithm.PLAlgorithm;
import javafx.scene.Node;

public interface GUIConfigurator {

    public Node ui();
	public String testParameters();
	public PLAlgorithm algorithm();
	
}
