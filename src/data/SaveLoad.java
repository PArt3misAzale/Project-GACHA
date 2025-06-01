package data;

import main.GamePanel;

import java.io.*;

public class SaveLoad {

    GamePanel gp;

    public SaveLoad(GamePanel gp) {
        this.gp = gp;
    }

    // PROFILES //
    public void saveProfilesData() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("res/profiles.save")));

            ProfilesDataStorage pds = new ProfilesDataStorage();

            // SAVE DATA //
            pds.profilesNames = gp.profilesNames;

            // Write the ProfileDataStorage object
            oos.writeObject(pds);

        } catch (IOException e) {
            System.out.println("Save Exception");
        }
    }

    public void loadProfilesData() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("res/profiles.save")));

            // Read the ProfileDataStorage object
            ProfilesDataStorage pds = (ProfilesDataStorage)ois.readObject();

            // LOAD DATA //
            gp.profilesNames = pds.profilesNames;

        } catch (Exception e) {
            System.out.println("Load Exception");
        }
    }

    // PROFILE DATA //
    public void saveProfileData(String profileName) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("res/" + profileName + ".save")));

            ProfileDataStorage pds = new ProfileDataStorage();

            // SAVE DATA //
            pds.playerLevel = gp.playerLevel;
            pds.worldLevel = gp.worldLevel; pds.worldExp = gp.worldExp;
            pds.worldLevelMaxExp = gp.worldLevelMaxExp;
            pds.levelExpPercentage = gp.levelExpPercentage;
            pds.birthdayDate = gp.birthdayDate;

            // Write the ProfileDataStorage object
            oos.writeObject(pds);

        } catch (IOException e) {
            System.out.println("Save Exception");
        }
    }

    public void loadProfileData(String profileName) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("res/" + profileName + ".save")));

            // Read the ProfileDataStorage object
            ProfileDataStorage pds = (ProfileDataStorage)ois.readObject();

            // LOAD DATA //
            gp.playerLevel = pds.playerLevel;
            gp.worldLevel = pds.worldLevel; gp.worldExp = pds.worldExp;
            gp.worldLevelMaxExp = pds.worldLevelMaxExp;
            gp.levelExpPercentage = pds.levelExpPercentage;
            gp.birthdayDate = pds.birthdayDate;

        } catch (Exception e) {
            System.out.println("Load Exception");
        }
    }

    // OBTAINED CHARACTERS DATA  //
    public void saveObtainedCharactersData(String profileName) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("res/" + profileName + "_obtained_characters.save")));

            ObtainedCharactersDataStorage ocds = new ObtainedCharactersDataStorage();

            // SAVE DATA //
            ocds.mael = gp.hasCharMael;

            // Write the SaveLoad object
            oos.writeObject(ocds);
            System.out.println("File saved");

        } catch (IOException e) {
            System.out.println("Save Exception");
        }
    }

    public void loadObtainedCharactersData(String profileName) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("res/" + profileName + "_obtained_characters.save"))); // rajouter le player profile en '+ playerProfile +' ?

            // Read the ProfileDataStorage object
            ObtainedCharactersDataStorage ocds = (ObtainedCharactersDataStorage)ois.readObject();

            // LOAD DATA //
            gp.hasCharMael = ocds.mael;

        } catch (Exception e) {
            System.out.println("Load Exception");
        }
    }
}
