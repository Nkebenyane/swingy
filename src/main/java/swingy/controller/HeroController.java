package swingy.controller;
import swingy.model.HeroModel;
import swingy.view.HeroView;

public class HeroController {
    private HeroModel model;
    private HeroView view;
    
    public HeroController(HeroModel model, HeroView view)
    {
        this.model = model;
        this.view = view;
    }
    public void setHeroName(String hero_name)
    {
        model.setHeroName(hero_name);
    }
    public String getHeroName()
    {
        return model.getHeroName();
    }
    public void setHeroClass(String hero_class)
    {
        model.setHeroClass(hero_class);
    }
    public String getHeroClass()
    {
        return model.getHereClass();
    }

    public void updateView()
    {
        view.printHeroDetails(model.getHeroName(),model.getHereClass());
    }
}