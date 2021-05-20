package com.geektech.Players;

public class WonderWoman extends JusticeLeague {
    // Berserk

    public WonderWoman(String name, int health, int damage, EnumSuperSkill superSkill) {
        super(name, health, damage, superSkill);
    }

    @Override
    public void applySuperAbility(Villain darkseid, JusticeLeague[] justiceLeague) {
        int returnedDamage = darkseid.getDamage()*1/10;
        darkseid.setHealth(darkseid.getHealth() - returnedDamage);
        System.out.println(this.getName() + " returned " + returnedDamage + " damage to Darkseid");
    }
}
