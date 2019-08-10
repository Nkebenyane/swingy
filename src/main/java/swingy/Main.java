package swingy;

import java.io.IOException;
import java.sql.SQLException;

import swingy.model.getinfo.UserData;
import swingy.view.HeroView;
import swingy.view.start.ConsoleStart;
import swingy.view.start.GuiStart;

public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
    if (args.length != 1 || (!args[0].equals("console") && !args[0].equals("gui"))) {
      System.out.println("Usage: program console | gui");
      System.exit(1);
    }
    UserData.connect();
    if (args[0].equalsIgnoreCase("console")) {
      System.out.println("\033[2J\033[H");
      HeroView.GameHeading();
      ConsoleStart.TheStartOfTheGame();
    }
    if(args[0].equalsIgnoreCase("gui"))
    {
      GuiStart.guiview();
    }
    UserData.close();
  }
}
