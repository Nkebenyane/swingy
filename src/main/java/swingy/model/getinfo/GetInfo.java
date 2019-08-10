package swingy.model.getinfo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import swingy.controller.HeroController;
import swingy.model.Hero;
import swingy.model.HeroFectory;
import swingy.view.HeroView;

public class GetInfo {
    public static void Select()
    {
        Scanner in = new Scanner(System.in);
       
        System.out.print("Enter hero name: ");
        String hero_name = in.nextLine();
        System.out.println();
        System.out.print("Enter hero_class: ");

        String hero_class = in.nextLine();
        UserData select = new UserData();
        select.GetData(hero_name, hero_class);
    }
    private static Hero retriveData() {
        Hero hero = new Hero();

        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println(
                "*note: To create a hero you need to enter your hero name and select hero class from the list below");
        System.out.println();
        System.out.println("Classes: attack  defense   hp\n" + "Warrior    10      10      1000\n"
                + "Hunter     20      20      1000\n");
        System.out.print("Enter hero name: ");
        String hero_name = in.nextLine();
        System.out.println();
        System.out.print("Enter hero_class: ");

        String hero_class = in.nextLine();
        hero = HeroFectory.newHero(hero_name, hero_class);
        System.out.println();
        System.out.println(hero);

        return hero;
    }

    // This class is for us to view user or player information.
    public static void IdontUnderstand() throws IOException, ClassNotFoundException, SQLException {
        HeroView view = new HeroView();
        Hero model = retriveData();
        UserData data = new UserData();

        HeroController controller = new HeroController(model, view, data);

        controller.updateView();
        controller.DataCapture();
    }
}