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

package plt.dataset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import plt.dataset.preprocessing.PreprocessingOperation;
import plt.utils.Preference;

 /**
 * a PreprocessedDataSet is a TrainableDataSet, created from a DataSet and list of operation to be
 * applied to the object's features. Any operation define a transformation that will be applied to a feature.
 * 
 * @author Vincent Farrugia
 * @author Hector P. Martinez
 * @author Luca Querella
 */
public class PreprocessedDataSet extends TrainableDataSet {


    private double[][] cache;

    private List<String> featureNames;
    
    private int[] objectIDs;
    
    private List<Set<Preference>> atomicGroups;
    private List<Preference> preferences;
    
    
    
    public PreprocessedDataSet(double[][] cache, List<Set<Preference>> atomicGroups,List<Preference> preferences,List<String> featureNames, int[] objectIDs) {

    	this.cache = cache;
    	this.atomicGroups = atomicGroups;
    	this.preferences = preferences;
    	this.featureNames = featureNames;
    	this.objectIDs = objectIDs;
    	
    }
    /**
     * Constructor for the PreprocessedDataSet
     * @param dataSet used as source for the PreprocessedDataSet
     * @param preprocessingOperations set of operation to be applied to the dataSet
     */
    public PreprocessedDataSet(DataSet dataSet, PreprocessingOperation[] preprocessingOperations) {
       // super(dataSet);
      //  this.dataSet = dataSet;
       // this.preprocessingOperations = preprocessingOperations;

        if (preprocessingOperations.length != dataSet.getNumberOfFeatures()) {
            throw new IllegalArgumentException();
        }

        int numberOfFeature = 0;
        for (int i = 0; i < dataSet.getNumberOfFeatures(); i++) {
            if (preprocessingOperations[i].numberOfOutput(dataSet,i) < 0) {
                throw new IllegalArgumentException();
            }
            
           /* if (this.dataSet != preprocessingOperations[i].getDataSet()) {
                throw  new IllegalArgumentException();
            }*/
            
            numberOfFeature += preprocessingOperations[i].numberOfOutput(dataSet,i);
        }

        
        
        this.cache = new double[dataSet.getNumberOfObjects()][numberOfFeature];
        for (int i = 0; i < cache.length; i++) {
            this.cache[i] = new double[numberOfFeature];
            for (int j = 0; j < this.cache[i].length; j++) {
                this.cache[i][j] = Double.NaN;
            }
        }

        objectIDs = dataSet.getIDs();
        
        preferences = dataSet.getPreferences();
        
        featureNames = new ArrayList<String>();
        
        int feature = 0;
        for (int originalFeature = 0; originalFeature < dataSet.getNumberOfFeatures(); originalFeature++) {
            for (int j = 0; j < preprocessingOperations[originalFeature].numberOfOutput(dataSet,originalFeature); j++) {
            	
            	for(int sample=0;sample<dataSet.getNumberOfObjects();sample++){
            		cache[sample][feature] = preprocessingOperations[originalFeature].value(dataSet,originalFeature, sample, j);
            	}
        		featureNames.add( preprocessingOperations[originalFeature].featureName(dataSet,originalFeature, j) );

            	feature++;
                //this.operationForFeature[counter++] = i;
            }
        }
        
        //Group together all preferences with the same groupID
        HashMap<Integer,Set<Preference>> hash = new HashMap<>();
        for (int i=0; i<dataSet.getNumberOfPreferences(); i++) {
            int groupID = dataSet.atomicGroup(i);
            Set<Preference> set = hash.get(groupID);
            if (set == null) {
                set = new HashSet<>();
                hash.put(groupID, set);
            }
            set.add(dataSet.getPreference(i));
        }
        
        //Sort the atomic groups by size (from larger to lower) in order
        //to facilitate equal size folds
        HashMap<Integer,Set<Integer>> sizeOrder = new HashMap<>();

        int max = 0;
        for(int ID : hash.keySet()){
        	int size = hash.get(ID).size();
        	if (size>max)
        		max = size;
        	if(!sizeOrder.containsKey(size)){
        		sizeOrder.put(size, new HashSet<Integer>());
        	}
        	sizeOrder.get(size).add(ID);
        }
                
        atomicGroups = new ArrayList<Set<Preference>>();
        
        for(int i = max; i>0;i--){
        	if(sizeOrder.containsKey(i))
        		for(int ID : sizeOrder.get(i))
        			atomicGroups.add(hash.get(ID));
        	
        }
        		

    }

