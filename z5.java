import java.util.*;
abstract class CarServices
{
    float price ; 
    int days ; 
    static float totalprice = 0 ;
    static int totaldays = 0 ; 
    CarServices()
    {
        price = 1000; 
        days = 1 ; 
        totalprice += this.price ; 
        totaldays += this.days ; 
    }
    CarServices(float price , int days)
    {
        this.price = price ; 
        this.days = days ; 
        totalprice += this.price ; 
        totaldays += this.days ; 
    }
    static void show(){
        System.out.printf("Total days after which you are going to recieve your vehicle : %d\n",totaldays);
        System.out.printf("Total price for availing our services : %f\n",totalprice);
    }
    abstract void display() ; 

}
class Cleaning extends CarServices 
{
    String typeOfWash ; 
    final static String wash[] = {"Normal Cleaning","Full Body Wash" , "Interior Cleaning"}; 
    final static float washprice[] = {500f,2000f,1000f};
    Cleaning()
    {
        super(); 
        typeOfWash = "Normal Cleaning"; 
    }
    Cleaning(float price , int days , String s)
    {
        super(price , days); 
        typeOfWash = s ; 
    }
    void display()
    {
        System.out.printf("Cleaning Services that you have selected : %s\nPrice : %f\nDays after which you will get your car : %d\n",typeOfWash,price,days);
    }
}
class Paint extends CarServices 
{
    String selectColor ; 
    final static String color[] = {"Red","Blue","Black","White","Gray"};
    final static float colorprice[] = {10000f,7000f,11000f,13000f,5000f};
    Paint()
    {
        super(); 
        selectColor = "White";
    }
    Paint(float price , int days , String s)
    {
        super(price , days); 
        selectColor = s ; 
    }
    void display()
    {
        System.out.printf("Paint that you have selected for your car: %s\nPrice : %f\nDays after which you will get your car : %d\n",selectColor,price,days);
    }
}
class AccidentalRepair extends CarServices
{
    String accident ; 
    final static String damage[] = {"Frontal Damage" , "Rear Damage" , "Door's Damage","Bumper Damage" , "Full body damage"};
    final static float damageprice[] = {10000f , 8000f , 6000f , 4000f , 20000f}; 
    AccidentalRepair()
    {
        super();
        accident = "Full body damage";
    }
    AccidentalRepair(float price , int days , String s)
    {
        super(price, days);
        accident = s ; 
    }
    void display()
    {
        System.out.printf("Accidental Repair that you have selected : %s\nPrice : %f\nDays after which you will get your car : %d\n",accident,price,days);
    }
}
interface user_details
{
    void display() ; //public + abstract 
}
class details implements user_details
{
    private String name ; 
    private int age ; 
    private String phoneno ; 
    private String user_car ; 
    final static String cars[] = {"Maruti Suzuki" , "Hyundai" , "Honda", "Mahindra","Toyota","Tata","BMW","Audi","Mercedes"};
    details()
    {
        name = "" ; 
        age = 25 ; 
        phoneno = "00000";
        user_car = "Not mentioned";
    }
    details(String name , int age , String phoneno , String user_car)
    {
        this.name = name ; 
        this.age = age ; 
        this.phoneno = phoneno ; 
        this.user_car = user_car;
    }
  
