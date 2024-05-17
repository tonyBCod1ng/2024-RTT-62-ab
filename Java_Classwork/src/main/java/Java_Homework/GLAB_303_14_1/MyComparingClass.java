package Java_Homework.GLAB_303_14_1;

class MyComparingClass {
    Generic_functionInterface<Integer> compareTwoVar = new Generic_functionInterface<Integer>() {
        @Override
        public Integer compare(Integer a, Integer b) {

            if (a > b) {
                return a;
            } else {
                return b;
            }
        }
    };

    Generic_functionInterface<String> stCompare = new Generic_functionInterface<String>() {
        public String compare(String a, String b) {

            if (a.equals(b)) {
                return "true";
            } else {
                return "false";
            }
        }
    };
    Generic_functionInterface<Float> flCompare = new Generic_functionInterface<Float>() {
        @Override
        public Float compare(Float a, Float b) {
            if (a < b) {
                return a;
            } else {
                return b;
            }
        }
    };
    
}
