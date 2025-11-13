 import java.util.Scanner;
public class Reciever {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter hte number of frames mto recive");
        int f=scanner.nextInt();
        int[]frames=new int[f];
        System.out.println("Enter"+f+"frames");
        for(int i=0;i<f;i++)
        {
            frames[i]=scanner.nextInt();
        }
        for(int i=0;i<f;i++)
        {
            System.out.print("recive recived frames:"+frames[i]);
            System.out.println("Sending acknowlegment for frames"+frames[i]);
        }
       scanner.close();
    }
    
}
