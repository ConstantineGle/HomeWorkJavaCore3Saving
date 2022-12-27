import java.io.File;

public class Main {
    public static void main(String[] args) {

        String[] saveList = {
                "D://Games/savegames/save1.dat",
                "D://Games/savegames/save2.dat",
                "D://Games/savegames/save3.dat"};

        GameProgress gameProgress1 = new GameProgress(100, 1, 1, 10.0);
        GameProgress gameProgress2 = new GameProgress(84, 3, 10, 150.40);
        GameProgress gameProgress3 = new GameProgress(58, 10, 22, 320.10);

        GameProgress.saveGame("D://Games/savegames/save1.dat", gameProgress1);
        GameProgress.saveGame("D://Games/savegames/save2.dat", gameProgress2);
        GameProgress.saveGame("D://Games/savegames/save3.dat", gameProgress3);

        GameProgress.zipFiles("D://Games/savegames/save.zip", saveList);

        File file1 = new File("D://Games/savegames/save1.dat");
        file1.delete();
        File file2 = new File("D://Games/savegames/save2.dat");
        file2.delete();
        File file3 = new File("D://Games/savegames/save3.dat");
        file3.delete();

        //GameProgress.openZip("D://Games/savegames/save.zip", "D://Games/savegames");

        //GameProgress.openProgress("D://Games/savegames/save1.dat");

    }
}
