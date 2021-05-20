package com.geektech.Players;

import java.util.Random;

public class Flash extends JusticeLeague {
    // Magic

    public Flash(String name, int health, int damage, EnumSuperSkill superSkill) {
        super(name, health, damage, superSkill);
    }

    @Override
    public void applySuperAbility(Villain darkseid, JusticeLeague[] justiceLeague) {
        Random random = new Random();
        int coef = random.nextInt(3) + 1;
        for (JusticeLeague hero : justiceLeague) {
            if (hero.getHealth() > 0) {
                hero.setDamage(hero.getDamage() + coef);
            }
        }
        System.out.println(this.getName() + " increased heroes' damage for " + coef);
    }
}
