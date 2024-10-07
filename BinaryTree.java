public class BinaryTree{
	Object root;
	BinaryTree left;
	BinaryTree right;

	public BinaryTree(Object root){
		this.root=root;
	}

	public BinaryTree(Object root, BinaryTree left, BinaryTree right){
		this.root=root;
		this.left=left;
		this.right=right;
	}

	public String toString(){
		StringBuffer buf=new StringBuffer();

		buf.append(root);	
		if(left!=null)	buf.append(left);	
		if(right!=null)	buf.append(right);
		
		return buf+"";
	}

	public String postOrder(){
		StringBuffer buf=new StringBuffer();
			
		if(left!=null)	buf.append(left.postOrder());	
		if(right!=null)	buf.append(right.postOrder());
		buf.append(root);

		return buf+"";
	}

	public String inOrder(){
		StringBuffer buf=new StringBuffer();

		if(left!=null)	buf.append(left.inOrder());
		if(root!=null)	buf.append(root);	
		if(right!=null)	buf.append(right.inOrder());
		
		return buf+"";
	}

	public int size() {
    	int leftSize = (left != null) ? left.size() : 0;  
    	int rightSize = (right != null) ? right.size() : 0;  
   	 	return 1 + leftSize + rightSize;  
	}

	public int countLeaves() {
        if (left == null && right == null) {
            return 1;
        }

        int leftLeaves = (left != null) ? left.countLeaves() : 0;
        int rightLeaves = (right != null) ? right.countLeaves() : 0;

        return leftLeaves + rightLeaves;
    }


    public boolean isFull() {
 		if (left == null && right == null) {
   		    return true;
    	}

    	if (left == null || right == null) {
       		return false;
    	}
    	
   	 	return left.isFull() && right.isFull();
	}

	public boolean isElement(String element){
		return this.toString().contains(element);
		
	}

	public static void main(String arg[]){

		BinaryTree E=new BinaryTree("E");
		BinaryTree F=new BinaryTree("F");
		BinaryTree C=new BinaryTree("C");
		BinaryTree B=new BinaryTree("B",E,F);
		BinaryTree A=new BinaryTree("A",B,C);

		System.out.println("Pre-Order: "+A);
		System.out.println("Post-Order: "+A.postOrder());
		System.out.println("In-Order: "+A.inOrder());	
		
		System.out.println(A.isElement("Z"));
		System.out.println(A.size());

	}

}
