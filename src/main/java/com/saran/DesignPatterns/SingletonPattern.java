package com.saran.DesignPatterns;


/*
 *  chess board -> playing 2 people at a time requires one board
 *   wanted to conduct a tournament-> 100 people-> 50 
 *   50 
 *   Chess c1=new Chess(); c1 obj-> 
 *   Chess c50=new Chess(); //memory
 *   Singleton saves memory because object is not created at each request.Only
 *   single instance is reuse multiple times
 *   
 *   Singleton defines a class that has only one instance and provides a global point of access to it
 *   
 *   at the time of creation of instance at load time (EAGER Instantiation) saves memory
 *   at the time of creation of instance whenever required (LAZY Instantiation)
 *   
 *   static member
 *   private constructor
 *   static factory method
 *   
 */
public class SingletonPattern {
       //EAGER INSTANTIATION
	   //create an object of SingleObject
	   private static SingletonPattern  instance = new SingletonPattern (); //class or static member
        //Lazy instantiation
	   private static SingletonPattern instance2;
	   //make the constructor private so that this class cannot be
	   //instantiated
	   private SingletonPattern(){}

	   //Get the only object available
	   public static SingletonPattern  getInstance() {
		 //Lazy instantiation
		   //synchronized can be use in two way :1) method 2) as a block
		   if(instance2 == null) {
			   synchronized(SingletonPattern.class) {
				   if(instance2==null) {
					   instance2=new SingletonPattern(); // instance will be created only at request time
				   }
			   }
			   
		   }
	      return instance;
	   }
	   public static SingletonPattern  getConnection(){
		      return instance;
		   }

	   public void showMessage(){
	      System.out.println("Welcome to the world of singleton");
	   }
	}

class Test2{
	 
	
	public static void main(String[] args) {
		
		SingletonPattern s=SingletonPattern.getConnection();
		s.showMessage();
		SingletonPattern s1=SingletonPattern.getConnection();
		s1.showMessage();
		SingletonPattern s2=SingletonPattern.getConnection();
		s2.showMessage();
		
		SingletonPattern i1=SingletonPattern.getInstance();
		i1.showMessage();
		
		
	}
}
