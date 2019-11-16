package clus.nas.gov.cls.tst;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import clus.nas.gov.cls.utils.ClusterFinder;

public class TestCaseA {
	
	
	double[] inpDD = null;
	int clusterCount = 3;
	double stdDev = .20;
	
	HashMap<Integer,ArrayList> clustersFound = null;
	
	ClusterFinder cf = new ClusterFinder();

	@Before
	public void setUp() throws Exception {
		
		String[] inpD = null;
		
		try(BufferedReader in = new BufferedReader(new FileReader(".//input0.txt"))) {
		    String str;
		    while ((str = in.readLine()) != null) {
		    	
		    	 inpD = str.split(","); 
		    }
		}
		catch (IOException e) {
		    System.out.println("File Read Error");
		}
		
		//Convert String[] to double[]
		inpDD = Arrays.stream(inpD).mapToDouble(Double::parseDouble).toArray();
		
		
		
	}

	@Test
	public void getCLusterGroup() {
		
		
		
		cf.setClusterCount(clusterCount);
		cf.setDataSet(inpDD);
		cf.setStdDev(stdDev);
		
		clustersFound = cf.getClusters();
		System.out.println("Clusters: " + clustersFound);
		assertNotNull("Response Message received is not NULL",clustersFound);
	}

	@Test
	public void getClusterTheta() {
		
		cf.setClusterCount(clusterCount);
		cf.setDataSet(inpDD);
		cf.setStdDev(stdDev);
		
		clustersFound = cf.getClusters();

		
		ArrayList<Double> finClus = new ArrayList<Double>();
		
		ArrayList<Double> cls1 = clustersFound.get(1);
		ArrayList<Double> cls2 = clustersFound.get(2);
		ArrayList<Double> cls3 = clustersFound.get(3);
		
		finClus.add(cf.getClusTheta(cls1, .20));
		finClus.add(cf.getClusTheta(cls2, .20));
		finClus.add(cf.getClusTheta(cls3, .20));


		System.out.println("Clusters Theta Value: " + finClus);
		
		assertNotNull("Response Message received is not NULL",finClus);
		
		
	}

}
