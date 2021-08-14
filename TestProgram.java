

public class TestProgram {

    // your output for this main should be:
    // inorder: ((1.0 + 2.0) * (3.0 - 4.0))
    // value: -3.0
    // height: 2


    public static void main(String[] args) 
    {
        PostfixTree pf = new PostfixTree();

        pf.pushNumber(1);
        pf.pushNumber(2);
        pf.pushAdd();
        pf.pushNumber(3);
        pf.pushNumber(4);
        pf.pushSubtract();
        pf.pushMultiply();
        
        

        //System.out.println("inorder: " + pf.inorder());
        System.out.println("value: " + pf.evaluate());
       // System.out.println("height: " + pf.height());

    }
}
