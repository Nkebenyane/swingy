package swingy.model.board;

import java.util.Random;
import java.util.Scanner;

import swingy.model.artifacts.Armor;
import swingy.model.artifacts.Helm;
import swingy.model.artifacts.Weapon;
import swingy.model.getinfo.UserData;


public class Map {
    String hero_name;
    String hero_class;
    int level;
    int experience;
    int attack;
    int defense;
    int hitpoints;

    String[][] board;
    int mapSize;

    Weapon W = new Weapon();
    Helm H = new Helm();
    Armor A = new Armor();

    public Map(String hero_name, String hero_class, int level, int experience, int attack, int defense, int hitpoints) {
        this.hero_name = hero_name;
        this.hero_class = hero_class;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defense = defense;
        this.hitpoints = hitpoints;

        // experience = (int) (level * 1000 + Math.pow((level - 1), 2) * 450);
        mapSize = (level - 1) * 5 + 10 - (level % 2);
        board = new String[mapSize][mapSize];
    }

    public void generateMap() {

        mapSize = (level - 1) * 5 + 10 - (level % 2);
        board = new String[mapSize][mapSize];
        fillMap();
        presentBoard();
    }

    public void fillMap() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                board[i][j] = " ";
            }
        }
        wall();
        hero();
        if (attack <= 10)
            weapon();
        if (defense <= 20)
            helm();
        if (hitpoints <= 50)
            armor();
    }

    public void wall() {
        int max = 0;
        int min = 0;
        while (max < mapSize - 1) {
            board[min][max] = "*";
            board[max][min] = "*";
            max++;
        }
        while (min < mapSize) {
            board[min][max] = "*";
            board[max][min] = "*";
            min++;
        }
    }

    public void presentBoard() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (board[i][j].equalsIgnoreCase("P")) {
                    System.out.print("[ " + board[i][j] + " ]");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("hero_name : " + hero_name);
        System.out.println("hero_class: " + hero_class);
        System.out.println("Level     : " + level);
        System.out.println("experience: " + experience);
        System.out.println("attack    : " + attack);
        System.out.println("defence   : " + defense);
        System.out.println("hitponts  : " + hitpoints);
    }

    public void move() {
        int i = 0;
        int j = 0;

        System.out.println();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            for (i = 0; i < mapSize; i++) {
                for (j = 0; j < mapSize; j++) {
                    if (board[i][j].equals("P")) {
                        break;
                    }
                }
                if (j != mapSize)
                    break;
            }
            System.out.println("this is i: " + i + " this is j: " + j);
            try {
                if (input.equalsIgnoreCase("w")) {
                    if (board[i - 1][j] == "V") {
                        System.out.println("fight / run? Press [F] to fight / [R] to run: ");
                        String option = in.nextLine();
                        if (option.equalsIgnoreCase("f")) {
                            System.out.println("fighting");
                            int t = fight(i, j);
                            if (t == 1) {
                                board[i][j] = " ";
                                board[i - 1][j] = "P";
                            } else {
                                board[i][j] = "P";
                            }
                        } else {
                            run(i, j);
                        }
                    }
                    if (board[i - 1][j] == "*") {
                        win();
                    }
                    if (board[i - 1][j] == "W") {
                        board[i][j] = " ";
                        board[i - 1][j] = "P";
                        attack = W.sward(attack);
                    }
                    if (board[i - 1][j] == "A") {
                        board[i][j] = " ";
                        board[i - 1][j] = "P";
                        defense = H.Pot(defense);
                    }
                    if (board[i - 1][j] == "H") {
                        board[i][j] = " ";
                        board[i - 1][j] = "P";
                        hitpoints = A.shield(hitpoints);
                    } else {
                        board[i][j] = " ";
                        board[i - 1][j] = "P";
                    }
                }
                if (input.equalsIgnoreCase("z")) {
                    if (board[i + 1][j] == "V") {
                        System.out.println("fight / run? Press [F] to fight / [R] to run: ");
                        String option = in.nextLine();
                        if (option.equalsIgnoreCase("f")) {
                            System.out.println("fighting");
                            int t = fight(i, j);
                            if (t == 1) {
                                board[i][j] = " ";
                                board[i + 1][j] = "P";
                            } else {
                                board[i][j] = "P";
                            }
                        } else {
                            run(i, j);
                        }
                    }
                    if (board[i + 1][j] == "*") {
                        win();
                    }
                    if (board[i + 1][j] == "W") {
                        board[i][j] = " ";
                        board[i + 1][j] = "P";
                        attack = W.sward(attack);
                    }
                    if (board[i + 1][j] == "A") {
                        board[i][j] = " ";
                        board[i + 1][j] = "P";
                        defense = H.Pot(defense);
                    }
                    if (board[i + 1][j] == "H") {
                        board[i][j] = " ";
                        board[i + 1][j] = "P";
                        hitpoints = A.shield(hitpoints);
                    } else {
                        board[i][j] = " ";
                        board[i + 1][j] = "P";
                    }
                }
                if (input.equalsIgnoreCase("a")) {
                    if (board[i][j - 1] == "V") {
                        System.out.println("fight / run? Press [F] to fight / [R] to run: ");
                        String option = in.nextLine();
                        if (option.equalsIgnoreCase("f")) {
                            System.out.println("fighting");
                            int t = fight(i, j);
                            if (t == 1) {
                                board[i][j] = " ";
                                board[i][j - 1] = "P";
                            } else {
                                board[i][j] = "P";
                            }
                        } else {
                            run(i, j);
                        }
                    }
                    if (board[i][j - 1] == "*") {
                        win();
                    }
                    if (board[i][j - 1] == "W") {
                        board[i][j] = " ";
                        board[i][j - 1] = "P";
                        attack = W.sward(attack);
                    }
                    if (board[i][j - 1] == "A") {
                        board[i][j] = " ";
                        board[i][j - 1] = "P";
                        defense = H.Pot(defense);
                    }
                    if (board[i][j - 1] == "H") {
                        board[i][j] = " ";
                        board[i][j - 1] = "P";
                        hitpoints = A.shield(hitpoints);
                    } else {
                        board[i][j] = " ";
                        board[i][j - 1] = "P";
                    }
                }
                if (input.equalsIgnoreCase("d")) {
                    if (board[i][j + 1] == "V") {
                        System.out.println("fight / run? Press [F] to fight / [R] to run: ");
                        String option = in.nextLine();
                        if (option.equalsIgnoreCase("f")) {
                            System.out.println("fighting");
                            int t = fight(i, j);
                            if (t == 1) {
                                board[i][j] = " ";
                                board[i][j + 1] = "P";
                            } else {
                                board[i][j] = "P";
                            }
                        } else {
                            run(i, j);
                        }
                    }
                    if (board[i][j + 1] == "*") {
                        win();
                    }
                    if (board[i][j + 1] == "W") {
                        board[i][j] = " ";
                        board[i][j + 1] = "P";
                        attack = W.sward(attack);
                    }
                    if (board[i][j + 1] == "A") {
                        board[i][j] = " ";
                        board[i][j + 1] = "P";
                        defense = H.Pot(defense);
                    }
                    if (board[i][j + 1] == "H") {
                        board[i][j] = " ";
                        board[i][j + 1] = "P";
                        hitpoints = A.shield(hitpoints);
                    } else {
                        board[i][j] = " ";
                        board[i][j + 1] = "P";
                    }
                }
                villains();

                for (i = 0; i < mapSize; i++) {
                    for (j = 0; j < mapSize; j++) {
                        System.out.print("[ " + board[i][j] + " ]" + " ");
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println("hero_name : " + hero_name);
                System.out.println("hero_class: " + hero_class);
                System.out.println("Level     : " + level);
                System.out.println("experience: " + experience);
                System.out.println("attack    : " + attack);
                System.out.println("defence   : " + defense);
                System.out.println("hitponts  : " + hitpoints);
                

                UserData CallThemAll = new UserData();
                CallThemAll.UpData(hero_name, hero_class, level, experience, attack, defense, hitpoints);
            } catch (Exception e) {
                System.out.println("out of map: with: " + e.getMessage() + " go back");
            }
        }
        in.close();
    }

    private void villains() {
        Random rand = new Random();
        int k;
        int p;

        k = rand.nextInt(mapSize);
        p = rand.nextInt(mapSize);
        if (board[k][p] != "*") {
            board[k][p] = "V";
        }
    }

    private void hero() {
        int i = 0;
        int j = 0;
        int x_mid = mapSize / 2;
        int y_mid = mapSize / 2;

        while (i < mapSize) {
            while (j < mapSize) {
                if (board[i][j].equals("P")) {
                    board[i][j] = " ";
                } else {
                    board[x_mid][y_mid] = "P";
                }
                j++;
            }
            i++;
        }
    }

    private void weapon() {
        Random rand = new Random();
        int k;
        int p;

        k = rand.nextInt(mapSize);
        p = rand.nextInt(mapSize);
        if (board[k][p] != "*") {
            board[k][p] = "W";
        }
    }

    private void helm() {
        Random rand = new Random();
        int k;
        int p;

        k = rand.nextInt(mapSize);
        p = rand.nextInt(mapSize);
        if (board[k][p] != "*") {
            board[k][p] = "H";
        }
    }

    private void armor() {
        Random rand = new Random();
        int k;
        int p;

        k = rand.nextInt(mapSize);
        p = rand.nextInt(mapSize);
        if (board[k][p] != "*") {
            board[k][p] = "A";
        }
    }

    public void win() {
        System.out.println(
                "reaches on of the borders of the map. YOU HAVE REACHES THE BOARDER OF THE MAP >>> YOU WON THE ");
        System.exit(1);
    }

    public int fight(int x, int y) {
        int z;

        Random rand = new Random();
        z = rand.nextInt(2);
        if (z == 1) {
            System.out.println("your won and your experience is: " + experience);
            experience = attack + defense + hitpoints;
            if (experience >= (int) (level * 1000 + Math.pow((level - 1), 2) * 450)) {
                level++;
                generateMap();
            }
            return 1;
        } else {
            attack = attack - 10;
            defense = defense - 5;
            hitpoints = hitpoints - 30;
            if (attack < 1)
                attack = 0;
            if (defense < 1)
                defense = 0;
            if (hitpoints < 1)
                hitpoints = 0;
            experience = attack + defense + hitpoints;
            System.out.println("your lost and your point is: " + experience);
            return 0;
        }
    }

    public void run(int x, int y) {

        if (board[x][y] == "V") {
            fight(x, y);
        } else {
            board[x][y] = "P";
            System.out.println("i is: " + x + "j is: " + y);
        }
    }
}