    public void display() 
    {
        System.out.println("\n");
        System.out.printf("Name : %s\nAge : %d\nPhone number : %s\nCar's Model : %s\n",this.name,this.age,this.phoneno,this.user_car);
    }
}
public class z5 {
static
{
    System.out.println("WELCOME TO GAURAV MOTORS");
    System.out.println("We provide various car services");
    
}
    public static String model() 
    {   
        int ch ; 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the model of car that you want to get serviced : ");
        for(int i = 0 ; i < details.cars.length ; i++)
        {
            System.out.printf("%d. %s\t",i+1,details.cars[i]);
        }
        System.out.print("\nEnter your choice here : ");
        ch = sc.nextInt();
        if(ch>=1 && ch<= details.cars.length)
        {
            return details.cars[ch-1];
        }
        else
        {
            return "Invalid name entered"; 
        }
    }
    public static void main(String[] args) throws InterruptedException
    {

        Scanner sc = new Scanner(System.in);
        String name ; 
        int age ; 
        String phoneno; 
        String car ; 
        System.out.println("\n\nPlease enter your details before availing the car services");
        System.out.print("Enter your name : ");
        name = sc.nextLine(); 
        System.out.print("Enter your age : " );
        age = sc.nextInt(); 
        sc.nextLine();
        System.out.print("Enter your phone number : ");
        phoneno = sc.nextLine(); 
        car = z5.model();

        details user = new details(name,age,phoneno,car);
        user.display();
        System.out.println("\n\n");
        int choice1 ; 
        int choice2 ; 
        String s ; float p ; String a ; 
        
        CarServices o[] = new CarServices[3]; 
        Cleaning obj1 ; 
        Paint obj2 ; 
        AccidentalRepair obj3 ; 
        int count = 0 ; 

        System.out.print("Do you want to avail our cleaning services : 1->Yes \t 0:No : ");
        choice1 = sc.nextInt() ;
        if(choice1 == 1)
        {
            System.out.println("Enter the cleaning service that you want to avail : ");
            for(int i = 0 ; i < Cleaning.wash.length ; i++)
            {
                System.out.printf("%d. %s - %fRs.\n",i+1,Cleaning.wash[i],Cleaning.washprice[i]);
            }
            System.out.print("Enter your choice : ");
            choice2 = sc.nextInt();
            System.out.println("\n\n");
            if(choice2 >=1 && choice2<= Cleaning.wash.length)
            {
                s = Cleaning.wash[choice2 - 1];
                p = Cleaning.washprice[choice2 - 1]; 
                System.out.printf("Your %s service is going to take 2 days\n",s);
                obj1 = new Cleaning(p,2,s);
                obj1.display();
                o[count] = obj1 ; 
                count++;
            }
            else
            {
                obj1 = new Cleaning();
                obj1.display();
                o[count] = obj1 ; 
                count++;
            }
            
        } 
        else
        {
            System.out.println("You dont't want to avail our fantastic cleaning services :( ");
        }

        System.out.println("\n\n");
        System.out.print("Do you want to avail our Paint services : 1->Yes \t 0:No : ");
        choice1 = sc.nextInt() ;
        if(choice1 == 1)
        {
            System.out.println("Enter the Paint service that you want to avail : ");
            for(int i = 0 ; i < Paint.color.length ; i++)
            {
                System.out.printf("%d. %s - %fRs.\n",i+1,Paint.color[i],Paint.colorprice[i]);
            }
            System.out.print("Enter your choice : ");
            choice2 = sc.nextInt();
            System.out.println("\n");
            if(choice2 >=1 && choice2<= Paint.color.length)
            {
                s = Paint.color[choice2 - 1];
                p = Paint.colorprice[choice2 - 1]; 
                System.out.printf("Your %s paint service is going to take 4 days\n",s);
                obj2 = new Paint(p,4,s);
                obj2.display();
                o[count] = obj2 ; 
                count++;
            }
            else
            {
                obj2 = new Paint();
                obj2.display();
                o[count] = obj2 ; 
                count++;
            }
            
        } 
        else
        {
            System.out.println("You dont't want to avail our fantastic Painting services :( ");
        }

        System.out.println("\n\n");
        System.out.print("Do you want to avail our Accidental Repair services : 1->Yes \t 0:No : ");
        choice1 = sc.nextInt() ;
        if(choice1 == 1)
        {
            System.out.println("Enter the AccidentalRepair service that you want to avail : ");
            for(int i = 0 ; i < AccidentalRepair.damage.length ; i++)
            {
                System.out.printf("%d. %s - %fRs.\n",i+1,AccidentalRepair.damage[i],AccidentalRepair.damageprice[i]);
            }
            System.out.print("Enter your choice : ");
            choice2 = sc.nextInt();
            System.out.println("\n");
            if(choice2 >=1 && choice2<= AccidentalRepair.damage.length)
            {
                s = AccidentalRepair.damage[choice2 - 1];
                p = AccidentalRepair.damageprice[choice2 - 1]; 
                System.out.printf("Your %s AccidentalRepair service is going to take 7 days\n",s);
                obj3 = new AccidentalRepair(p,7,s);
                obj3.display();
                o[count] = obj3 ; 
                count++;
            }
            else
            {
                obj3 = new AccidentalRepair();
                obj3.display();
                o[count] = obj3 ; 
                count++;
            }
            
        } 
        else
        {
            System.out.println("You dont't want to avail our fantastic Damage repair services :( ");
        }

        System.out.println("\n");
            CarServices.show();
            System.out.println("\n");
          for(int i = 0  ; i < CarServices.totaldays ; i++)
                {
                    System.out.println("Day "+ (i+1));
                    Thread.sleep(500);
                }
            System.out.println("Your car is ready you can collect it from us :)");

            System.out.println("Finalizing your services : ");
            for(int i = 0 ; i < count ; i++)
            {
                System.out.println("");
                o[i].display();
            }

    }   
}
