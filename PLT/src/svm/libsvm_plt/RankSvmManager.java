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

package svm.libsvm_plt;


import java.util.ArrayList;
import java.util.HashMap;

import plt.dataset.TrainableDataSet;
import plt.featureselection.SelectedFeature;
import plt.utils.Preference;
import plt.utils.ANN.SimpleNeuralNetwork;
import svm.libsvm.svm;
import svm.libsvm.svm_model;
import svm.libsvm.svm_node;
import svm.libsvm.svm_parameter;

/**
 *
 * @author Institute of Digital Games, UoM Malta
 */
public class RankSvmManager implements IRankSvm,Cloneable
{
    PL_Object[] curr_objects;
    PL_Ranking[] curr_rankings;
    int curr_numFeatures;
    
    svm_parameter curr_algParams;      // Algorithm parameters used during training.
    svm_problem_pl curr_dataset;       // Dataset used to train the model.
    svm_model curr_model;              // Current model.
    
    public boolean performSetup(TrainableDataSet para_trainingDataSet,
                                SelectedFeature para_fSelected,
                                HashMap<String,Object> para_userConfig)
    {
        // Convert PLT representation of objects.
        Object[] retData = createPLObjects(para_trainingDataSet, para_fSelected);
        PL_Object[] objects = (PL_Object[]) retData[0];
        int numFeatures = (int) retData[1];
        
        // Convert PLT representation of rankings.
        PL_Ranking[] rankings = createPLRankings(para_trainingDataSet, para_fSelected);
        
        
        // Safety Check.
        if((objects == null)||(rankings == null)) return false;
        
        
        svm_parameter algParams = createRankSVMAlgParams(para_userConfig);        
        svm_problem_pl dSet = createDataset(objects, rankings, numFeatures);
        
        
        
        curr_objects = objects;
        curr_rankings = rankings;
        curr_numFeatures = numFeatures;
        
        curr_algParams = algParams;
        curr_dataset = dSet;
        curr_model = null;
        
        return true;
    }
    
    @Override
    public boolean runRankSVM() throws InterruptedException
    {
        // Safety Check.
        if(curr_dataset == null) return false;
                
        
        System.out.println("Running PLT_SVM...");
              
        // This extension of LIBSVM provides Rank SVM for PLT.
        svm_model trainedModel = null;
        if(curr_algParams.svm_type == svm_parameter.RANK)
        {
            // Construct model via training.
            trainedModel = svm.svm_train(curr_dataset, curr_algParams);
        }        
        curr_model = trainedModel;
        
        System.out.println("PLT_SVM Done.");
        
        return true;
    }
    
    @Override
    public double calculateUtility(double[] para_instanceFeatureData)
    {
        if(curr_model == null)
        {
            // Training has not yet occurred.
            return 0;
        }
        else
        {
            svm_node[] convertedInstance = new svm_node[curr_numFeatures];
            for(int i=0; i<curr_numFeatures; i++)
            {
                convertedInstance[i] = new svm_node();
                convertedInstance[i].index = i+1;      // To abide with 1-based indexing of svm_nodes.
                convertedInstance[i].value = para_instanceFeatureData[i];
            }

            return svm.svm_pl_calculateUtility(curr_model, curr_algParams, curr_dataset, convertedInstance);
        }
    }
    
