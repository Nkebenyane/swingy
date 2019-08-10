package swingy.model;


public class Hero implements HeroPlan {

    private String hero_name;
    private String hero_class;
    private int level;
    private int Experience;
    private int Attack;
    private int Defense;
    private int HitPoints;
    public Object resultSet;

	public void setHero_name(String hero_name) {
        this.hero_name = hero_name;
    }

    public String getHero_name() {
        return this.hero_name;
    }

    public void setHero_class(String hero_class) {
        this.hero_class = hero_class;
    }

    public String getHeroClass() {
        return hero_class;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setExperience(int Experience) {
        this.Experience = Experience;
    }

    public int getExperience() {
        return Experience;
    }

    public void setAttack(int Attack) {
        this.Attack = Attack;
    }

    public int getAttack() {
        return Attack;
    }

    public void setDefense(int Defense) {
        this.Defense = Defense;
    }

    public int getDefense() {
        return Defense;
    }
    
    @Override
    public void setHitPoint(int HitPoints) {
        this.HitPoints = HitPoints;
    }
    public int getHitPoints() {
        return HitPoints;
    }

    @Override
    public String toString() {
        return ("i am " + this.hero_name + " of " + this.hero_class + " class.");
    }

}