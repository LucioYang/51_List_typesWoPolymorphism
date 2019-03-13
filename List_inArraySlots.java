/**
  Implement a list of diverse types, including
  integers, double-precision floating point numbers,
  and Strings.
 */

public class List_inArraySlots {

     private int[]    intElements;
     private double[] doubleElements;
     private String[] stringElements;
     private int filledElements; // the number of elements in this list

     /* type identifier for each element
       That is, typeOfElements[i] == 0 means element i is an integer;
                                     1 means element i is a double;
                                     2 means element i is a String.
        Optional extra education in programming (not comp sci):
            replace these "magic numbers" with an "enumerated type".
     */
     private int[] typeOfElements;

     private static final int INITIAL_CAPACITY = 10;

     /**
      Construct an empty list with a small initial capacity.
     */
     public List_inArraySlots() {
        intElements = new int[INITIAL_CAPACITY];
        doubleElements = new double[INITIAL_CAPACITY];
        stringElements = new String[INITIAL_CAPACITY];
        // filledElements is already initialized to 0.
        typeOfElements = new int[INITIAL_CAPACITY];
     }


    /**
      @return the number of elements in this list
     */
     public int size() {
        return filledElements;
     }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
     public String toString() {
        String ans = "[";
		for (int i = 0; i < typeOfElements.length; i++) {
			if (typeOfElements[i] == 0)
				ans += intElements[i] + ", ";
			else if (typeOfElements[i] == 1)
				ans += doubleElements[i] + ", ";
			else
				ans += stringElements[i] + ", ";
		}
		ans += "]";
		return ans;
     }


    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int type   // same meaning as in typeOfElements
                       , int    intValue
                       , double doubleValue
                       , String stringValue
                       ) {
        if (filledElements == intElements.length)
            expand();
        intElements[filledElements] = intValue;
        doubleElements[filledElements] = doubleValue;
        stringElements[filledElements] = stringValue;
        typeOfElements[filledElements++] = type;
        return true;
     }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
     private void expand() {
        System.out.println( "expand... (for debugging)");
           /* S.O.P. rules for debugging:
              Working methods should be silent. But during
              development, the programmer must verify that
              this method is called when that is appropriate.
              So test using the println(), then comment it out.
              */
        int elemIndex;
        int[] intBigger = new int[intElements.length * 2];
        for(elemIndex = 0; elemIndex < filledElements; elemIndex++)
            intBigger[elemIndex] = intElements[elemIndex];
        intElements = intBigger;

        double[] doubleBigger = new double[doubleElements.length * 2];
        for(elemIndex = 0; elemIndex < filledElements; elemIndex++)
            doubleBigger[elemIndex] = doubleElements[elemIndex];
        doubleElements = doubleBigger;

        String[] stringBigger = new String[stringElements.length * 2];
        for(elemIndex = 0; elemIndex < filledElements; elemIndex++)
            stringBigger[elemIndex] = stringElements[elemIndex];
        stringElements = stringBigger;

        int[] typeBigger = new int[typeOfElements.length * 2];
        for(elemIndex = 0; elemIndex < filledElements; elemIndex++)
            typeBigger[elemIndex] = typeOfElements[elemIndex];
        typeOfElements = typeBigger;
     }
	 
	public Element get(int index) {
		Element ans = new Element();
		if (typeOfElements[index] == 0) {
			ans.intValue = intElements[index];
			ans.type = 0;
		}
		else if (typeOfElements[index] == 1) {
			ans.doubleValue = doubleElements[index];
			ans.type = 1;
		}
		else {
			ans.stringValue = stringElements[index];
			ans.type = 2;
		}
		return ans;
	}
}
