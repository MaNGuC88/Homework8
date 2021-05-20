package com.geektech.Players;

public abstract class JusticeLeague extends GameEntity implements SuperAbility{

    private EnumSuperSkill superSkill;

    public JusticeLeague(String name, int health, int damage, EnumSuperSkill superSkill) {
        super(name, health, damage);
        this.superSkill = superSkill;
    }
}
