package com.geektech.Players;

public class Medic extends JusticeLeague {

    private int healPoints;

    public Medic(String name, int health, int damage, EnumSuperSkill superSkill, int healPoints) {
        super(name, health, damage, superSkill);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperAbility(Villain darkseid, JusticeLeague[] justiceLeague) {
        for (int i = 0; i < justiceLeague.length; i++) {
            if(justiceLeague[i].getHealth() > 0 && justiceLeague[i] != this) {
                justiceLeague[i].setHealth(healPoints + justiceLeague[i].getHealth());
            }
        }
        System.out.println(this.getName() + " healed for " + healPoints);
        this.setDamage(0);
    }
}
