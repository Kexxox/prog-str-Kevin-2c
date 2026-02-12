
public class MainPersonas {
    public static void main(String[] args) {


        int[]arr;
        int[]arr1 = new int [4];
        int[]arr2 = {1,2,3,4};





        System.out.println(arr1[0]);
        System.out.println(arr1[1]);

        System.out.println("______________________");

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        System.out.println("______________________");

        for(int numero : arr1){
            System.out.println(numero);
        }


        System.out.println("______________________");

        Personass [] personas = new Personass[3];

        Personass persona1 = new Personass();
        persona1.setId(1);
        persona1.setName("Test");
        persona1.setActive(true);

        Personass persona2 = new Personass(2,"Eliel");
        Personass persona3 = new Personass(3,"David");

        personas[0] = persona1;
        personas[1] = persona2;
        personas[2] = persona3;

        personas[0]= null;


        for (Personass persona: personas){

            if(persona==null) {
                System.out.println("Hay un null");
            }else{
                System.out.println("____________________");
                System.out.println(persona.getId());
                System.out.println(persona.getName());
                System.out.println(persona.isActive());
            }



        }


    }
}