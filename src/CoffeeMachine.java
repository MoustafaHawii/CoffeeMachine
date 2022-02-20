import java.util.Scanner;
/**
 * @author Moustafa Hawi
 * @date 19.02.2022
 * @version 1.0
 */
public class CoffeeMachine {
    //Scanner
    Scanner scanner = new Scanner(System.in);
    //Attribute
    private int amountSugar = 40;
    private int amountCoffee =  40;
    private int amountMilk = 25;
    private int amountRahm = 20;
    //setter und getter
    public void setAmountSugar(int amountSugar) {
        this.amountSugar = amountSugar;
    }
    public void setAmountCoffee(int amountCoffee) {
        this.amountCoffee = amountCoffee;
    }
    public void setAmountMilk(int amountMilk) {
        this.amountMilk = amountMilk;
    }
    public void setAmountRahm(int amountRahm) {
        this.amountRahm = amountRahm;
    }
    /**
     * Diese Methode erstellt einen Cappcino.
     */
    public void createCappucino(){
        amountCoffee--;
        amountMilk--;
        System.out.println("Wie viel Zucker Würfel hätten Sie gerne?");
        int sugarinCoffee = scanner.nextInt();
        if (amountSugar >= sugarinCoffee) {
            if (amountSugar != sugarinCoffee) {
                amountSugar = amountSugar - sugarinCoffee;
            } else{
                amountSugar = amountSugar - sugarinCoffee;
                refill();
            }
        } else {
            System.out.println("Wir haben zu wenig Zucker. Sie müssen weniger Zucker nehmen. Maximale Anzahl Zucker: " + amountSugar);
            System.out.println("Wir werden die Zutaten wieder auffüllen.");
            createCappucino();
            refill();
        }
    }
    /**
     * Diese Methode erstellt einen Latte Macchiato.
     */
    public void createLatteMacchiato(){
        amountCoffee--;
        amountMilk--;
        System.out.println("Wie viel Zucker Würfel hätten Sie gerne?");
        int sugerinCoffee = scanner.nextInt();
        if (amountSugar >= sugerinCoffee){
            if (amountSugar != sugerinCoffee){
                amountSugar = amountSugar - sugerinCoffee;
            } else{
                amountSugar = amountSugar - sugerinCoffee;
                refill();
            }
        } else{
            System.out.println("Wir haben zu wenig Zucker. Sie müssen weniger Zucker nehmen. Maximale Anzahl Zucker: "+ amountSugar);
            System.out.println("Wir werden die Zutaten wieder auffüllen.");
            createLatteMacchiato();
            refill();
        }
    }
    /**
     * Diese Methode erstellt einen Espresso.
     */
    public void createEspresso(){
        amountCoffee--;
        System.out.println("Wie viel Zucker Würfel hätten Sie gerne?");
        int sugerinCoffee = scanner.nextInt();
        if (amountSugar >= sugerinCoffee){
            if (amountSugar != sugerinCoffee){
                amountSugar = amountSugar - sugerinCoffee;
            }else{
                amountSugar = amountSugar - sugerinCoffee;
                refill();
            }
        } else{
            System.out.println("Wir haben zu wenig Zucker. Sie müssen weniger Zucker nehmen. Maximale Anzahl Zucker: "+ amountSugar);
            System.out.println("Wir werden die Zutaten wieder auffüllen.");
            createEspresso();
            refill();
        }
        System.out.println("Wie viel Rahm hätte Sie gerne?");
        int rahminCoffee = scanner.nextInt();
        if (amountRahm >= rahminCoffee){
            if (amountRahm != rahminCoffee){
                amountRahm = amountRahm - rahminCoffee;
            } else{
                amountRahm = amountRahm - rahminCoffee;
                refill();
            }
        }else {
            System.out.println("Wir haben zu wenig Rahm. Sie müssen weniger Rahm nehmen. Maximale Anzahl Rahm: "+ amountRahm);
            System.out.println("Wir werden die Zutaten wieder auffüllen.");
            createEspresso();
            refill();
        }
    }
    /**
     * Wenn Zutat fehlt wird die refill() Methode aufgerufen damit die Zutat wieder Aufgestockt wird.
     */
    public void refill(){
        setAmountSugar(40);
        setAmountCoffee(40);
        setAmountMilk(25);
        setAmountRahm(20);
    }
    /**
     * User Dialog.
     */
    public void run() {
        boolean loop = true;
        while (loop == true) {
            System.out.println("Wählen Sie Ihren Kaffe:");
            System.out.println("\t-Cappucino (Wählen Sie: 1 )");
            System.out.println("\t-Latte Macchiato (Wählen Sie: 2");
            System.out.println("\t-Espresso (Wählen Sie:) 3");
            System.out.println("\t-Maschine ausschalten (Wählen Sie:) 4");
            int userWahl = scanner.nextInt();
            switch (userWahl) {
                case 1:
                    System.out.println("Sie hätten gerne einen Cappucino: ");
                    createCappucino();
                    break;
                case 2:
                    System.out.println("Sie hätten gerne einen Latte Macchiato: ");
                    createLatteMacchiato();
                    break;
                case 3:
                    System.out.println("Sie hätten gerne einen Espresso: ");
                    createEspresso();
                    break;
                case 4:
                    loop = false;
                    System.out.println("Maschine wird heruntergefahren.");
                    break;
                default:
                    System.out.println("Dieser Case existiert nicht!");
                    run();
            }
        }
    }
}