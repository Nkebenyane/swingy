package swingy.model;

import swingy.model.hero_class.WarriorBuilder;
import swingy.model.hero_class.HunterBuilder;

public abstract class HeroFectory {
    public static Hero newHero(String hero_name, String hero_class) {
        Hero ThePlayer = null;
        if (hero_class.equalsIgnoreCase("Warrior")) {
            HeroBuilder Player = new WarriorBuilder();
            HeroEngineer heroEngineer = new HeroEngineer(Player);
            heroEngineer.makeHero(hero_name, hero_class);
            ThePlayer = heroEngineer.getHero();
            return ThePlayer;
        }
        if (hero_class.equalsIgnoreCase("Hunter")) {
            HeroBuilder Player = new HunterBuilder();
            HeroEngineer heroEngineer = new HeroEngineer(Player);
            heroEngineer.makeHero(hero_name, hero_class);
            ThePlayer = heroEngineer.getHero();
            return ThePlayer;
        }
        return ThePlayer;
    }
}