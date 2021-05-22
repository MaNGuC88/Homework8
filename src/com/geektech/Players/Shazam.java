package com.geektech.Players;

import java.util.Random;

public class Shazam extends JusticeLeague {
    // Thor

    public Shazam(String name, int health, int damage, EnumSuperSkill superSkill) {
        super(name, health, damage, superSkill);
    }

    @Override
    public void applySuperAbility(Villain darkseid, JusticeLeague[] justiceLeague) {
        Random random = new Random();
        int stun = random.nextInt(2);
        if (stun == 0) {
            darkseid.setDamage(0);
            System.out.println("Shazam stunned Darkseid for 1 round");
        } else {
            darkseid.setDamage(100);
        }
    }
}
