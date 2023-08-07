package Features;

// Types of Inheritance are:
    // Single inheritance
    // Multi-level inheritance
    // Multiple inheritances
    // Hybrid inheritance
    // Hierarchical inheritance

class A {
	int a, b;
	public void add(int x, int y)
	{
		a = x;
		b = y;
		System.out.println("addition of a + b is:" + (a + b));
	}
}
class B extends A {
	public void sum(int x, int y)
	{
		add(x, y);
	}

	// Driver Code
	public static void main(String[] args)
	{
		B b1 = new B();
		b1.sum(5, 6);
	}
}

