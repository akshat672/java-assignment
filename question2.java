import java.util.*;
public class question2 {
    public static void main( String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of emails");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the spam scores");
        int[] arr = new int[number];
        for(int i=0; i<number; i++){
        int val =  sc.nextInt();
        if(val <0 ){
            System.out.println("Negative scores are not allowed");
       return; }
        arr[i] = val;
    

        }
        int[] result = new int[number];
       for(int i=0; i<number; i++){
        int v = arr[i];
        if(v>=50){
            result[i] = v + 10;
        }
        else{
            result[i] = Math.max(0, v-5);
        }
       }
       Map <Integer, Integer> map = new HashMap<>();
       for(int c : result){
         map.put(c, map.getOrDefault(c,0)+1);
       }
       long sum =0;
       for(int d: result){
        if(map.get(d) == 1){
            sum += d;
        }
       }
       if(sum == 0){
        System.out.println("No unique scores found after modification");
       } else{
        System.out.println(sum);
       }

    }
    
}