    @Override
    public SVMDataStore getDataForSVsAndAlphas(TrainableDataSet para_dSet)
    {
        
        double[][] svData_rankPairs = null;
        double[][] svData_objData = null;
        double[] alphas = null;
        int[] objID_actuals = null;
        
        
        ArrayList<double[]> tmpRList = new ArrayList<>();
        ArrayList<Double> tmpAlphList = new ArrayList<>();
        ArrayList<Integer> idsOfEncounteredObjs = new ArrayList<>();
        ArrayList<double[]> tmpObjData = new ArrayList<>();
        
        for(int i=0; i<curr_model.SV.length; i++)
        {
            double tmpAlpha = curr_model.sv_coef[0][i];
            
            if(tmpAlpha != 0)
            {                
                svm_node[] svRPair = curr_model.SV[i];
                
                int prefObj_internalID = (int) svRPair[0].value;
                int nonPrefObj_internalID = (int) svRPair[1].value;
                
                PL_Object prefObj = curr_dataset.pl_objArr_orig[prefObj_internalID];
                PL_Object nonPrefObj = curr_dataset.pl_objArr_orig[nonPrefObj_internalID];
                
                int prefObj_actualID = prefObj.getObjIDActual();
                int nonPrefObj_actualID = nonPrefObj.getObjIDActual();
                
                if(! idsOfEncounteredObjs.contains(prefObj_actualID))
                {
                    idsOfEncounteredObjs.add(prefObj_actualID);
                    tmpObjData.add(para_dSet.getFeatures(prefObj_internalID));
                }
                
                if(! idsOfEncounteredObjs.contains(nonPrefObj_actualID))
                { 
                    idsOfEncounteredObjs.add(nonPrefObj_actualID);
                    tmpObjData.add(para_dSet.getFeatures(i));
                    
                    //svm_node[] svRPair_nonPrefObj = curr_dataset.pl_objs[nonPrefObj_internalID];
                    //tmpObjData.add(convertSvmNodeArrayToDoubleArray(svRPair_nonPrefObj));
                }
                
                tmpAlphList.add(tmpAlpha);
                tmpRList.add(new double[] { prefObj_actualID, nonPrefObj_actualID });
            }      
        }
        
        
        
        svData_rankPairs = new double[tmpRList.size()][];
        for(int i=0; i<tmpRList.size(); i++)
        {
            svData_rankPairs[i] = tmpRList.get(i);
        }
        
        svData_objData = new double[tmpObjData.size()][];
        for(int i=0; i<tmpObjData.size(); i++)
        {
            svData_objData[i] = tmpObjData.get(i);
        }
        
        alphas = new double[tmpAlphList.size()];
        for(int i=0; i<tmpAlphList.size(); i++)
        {
            alphas[i] = tmpAlphList.get(i);
        }
        
        objID_actuals = new int[idsOfEncounteredObjs.size()];
        for(int i=0; i<idsOfEncounteredObjs.size(); i++)
        {
            objID_actuals[i] = idsOfEncounteredObjs.get(i);
        }
        
        
        SVMDataStore retStore = new SVMDataStore(svData_rankPairs, svData_objData, alphas, objID_actuals);
        return retStore;
        
    }
    
    
    
    /*public double calculateAccuracy()
    {
        return calculateAccuracy(curr_model,curr_algParams,curr_dataset,curr_dataset);
    }
    
    public double calculateAccuracy(svm_model para_trainedModel,
                                    svm_parameter para_algParams,
                                    svm_problem_pl para_trainingDataset,
                                    svm_problem_pl para_testingDataset)
    {
        return svm.svm_pl_accuracyChecks(para_trainedModel, para_algParams, para_trainingDataset, para_testingDataset);
    }*/
    
    
    private double[] convertSvmNodeArrayToDoubleArray(svm_node[] para_svmNodeArr)
    {
        double[] convertedArr = new double[para_svmNodeArr.length];
        for(int i=0; i<para_svmNodeArr.length; i++)
        {
            convertedArr[i] = para_svmNodeArr[i].value;
        }
        
        return convertedArr;
    }
    
    
    private Object[] createPLObjects(TrainableDataSet para_tDataSet, SelectedFeature para_fSelected)
    {
        
        int numObjects = para_tDataSet.getNumberOfObjects();
        
        PL_Object[] plObjArr = new PL_Object[numObjects];
        for(int i=0; i<numObjects; i++)
        {
            plObjArr[i] = new PL_Object(para_tDataSet.getID(i), i, para_fSelected.select(para_tDataSet.getFeatures(i)));
        }
        
        Object[] retData = new Object[2];
        retData[0] = plObjArr;
        retData[1] = plObjArr[0].getNumFeatures();
        return retData;
    }
    
