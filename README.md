# NasRov
A module that would identify obstacle clusters based on position coordinates.



Code based on Maven project build. 

Dependencies: 

	JUnit
	Java 1.8 ++
	Maven 3.X
	
	
To Build: 
	mvn clean package - This will generate a jar file in ./target/ClusFind-0.0.1-SNAPSHOT.jar
	
	This will run two JUnit tests which should build and run successfully.
	
To Execute: 
	java -jar ./target/ClusFind-0.0.1-SNAPSHOT.jar input2.txt
	
	Note: MUST include input file as CLI argument, i.e. input0.txt, input1.txt, input2.txt
		OR any file that contains position coordinates in double values separated by commas.
		

		

NOTE: This simulation is intended to be replaced with a more robust and accurate component for finding and establishing clusters based on more accurate data scieince approaches such as K-Means or DBScan. 

Hence the highlight of this package is NOT the algorthythm rather the packaging and the Java build mechanism that would allow to easily swap out the cluster computation with any other package.

This is done in the following way.

1. To easily perform the swap, TWO interfaces were established
  
  
    public HashMap<Integer,ArrayList> getClusters() throws Exception;
	  public double getClusTheta(ArrayList<Double> cluster, double stdDev) throws Exception;
  
  - The first interface getClusters is intended to be implemented by returning to the application the Clusters found given the provided data points.
  - The second interface is intended to be implemented by returning the Theta (Center) of each cluster found.
  
  
  
  
  
  
  
  
  
  
  
  
  

