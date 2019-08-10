package swingy.model.hero_class;

import swingy.model.Hero;
import swingy.model.HeroBuilder;

public class HunterBuilder implements HeroBuilder {
    private Hero hero;

    // The Hero will be created when ever the OldHeroBuilder is called
    public HunterBuilder() {
        this.hero = new Hero();
    }

    @Override
    public void HeroBuilderHero_name(String hero_name) {
        hero.setHero_name(hero_name);
    }

    @Override
    public void HeroBuilderHero_class() {
        hero.setHero_class("Hunter");
    }

    @Override
    public void HeroBuilderLevel() {
        int level = 1;
        hero.setLevel(level);
    }

    @Override
    public void HeroBuilderExperience() {
        int experience = 1000;
        hero.setExperience(experience);
    }

    @Override
    public void HeroBuilderAttack() {
        int attack = 20;
        hero.setAttack(attack);
    }

    @Override
    public void HeroBuilderDefense() {
        int defense = 20;
        hero.setDefense(defense);
    }  
    @Override
    public void HeroBuilderHitPoints() {
        int hitpoints = 10;
        hero.setHitPoint(hitpoints);
    }
    public Hero getHero() {
        return hero;
    }  
}