    private PL_Ranking[] createPLRankings(TrainableDataSet para_tDataSet, SelectedFeature para_fSelected)
    {
        int numPreferences = para_tDataSet.getNumberOfPreferences();
        
        PL_Ranking[] plRankArr = new PL_Ranking[numPreferences];
        for(int i=0; i<numPreferences; i++)
        {
            Preference p = para_tDataSet.getPreference(i);
            plRankArr[i] = new PL_Ranking(p.getPreferred(), p.getOther());
        }
        
        return plRankArr;       
    }
    
    
        
    private svm_problem_pl createDataset(PL_Object[] para_objects,
                                         PL_Ranking[] para_rankings,
                                         int para_numOfFeatures)
    {
        // Prepare the SVM Dataset. Note: Use svm_problem_plt instead of svm_problem.
        svm_problem_pl prob = new svm_problem_pl();
        prob.l = para_rankings.length;
        prob.y = new double[prob.l];


        
        prob.x = new svm_node [prob.l][2];
        for(int i=0;i<prob.l;i++)
        {
            // X stores rank pairs.
            PL_Ranking rankDataSample = para_rankings[i];
            prob.x[i][0] = new svm_node();
            prob.x[i][0].index = 1;
            prob.x[i][0].value = rankDataSample.objID_pref;
            prob.x[i][1] = new svm_node();
            prob.x[i][1].index = 2;
            prob.x[i][1].value = rankDataSample.objID_nonPref;

            // Y (desired vals) is set to all 1s for PLT.
            prob.y[i] = 1;
        }


        // Fill in pl_objs. PLT SVM will require feature data.
        prob.pl_objs = new svm_node[para_objects.length][para_numOfFeatures];
        for(int i=0; i<para_objects.length; i++)
        {
            PL_Object objectDataSample = para_objects[i];
            for(int f=0; f<para_numOfFeatures; f++)
            {
                prob.pl_objs[i][f] = new svm_node();
                prob.pl_objs[i][f].index = f+1;      // To abide with 1-based indexing of svm_nodes.
                prob.pl_objs[i][f].value = objectDataSample.features[f];
            }
        }


        // Keep references to object and ranking , data objects.
        prob.pl_objArr_orig = para_objects;
        prob.pl_rankingArr_orig = para_rankings;
        
        return prob;
    }
    
    
    private svm_parameter createRankSVMAlgParams(HashMap<String,Object> para_userConfig)
    {
        // Set Default Rank SVM Algorithm Parameters.
        svm_parameter param = new svm_parameter();        
        param.svm_type = svm_parameter.RANK;            // For Preference Learning / Rank SVM.
        param.kernel_type = svm_parameter.LINEAR;
        param.degree = 3;
        param.gamma = 0;
        param.coef0 = 0;
        param.nu = 0.5;
        param.cache_size = 40;
        param.C = 1;
        param.eps = 1e-3;
        param.p = 0.1;
        param.shrinking = 1;
        param.probability = 0;
        param.nr_weight = 0;
        param.weight_label = new int[0];
        param.weight = new double[0];
        
        if(param.gamma == 0) param.gamma = 0.5;
        
        
        
        // Override with User Specified Parameters.
        
        String kernelType = (String) para_userConfig.get("kernel");
        if(kernelType.equals("Linear")) { param.kernel_type = svm_parameter.LINEAR; }
        else if(kernelType.equals("Poly")) { param.kernel_type = svm_parameter.POLY; }
        else if(kernelType.equals("RBF")) { param.kernel_type = svm_parameter.RBF; }
        
        // Guaranteed to be != 0 due to pre-experiment validation check.
        param.gamma = (double) para_userConfig.get("gamma");
        param.degree = (int) ((double) para_userConfig.get("degree"));
        
        return param;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
    

        RankSvmManager copy = new RankSvmManager();
        
        copy.curr_objects = this.curr_objects;
        copy.curr_rankings = this.curr_rankings;
        copy.curr_numFeatures = this.curr_numFeatures;

        
        copy.curr_algParams = (svm_parameter)this.curr_algParams.clone();
        copy.curr_dataset = this.curr_dataset;
        if(this.curr_model!= null)
        	copy.curr_model = (svm_model)this.curr_model.clone();        

        return copy;
    }
}
