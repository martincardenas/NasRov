package clus.nas.gov.cls.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import clus.nas.gov.cls.IClusterOps;

public class ClusterFinder implements IClusterOps {

	private double[] dataSet = null;
	private int clusterCount = 0;
	private double stdDev = 0.20;

	public ClusterFinder(double[] dataSet, int clusterCount, double stdDev) {

		this.dataSet = dataSet;
		this.clusterCount = clusterCount;
		this.stdDev = stdDev;
	}

	public ClusterFinder() {

	}

	@Override
	public HashMap<Integer,ArrayList> getClusters() {

		// simulate the cluster selection by grouping position coordinates by groups of
		// 3
		// Group 1: all position coordinates from 0.0 to <= 100
		// Group 2 : 101 <= 200
		// Group 3: 201 <= 300

		// Scan the dataset and assign each doble value to their appropriate group

		ArrayList<Double> cls1 = new ArrayList<Double>();
		ArrayList<Double> cls2 = new ArrayList<Double>();
		ArrayList<Double> cls3 = new ArrayList<Double>();

		HashMap<Integer, ArrayList> hmapClus = new HashMap<Integer, ArrayList>();

		// This cluster creation will be based on clusterCount, for now WE WILL ASSUME
		// 3.

		for (int i = 0; i < dataSet.length; i++) {
			if (dataSet[i] <= 100)
				cls1.add(dataSet[i]);

			if ((dataSet[i] <= 200) && (dataSet[i] > 100))
				cls2.add(dataSet[i]);

			if ((dataSet[i] <= 400) && (dataSet[i] > 200))
				cls3.add(dataSet[i]);

		}

		hmapClus.put(1, cls1);
		hmapClus.put(2, cls2);
		hmapClus.put(3, cls3);

		return hmapClus;

	}

	@Override
	public double getClusTheta(ArrayList<Double> cluster, double stdDev) {
		double sum = 0.0;
		int x = 0;

		Iterator<Double> foreach = cluster.iterator();
		while (foreach.hasNext())
			sum = sum + foreach.next();

		double clusTheta = sum / cluster.size();

		// Apply the stdDev factor
		// SKIP this but assume part of the calculation

		return clusTheta;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double[] getDataSet() {
		return dataSet;
	}

	public void setDataSet(double[] dataSet) {
		this.dataSet = dataSet;
	}

	public int getClusterCount() {
		return clusterCount;
	}

	public void setClusterCount(int clusterCount) {
		this.clusterCount = clusterCount;
	}

	public double getStdDev() {
		return stdDev;
	}

	public void setStdDev(double stdDev) {
		this.stdDev = stdDev;
	}

}
