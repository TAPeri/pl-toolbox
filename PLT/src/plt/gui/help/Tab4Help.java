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

package plt.gui.help;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import plt.gui.customcomponents.ModalPopup;

/**
*
* Help page for the algorithm selection page
*
* @author Vincent Farrugia
* @author Hector P. Martinez
*/
public class Tab4Help extends ModalPopup {
        public void show(Parent parent, final EventHandler<MouseEvent> eventHandler) {
            
            WebView w = new WebView();
            w.setMaxSize(450 , 400);
           
            WebEngine e = w.getEngine();
            e.loadContent("<h1>Preference Learning Toolbox</h1>\n" +
"<h2>Preference Learning Algorithms</h2>\n" +
"Once data is loaded, features preprocessed and a feature selection strategy selected, this screen shows the configuration of the Preference Learning algorithm that creates the final model.\n" +
"<h3>Evaluation method</h3>\n" +
"The user can select the training algorithm and the method to evaluate its performance.\n" +
"<h4>Training algorithms</h4>\n" +
"Two training algorithms for <b>multi-layer perceptrons</b> [1] and one for <b>support vector machines</b> [2] are supported, namely <b>backpropagation</b> [3], <b>neuroevolution</b> [4] and <b>ranking SVM</b> [5].\n" +
"<ul>\n" +
"	<li>Multi-layer perceptron: this is the most common artificial neural network topology. It features a set of neurons organized in a sequence of layers. The output of each neuron is an input to every neuron in the next layer. The input features are connected to all the neurons in the first layer and the output of the neurons in the last layer form the outputs of the network. The user can choose the <b>number of layers</b>, the <b>number of neurons per layer</b> (except for the output layer which contains a single neuron) and the <b>activation function</b> of each neuron, affecting the complexity of the model trained.</li>\n" +
"           <ul><li>Backpropagation: this is a gradient-descent algorithm that iteratively "
                    + "(over a given <b>number of epochs</b>) optimizes an error function by adjusts the weights of the "
                    + "network proportionally to the gradient of the error with respect to the current value of the weights "
                    + "and current data samples. The proportion and therefofore the strength of each update is regulated by "
                    + "the given <b>learning rate</b>. The error function used is the Rank Margin function which for a given "
                    + "pair of data samples (A and B, with A preferred over B) yields 0 if the network output for A  "
                    + "(f<sup>A</sup>) is more than one unit larger than the network output for B (f<sup>B</sup>) and "
                    + "1.0-((f<sup>A</sup>)-(f<sup>B</sup>)) otherwise. The total error is averaged over the complete "
                    + "set of pairs in the training set. If the error is below a given <b>threshold</b>, "
                    + "training stops before reaching the specified number of epochs, and the current weight values are returned as final model.</li>\n" +
"           <li>Neuro-evolution: this is a genetic-search based algorithm that iteratively optimizes a set (population) of neural "
                    + "networks (individuals) to maximize a fitness function. The fitest neural network after a given number of "
                    + "iterations (<b>generations</b>) is returned as the trained model. The set of individuals on each generation "
                    + "is created by copying a given fraction of the fittest individuals in the previous generation "
                    + "(<b>elitism size</b>) and filling the rest of the population (<b>population size</b>) "
                    + "with offspring resulting from combining pairs of individuals in the previous population (parents). "
                    + "Parents are selected using a <b>roulette wheel</b> algorithm that selects two individuals proportionally "
                    + "to their fitness from a given fraction of the fittest individuals (<b>parents</b>). "
                    + "Once a pair of individuals is selected, they are combined applying a cross-over operator "
                    + "(<b>cross-over type</b>) with a given probability (<b>cross-over probability</b>) "
                    + "and a Gaussian mutation (mean equal to 0.0 and standard deviation equal to 0.1) to each gene "
                    + "(network weight) with a given probability (<b>mutation probability</b>). For each network and "
                    + "pair in the dataset, the fitness function calculates the logistic sigmoid function of the difference "
                    + "between the network's output for the preferred and the network's output for the non-perferred objects "
                    + "in the pair. The parameter of the logistic function (which multiplies the output difference) "
                    + "is equal to 30 if the difference is positive and 5.0 otherwise. The fitness of a network is calculated "
                    + "as the average of this value over the complete set of training pairs.</li>\n" +
"       <li>Support vector machine: this is a binary classifier that separates the iput put samples linearly in a projected " +
"space. The decision boundary of the classifier is given by a linear combination of training samples "+
                    "(called <i>support vectors</i>) in the projected space. The projection in provided by the kernel function that the user must select. "
                    + "The support vector and weights are selected to satisfy a set of constrains derived from the input samples and a cost parameter (C) defined by the user which regulates the penalization of misclassified training samples; in this implementation," +
                    " the quadratic programmer solver contained in <a href=\"http://www.csie.ntu.edu.tw/~cjlin/libsvm/\">LIBSVM</a> is used." +
                    "<ul><li>Ranking SVM: this training algorithm uses the same solver as standard training algorithms for binary SVMs; "+
                    "the only difference lies in the set of constrains which are defined in terms of pairwise preferences between trainig samples.</li></ul>"+
                    "</ul>\n" +
"<h4>Evaluation method</h4>\n" +
"The user can choose to either train the models using the complete dataset (<b>no validation</b>) and therefore assesssing the performance as the percentage of correctly classified training pairs or can test the generability of the results by using <b>K-fold cross validation</b> that will train <b>k</b> models using different partitions of the data and return the percentage of correctly classified pairs not used for training (validation accuracy).\n" +
"\n" +
"<h2>Execution and Results</h2>\n" +
"With the algorithm configured, pressing the button <b>run</b> will start the feature selection and model training algorithms and show an approximated progress report. Once the whole process is completed, a summary screen with the configuration of each step as well as the training and validation accuracies of the final models are displayed. The final models can be saved individually by clicking on their accuracy pressing <b>Save Model</b>."+
     "<h2>References</h2>\n" +
            "<ul>"+
             "<li>[1] C.M. Bishop. <i>Neural networks for pattern recognition</i>. Oxford university press, 1995</li>"+
             "<li>[2] C. Cortes and V. Vapnik. <i>Support-vector networks</i>. Machine learning, 20(3):273–297, 1995</li>"+
             "<li>[3] B. Bai, J. Weston, D. Grangier, R. Collobert, K. Sadamasa, Y. Qi, O. Chapelle, and " +
"K. Weinberger. <i>Learning to rank with (a lot of) word features</i>. Information retrieval, 13(3):291–314, 2010.</li>"+
             "<li>[4] G.N. Yannakakis, M. Maragoudakis, and J. Hallam. <i>Preference learning for cognitive modeling: a case study on entertainment preferences</i>. "+
                    "Systems, Man and Cybernetics, Part A: Systems and Humans, IEEE Transactions on, 39(6):1165–1175, 2009.</li>"+
             "<li>[5] T. Joachims, <i>Optimizing Search Engines Using Clickthrough Data</i>. Proceedings of the ACM Conference on Knowledge Discovery and Data Mining (KDD), ACM, 2002. </li>"+               
                    "</ul>");
            super.show(w, parent,null,new Button("close"), 500,500,false);  
        }
}
