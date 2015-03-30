package plt.dataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import plt.dataset.datareader.DataFileParseStatus;

public class DataParser {
	
	private File file;
	private DataFileParseStatus status;

	private List<String> originalPreview;
	private List<List<String>> previewData;
	private List<String> features;
	private String separator;
		
	final private int previewSize = 10;
	
	boolean recomputePreview = true;
	
	
	private boolean IDcolumn;
	private int skipRows;
	private int skipColumns;
	private boolean featuresIncluded;
	final private String defaultValue = "?";
	private boolean squared = true;;
	
	public DataParser(File f,String sep, int rows, int columns,boolean IDin,boolean featuresIn,boolean sq){
		
		squared = sq;
		separator = sep;
		skipRows = rows;
		skipColumns = columns;
		IDcolumn = IDin;
		featuresIncluded = featuresIn;
		
		file = f;
		
		
		originalPreview = readLines(f,previewSize);	
		recomputePreview = true;
		
	}
	
	
	private List<String> readLines(File f,int numberLines){
		
        Scanner scanner;
        int lines = 0;
        List<String> output = new ArrayList<String>();
        
        try {
				scanner = new Scanner(new BufferedReader(new FileReader(f)));            

				while (scanner.hasNextLine() && (lines<numberLines)) {

					lines++;
					output.add(scanner.nextLine());

				}
            
				scanner.close();
		
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
            
        return output;
	}	
	


	
	public void setSeparator(String s){
		if(s==null)
			return;
		if (s.length()==0)
			return;
		if(!separator.equals(s)){
			separator = s;
			recomputePreview = true;
		}
	}
	
	public void setIDcolumn(boolean id){
		if(IDcolumn!=id){
			IDcolumn = id;
			recomputePreview = true;
		}
	}

	public void skipRows(int number) {
		if(number<0)
			number = 0;
		if(number!=skipRows){
			skipRows = number;
			originalPreview = readLines(file,previewSize+skipRows);
			recomputePreview = true;
		}
		
	}
	
	public void skipColumns(int number) {
		if(number<0)
			number = 0;
		if(number!=skipColumns){
			skipColumns = number;
			recomputePreview = true;
		}
		
	}
	
	public List<String> getFeatureNames(){
		
		if(recomputePreview){
			
			recomputePreview();
			
		}
		
		return features;
	}
	
	public List<List<String>> getPreviewData(){
		
		if(recomputePreview){
			recomputePreview();
		}
		
		return previewData;
		
	}
	
	
	public List<List<String>> getData(){
		
		if(data==null){
			processData();
		}
		return data;

	}
	
	
	List<List<String>> data;
	
	public DataFileParseStatus processData(){
		
		//TODO manage large files by reading the file in chuncks
		List<String> allData = readLines(file,Integer.MAX_VALUE);
		 
		data =  parse(allData,true);
		allData.clear();
		return status;
		
	}

	public DataFileParseStatus getStatus(){

		return status;
		
	}
	
	//Parses the 
	private void recomputePreview(){

		previewData = parse(originalPreview,false);
		recomputePreview = false;
	}
	
	private List<List<String>> parse(List<String> inData,boolean logErrors){
	
		
		if(logErrors)
			status = new DataFileParseStatus();
		
		features = new ArrayList<String>();
		List<List<String>> outData = new ArrayList<List<String>>();
		
		int offset = 0;
		if(featuresIncluded){
		
			offset++;
			
			if(skipRows<inData.size()){
				
				String[] featuresSplit = inData.get(skipRows).split(separator);

				if(!IDcolumn)
					features.add("ID");
				
				for(int i = skipColumns;i<featuresSplit.length;i++)
					features.add(featuresSplit[i]);
				
			}
			
		}
		
		int maxSize = features.size();
		
		for(int i = skipRows+offset;i<inData.size();i++){
			
			String[] rowSplit = inData.get(i).split(separator);
			
			List<String> row = new ArrayList<String>();

			if(!IDcolumn)
				row.add(""+(i-(skipRows+offset)));
			else{
				if(skipColumns<rowSplit.length)
					try{
						Integer.valueOf(rowSplit[skipColumns]);
					}catch(NumberFormatException ex){
						if(logErrors){
							status.setDescription(file.getAbsolutePath()+"\nID must be an integer. Found \""+rowSplit[skipColumns]+"\" in line "+i+".");
							status.setError(1);
							return new ArrayList<List<String>>();
						}
						
					}
			}
		
			for(int j = skipColumns; j<rowSplit.length;j++)
				row.add(rowSplit[j]);
			
			if(row.size()>maxSize)
				maxSize = row.size();
			
			outData.add(row);
			
		}
		
		if(featuresIncluded){
			if(logErrors&(features.size()<maxSize)){
				status.setDescription(file.getAbsolutePath()+"\nFound "+maxSize+" features but only "+features.size()+" feature labels.");
				status.setError(1);
				return new ArrayList<List<String>>();
			}
			
			while(features.size()<maxSize){
				features.add(defaultValue);
			}
		}
		
		if(squared)
			for(int i = 0; i< outData.size();i++){
				if(logErrors&(outData.get(i).size()<maxSize)){
					status.setDescription(file.getAbsolutePath()+"\nRow "+i+" contains only "+outData.get(i).size()+" values. "+maxSize+" values were expected.");
					status.setError(1);
					return new ArrayList<List<String>>();
				}else{
					while(outData.get(i).size()<maxSize)
						outData.get(i).add(defaultValue);
			
				}
			}
		
		
		if(!featuresIncluded){
			
			features = new ArrayList<String>();
			
			features.add("ID");
			for(int i=1;i<maxSize;i++)
				features.add("F"+(i-1));
			
		}
		
		if(logErrors){
			status.setDescription(file.getAbsolutePath());
			status.setError(0);
		}

		return outData;
	
	}



	public void setFeaturesIncluded(boolean newValue) {
		if(featuresIncluded!=newValue){
				featuresIncluded = newValue;
				recomputePreview = true;
		}
			
	}

}
