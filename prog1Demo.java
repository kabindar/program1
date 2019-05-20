package program1;

/**
 * @author Khbindar Arumugam
 * @date 5-19-2019 
 * 
 * @overview 
 * The program gets input from a text file and creates a binary search tree. (The name of the text file should be "tree_val.txt") 
 * It has a menu where the user can manipulate the binary search tree and the actions are to delete a node, search a node, or to print a tree.
 * 
 * @how-to-use-the-menu
 * 1.Run the program
 * 2.To print a tree enter number 3 in the console window.
 * 3.To continue the program enter y or to quit enter n.
 * 4.To search enter 2.
 * 5.Enter integer to search in the console window and if the integer is found the program will return true of not it will return false.
 * To continue the program enter y or to quit enter n.
 * 6.To delete enter 1.
 * 7.Enter integer to be deleted. (The program will delete the specified integer)
 * 
 * @extra-features
 * After each selection the program prints the binary search tree in 3 orders and they're In-order, Post-order, Pre-order.
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class prog1Demo {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
              
        String token = null;
		
		Scanner fileInput = new Scanner(System.in);
		fileInput = new Scanner(new File("src//program1//tree_val.txt"));
			
		        Scanner scan = new Scanner(System.in);
		    
		        BST bst = new BST();         
		        char ch; 
		       
		        while (fileInput.hasNext()) {
	      		     
	      		      token = fileInput.next();
	      		      String[] values = token.split(",");
	      		      
	      		      int[] intValues = new int[values.length];
	      		         System.out.println("INSERT: ");
	      		         
	      				 for (int i = 0; i < values.length; i++) {
	      				
	      				     try {
	      				         intValues[i] = Integer.parseInt(values[i]);
	      				         bst.insert(intValues[i]);
	      				         System.out.print(intValues[i] + " ");
	      				         
	      				     }
	      				     catch (NumberFormatException nfe) {
	      				         continue;
	      				     }
	      				     
	      				  System.out.println();
	      				 }
		        }
		        
		        
		        do    
		        {
		            System.out.println("\nBinary Search Tree Operations\n");
		            System.out.println("1. delete");
		            System.out.println("2. Search");
		            System.out.println("3. Print");
		 
		            int choice = scan.nextInt();            
		            switch (choice)
		            {                         
		            case 1 : 
		                System.out.println("Enter integer element to delete");
		                bst.delete( scan.nextInt() );                     
		                break;                         
		            case 2 : 
		                System.out.println("Enter integer element to search");
		                System.out.println("Search result : "+ bst.search( scan.nextInt() ));
		                break; 
		            case 3 : 
		                bst.printBST();
		                break;  
		            default : 
		                System.out.println("Wrong Entry \n ");
		                break;   
		            }
		            
		            System.out.println();
		            System.out.println();
		       
		            System.out.print("\nPost order : ");
		            bst.postorder();
		            System.out.print("\nPre order : ");
		            bst.preorder();
		            System.out.print("\nIn order : ");
		            bst.inorder();
		           
		 
		         
		            System.out.println("\nDo you want to continue (Type y or n) \n");
		            ch = scan.next().charAt(0); 
		             
		 
		        } while (ch == 'Y'|| ch == 'y');               
		 
		       
           
		fileInput.close();
		scan.close();
	}
}





