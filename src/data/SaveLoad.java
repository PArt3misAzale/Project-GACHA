package data;

import main.GamePanel;

import java.io.*;

public class SaveLoad {

    GamePanel gp;

    public SaveLoad(GamePanel gp) {
        this.gp = gp;
    }

    // PROFILE DATA //
    public void saveProfileData() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("res/data/profiles/profile1.save"))); // rajouter le player profile en '+ playerProfile +' ?

            ProfilesDataStorage pds = new ProfilesDataStorage();

            // SAVE DATA //
            pds.playerLevel = gp.playerLevel;
            pds.worldLevel = gp.worldLevel; pds.worldExp = gp.worldExp;

            // Write the ProfilesDataStorage object
            oos.writeObject(pds);

        } catch (IOException e) {
            System.out.println("Save Exception");
        }
    }

    public void loadProfileData() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("res/data/profiles/profile1.save"))); // rajouter le player profile en '+ playerProfile +' ?

            // Read the ProfilesDataStorage object
            ProfilesDataStorage pds = (ProfilesDataStorage)ois.readObject();

            // LOAD DATA //
            gp.playerLevel = pds.playerLevel;
            gp.worldLevel = pds.worldLevel; gp.worldExp = pds.worldExp;

        } catch (Exception e) {
            System.out.println("Load Exception");
        }
    }

    // OBTAINED CHARACTERS DATA  //
    public void saveObtainedCharactersData() {
        try {
            System.out.println("Save started");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("res/data/obtained_characters/profile1.save"))); // rajouter le player profile en '+ playerProfile +' ?

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

    public void loadObtainedCharactersData() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("res/data/obtained_characters/profile1.save"))); // rajouter le player profile en '+ playerProfile +' ?

            // Read the ProfilesDataStorage object
            ObtainedCharactersDataStorage ocds = (ObtainedCharactersDataStorage)ois.readObject();

            // LOAD DATA //
            gp.hasCharMael = ocds.mael;

        } catch (Exception e) {
            System.out.println("Load Exception");
        }
    }
}
