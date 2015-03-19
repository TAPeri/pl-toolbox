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

package plt.dataset.datareader;

import java.util.*;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import plt.dataset.DataParser;
import plt.dataset.DataSet;
import plt.utils.Preference;

/**
 * Reader for a 2-file format. 
 * Objects file contains the input samples (1 per row)
 * The order file specify the partial orders between input samples (each row a sequence of IDs, from higher to lower)
 *
 * @author Institute of Digital Games, UoM Malta
 */
public class ObjectsOrderFormat implements DataSet {

    
    private String[][] features;//Objects
    private List<Preference> instances;//orders
    
    private String[] featuresName;
    private String IDname;
    //private boolean isReady;
    
    private boolean[] numeric;
    private List<Integer> atomicGroups;
    
    private HashMap<Integer, Integer> ID2feature;//ID -> feature Idx
    private HashMap<Integer, Integer> feature2ID;//featyre Idx -> ID
    
    private HashMap<Integer, Object> featureToMinValMap;
    private HashMap<Integer, Object> featureToMaxValMap;
    
    private int numOfPreferences;

    
    public int getID(int idx){
    	return feature2ID.get(idx);
    
    }
    
    public ObjectsOrderFormat() 
    {
       // this.isReady = false;
        
        /*this.objects = null;
        this.order = null;
        
        this.localParseStatusObjects = new DataFileParseStatus();
        this.localParseStatusOrders = new DataFileParseStatus();*/
        
        

        
        featureToMinValMap = new HashMap<>();
        featureToMaxValMap = new HashMap<>();
        
        numOfPreferences = 0;
        
        dataFilesValid = new SimpleBooleanProperty(false);
        
    }
    
    
    
    public void addDataLoaderListener(ChangeListener<Boolean> listener){
    	dataFilesValid.addListener(listener);
    }
    
    private BooleanProperty dataFilesValid;
    
    private String parsingObjectsInformation = "";
    private String parsingOrderInformation = "";
    
    
    
    public String getParsingDetails(){
    	if(parsingOrderInformation.length()==0)
    		return parsingObjectsInformation;
    	else
    		return parsingObjectsInformation+"\n"+parsingOrderInformation;
    }
    
    
    public String setObjectData(DataParser parser){
    	
    	parsingObjectsInformation = parser.getDetails();
    	
    	if(parser.getData().size()==0){
    		dataFilesValid.setValue(false);
    		return "No objects found in file.";
    	}
    	
    	if(parser.getFeatureNames().size()==1){
    		dataFilesValid.setValue(false);
    		return "Objects only contain ID.";
    	}else{
    		
        	featuresName = new String[parser.getFeatureNames().size()-1];
        	IDname = parser.getFeatureNames().get(0);
    		for(int j = 1; j < parser.getFeatureNames().size(); j++){
    			
    			featuresName[j-1] = parser.getFeatureNames().get(j); 
    		}
    		
    	}
    	numFeatures = featuresName.length;

    	
    	features = new String[parser.getData().size()][parser.getFeatureNames().size()-1];//ID is removed
    	numeric = new boolean[parser.getFeatureNames().size()-1];
    	
    	//delete preferences
    	instances = new ArrayList<Preference>();
    	atomicGroups = new ArrayList<Integer>();
    	
    	for(int i = 0 ; i< numeric.length; i++)
    		numeric[i] = true;
    	
    	ID2feature = new HashMap<Integer, Integer>();
    	feature2ID = new HashMap<Integer, Integer>();
    	
    	
    	for(int i = 0; i < parser.getData().size(); i++){
    		
    		int ID = Integer.valueOf(parser.getData().get(i).get(0));
    		ID2feature.put(ID, i);///ID -> index on features
    		feature2ID.put(i, ID); //orderToActualObjID.put(entryNum, indentifier);//line number - comments - feature line -> ID (int)
    		
    		for(int j = 1; j < parser.getFeatureNames().size(); j++){
    			
    			features[i][j-1] = parser.getData().get(i).get(j);    	
    			
                try {
                    Double.parseDouble(parser.getData().get(i).get(j));
                }catch (NumberFormatException e) {
                    this.numeric[j-1] = false;
                }
    		}
    	}
    	
    	calculateMinNMaxForAllData();
    	dataFilesValid.setValue(false);//Need a new order file

    	return "Valid object file: "+  parser.getStatus().getDescription()+"\n"
		+ "Number of samples: "+getNumberOfObjects()+"\n"
		+ "Number of features: "+getNumberOfFeatures();
    	

    }
    
