import java.util.*;
import java.lang.*;
// Write the method bodies for this file.

public class PostfixTree5 {

   public class Node<T>{
   
      T value;
      boolean parent = false;
      boolean children = false;
      
      Node left;
      Node right;
      
      
   
      
      
      
      
   }
   
    String infix;
   Stack<Node> stack = new Stack(); 
     
     
     
     
   public void pushNumber(double d) {
      Node<Double> item = new Node();
      item.value = d;
      stack.push(item);
        
        
   }

   public void pushAdd() {
      Node<String> add = new Node<String>();
      add.value = "+";
      add.right = stack.peek();
      add.right.parent = true;
      add.left = hasParent(stack.peek());
      add.left.parent = true; 
      add.children = true;
      stack.push(add);
     
   }
   
   public void pushSubtract() {
      Node<String> sub = new Node<String>();
      sub.value = "-";
      sub.right = stack.peek();
      sub.right.parent = true;
      sub.left = hasParent(stack.peek());
      sub.left.parent = true; 
      sub.children = true;
      stack.push(sub);
     
   }
   
   public void pushMultiply() {
      Node<String> mult = new Node<String>();
      mult.value = "*";
      mult.right = stack.peek();
      mult.right.parent = true;
      mult.left = hasParent(stack.peek());
      mult.left.parent = true; 
      mult.children = true;
      stack.push(mult);
     
   }
   public void pushDivide() {
      Node<String> div = new Node<String>();
      div.value = "/";
      div.right = stack.peek();
      div.right.parent = true;
      div.left = hasParent(stack.peek());
      div.left.parent = true; 
      div.children = true;
      stack.push(div);
     
   }
   double evaluate() { 
      return eval_recursive(stack.peek());}
   
   
   
   
   public double eval_recursive(Node n){
           //if(n.value instanceof Character){
      if(n.value.equals( "+"))
      {//infix.append( n.left.value + "+" + n.right.value);
         System.out.println("ad"+" "+n.left.value +" "+ n.right.value); 
         return eval_recursive(n.left) + eval_recursive(n.right);}
      else if(n.value.equals("-"))
      { //infix.append( n.left.value + "-" + n.right.value);
         System.out.println("sub"+n.left.value +" "+ n.right.value);
         return eval_recursive(n.left)-eval_recursive(n.right);}
      else if(n.value.equals( "*"))
      { //infix.append( n.left.value + "*" + n.right.value);
         System.out.println("mult"+n.left.value +" "+ n.right.value);
         return eval_recursive(n.left) * eval_recursive(n.right);}
               
      else if (n.value.equals("/"))
      { //infix.append(n.left.value + "/" + n.right.value);
         System.out.println("div"+n.left.value +" "+ n.right.value);
         return eval_recursive(n.left) / eval_recursive(n.right);}
                   
      else {
         Node<Double> k = n;
         return k.value;}
                    
   }
   public String inorder(){
      String output = inorderRecurse(stack.peek());
      return output;
   }
         
      
   public String inorderRecurse(Node n) {
   String output = "(";
      if (n.children == true ){
         if(n.value.equals( "+"))
         { output= output+  inorderRecurse(n.left) + "+" + inorderRecurse(n.right)+ ")";
            return output;
         }
         else if(n.value.equals("-"))
         { output = output+ inorderRecurse(n.left) + "-" + inorderRecurse(n.right)+ ")";
            return output;
         }
         else if(n.value.equals( "*"))
         { output = output +inorderRecurse(n.left) + "*" + inorderRecurse(n.right)+ ")";
            return output;
         }
               
         else if (n.value.equals("/"))
         { output = output + inorderRecurse(n.left) + "/" + inorderRecurse(n.right)+ ")";
            return output ;
         }
          else 
             return n.value + " %%%% ";
        }
      
                   
         else 
            return  ""+ n.value;
      
         // System.out.println(stack);
        
   }

   
   public Node hasParent(Node node){
      
         
      if (node.parent == true ){
            
         return hasParent(stack.get(stack.indexOf(node)-1));}
      else 
            
         return node;
   }
   
   public int height(){
     int height = hRecurse(stack.peek());
      return height;}
      
      
  int hRecurse(Node n){
  
  
  
   if(n.children == true ){
      int l =0 ;
      l += hRecurse(n.left)+ 1;
      int r=0 ;
      r += hRecurse(n.right)+1;
      if( l> r)
         return l;
      else
         return r;  }
    else 
      return 0  ;
      }
   
}
   
