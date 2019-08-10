package swingy.controller;

import java.sql.SQLException;

import swingy.model.Hero;
import swingy.model.getinfo.UserData;
import swingy.view.HeroView;

public class HeroController {
    private Hero model;
    private HeroView view;
    private UserData data;

    public HeroController(Hero model, HeroView view, UserData map) {
        this.model = model;
        this.view = view;
        this.data = map;
    }

    public void setHeroName(String hero_name) {
        model.setHero_name(hero_name);
    }

    public String getHeroName() {
        return model.getHero_name();
    }

    public void setHeroClass(String hero_class) {
        model.setHero_class(hero_class);
    }

    public String getHeroClass() {
        return model.getHeroClass();
    }

    public void setLevel(int level) {
        model.setLevel(level);
    }

    public int getLevel() {
        return model.getLevel();
    }

    public void setExperience(int Experience) {
        model.setExperience(Experience);
        ;
    }

    public int getExperience() {
        return model.getExperience();
    }

    public void setAttack(int Attack) {
        model.setAttack(Attack);
    }

    public int getAttack() {
        return model.getAttack();
    }

    public void setDefense(int Defense) {
        model.setDefense(Defense);
    }

    public int getDefense() {
        return model.getDefense();
    }

    public void setHitPoints(int HitPoints) {
        model.setHitPoint(HitPoints);
    }

    public int getHitPoints() {
        return model.getHitPoints();
    }

    public void updateView() {
        try {
            view.printHeroDetails(model.getHero_name(), model.getHeroClass(), model.getLevel(), model.getExperience(),
                    model.getAttack(), model.getDefense(), model.getHitPoints());
        } catch (NullPointerException e) {

            System.out.println();
        }
    }

    public void DataCapture() throws ClassNotFoundException, SQLException {

        try {
            data.Data(model.getHero_name(), model.getHeroClass(), model.getLevel(), model.getExperience(),
                    model.getAttack(), model.getDefense(), model.getHitPoints());
        } catch (NullPointerException e) {

            System.out.print("Hero Name Does Not Exist Please Enter your option e.g[ CREATE || SELECT ]:");
        }
    }
}