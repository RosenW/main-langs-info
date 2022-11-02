package com.newthinktank;

// Dialog used for user input
import javax.swing.JOptionPane;

// Right click project New -> Package
// Right click Package -> New Class
// Run -> Java Application -> HelloWorld

// Public class other classes can access
// Classes are blueprints for modeling real
// world objects or systems
// The code between { } belongs to the class

/*
 * Multiline Comment
 */

// Used to get user input
// Array functions
// ArrayLists
// Iterators
// Used to get collection types (Lists)
import java.util.*;

// Used to generate ranges
import java.util.stream.IntStream;


public class HelloWorld {

	// static means that this object belongs
	// to the class (More Later)
	// A scanner object receives input and
	// by using System.in you are reading
	// from the keyboard
	static Scanner sc = new Scanner(System.in);

	// This is a constant thats value can't change
	final double SHORTPI = 3.14159;

	// ---- ENUMERATED TYPES ----
	// Custom type with limited number of options
	// Must be declared at top of class
	public enum Day {Monday,Tuesday,Wednesday};

	// ---- METHODS ----
	// Methods avoid duplicate code and
	// and help organize
	// public methods : Executed by any program
	// that knows of your class
	// private methods : Available only to your class
	// protected methods : Available to your class
	// and subclasses (More Later)

	// Receive to ints and return an int
	// static means we don't have to create an
	// object to use this
	// return type methodName(parameters w/ types)
	public static int getSum(int x, int y) {
		return x + y;
	}

	// Demonstrate pass by value
	public static void changeMe(int cNum) {
		cNum = 10;
	}

	// Receive a variable number of parameters
	public static int getSum2(int ... nums) {
		int sum = 0;
		for(int x: nums) {
			sum += x;
		}
		return sum;
	}

	// Return an array with multiple values
	static int[] getNext2(int x) {
		int[] vals = new int[2];
		vals[0] = x + 1;
		vals[1] = x + 2;
		return vals;
	}

	// Return a list of different types
	static List<Object> getRandList(){
		String name = "Derek";
		int age = 44;
		return Arrays.asList(name, age);
	}

	// Recursive functions call themselves
	static int factorial(int num) {
		// Must have a condition were we don't
		// call for the function to execute
		if(num == 1) {
			return 1;
		} else {
			int result = num * factorial(num - 1);
			return result;
		}
	}

	static int getSum3(int[] nums) {
		int sum = 0;
		for(int x: nums) sum += x;
		return sum;
	}

	// 1st : result = 4 * factorial(3) = 4 * 6 = 24
	// 2nd : result = 3 * factorial(2) = 3 * 2 = 6
	// 3rd : result = 2 * factorial(1) = 2 * 1 = 2

	// ---- MAIN FUNCTION ----

