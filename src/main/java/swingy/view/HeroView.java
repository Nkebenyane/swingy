package swingy.view;

import java.util.Scanner;
import swingy.Main;

public class HeroView {
    // public static int level;
    public static String hero_name;
    
	public void printHeroDetails(String hero_name, String hero_class,int level, int experience, int attack, int defense, int hitpoints) {
        System.out.println("----------------------------");
        System.out.println("        Hero info:          ");
        System.out.println("----------------------------");
        System.out.println("Name       : " + hero_name);
        System.out.println("Class      : " + hero_class);
        System.out.println("Level      : " + level);
        System.out.println("Experiance : " + experience);
        System.out.println("Attack     : " + attack);
        System.out.println("Defense    : " + defense);
        System.out.println("HitPoints  : " + hitpoints);
        

        System.out.println();
    }

    public static void GameHeading() {
        System.out.println("***********************************************");
        System.out.println("**                                           **");
        System.out.println("**                  Swingy                   **");
        System.out.println("**                                           **");
        System.out.println("***********************************************");
        System.out.println();
    }
    // System.out.println("--------------------------------------------------------------------------------------");
    // System.out.println("-                             You have two options                                   -");
    // System.out.println("-                                                                                    -");
    // System.out.println("- [Fight]    : which engages him in a battle with the villain                        -");
    // System.out.println("-                                                                                    -");
    // System.out.println("- [Run  ]    : which gives him a 50% chance of returning to the previous position.   -");
    // System.out.println("-              If the odds aren’t on his side, he must fight the villain.            -");
    // System.out.println("--------------------------------------------------------------------------------------");


    // public void TheStartOfTheGame() {
    //     System.out.println();
    //     System.out.println("Your options are:");
    //     System.out.println("CREATE: To create a hero");
    //     System.out.println("SELECT: To select a priviously created hero");

    //     System.out.println();

    //     Scanner in = new Scanner(System.in);

    //     System.out.print("Enter your option: ");

    //     while (in.hasNext()) {
    //         String option = in.nextLine();
    //         if (!option.equalsIgnoreCase("CREATE") && !option.equalsIgnoreCase("SELECT")) {
    //             System.out.println("Invalid option:");
    //             System.out.print("Enter your option e.g[ CREATE || SELECT ]: ");
    //         }
    //         if (option.equalsIgnoreCase("CREATE")) {
    //             Main.IdontUnderstand();
    //         }
    //         if (option.equalsIgnoreCase("SELECT")) {
    //             System.out.println("you are about to use you old hero");
    //         }
    //     }
    //     in.close();
    // }
}
