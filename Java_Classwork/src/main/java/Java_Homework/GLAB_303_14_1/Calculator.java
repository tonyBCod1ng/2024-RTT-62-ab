package Java_Homework.GLAB_303_14_1;

class Calculator {
    FuncInterfaceExample funcInterfaceExample = new FuncInterfaceExample() {
        @Override
        public int sum(int a, int b) {
            return a + b;
        }
    };
}
