package com.geektech.Players;

import java.util.Random;

public class Cyborg extends JusticeLeague {
    // Witcher

    public Cyborg(String name, int health, int damage, EnumSuperSkill superSkill) {
        super(name, health, damage, superSkill);
    }

    @Override
    public void applySuperAbility(Villain darkseid, JusticeLeague[] justiceLeague) {
        boolean firstDeadHero = false;
        for (int i = 0; i < justiceLeague.length; i++) {
            if (justiceLeague[i].getHealth() <= 0) {
                firstDeadHero = true;
            }
            if (firstDeadHero && this.getHealth() > 0) {
                justiceLeague[i].setHealth(justiceLeague[i].getHealth() + this.getHealth());
                this.setHealth(0);
                this.setDamage(0);
                System.out.println("Cyborg brought back to life " + justiceLeague[i].getName());
            }
        }
    }
}
