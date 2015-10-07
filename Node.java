package denntaku;



abstract class Node {
    abstract public void show();
    abstract public void rpn();
    abstract public void setOp(char c);
    abstract public void addLeft(Node n);
    abstract public void addRight(Node n);
	 public double getValue(){
		return getValue();
	}
}
class Num extends Node {
    public Num(double d){
	value = d;
    }
    private double value;
    @Override public void setOp(char c){}
    @Override public void addLeft(Node n){}
    @Override public void addRight(Node n){}
    @Override public void show(){
	System.out.print(value);
    }
    @Override public void rpn(){
	System.out.print(value);
    }
}
class Op extends Node{
    public static Node connectToLeft(Node n){
	final Op result = new Op();
	result.left = n;
	return result;
    }
    public Op(){}
    private char op;
    private Node left;
    private Node right;
    @Override public void setOp(char c){
	op = c;
    }
    @Override public void addLeft(Node n){
	left = n;
    }
    @Override public void addRight(Node n){
	right = n;
    }
    @Override public void show(){
	System.out.print("(");
	if(left!=null){
	    left.show();
	}
	System.out.print(op);
	if(right!=null){
	    right.show();
	}
	System.out.print(")");
    }
    @Override public void rpn(){
	if(left!=null){
	    left.rpn();
	}
	System.out.print(" ");
	if(right!=null){
	    right.rpn();
	}
	System.out.print(" ");
	System.out.print(op);
	System.out.print(" ");
    }
    private double ans = 0;
	private final char opList[] = {'+','-','*','/'};
	public double getValue(){
		while(left!=null && right!=null){
			ans += left.getValue();
			if(op == opList[0])
				ans += right.getValue();
			if(op == opList[1])
				ans -= right.getValue();
			if(op == opList[2])
				ans *= right.getValue();
			if(op == opList[3])
				ans /= right.getValue();
		}
		return ans;
	}
}