	// Code in main is where execution begins
	// static means this is a class function
	// versus an object function (More later)
	// void states that this code does not return
	// a value during execution
	// Any data passed to your program from the
	// terminal or command line is stored in args
	public static void main(String[] args) {

		// println is a method (function) that
		// prints the provided string to the
		// console
		// All statements end with a ;
		// Java is case sensitive
		// print does the same without a newline
		System.out.println("Hello World");

		// ---- VARIABLES ----
		// Must start with a letter and then
		// letters, numbers, _ or $

		// Create a variable for holding whole numbers
		int var1 = 100;

		// Create multiple variables
		int v2, v3;

		// ---- DATA TYPES ----
		// Java requires every variable to have
		// a defined data type
		// Primitive Types
		// byte, short, char, boolean, int, float,
		// double, and long

		// Wrapper classes make primitive types
		// act like objects
		System.out.println("Byte Max: " +
				Byte.MAX_VALUE);
		System.out.println("Byte Min: " +
				Byte.MIN_VALUE);
		System.out.println("Short Max: " +
				Short.MAX_VALUE);
		System.out.println("Short Min: " +
				Short.MIN_VALUE);
		System.out.println("Char Max: " +
				(Character.MAX_VALUE+0));
		System.out.println("Char Min: " +
				(Character.MIN_VALUE+0));
		System.out.println("Int Max: " +
				Integer.MAX_VALUE);
		System.out.println("Int Min: " +
				Integer.MIN_VALUE);
		System.out.println("Float Max: " +
				Float.MAX_VALUE);
		System.out.println("Float Min: " +
				Float.MIN_VALUE);
		System.out.println("Double Max: " +
				Double.MAX_VALUE);
		System.out.println("Double Min: " +
				Double.MIN_VALUE);
		System.out.println("Long Max: " +
				Long.MAX_VALUE);
		System.out.println("Long Min: " +
				Long.MIN_VALUE);

		// Booleans are either true or false
		// You can't use 0 or anything else
		boolean happy = true;

		// Characters can only store single
		// characters (must use ')
		char a = 'a';

		// You can also store escaped characters
		// \n, \t, \b, \f, \r, \", \', \\

		// Floating point precision 6 decimals
		float fNum = 1.1111111111111111F;
		float fNum2 = 1.1111111111111111F;
		System.out.println("Float : " +
				(fNum + fNum2));

		// Double precision 15 decimals
		double dblNum = 1.1111111111111111;
		double dblNum2 = 1.1111111111111111;
		System.out.println("Float : " +
				(dblNum + dblNum2));

		// Can use scientific notation
		double thousand = 1e+3;
		System.out.println(thousand);

		// You can define longs with _
		long bigNum = 123_456_789;

		// ---- CASTING ----
		// You can convert from smaller types
		// to larger types automatically
		int smInt = 10;
		long smLong = smInt;

		// Use (newType) otherwise
		double cDbl = 1.234;
		int cInt = (int) cDbl;
		System.out.println(cInt);

		long bigLong = 21474836470L;
		int bInt = (int) bigLong;
		System.out.println(bInt);

		// Use wrapper class to convert to string
		String favNum = Double.toString(1.618);

		// Convert Strings to primitives with
		// Byte.parseByte, Boolean.parseBoolean,
		// and the same format for each type
		// except for chars
		int strInt = Integer.parseInt("10");

		// ---- MATH ----
		System.out.println("5 + 4 = "+(5+4));
		System.out.println("5 - 4 = "+(5-4));
		System.out.println("5 * 4 = "+(5*4));
		System.out.println("5 / 4 = "+(5/4));
		System.out.println("5 % 4 = "+(5%4));

		// Math done on integers default to
		// integer output and doubles return doubles
		System.out.println("5 / 4 = "+(5.0/4.0));

		// incMe++ same as incMe = incMe + 1
		// Can also decrement with --
		int incMe = 0;
		System.out.println("incMe: "+(incMe++));
		System.out.println("incMe: "+(++incMe));

		// incMe = incMe + 10 == incMe += 10
		// Same with -= *= /= %=
		incMe += 10;

		// Numerous math functions
		System.out.println("abs(-1) = "+Math.abs(-1));
		System.out.println("ceil(4.25) = "+Math.ceil(4.25));
		System.out.println("floor(4.25) = "+Math.floor(4.25));
		System.out.println("round(4.25) = "+Math.round(4.25));
		System.out.println("max(4,5) = "+Math.max(4,5));
		System.out.println("min(4,5) = "+Math.min(4,5));
		System.out.println("exp(1) = "+Math.exp(1));
		System.out.println("log(1) = "+Math.log(1));
		System.out.println("log10(1) = "+Math.log10(1));
		System.out.println("pow(2,2) = "+Math.pow(2,2));
		System.out.println("sqrt(4) = "+Math.sqrt(4));
		System.out.println("cbrt(4) = "+Math.cbrt(4));
		System.out.println("hypot(5,5) = "+Math.hypot(5,5));
		System.out.println("PI = "+Math.PI);

		// Trig Functions Radians
		System.out.println("sin(1.5708) = "+Math.sin(1.5708));
		System.out.println("cos(1.5708) = "+Math.cos(1.5708));
		System.out.println("tan(1.5708) = "+Math.tan(1.5708));
		System.out.println("asin(1.5708) = "+Math.asin(1.5708));
		System.out.println("acos(1.5708) = "+Math.acos(1.5708));
		System.out.println("atan(1.5708) = "+Math.atan(1.5708));
		System.out.println("sinh(1.5708) = "+Math.sinh(1.5708));
		System.out.println("cosh(1.5708) = "+Math.cosh(1.5708));
		System.out.println("tanh(1.5708) = "+Math.tanh(1.5708));
		System.out.println("toDegrees(1.5708) = "+Math.toDegrees(1.5708));
		System.out.println("toRadians(90) = "+Math.toRadians(90));

		// Random number between 5 and 20
		int minNum = 5;
		int maxNum = 20;
		int randNum = minNum + (int)(Math.random() *
				((maxNum - minNum) + 1));
		System.out.println("Rand : "+randNum);

		// ---- STRINGS ----
		// Strings are objects (Reference Type)
		// They have built in methods and must
		// be surrounded with "
		String name = "Derek";

		// Combine strings with +
		// or +=
		String wName = name + " Banas";
		wName += " is my name";

		// Conversion is automatic when using
		// primitives
		String drsDog = "K" + 9;

		// Get character at index
		System.out.println(wName.charAt(0));

		// Does it contain a Derek
		// startsWith, endsWith
		System.out.println(wName.contains("Derek"));

		// Get index of match
		System.out.println((wName.indexOf("Derek")));

		// Number of characters
		System.out.println(wName.length());

		// Don't use == to compare strings use equals
		// == would check if they point to the same
		// memory location
		// .equalsIgnoreCase ignores case
		String str1 = "dog";
		System.out.println("dog equals cat : " +
		(str1.equals("cat")));

		// Compare strings 0 if same, -1 if string
		// comes before other or 1
		// compareToIgnoreCase
		System.out.println(wName.compareTo("ABC"));

		// Replace matches
		// replaceFirst
		System.out.println(wName.replace("Derek", "Bob"));

		// Get string at indexes
		System.out.println(wName.substring(0,5));

		// Turn string into array
		// Shortcut for printing array (Enhanced For)
		// toCharArray
		for(String x: wName.split(" ")) System.out.println(x);

		// trim : Deletes whitespace at beginning and end
		// toUpperCase, toLowerCase

		// ---- STRING BUILDER & BUFFER ----
		// If you have to make many string changes
		// a StringBuilder may be better
		// Use a StringBuffer if using threads

		// Create StringBuilder
		StringBuilder sb = new StringBuilder("I'm a string builder");

		// Number of characters
		System.out.println(sb.length());

		// Get size set aside
		// Increase size with ensureCapacity
		System.out.println(sb.capacity());

		// Append a primitive or string
		sb.append(" Yeah");

		// Insert at index
		System.out.println(sb.insert(6, "Big "));

		// Replace at indexes
		System.out.println(sb.replace(6, 9, "wig"));

		// Extract substring
		System.out.println(sb.substring(6,10));

		// Delete characters at indexes
		System.out.println(sb.delete(6, 10));

		// Get char at index
		System.out.println(sb.charAt((4)));

		// Get index for string
		System.out.println(sb.indexOf("Yeah"));

		// ---- ARRAYS ----
		// Arrays are boxes in memory that hold
		// multiple values

		// Create an array that can hold 10 values
		int[] a1 = new int[10];

		// Assign a value to the first index (address)
		a1[0] = 1;

		// Fill array with a value
		Arrays.fill(a1,2);

		// Get value
		System.out.println(a1[0]);

		// Get size
		System.out.println(a1.length);

		// Create and add values at the same time
		String[] a2 = {"one","two"};

		// Generate an array from 1 to 10 (More Later)
		int[] oneTo10 = IntStream.rangeClosed(1, 10).toArray();

		// The enhanced for loop
		for(int x: oneTo10) System.out.println(x);

		// Find value
		System.out.println(Arrays.binarySearch(oneTo10, 9));

		// Multidimensional array
		int a3[][] = new int[2][2];

		// Create and initialize
		// a4[How many down][How many across]
		String[][] a4 = {{"00", "10"},
				{"01", "11"}};

		System.out.println(a4[1][1]);

		// a5[How many down][How many across][How many Groups]
		// a5[3][4][1]
		String a5[][][] = {{{"000"}, {"100"}, {"200"}, {"300"}},
				{{"010"}, {"110"}, {"210"}, {"310"}},
				{{"020"}, {"120"}, {"220"}, {"320"}}};
		System.out.println(a5[2][3][0]);

		// Copy array into another
		int a6[] = {1,2,3};
		int a7[] = Arrays.copyOf(a6, 3);

		// Compare arrays
		System.out.println(Arrays.equals(a6, a7));

		// Sort array
		int a8[] = {3,2,1};
		Arrays.sort(a8);
		System.out.println(Arrays.toString(a8));

		// ---- ARRAYLIST ----
		// ArrayLists resize and provide for easy
		// insertion and deletion
		// Create a String ArrayList with 20 spaces
		ArrayList<String> aL1 = new ArrayList<String>(20);

		// Add value
		aL1.add("Sue");

		// Generate an ArrayList
		ArrayList<Integer> aL2 = new ArrayList<>(Arrays.asList(1,2,3,4));
		for(Integer x: aL2) System.out.println(x);

		// Get a value
		System.out.println(aL2.get(1));

		// Add a value at index
		aL2.set(1, 5);

		// Delete value (Delete all aL2.clear())
		aL2.remove(3);

		// Iterators are used to cycles through
		// collections like ArrayLists
		Iterator it = aL2.iterator();

		// Loop while more values exist
		while(it.hasNext()) {
			// Output each value
			System.out.println(it.next());
		}

		// ---- LINKEDLIST ----
		// Best when you have to make changes
		// in the middle of the list
		// Each link has a reference to the value
		// before and the value after
		LinkedList<Integer> lL1 = new LinkedList<Integer>();

		// Add value
		lL1.add(1); lL1.add(2); lL1.add(3);

		// Add array to list
		lL1.addAll(Arrays.asList(1,2,3,4));

		// Add to front (addLast Also)
		lL1.addFirst(0);

		// Check if in list
		System.out.println(lL1.contains(4));

		// Get index for match
		System.out.println(lL1.indexOf(4));

		// Replace
		lL1.set(0, 2);

		// Get value
		// Also getFirst, getLast
		System.out.println(lL1.get(0));

		// Delete (clear() removes all)
		lL1.remove(1);

		// Get size
		System.out.println(lL1.size());

		// Convert to array
		Object[] a9 = lL1.toArray();

		// ---- USER INPUT ----
		// The Scanner object receives user input
		// using nextShort, nextByte, nextBoolean,
		// nextInt, nextFloat, nextDouble,
		// nextLong, nextLine
		System.out.print("Enter name: ");

		// Did the user enter a string
		// Use hasNextDataType to check if a
		// valid type was entered
		if(sc.hasNextLine()){
			String userName = sc.nextLine();
			System.out.println("Hello "+userName);
		}

		// Get input using a dialog box
		String jopName =
				JOptionPane.showInputDialog("Enter Name");
		System.out.println("Hello "+jopName);

		// ---- CONDITIONALS ----
		// Relational Operators : == != > < >= <=
		// Logical Operators : ! && ||
		int age = 12;
		if ((age >= 5) && (age <= 6)){
			System.out.println("Go to Kindergarten");
		} else if ((age >= 7) && (age <= 13)){
			System.out.println("Go to Middle School");
		} else if ((age >= 14) && (age <= 18)){
			System.out.println("Go to High School");
		} else {
			System.out.println("Stay Home");
		}

		System.out.println("true || false = "+(true || false));
		System.out.println("!true = "+(!true));

		// The ternary operator returns the 1st value
		// when the condition is true and the 2nd
		// otherwise
		boolean canVote = (age >= 18) ? true : false;
		System.out.println("Can Vote : "+canVote);

		// Switch is used when you have limited options
		String lang = "France";
		switch(lang) {
		case "Chile": case "Cuba":
			System.out.println("Hola");

			// Without break the next condition
			// is checked
			break;
		case "France":
			System.out.println("Bonjour");
			break;
		case "Japan":
			System.out.println("Konnichiwa");
			break;
		default:
			System.out.println("Hello");
		}

		// ---- LOOPING ----
		for(int i = 0; i < 5; i++) {
			System.out.println(i);
		}

		// while loops as long as a condition is true
		int wI = 0;
		while (wI < 20) {

			// Only print even numbers
			if(wI % 2 == 0) {
				System.out.println(wI);
				wI++;
				// Jump back to the beginning of loop
				continue;
			}
			if(wI >= 10) {
				// Stop looping
				break;
			}
			wI++;
		}

		// Do whiles execute at least once
		int secretNum = 7;
		int guess = 0;
		do {
			System.out.println("Guess : ");
			if(sc.hasNextInt()){
				guess = sc.nextInt();
			}
		}while(secretNum != guess);
		System.out.println("You guessed it");

		// ---- METHODS ----
		System.out.println("5 + 4 = " + getSum(5,4));

		// All data passed to a function is pass by
		// value so changes in the method have no
		// effect outside of the function
		int cNum = 0;
		changeMe(cNum);
		System.out.println("cNum = " + cNum);

		// You can pass a variable number of values
		// to a method
		System.out.println("1+2+3 = " + getSum2(1,2,3));

		// You can receive multiple values with an array
		int[] multVA = getNext2(5);
		// 1 line for loop
		for(int x: multVA) System.out.println(x);

		// Receive multiple values of different types
		List<Object> randList = getRandList();
		System.out.println(randList);

		// Demonstrate recursion (functions calling
		// themselves)
		System.out.println("Fact 4 = " + factorial(4));

		// Pass array to method
		int[] nums = {1,2,3};
		System.out.println("Sum = " + getSum3(nums));

		// ---- EXCEPTION HANDLING ----
		// Used to catch errors that could crash
		// our program

		// Surround problem code with a try block
		try {
			// int badInt = 10 / 0;

			// You can create your own exception
			// classes or just throw one without
			throw new Exception("Bad Stuff");
		}
		// Catch division by 0
		catch(ArithmeticException ex) {
			System.out.println("Can't divide by zero");
			System.out.println(ex.getMessage());
			System.out.println(ex.toString());
		}
		// Catch any exception
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		// Executed whether exception occurred or not
		// Used to close files, DBs and other clean up
		finally {
			System.out.println("Clean Up");
		}

		// ---- ENUMERATED TYPES ----
		Day favDay = Day.Monday;
		System.out.println("Fav day is "+favDay);

	}
}
