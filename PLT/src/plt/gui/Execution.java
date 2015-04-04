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
import java.util.logging.*;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import plt.experiments.Experiment;
import plt.gui.customcomponents.ExecutionModalPopup;
import plt.report.Report;
import plt.utils.TimeHelper;

/**
 *
 * Creates a window that launches the execution
 * of the experiment and displays the progress
 *
 * @author Vincent Farrugia
 * @author Hector P. Martinez
 * 
 */
public class Execution  {

    private final Experiment experiment;
    private final Logger logger;
    
    Thread execThread;
    Thread timerThread;
    boolean terminatedFlag;
    Report latestReport;
    
    Text txtCurrDuration;
    Calendar cStart;
    
    boolean haltTimerThread;
    
    public Execution(Experiment exp) {
        super();
        this.experiment = exp;
        this.logger =  Logger.getLogger("plt.logger");
        
        execThread = null;
        terminatedFlag = false;
        latestReport = null;
        
        haltTimerThread = false;
    }

    public void show(final Stage stage) {

        final Parent parent = stage.getScene().getRoot();
        
        final ExecutionModalPopup emp = new ExecutionModalPopup();
        
        	ListView<String> list = new ListView<>();

        		final ObservableList<String> items = FXCollections.observableArrayList();
        		list.setItems(items);
        		
        		//Add logs to the observable list of items
                logger.addHandler(new Handler() {

                    @Override
                    public void publish(LogRecord lr) {
                        final String log = lr.getMessage();
                        Platform.runLater(new Runnable() {

                            @Override
                            public void run() {
                                items.add(log);
                            }
                        });
                    }

                    @Override
                    public void flush() {
                    }

                    @Override
                    public void close() throws SecurityException {
                    }
                });
        		
        
        	final VBox progressUpdateBotBox = new VBox(2);        
        
        		final BorderPane progressUpdateFirstHBox = new BorderPane();
        		progressUpdateBotBox.getChildren().add(progressUpdateFirstHBox);
        
        
        			Text txtCurrTask = new Text(""); 
        			progressUpdateFirstHBox.setLeft(txtCurrTask);
        			txtCurrTask.textProperty().bind(ExecutionProgress.currTaskTextIndicator);
        	
        		
        			txtCurrDuration = new Text("");// WARNING: Using Label instead of Text hangs the program.
        			progressUpdateFirstHBox.setRight(txtCurrDuration);
        
            	final HBox progressUpdateHBox = new HBox(10);
            	progressUpdateBotBox.getChildren().add(progressUpdateHBox);       			
        			
        			
        			ProgressBar pBar = new ProgressBar(0);
        			progressUpdateHBox.getChildren().add(pBar);
            			pBar.progressProperty().bind(ExecutionProgress.totProgress);
            	
            		ProgressIndicator pIndi = new ProgressIndicator(-1);
            		progressUpdateHBox.getChildren().add(pIndi);
            	
            		final Button btnAbort = new Button("Abort");
            		progressUpdateHBox.getChildren().add(btnAbort);        
        
                    	EventHandler<MouseEvent> abortHandler = new EventHandler<MouseEvent>() {
                    		@Override
                    		public void handle(MouseEvent t) {
                    			terminatedFlag = true;
                    			if(execThread != null)
                    			{
                    				execThread.interrupt();
                    				ExecutionProgress.requestThreadInterrupt(1); // Algorithm thread.
                    				ExecutionProgress.requestThreadInterrupt(2); // Timer thread.
                    			}
                    		}
                    	};
            		
         emp.show(parent, list, progressUpdateBotBox, btnAbort, abortHandler, 400, 600);		
            		
            		
pBar.setPrefSize(460,20);        
pIndi.setPrefSize(20, 20);
btnAbort.setPrefSize(150, 20);
list.setMaxHeight(300);
list.setMaxWidth(450);


        
        final Execution self = this;
                
        final Button button = new Button("Running..");
        button.disableProperty().set(true);
        
        
        
        Task<Report> task = new Task<Report>() 
        {
            int threadID = 1;
            
            @Override
            protected Report call() throws Exception {
           
                ExecutionProgress.registerThread(threadID);
                return self.experiment.start();
            }
        };

        
        
        task.valueProperty().addListener(new ChangeListener<Report>() {

            @Override
            public void changed(ObservableValue<? extends Report> ov, Report t, Report t1) {
                
                if(! terminatedFlag)
                {
                    latestReport = t1;
                    
                    haltTimerThread = true;
                    
                    progressUpdateBotBox.getChildren().clear();
                    progressUpdateFirstHBox.getChildren().clear();
                    
                    
                    progressUpdateHBox.getChildren().clear();
                    btnAbort.setText("Close Console");
                    
                    Button btnGenerateReport = new Button("Generate Report");
                    btnGenerateReport.setOnMouseClicked(new EventHandler<MouseEvent>() 
                    {
                        @Override
                        public void handle(MouseEvent t) 
                        {
                            button.disableProperty().set(false);
                            button.textProperty().set("Close console");
                            ResultViewer v = new ResultViewer(experiment,latestReport);
                            v.show(stage);
                        }
                    });
                    
                    Button btnCompleteNotice = new Button("Execution Success");
                    btnCompleteNotice.setStyle("-fx-background-color: linear-gradient(#35C700, #227D01);"+"-fx-background-radius: 8;"+"-fx-background-insets: 0;"+"-fx-text-fill: white;");
                    
                    
                    progressUpdateHBox.getChildren().addAll(btnCompleteNotice,btnGenerateReport,btnAbort);
                    progressUpdateBotBox.getChildren().add(progressUpdateHBox);
                    
                    button.disableProperty().set(false);
                    button.textProperty().set("Close console");
                    ResultViewer v = new ResultViewer(experiment,latestReport);
                    v.show(stage);
                }

            }
        });
        
        timerThread = new Thread(new TimerTask());
        timerThread.start();
        
        execThread = new Thread(task);
        execThread.start();
    }
    
    class TimerTask implements Runnable
    {
        int threadID = 2;
        
        public TimerTask()
        {
            cStart = Calendar.getInstance();
        }

        
        String prevTime = "";
        
        @Override
        public void run() 
        {
            ExecutionProgress.registerThread(threadID);
            while((! haltTimerThread)&&(! ExecutionProgress.shutdownProgram)&&(! ExecutionProgress.hasInterruptRequest(threadID)))
            {
                Calendar currTStamp = Calendar.getInstance();
                
                if(!prevTime.equals(""+TimeHelper.calculateDuration(cStart, currTStamp))){
                	prevTime = ""+TimeHelper.calculateDuration(cStart, currTStamp);
                }
                //REMOVED
                //txtCurrDuration.setText( TimeHelper.calculateDuration(cStart, currTStamp) );
            }
            
            if((ExecutionProgress.needToShutdown())||(ExecutionProgress.hasInterruptRequest(threadID)))
            {
                ExecutionProgress.signalDeactivation(threadID);
            }
        }
    }
    
    
}