package swingy;

import swingy.model.HeroModel;
import swingy.model.board.Board;
import java.util.Scanner;

import swingy.controller.HeroController;
import swingy.view.HeroView;

public class Main {
    public static void main(String[] args) {

        if (args[0].equalsIgnoreCase("console")) {
            System.out.print("\033[H\033[2J");
            HeroView view = new HeroView();
            view.GameHeading();
            view.TheStartOfTheGame();
        }
    }

    public static void IdontUnderstand() {
        HeroView view = new HeroView();
        HeroModel model = retriveHeroFromDatabase();

        HeroController controller = new HeroController(model, view);
        controller.updateView();

        Board map = new Board();
        map.fillBoard();
        map.presentBoard();
        map.move();
    }

    private static HeroModel retriveHeroFromDatabase() {

        HeroModel Hero = new HeroModel();

        Scanner in = new Scanner(System.in);
        // while (in.hasNext()) {
            System.out.println();
            System.out.println(
                    "*note: To create a hero you need to enter your hero name and select hero class from the list below");
            System.out.println();
            System.out.println("Hunter \n" + "Warrior\n");
            System.out.print("Enter hero name: ");
            String hero_name = in.nextLine();
            System.out.println();
            System.out.print("Enter hero_class: ");
            String hero_class = in.nextLine();

            Hero.setHeroName(hero_name);
            Hero.setHeroClass(hero_class);

        //     in.close();
        // }  
        return Hero;
    }
}
