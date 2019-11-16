# NasRov
A module that would identify obstacle clusters based on position coordinates.

NOTE: This simulation is intended to be replaced with a more robust and accurate component for finding and establishing clusters based on more accurate data scieince approaches such as K-Means or DBScan. 

Hence the highlight of this package is NOT the algorthythm rather the packaging and the Java build mechanism that would allow to easily swap out the cluster computation with any other package.

This is done in the following way.

1. To easily perform the swap, TWO interfaces were established
  
  
    public HashMap<Integer,ArrayList> getClusters() throws Exception;
	  public double getClusTheta(ArrayList<Double> cluster, double stdDev) throws Exception;
  
  - The first interface getClusters is intended to be implemented by returning to the application the Clusters found given the provided data points.
  - The second interface is intended to be implemented by returning the Theta (Center) of each cluster found.
  
  
 

Code based on Maven project build. 

Dependencies: 

	JUnit
	Java 1.8 ++
	Maven 3.X
	
	
To Build: 
	mvn clean package - This will generate a jar file in ./target/ClusFind-0.0.1-SNAPSHOT.jar
	
	This will run two JUnit tests which should build and run successfully. Both tests check to see the return of the List are not NULL.
	
	
	
To Execute: 
	java -jar ./target/ClusFind-0.0.1-SNAPSHOT.jar input2.txt
	
	Note: MUST include input file as CLI argument, i.e. input0.txt, input1.txt, input2.txt
		OR any file that contains position coordinates in double values separated by commas.
		
Sample Output:

	java -jar ./target/ClusFind-0.0.1-SNAPSHOT.jar input2.txt
	
	Clusters Found for this position coordinates :{1=[0.2, 1.2, 3.1, 3.2, 4.1, 5.9, 51.8, 56.1, 56.5, 57.8, 59.3, 59.5, 60.9, 61.1, 61.6, 61.7, 62.9, 63.0, 65.1, 66.9, 68.0], 2=[142.4, 169.2, 182.0, 183.4, 185.4, 186.5, 189.2, 189.4, 189.8, 190.2, 192.9, 193.4, 194.3, 198.2], 3=[266.1, 278.6, 279.9, 281.1, 285.2, 285.4, 285.4, 285.5, 285.6, 287.1, 290.5, 350.3, 353.5, 359.5, 359.8]}

Theta calculations for clusters :[44.28095238095238, 184.7357142857143, 302.2333333333334]


		

 
  
  
  
  
  
  
  
  
  
  

