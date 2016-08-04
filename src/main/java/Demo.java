/**
 * Created by piers on 04/08/16.
 */
public class Demo {

    public static void main(String[] args) {
        ParameterSweep sweep = new Implementation();

        sweep.setBoolean("bool", 0.75);

        int i = 0;
        for(Boolean result : sweep.getBoolean("bool")){
            System.out.println("Boolean was: " + result);
            System.out.println("I: " + i++);
            if(i > 150) break;
        }

        sweep.setInteger("int", 10, 20);
        for(Integer j : sweep.getInteger("int", 10)){
            System.out.println(j);
        }

        try{
            for(Integer j : sweep.getInteger("not present", 10)){
                System.out.println(j);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
