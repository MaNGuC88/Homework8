package com.geektech.Game;

import com.geektech.Players.*;

public class Battle {

    private static int roundNumber = 0;

    public static void startBattle() {

        Villain darkseid = new Villain("Darkseid", 2000, 100);

        Superman superman = new Superman("Superman", 300, 20, EnumSuperSkill.LASER_VISION);
        WonderWoman wonderWoman = new WonderWoman("Wonder Woman", 200, 10, EnumSuperSkill.LASSO_OF_TRUTH);
        Flash flash = new Flash("Flash", 150, 5, EnumSuperSkill.SUPER_SPEED);

        Medic doc = new Medic("Doc", 150, 0, EnumSuperSkill.TO_HEAL, 10);
        Medic nurse = new Medic("Nurse", 150, 0, EnumSuperSkill.TO_HEAL, 5);

        Shazam shazam = new Shazam("Shazam", 200, 0, EnumSuperSkill.LIGHTNING);
        Aquaman aquaman = new Aquaman("Aquaman", 400, 3, EnumSuperSkill.TO_RULE_FISHES);
        Cyborg cyborg = new Cyborg("Cyborg", 250, 0, EnumSuperSkill.TO_FLY);

        JusticeLeague[] justiceLeague = {superman, wonderWoman, flash, doc, nurse, shazam, aquaman, cyborg};

        System.out.println("--------------THE BATTLE HAS STARTED--------------");
        printStatistics(darkseid, justiceLeague);

        while (!isGameOver(darkseid, justiceLeague)) {
            round(darkseid, justiceLeague);
        }
    }

    private static void round(Villain darkseid, JusticeLeague[] justiceLeague) {
        roundNumber++;
        System.out.println("---------------ROUND NUMBER " + roundNumber + "---------------");
        darkseidHits(darkseid, justiceLeague);
        justiceLeagueHit(darkseid, justiceLeague);
        superAbility(darkseid, justiceLeague);
        System.out.println(" * * * * * * * * * * * * * * * * * * * *");
        printStatistics(darkseid, justiceLeague);
    }

    private static void superAbility(Villain darkseid, JusticeLeague[] justiceLeague) {
        for (int i = 0; i < justiceLeague.length; i++) {
            if (darkseid.getHealth() > 0 && justiceLeague[i].getHealth() > 0) {
                justiceLeague[i].applySuperAbility(darkseid, justiceLeague);
            }
        }
    }

    private static boolean isGameOver(Villain darkseid, JusticeLeague[] justiceLeague) {
        if (darkseid.getHealth() <= 0) {
            System.out.println("-----------Justice League Won!!!-----------");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < justiceLeague.length; i++) {
            if (justiceLeague[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("------------Darkseid won!!!------------");
        }
        return allHeroesDead;
    }

    private static void justiceLeagueHit(Villain darkseid, JusticeLeague[] justiceLeague) {
        for (int i = 0; i < justiceLeague.length; i++) {
            if (darkseid.getHealth() > 0 && justiceLeague[i].getHealth() > 0) {
                darkseid.setHealth(darkseid.getHealth() - justiceLeague[i].getDamage());
            }
        }
    }

    private static void darkseidHits(Villain darkseid, JusticeLeague[] justiceLeague) {
        for (int i = 0; i < justiceLeague.length; i++) {
            if (darkseid.getHealth() > 0 && justiceLeague[i].getHealth() > 0) {
                justiceLeague[i].setHealth(justiceLeague[i].getHealth() - darkseid.getDamage());
            }
        }
    }

    private static void printStatistics(Villain darkseid, JusticeLeague[] justiceLeague) {
        System.out.println(darkseid.getName() + "'s health = " + darkseid.getHealth() + ", damage = "
                + darkseid.getDamage());
        for (JusticeLeague hero : justiceLeague) {
            System.out.println(hero.getName() + "'s health = " + hero.getHealth() + ", damage = "
                    + hero.getDamage());
        }
    }
}
