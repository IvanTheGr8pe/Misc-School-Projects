import java.util.*;
//it compiles but the logic is totally wrong,  I can't figure out what  i am getting wrong.
//question: InnerNode is an instance of Node but why can't i use InnerNode's variables when an InnerNode passes thru a parameter as an object of Node? 

public class PostfixTree {

   public class Node {
      
      boolean parent = false;
   
      double value;
      
      
      }
      
   class InnerNode extends Node{
      
      String value;
      Node left;
      Node right;
      
      
      
      
      }
   
   
   
      

  static Stack<Node> stack = new Stack(); 

    public void pushNumber(double d) {
        Node item = new Node();
        item.value = d;
        stack.push(item);
        
    }

    public void pushAdd() {
      InnerNode add = new InnerNode();
      add.value = "+";
      add.left =  stack.get(stack.indexOf(hasParent(stack.peek()))); 
      add.left.parent = true;
      add.right = stack.peek();
      add.right.parent = true;
      stack.push(add);
    }


    public void pushMultiply() { 
      InnerNode mult = new InnerNode();
      mult.value = "*";
      mult.left = stack.get(stack.indexOf(hasParent(stack.peek())));
      mult.left.parent = true;
      mult.right = stack.peek(); 
      mult.right.parent = true;
      stack.push(mult);
    }
    
    public void pushSubtract() {
        InnerNode sub = new InnerNode();
         sub.value = "-";
         sub.left = stack.get(stack.indexOf(hasParent(stack.peek())));
         sub.left.parent = true; 
         sub.right = stack.peek();
         sub.right.parent = true;
         stack.push(sub);
    }


    public void pushDivide() {
      InnerNode div = new InnerNode();
      div.value = "/";
      div.left = stack.get(stack.indexOf(hasParent(stack.peek())));
      div.left.parent = true;
      div.right = stack.peek(); 
      div.right.parent =true;
      stack.push(div);
    }

    public double evaluate() {
      for ( Node node:stack){
         
         System.out.println(node.value);}
       return eval_recursive(stack.pop()); 
    }
    

    public String inorder() {
        return "";
    }

    public int height() {
        return -1;
    }
    
     double eval_recursive (Node node){
         if (node instanceof InnerNode){
                InnerNode n = (InnerNode)node;
                
                  switch(n.value){
                     case "+":{ System.out.println("ad"+n.left.value +" "+ n.right.value); 
                         return eval_recursive(n.left) + eval_recursive(n.right);}
                     case "-":{ System.out.println("sub"+n.left.value +" "+ n.right.value);
                         return eval_recursive(n.left)-eval_recursive(n.right);}
                     case "*":{ System.out.println("mult"+n.left.value +" "+ n.right.value);
                         return eval_recursive(n.left) * eval_recursive(n.right);}
               
                     case "/":{ System.out.println("div"+n.left.value +" "+ n.right.value);
                        return eval_recursive(n.left) / eval_recursive(n.right);}
                     default:
                        return -1;
                        }
         
                   
                }
            else 
                  return node.value;
            }
    
                                                
   public Node hasParent(Node node){
      
         
         if (node.parent != false ){
            
            return hasParent(stack.get(stack.indexOf(node)-1));}
         else 
            
            return node;
            }
            

}


