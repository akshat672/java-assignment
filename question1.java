import java.util.*;
   class LabTestInfo{

    private  List<String> testList = new ArrayList<>();
    public void addTestDetails(String testDetails){
        testList.add(testDetails);
    }
    public List<String> getTestsWithinGivenCostRange(int minimumCost, int maximumCost){
         
        List<String> result = new ArrayList<>();
        for(String entry: testList){
            String[] parts = entry.split(":"); 
        String testName = parts[0].trim();
        String costName = parts[1].trim();
        int cost = Integer.parseInt(costName);
        if(cost>= minimumCost && cost<= maximumCost){
            result.add(testName);
        }}
return result;
    }
}
public class question1{
    public static void main(String[] args){
        LabTestInfo lab = new LabTestInfo();
    System.out.println("Enter the number of lab test details to be added");
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter lab test details(testName:cost)");
     for(int i=0; i<number; i++){
      String testDetails = sc.nextLine();
      lab.addTestDetails(testDetails);
     }
     System.out.println("Enter the minimum cost");
     int minimumCost = sc.nextInt();
     sc.nextLine();
     System.out.println("Enter the maximum cost");
     int maximumCost = sc.nextInt();
     sc.nextLine();
     List<String> filtered = lab.getTestsWithinGivenCostRange(minimumCost, maximumCost);
     if(filtered.isEmpty()){
        System.out.println("No Tests found within the specified cost range");
     }
     else {
     System.out.println("Test with cost between " + minimumCost + " and " + maximumCost + " INR");
       for(String details : filtered){
        System.out.println(details);
       }
    
    }}
}