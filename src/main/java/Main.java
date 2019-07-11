import view.Cli;
import view.Gui;

public class Main {
    public static void main(String[] args) {
        if (args[0].equals("console"))
        {
            System.out.println("You are viewing in a console");
            Cli.console();
        }
        if (args[0].equals("GUI"))
        {
            System.out.println("You are viewing in GUI");
            Gui.graphic();
        }

    }
}
