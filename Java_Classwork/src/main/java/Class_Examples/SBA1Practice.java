package Class_Examples;

public class SBA1Practice {
    public static void main(String[] args) {

        //region Part 1 - create a for loop to print each char on its own line
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
        //endregion

        //region Part 2 - convert string to integer values
        String ten = "10";
        String hundred = "100";
        System.out.println(Integer.parseInt(ten));
        System.out.println(Integer.parseInt(hundred));
        //endregion

        //region - find the sum of all the integers
        int[] array = {2, 4, 5, 6, 7, 8, 10};
        int sum = 0;
        for(int num : array){
            sum += num;
        }
        System.out.println(sum);
        //endregion

        //region - print the given array of strings into integers
        String[] nums = {"2", "4", "5", "6", "7", "8", "10"};

        for(String num : nums){
            System.out.println(Integer.parseInt(num));
        }
        //endregion
    }
}