    /**
     * Given a number in [0..this.getNumberOfIstances()-1] returns the nth preference.
     * A preference is defined between to objects.
     * @param n a number that identify the instance.
     * @return a preference between two objects. 
     */
    @Override
    public Preference getPreference(int n) {
        return preferences.get(n);
    }

    /**
     * Returns the number of the feature for the objects in the dataset
     * A feature is a property of an object and in the dataset all the 
     * objects have the same number and types of features
     * 
     * @return the number of the features for the object in the dataset
     */
    @Override
    public int getNumberOfFeatures() {
        return this.cache[0].length;
    }

     /**
     * Given a number n in [0..this.getNumberOfObjects()-1] and a number f in [0..this.getNumberOfFeatures()-1]
     * returns the fth feature of the nth object
     * @param n a number that identify the object
     * @param f a number that identify the feature
     * @return the fth feature of the nth object
     */
    @Override
    public double getFeature(int n, int f) {
    	
    	
        /*if (n < 0 || n > this.dataSet.getNumberOfObjects() - 1) {
            throw new IllegalArgumentException();
        }

        if (f < 0 || f > this.getNumberOfFeatures() - 1) {
            throw new IllegalArgumentException();
        }

        initCache();

        Double cacheValue = this.cache[n][f];

        if (cacheValue.isNaN()) {

            int value = 0;
            int i = f-1;

            while (i > 0 && this.operationForFeature[f] == this.operationForFeature[i--]) {
                value++;
            }

            
            cache[n][f] = this.preprocessingOperations[this.operationForFeature[f]].value(this.dataSet,f, n, value);
            cacheStatus[n] += 1;
        }*/

        return cache[n][f];
    }

     /**
     * Given a number in [0..this.getNumberOfObjects()-1] returns all the feature of the nth object
     * @param n a number that identify the object
     * @return an array with all the features of the nth object
     */
    @Override
    public double[] getFeatures(int n) {


        return cache[n];
    }

   /**
    *  Returns the number of the instances in the dataset
    *  An instance define a preference between 2 objects
    * 
    *  @return the number of instances in the dataset
    */
    @Override
    public int getNumberOfPreferences() {
        return this.preferences.size();
    }


    @Override
    public int getID(int i) {
        return this.objectIDs[i];
    }


    @Override
    public String toString() {
        
        return "{PreprocessedDataSet - number of feature(s): " + this.getNumberOfFeatures() +
                " number of istance(s): " + this.getNumberOfPreferences() + "}";
    }

	
    
    /**
     * @return all the atomicsGropus of the trainableDataSet
     * an atomic group is a set of pairwise preferences that
     * should not be separated during k-fold cross-validation
     * e.g. pairs that are created from a ranking
     * or all ratings from the same user
     */
    @Override
    public List<Set<Preference>> atomicGroups () {
    	
    	return atomicGroups;

    }

	@Override
	public TrainableDataSet subSet(Set<Integer> subset) {
		

		List<Preference> subsetPreferences = new ArrayList<Preference>();
		List<Set<Preference>> subsetAtomicGroups = new ArrayList<Set<Preference>>();
		for(int groupID : subset){
			subsetAtomicGroups.add(this.atomicGroups.get(groupID));
			subsetPreferences.addAll(this.atomicGroups.get(groupID));
		}
		
		return new PreprocessedDataSet(cache,subsetAtomicGroups,subsetPreferences,this.featureNames,this.objectIDs);
	}
	
	
	

	@Override
	public int getNumberOfObjects() {
		return cache.length;
	}
	@Override
	public String getFeatureName(int i) {
		return this.featureNames.get(i);
	}
	
	
   
}