    public String setOrderData(DataParser parser){
    	
    	parsingOrderInformation = parser.getDetails();
    	
    	instances = new ArrayList<Preference>();
    	atomicGroups = new ArrayList<Integer>();
    	
    	numOfPreferences = parser.getData().size();
    	
    	if((ID2feature==null)||(ID2feature.size()==0))
    		return  "Load object file first.";
    	
    	if(parser.getData().size()==0){
    		dataFilesValid.setValue(false);
    		return "No orders in file.";
    	}
    	

    	
    	for(int i = 0; i < parser.getData().size(); i++){

    		
        	if(parser.getData().get(i).size()<3){//at least ID + two objects
        		dataFilesValid.setValue(false);
        		return "Line "+i+" contains less than two objects.";
        	}
    		
    		int ID = Integer.valueOf(parser.getData().get(i).get(0));
    		
    		int[] order = new int[parser.getData().get(i).size()-1];
    		
    		for(int j = 1; j < parser.getData().get(i).size(); j++){
    			
    			int objectID = -1;
    			
    			try {
    				  
    						
    				objectID	=Integer.valueOf(parser.getData().get(i).get(j));  
    				
        			if(!ID2feature.containsKey(objectID)){
        				dataFilesValid.setValue(false);
        				return "Object with ID "+order[j-1]+" not found on object file. Line "+i;
        			}else{
        				order[j-1] =ID2feature.get(objectID);
        				
        			}
    				
                }catch (NumberFormatException e) {
                	
                   dataFilesValid.setValue(false);
                   return "Order file must contain ID integer values. Found \""+parser.getData().get(i).get(j)+"\" at line "+i;
                }
    			

    			
    		}
    		
    		for (Preference p : Preference.listToPairWisePreference(order)) {
                //instances.add(p);
    			instances.add(p);
                atomicGroups.add(ID);//group ID
            }
    		
    	}
    	
    	dataFilesValid.setValue(true);
    	
    	return  "Valid order file: "+parser.getStatus().getDescription()+"\n"
    			+ "Number of pairwise preferences: "+getNumberOfPreferences();

    }
    
    public String setSingleFile(DataParser parser) {
    	
    	parsingObjectsInformation = parser.getDetails();
    	parsingOrderInformation = "";
    	
    	features = new String[parser.getData().size()][parser.getFeatureNames().size()-2];//ID and ratings are removed
    	
    	
    	featuresName = new String[parser.getFeatureNames().size()-2];
    	
    	numFeatures = featuresName.length;
    	
    	IDname = parser.getFeatureNames().get(0);
		for(int j = 1; j < parser.getFeatureNames().size()-1; j++){
			
			featuresName[j-1] = parser.getFeatureNames().get(j); 
		}
		
    	numeric = new boolean[parser.getFeatureNames().size()-2];
    	instances = new ArrayList<Preference>();
    	atomicGroups = new ArrayList<Integer>();
    	
    	double[] ratings = new double[parser.getData().size()];
    	
    	for(int i = 0 ; i< numeric.length; i++)
    		numeric[i] = true;
    	
    	ID2feature = new HashMap<Integer, Integer>();
    	feature2ID = new HashMap<Integer, Integer>();
    	
    	
    	for(int i = 0; i < parser.getData().size(); i++){
    		
    		int ID = Integer.valueOf(parser.getData().get(i).get(0));
    		ID2feature.put(ID, i);///ID -> index on features
    		feature2ID.put(i, ID); //orderToActualObjID.put(entryNum, indentifier);//line number - comments - feature line -> ID (int)
    		
    		for(int j = 1; j < parser.getFeatureNames().size()-1; j++){
    			
    			features[i][j-1] = parser.getData().get(i).get(j);    	
    			
                try {
                    Double.parseDouble(parser.getData().get(i).get(j));
                }catch (NumberFormatException e) {
                    this.numeric[j-1] = false;
                }
    		}
    		
            try {
                ratings[i] = Double.parseDouble(parser.getData().get(i).get(parser.getFeatureNames().size()-1));
            }catch (NumberFormatException e) {
            	dataFilesValid.setValue(false);
                return "Found non numerical rating ("+parser.getData().get(i).get(parser.getFeatureNames().size()-1)+")in line "+i;
            }
    	}
    	
    	for(int i=0;i<ratings.length-1;i++){
    		
    		for(int j=i+1;j<ratings.length;j++){
    			
    			if(ratings[i]>ratings[j]){
    				instances.add(new Preference(i,j));
    				atomicGroups.add( feature2ID.get(i));
    			}
    			else if(ratings[i]<ratings[j]){
    				instances.add(new Preference(j,i));
    				atomicGroups.add( feature2ID.get(i));
    			}
    			
    		}
    	}
    	
    	numOfPreferences = ratings.length;
    	
    	
    	calculateMinNMaxForAllData();
    	
    	dataFilesValid.setValue(true);

    	
    	return "Valid object file: "+  parser.getStatus().getDescription()+"\n"
		+ "Number of samples: "+getNumberOfObjects()+"\n"
		+ "Number of features: "+getNumberOfFeatures()+"\n"
		+ "Number of pairwise preferences: "+getNumberOfPreferences();
    	
    	// TODO Auto-generated method stub
    	
    }
    
