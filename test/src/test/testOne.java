package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class testOne {

	public static void main(String[] args) {
//		int[] arr1 = {1,2,2,3,3,3,4,5,6};  
//		int[] arr2 = {1,2,3,4}; 
//		ArrayList<Integer> arr3 = new ArrayList<Integer>();  
//		for(int i = 0; i <arr1.length; i++) { 
//			for(int j = 0; j < arr2.length; j++) { 
//				if(arr1[i] == arr2[j]) { 
//					arr3.add(arr1[i]);
//				}
//			}
//		} 
//		
//	 for(int i : arr3) { 
//		 System.out.println(i);
//	 }
	 
        Scanner sc = new Scanner(System.in); 
//        
//        int i = scan.nextInt(); 
//        double d = scan.nextDouble();   
//        scan.nextLine();  //nextLine đọc dòng cuối cùng nên phải thêm vào nếu k thì k đọc đc chuỗi string
//        String s = scan.nextLine();
//       
//
//        // Write your code here.
//
//        System.out.println("String: " + s);
//        System.out.println("Double: " + d);
//        System.out.println("Int: " + i); 
		 
//		  int x = sc.nextInt(); 
//	      for(int i = 1; i <= 10  ; i++){  
//	          int result = x * i ;
//	          System.out.println( x + " x " + i + " = " +result);
//	      } 
         
//        int t=in.nextInt(); // nhập vào 2 vòng lặp  
//        
//        for(int i=0;i<t;i++){ 
//        	
//            int a = in.nextInt(); // 0
//            int b = in.nextInt(); // 2
//            int n = in.nextInt(); // 10 
//            int re = a ;
//            
//            for(int k = 0; k < n; k++){ 
//            	re += b * (int)Math.pow(2, k);
//                System.out.printf("%d ",re);
//            } 
            // xong vòng lặp 1 sẽ cách vòng lặp 2 3 dòng
//            System.out.println(); // xuống dòng 
//            System.out.println(); 
//            System.out.println();
//        }
//        in.close(); 
//        String string="abcdef";
//        String reverse = new StringBuffer(string).
//        reverse().toString();
//        System.out.println("\nString before reverse:"+string);
//        System.out.println("String after reverse: "+reverse); 
        int n = sc.nextInt() ; 
        int count = 0;  
      
        for(int i = 1 ; i <= n ; i++) { 
        	if(n%i==0) { 
        		count++;
        	}
        } 
        if(count==2) { 
        	System.out.println("ok");
        }else { 
        	System.out.println("not ok");
        }   
        String a = sc.next() ;
        BigInteger bi = new BigInteger(a);  
        if(bi.isProbablePrime(1)) { 
        	System.out.println("ok");
        }
        
     
       
       
        
	       
	}

}
