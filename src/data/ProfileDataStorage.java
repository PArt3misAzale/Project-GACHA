package data;

import java.io.Serializable;

public class ProfileDataStorage implements Serializable {

    int playerLevel;
    int worldLevel;
    int worldExp;
    int worldLevelMaxExp;
    double levelExpPercentage;
    int[] birthdayDate = new int[2];

}
