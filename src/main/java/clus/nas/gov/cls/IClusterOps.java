package clus.nas.gov.cls;

import java.util.ArrayList;
import java.util.HashMap;

public interface IClusterOps {
	
	public HashMap<Integer,ArrayList> getClusters() throws Exception;
	public double getClusTheta(ArrayList<Double> cluster, double stdDev) throws Exception;

}
