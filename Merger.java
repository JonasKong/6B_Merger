/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
		ArrayList<String> storage = new ArrayList<String>(nItems) ;

		int index0 = start0;
		int index1 = start1; 
		while ((index0 < start1) && (index1 < nItems)) {
			if (usersData.get(index1).compareTo(usersData.get(index0)) < 0) {
				storage.add(usersData.get(index1));
				index1++;

			} else {
				storage.add(usersData.get(index0));
				index0++;

			}
		}
		if ((index0 == start1) && ((index1 == nItems) == false)){
			for (int ind = index1; ind < nItems; ind ++) {
				storage.add(usersData.get(index1));
			}
		} else if ((index1 == nItems) && ((index0 == start1) == false)){
			for (int ind = index0; ind < start1; ind ++) {
				storage.add( usersData.get(index0));
			}
		}
		for (String toMove: storage) {
			usersData.set(start0, toMove);
			start0++;
		}
	}
   


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}