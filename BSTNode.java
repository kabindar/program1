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
 * @Code
 * Object called BSTNode is created with isEmpty, insert, delete, printTree, search, inorder, postorder, preorder functions to run the prog1Demo
 * 
 */

import java.util.Scanner;

public class BSTNode {
	
	 BSTNode left, right;
     int data;
 
     /* Constructor */
     public BSTNode()
     {
         left = null;
         right = null;
         data = 0;
     }
     /* Constructor */
     public BSTNode(int n)
     {
         left = null;
         right = null;
         data = n;
     }
     
     /* Function to set left node */
     public void setLeft(BSTNode n)
     {
         left = n;
     }
     
     /* Function to set right node */ 
     public void setRight(BSTNode n)
     {
         right = n;
     }
     
     /* Function to get left node */
     public BSTNode getLeft()
     {
         return left;
     }
     
     /* Function to get right node */
     public BSTNode getRight()
     {
         return right;
     }
     
     /* Function to set data to node */
     public void setData(int d)
     {
         data = d;
     }
     
     /* Function to get data from node */
     public int getData()
     {
         return data;
     }     
 }
 
 /* Class BST */
 class BST
 {
     private static BSTNode root;
 
     /* Constructor */
     public BST()
     {
         root = null;
     }
     
     
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     
     
     /* Functions to insert data */
     public void insert(int data)
     {
         root = insert(root, data);
     }
     /* Function to insert data recursively */
     private BSTNode insert(BSTNode node, int data)
     {
         if (node == null)
             node = new BSTNode(data);
         else
         {
             if (data <= node.getData())
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         return node;
     }
   
     /* Functions to delete data */
     public void delete(int k)
     {
         if (isEmpty())
             System.out.println("Tree Empty");
         else if (search(k) == false)
             System.out.println("Sorry "+ k +" is not present");
         else
         {
             root = delete(root, k);
             System.out.println(k+ " deleted from the tree");
         }
     }
     private BSTNode delete(BSTNode root, int k)
     {
         BSTNode p, p2, n;
         if (root.getData() == k)
         {
             BSTNode lt, rt;
             lt = root.getLeft();
             rt = root.getRight();
             if (lt == null && rt == null)
                 return null;
             else if (lt == null)
             {
                 p = rt;
                 return p;
             }
             else if (rt == null)
             {
                 p = lt;
                 return p;
             }
             else
             {
                 p2 = rt;
                 p = rt;
                 while (p.getLeft() != null)
                     p = p.getLeft();
                 p.setLeft(lt);
                 return p2;
             }
         }
         if (k < root.getData())
         {
             n = delete(root.getLeft(), k);
             root.setLeft(n);
         }
         else
         {
             n = delete(root.getRight(), k);
             root.setRight(n);             
         }
         return root;
     }
     
     /* Functions to search for an element */
     public boolean search(int val)
     {
         return search(root, val);
     }
     /* Function to search for an element recursively */
     private boolean search(BSTNode r, int val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.getData();
             if (val < rval)
                 r = r.getLeft();
             else if (val > rval)
                 r = r.getRight();
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
    
     /* Function for in-order traversal */
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(BSTNode r)
     {
         if (r != null)
         {
             inorder(r.getLeft());
             System.out.print(r.getData() +" ");
             inorder(r.getRight());
         }
     }

     /* Function for pre-order traversal */
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(BSTNode r)
     {
         if (r != null)
         {
             System.out.print(r.getData() +" ");
             preorder(r.getLeft());             
             preorder(r.getRight());
         }
     }
     
     /* Function for post-order traversal */
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(BSTNode r)

     {
         if (r != null)
         {
             postorder(r.getLeft());             
             postorder(r.getRight());
             System.out.print(r.getData() +" ");
         }
     }  
     
     public static void printTree(BSTNode root, int space)  
     {  
    	 int COUNT = 7;
    	
         if (root == null)  
             return;  
         
         space += COUNT;  
       
         // Recursively processing right child
         printTree(root.right, space);  
       
   
         System.out.println(" ");  
         for (int i = COUNT; i < space; i++)  
             System.out.print(" "); 
             
         if((root.right) != (null)) {
         System.out.print(root.data + "-----"); 
         System.out.print("|");
         
         }
         else if((root.left) != (null)) {
             System.out.print(root.data + "-------"); 
             }
         else {
        	 System.out.print(root.data);
         }
         
         // Recursively processing left child  
         printTree(root.left, space); 
        
     }  
         
     public static void printBST()  
     {   
         printTree(root, 0);  
     }  
     
 }
     
     
