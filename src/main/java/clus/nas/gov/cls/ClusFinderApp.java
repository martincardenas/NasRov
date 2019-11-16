package clus.nas.gov.cls;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import clus.nas.gov.cls.utils.ClusterFinder;

public class ClusFinderApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
 
		if (args.length == 0) {
			System.out.println("Please enter the input file as argument i.e. input0.txt, input1.txt, input2.txt ");
			return;
		}

		
		
		String[] inpD = null;
		
		try(BufferedReader in = new BufferedReader(new FileReader(".//"+ args[0]))) {
		    String str;
		    while ((str = in.readLine()) != null) {
		    	
		    	 inpD = str.split(","); 
		    }
		}
		catch (IOException e) {
		    System.out.println("File Read Error" + e.getMessage());
		}
		
		//Convert String[] to double[]
		double[] inpDD = Arrays.stream(inpD).mapToDouble(Double::parseDouble).toArray();
		
		
		
		// Get the calculator
		ClusterFinder clsC = new ClusterFinder(inpDD,3,.20);
		// Call the cluster finder
		HashMap<Integer,ArrayList> foundClustersMap = clsC.getClusters();
		
		System.out.println("\nClusters Found for this position coordinates :"+ foundClustersMap);
		
		
		ArrayList<Double> finClus = new ArrayList<Double>();
		
		ArrayList<Double> cls1 = foundClustersMap.get(1);
		ArrayList<Double> cls2 = foundClustersMap.get(2);
		ArrayList<Double> cls3 = foundClustersMap.get(3);
		
		
		
		// Get the Theta per group cluster

		// return ArrayList<Double> of 3 group Theta calculations.

		
		finClus.add(clsC.getClusTheta(cls1, .20));
		finClus.add(clsC.getClusTheta(cls2, .20));
		finClus.add(clsC.getClusTheta(cls3, .20));

		

		
		
		
		
		
		// Print out the results
		System.out.println("\nTheta calculations for clusters :" + finClus);
		
		


	}

}