    public int getObjActualID(int para_objOrderID) {
        return feature2ID.get(para_objOrderID);
    }
    
    @Override
    public int getNumberOfObjects() {

        return features.length;
    }

    @Override
    public int getNumberOfPreferences() {

        return numOfPreferences;
    }

    int numFeatures = 0;
    
    @Override
    public int getNumberOfFeatures() {
    	return numFeatures;
//        return features[0].length;
    }

    @Override
    public String getFeatureName(int n) {

        if (n >= this.getNumberOfFeatures() || n < 0) {
            throw new IllegalArgumentException();
        }

        if (this.featuresName != null) {
            if (n < this.featuresName.length) {
                return this.featuresName[n];
            }
        }

        return "Unknown";
    }
    
    public String getIDName(){
    	return IDname;
    }

    @Override
    public String[] getFeatures(int n) {

        if (n >= this.getNumberOfObjects() || n < 0) {
            throw new IllegalArgumentException();
        }

        return features[n];
    }

    @Override
    public String getFeature(int n, int f) {

        if (n >= this.getNumberOfObjects() || n < 0) {
            throw new IllegalArgumentException();
        }

        if (f >= this.getNumberOfFeatures() || f < 0) {
            throw new IllegalArgumentException();
        }

        return features[n][f];
    }

    @Override
    public Preference getPreference(int n) {

        if (n >= this.getNumberOfPreferences() || n < 0) {
            throw new IllegalArgumentException();
        }
        return this.instances.get(n);
    }

    @Override
    public int atomicGroup(int n) {
        return this.atomicGroups.get(n);
    }

    @Override
    public boolean isNumeric(int f) {
        return this.numeric[f];
    }

    public String toString() {
        return "{Dataset: " + super.toString() + "}";
    }
    
    private void calculateMinNMaxForAllData()
    {
        int numObjects = this.getNumberOfObjects();
        int numFeatures = this.getNumberOfFeatures();
        
        for(int c=0; c<numFeatures; c++)
        {
            if(this.isNumeric(c))
            {
                double currentMin = Double.parseDouble(this.getFeature(0, c));
                double currentMax = Double.parseDouble(this.getFeature(0, c));
                
                for(int r=0; r<numObjects; r++)
                {
                    double tmpVal = Double.parseDouble(this.getFeature(r, c));
                    
                    if(tmpVal < currentMin)
                    {
                        currentMin = tmpVal;
                    }
                    
                    if(tmpVal > currentMax)
                    {
                        currentMax = tmpVal;
                    }
                }
                
                featureToMinValMap.put(c, currentMin);
                featureToMaxValMap.put(c, currentMax);
            }
        }
    }
    
    public Object getMinValForFeature(int feature)
    {
        if(featureToMinValMap.containsKey(feature))
        {
            return featureToMinValMap.get(feature);
        }
        else
        {
            return null;
        }
    }
    
    public Object getMaxValForFeature(int feature)
    {
        if(featureToMaxValMap.containsKey(feature))
        {
            return featureToMaxValMap.get(feature);
        }
        else
        {
            return null;
        }
    }
}