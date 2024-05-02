```java
class ListNode {

    int value = 0;
    ListNode rest = null;

    // ...

}
```

In fact, this is the *original* linked list, then called a *cons cell*, invented back in 1958. The only thing you can do with this "list" is get the first element, or get the rest of the list. A complete implementation of this linked list is found in `ListNode.java`. Documentation of this class is in the [ListNode Javadoc](./javadocs/ListNode.html).

This programming project asks you to write twelve tail-recursive linked list functions. The signatures of these functions are listed below; you can read more about them in the [ListFuntions JavaDoc](./javadocs/ListFunctions.html)

* <code class="prettyprint lang-java">boolean isEmpty(ListNode list)</code>
* <code class="prettyprint lang-java">int size(ListNode list)</code>
* <code class="prettyprint lang-java">int get(ListNode list, int index)</code>
* <code class="prettyprint lang-java">int indexOf(ListNode list, int element)</code>
* <code class="prettyprint lang-java">int lastIndexOf(ListNode list, int element)</code>
* <code class="prettyprint lang-java">boolean equals(ListNode list1, ListNode list2)</code>
* <code class="prettyprint lang-java">ListNode reverse(ListNode list)</code>
* <code class="prettyprint lang-java">ListNode headList(ListNode list, int n)</code>
* <code class="prettyprint lang-java">ListNode tailList(ListNode list, int n)</code>
* <code class="prettyprint lang-java">ListNode subList(ListNode list, int start, int end)</code>
* <code class="prettyprint lang-java">ListNode add(ListNode list, int element)</code>
* <code class="prettyprint lang-java">ListNode addAll(ListNode list1, ListNode list2)</code>

`ListFunctions.java` contains function stubs for each of the functions above, although you should feel free to write additional private functions. A second file, `ListFunctionsTestUtils.java`, contains utility functions you may use for testing, but which should *not* be used in your code. You can find details on those function in the [ListFunctionsUtils Javadoc](./javadocs/ListFunctionsUtils.html).

Your submission should additionally follow the constraints below:

1. All recursive functions should be tail recursive. Not all functions require recursion, but all recursive functions must be tail-recursive - that is, whenever functions call themselves, the result must be returned directly. You are not allowed to use any non-recursive looping, such as `for`, `while`, or `goto`.
2. You are not allowed to have non-local variables (i.e., variables that exist outside of functions), nor create any arrays.
3. Your functions must run in O(n) time (or better).
4. You should not use the later functions in earlier ones. For example, the code for `addAll` can use `reverse`, but not vice versa.


