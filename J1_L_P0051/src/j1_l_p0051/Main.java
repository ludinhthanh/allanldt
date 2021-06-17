
package j1_l_p0051;

class Main{

    public static void main(String[] arrs) {
        Program pr1=new Program();
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
