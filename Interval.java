import java.util.LinkedList;
import java.util.List;

public class Interval {

    public class IntervalStruct{
        private int start;
        private int end;
        public IntervalStruct(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        // Introduction to Intervals - https://youtu.be/2ZLl8GAk1X4?t=135946
        //      1. An interval is a range represented by two numbers like (5, 8)
        //      2. The two numbers are termed as - start and end.
        //      3. Example - Time interval in tasks or jobs - 
        //              a = (1, 3)
        //              b = (4, 5)
        //              c = (8, 10)
        //              d = (9, 11)
        //
        // Overlapping Intervals - https://youtu.be/2ZLl8GAk1X4?t=136142
        // Relationship between two intervals a and b
        //      1. a and b do not overlap.
        //      2. a and b overlap, b ends after a.
        //      3. a completely overlaps b.
        //      4. a and b overlap, a ends after b.
        //      5. b completely overlaps a.
        //      6. b and a do not overlap.
        //
        //
        // Merge Intervals - https://youtu.be/2ZLl8GAk1X4?t=136441
        // Question 1: Given a list of intervals, merge all the overlapping intervals and
        // return a list of non-overlapping intervals. Example:
        // Input: intervals = [{2, 6}, {1, 3}, {8, 10}]
        // Output: [{1, 6}, {8, 10}]
        //
        //
        // Insert Intervals - https://youtu.be/2ZLl8GAk1X4?t=137763
        // Question 2: Given a list of non-overlapping intervals sorted by their start time, insert
        // a given interval at the valid position, merge all the overlapping intervals and return a list
        // of mutually exclusive intervals. Example:
        // Input: intervals - [{1, 3}, {5, 7}, {8, 10}], newInterval = [{4, 9}]
        // Output: [{1, 3}, {4, 10}]
    }
} 
