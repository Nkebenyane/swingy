package swingy.view.start;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import swingy.model.getinfo.GetInfo;
import swingy.view.HeroView;

public class ConsoleStart {

    public static void TheStartOfTheGame() throws IOException, ClassNotFoundException, SQLException {
        System.out.println();
        System.out.println("Your options are:");
        System.out.println("CREATE: To create a hero");
        System.out.println("SELECT: To select a priviously created hero");

        System.out.println();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter your option: ");

        while (in.hasNext()) {
            String option = in.nextLine();
            if (!option.equalsIgnoreCase("CREATE") && !option.equalsIgnoreCase("SELECT")) {
                System.out.println("Invalid option:");
                System.out.print("Enter your option e.g[ CREATE || SELECT ]: ");
            }
            if (option.equalsIgnoreCase("CREATE")) {
                System.out.println("The Start Of The Game");
                GetInfo.IdontUnderstand();
            }
            if (option.equalsIgnoreCase("SELECT")) {
                System.out.println("you are about to use you old hero");
                GetInfo.Select();
            }
        }
        in.close();
    }
}