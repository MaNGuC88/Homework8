package com.geektech.Players;

import java.util.Random;

public class Superman extends JusticeLeague {
    // Warrior

    public Superman(String name, int health, int damage, EnumSuperSkill superSkill) {
        super(name, health, damage, superSkill);
    }

    @Override
    public void applySuperAbility(Villain darkseid, JusticeLeague[] justiceLeague) {
        Random random = new Random();
        int coef = random.nextInt(3) + 2;
        if (this.getHealth() > 0) {
            this.setDamage(this.getDamage() * coef);
            System.out.println(this.getName() + " used " + coef + " times critical strike = ["
                    + this.getDamage() * coef + "]");
        }
    }
}
