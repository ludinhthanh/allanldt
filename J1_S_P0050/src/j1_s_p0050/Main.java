package J1_S_P0050;
class Main{
    public static void main(String[] arrs) {

        EquationProgram pr1=new EquationProgram();
        while(true){
            int choice=pr1.menu();

            switch(choice){
                case 1: pr1.option1();
                        break;
                case 2: pr1.option2();
                        break;
                case 3: pr1.terminate();
                        break;
            }
        }

    }
}