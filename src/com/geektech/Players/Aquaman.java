package com.geektech.Players;

import java.util.Random;

public class Aquaman extends JusticeLeague {
    // Tank

    public Aquaman(String name, int health, int damage, EnumSuperSkill superSkill) {
        super(name, health, damage, superSkill);
    }

    @Override
    public void applySuperAbility(Villain darkseid, JusticeLeague[] justiceLeague) {
        int absorbedDamage = darkseid.getDamage() * 1/5;
        for (int i = 0; i < justiceLeague.length; i++) {
            if (this.getHealth() > 0 && darkseid.getHealth() > 0 && justiceLeague[i] != this) {
                justiceLeague[i].setHealth(justiceLeague[i].getHealth() + absorbedDamage);
                this.setHealth(this.getHealth() - absorbedDamage);
            }
        }
        System.out.println("Aquaman absorbed " + absorbedDamage + " damage from each hero");
    }
}
