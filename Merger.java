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

      int currentPlace0 = start0;
      int currentPlace1 = start1;

      ArrayList<String> mergedList = new ArrayList<String>();
      for(int x = 0; x < start0; x++) mergedList.add(usersData.get(x));

      while(currentPlace0 < start1 && currentPlace1 < nItems){
        System.out.println(mergedList+ usersData.get(currentPlace0) + "\t" + usersData.get(currentPlace1));
        if(usersData.get(currentPlace0).compareTo(usersData.get(currentPlace1)) < 0){
          mergedList.add(usersData.get(currentPlace0));
          currentPlace0++;
        } else {
          mergedList.add(usersData.get(currentPlace1));
          currentPlace1++;
        }
      }

      if(currentPlace0 < start1)for(int x = currentPlace0; x < start1; x++) mergedList.add(usersData.get(x));
      else for(int x = currentPlace1; x < nItems; x++) mergedList.add(usersData.get(x));

      for(int x = nItems; x < usersData.size(); x++) mergedList.add(usersData.get(x));
      usersData = mergedList;
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