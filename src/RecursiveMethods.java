//             Connor Pham
//              CS 160 Program7
//              4/28/23
public class RecursiveMethods {
    public static void main(String[] args) {
        RecursiveMethods p6 = new RecursiveMethods();
        //Some testing on the methods
        int partI = p6.byLeapsAndBounds(3);
        System.out.println("Part I answer: " + partI); //should print Part I answer: 3

        int partII = p6.subCount("aaaa","a");
        System.out.println("Part II answer: " + partII); //should print Part II answer: 4


    }
    public int byLeapsAndBounds(int n) {
        //Part I code goes here
        // n = 0 or n =1 then return (base case)
        if(n ==1 || n ==0) {
            return 1;
        }
        //followed by leap or bound
        // recursion occurs here
        int moves = byLeapsAndBounds(n-1) + byLeapsAndBounds(n-2);
        // returning amount of possible leaps/bounds
        return moves;

    }
    public int subCount(String str, String subStr) {
        //Part II code goes here
        //checking if subStr doesn't exist in str and returns 0 (base case)
        if(str.length() < subStr.length()) {
            return 0;
        }
        //checking if subStr exists at the start of str with a simple for loop
        boolean value = true;
        for(int i = 0; i < subStr.length(); i++) {
            if (str.charAt(i) != subStr.charAt(i)){
                value = false;
                break;
            }
        }
        // if subStr exists in str we check and count recursively and return count of subStr in Str
        if(value == true) {
            return 1 + subCount(str.substring(1),subStr);
        }
        else {
            return subCount(str.substring(1), subStr);
        }
    }
    public int binarySearch(int[]array, int target, int left, int right) {
        //Part III code goes here
        //makes sure its sorted
        if (right >= left) {
            //normal binary search algorithm
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > target) {
                // recursively searching with lesser input
                return binarySearch(array, target, left, mid - 1);
            }
            return binarySearch(array, target, mid + 1, right);
        }
        return -1;
    }
}
