package swingy.model;

public class HeroEngineer{
    //creates a Hero using a Builder Interface that is defined in the OldHeroBuilder

    private HeroBuilder heroBuilder;
    public HeroEngineer(HeroBuilder heroBuilder)
    {
        this.heroBuilder = heroBuilder;
    }
    public Hero getHero()
    {
        return this.heroBuilder.getHero();
    }
    public void makeHero(String hero_name, String hero_class)
    {
        this.heroBuilder.HeroBuilderHero_name(hero_name);
        this.heroBuilder.HeroBuilderHero_class();
        this.heroBuilder.HeroBuilderLevel();
        this.heroBuilder.HeroBuilderExperience();
        this.heroBuilder.HeroBuilderAttack();
        this.heroBuilder.HeroBuilderDefense();
        this.heroBuilder.HeroBuilderHitPoints();

    }
}