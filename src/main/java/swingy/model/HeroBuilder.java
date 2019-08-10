package swingy.model;

public interface HeroBuilder{
    public void HeroBuilderHero_name(String hero_name);
    public void HeroBuilderHero_class();
    public void HeroBuilderLevel();
    public void HeroBuilderExperience();
    public void HeroBuilderAttack();
    public void HeroBuilderDefense();
    public void HeroBuilderHitPoints();
    public Hero getHero();

}