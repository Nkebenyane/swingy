package swingy.model.hero_class;

import swingy.model.Hero;
import swingy.model.HeroBuilder;;

public class WarriorBuilder implements HeroBuilder {
    private Hero hero;

    // The Hero will be created when ever the OldHeroBuilder is called
    public WarriorBuilder() {
        this.hero = new Hero();
    }

    @Override
    public void HeroBuilderHero_name(String hero_name) {
        hero.setHero_name(hero_name);
    }

    @Override
    public void HeroBuilderHero_class() {
        hero.setHero_class("Warrior");
    }

    @Override
    public void HeroBuilderLevel() {
        hero.setLevel(1);
    }

    @Override
    public void HeroBuilderExperience() {
        hero.setExperience(1000);
    }

    @Override
    public void HeroBuilderAttack() {
        hero.setAttack(10);
    }

    @Override
    public void HeroBuilderDefense() {
        hero.setDefense(10);
    }
    @Override
    public void HeroBuilderHitPoints() {
        hero.setHitPoint(10);
    }
    public Hero getHero() {
        return hero;
    }


}