public class ListFunctions {

    /**
     * Return true if the list is empty.
     *
     * Examples:
     *
     * * isEmpty(makeList()) should return true
     * * isEmpty(makeList(0)) should return false
     *
     * @param list The list.
     * @return True if the list is empty; false otherwise.
     */
    public static boolean isEmpty(ListNode list) {
        return list==null;
    }

    /**
     * Get the number of elements in the list.
     *
     * Examples:
     *
     * * size(makeList()) should return 0
     * * size(makeList(0, 1)) should return 2
     *
     * @param list The list.
     * @return The size of the list.
     */
    public static int size(ListNode list) {
        return sizeHelper(list, 0);
    }

    private static int sizeHelper(ListNode list, int acc) {
        if (list == null) return acc;
        return sizeHelper(list.getRest(), acc + 1);
    }

    /**
     * Get the element at the index.
     *
     * The index is assumed to be in range.
     *
     * Examples:
     *
     * * get(makeList(0, 1, 4, 9), 2) should return 4
     *
     * @param list The list.
     * @param index The index of the desired element.
     * @return The element at the index.
     */
    public static int get(ListNode<Integer> list, int index) {
        return getHelper(list, index);
    }

    private static int getHelper(ListNode<Integer> list, int index) {
        if (index == 0) return list.getFirst();
        return getHelper(list.getRest(), index - 1);
    }

    /**
     * Get the index of the first occurrence of the element.
     *
     * Examples:
     *
     * * indexOf(makeList(0, 3, 3, 4), 3) should return 1
     *
     * @param list The list
     * @param element The element.
     * @return The index of the first occurrence element, or -1 if it is not in
     *   the list.
     */
    public static int indexOf(ListNode<Integer> list, int element) {
        return indexOfHelper(list, element, 0);
    }

    private static int indexOfHelper(ListNode<Integer> list, int element, int index) {
        if (list == null) return -1;
        if (list.getFirst().equals(element)) return index;
        return indexOfHelper(list.getRest(), element, index + 1);
    }

    /**
     * Get the index of the last occurrence of the element.
     *
     * Examples:
     *
     * * lastIndexOf(makeList(0, 3, 3, 4), 3) should return 2
     *
     * @param list The list
     * @param element The element.
     * @return The index of the last occurrence element, or -1 if it is not in
     *   the list.
     */
    public static int lastIndexOf(ListNode list, int element) {
        return lastIndexOfHelper(list,element, -1, 0); // FIXME
    }
    public static int lastIndexOfHelper(ListNode<Integer> list, int element, int index, int count) {
        if(list == null) return index;
        if(list.getFirst() == element){
        	return lastIndexOfHelper(list.getRest(),element,count,count+1);
        }
        else {
        	return lastIndexOfHelper(list.getRest(),element,index,count+1);
        }
        	
        
        
    	
    }
    

    /**
     * Return true if the two lists are the same.
     *
     * Examples:
     *
     * * equals(makeList(1, 2), makeList(1, 2)) should return true
     * * equals(makeList(1, 2), makeList(1, 1)) should return false
     *
     * @param list1 The first list.
     * @param list2 The second list.
     * @return True if the lists are equal; false otherwise.
     */
    public static boolean equals(ListNode list1, ListNode list2) {
        // Both lists are empty
        if (list1 == null && list2 == null) return true;
        
        // Only one list is empty, or the values of the current nodes are not equal
        if (list1 == null || list2 == null || !list1.getFirst().equals(list2.getFirst())) return false;
        
        // Recurse on the rest of the lists
        return equals(list1.getRest(), list2.getRest());
    }

    /**
     * Create a new, reversed list.
     *
     * Examples:
     *
     * * reverse(makeList(1, 2, 3)) should be equivalent to makeList(3, 2, 1)
     *
     * @param list The list to reverse.
     * @return A new list that is reversed of the argument.
     */
    public static ListNode reverse(ListNode list) {
        return reverseHelper(list, null);
    }

    private static ListNode reverseHelper(ListNode list, ListNode reversed) {
        if (list == null) {
            return reversed;
        }
        
       return  reverseHelper(list.getRest(), new ListNode(list.getFirst(),reversed)); 
        
    }

    /**
     * Get the first n elements of a list.
     *
     * n is assumed to between 0 and the size of the list, inclusive.
     *
     * Examples:
     *
     * * headList(makeList(1, 2, 3, 4), 2) should be equivalent to
     *   makeList(1, 2)
     *
     * @param list The list.
     * @param n The number of elements to get.
     * @return The head list of the specified size.
     */
    public static ListNode headList(ListNode list, int n) {
    	ListNode result = headListHelper(list, n, null);
        return reverse(result);
    }
    private static ListNode headListHelper(ListNode list, int n, ListNode acc) {
    	if (list == null || n == 0) {
            return acc; 
        }
        return headListHelper(list.getRest(), n - 1, new ListNode(list.getFirst(), acc));
    }

    /**
     * Get the last n elements of a list.
     *
     * n is assumed to between 0 and the size of the list, inclusive.
     *
     * Examples:
     *
     * * tailList(makeList(1, 2, 3, 4), 2) should be equivalent to
     *   makeList(3, 4)
     *
     * @param list The list.
     * @param n The number of elements to get.
     * @return The tail list of the specified size.
     */
    public static ListNode tailList(ListNode list, int n) {
        return tailListHelper(list, list, n);
    }

    private static ListNode tailListHelper(ListNode lead, ListNode follow, int n) {
       
        if (n > 0 && lead != null) {
            return tailListHelper(lead.getRest(), follow, n - 1);
        }       
        else if (lead != null) {
            return tailListHelper(lead.getRest(), follow.getRest(), n);
        }       
        return follow;
    }

    /**
     * Get the slice of the list between the start and end indices.
     *
     * start and end are assumed to be between 0 and the size of
     * the list, inclusive, and that start <= end.
     *
     * Examples:
     *
     * * subList(makeList(1, 2, 3, 4), 1, 3) should be equivalent to
     *   makeList(2, 3)
     *
     * @param list The list.
     * @param start The first index to include in the slice.
     * @param end The first index to exclude from the slice.
     * @return The slice of the list between the start and end indices.
     */
    public static ListNode subList(ListNode list, int start, int end) {
        if (start == 0) {
            // Start constructing the sublist
            return new ListNode(list.getFirst(), subList(list.getRest(), 0, end - 1));
        }
        // Skip the first start elements
        return subList(list.getRest(), start - 1, end - 1);
    }

    /**
     * Add an element at the end of the list.
     *
     * * add(makeList(1, 2), 3) should be equivalent to makeList(1, 2, 3)
     *
     * @param list The list.
     * @param element The element to add.
     * @return The list with the new element added.
     */
    
    public static ListNode add(ListNode list, int element) {
    	  if (list == null) {
    	        return new ListNode(element, null);
    	    } else {
    	        return new ListNode(list.getFirst(), add(list.getRest(), element));
    	    }
    }

    /**
     * Add all of the second list to the end of the first list.
     *
     * * addAll(makeList(1, 2), makeList(3, 4)) should be equivalent to
     *   makeList(1, 2, 3, 4)
     *
     * @param list1 The first list.
     * @param list2 The second list.
     * @return A new list that combines the two lists.
     */
    public static ListNode addAll(ListNode list1, ListNode list2) {
        // Base case: if the first list is null, return a copy of the second list
        if (list1 == null) {
            return list2;
        }
        // Recursively add elements of the first list to the new list
        // Then append the second list to the end of the new list created from the first
        return new ListNode(list1.getFirst(), addAll(list1.getRest(), list2));
    }

}
