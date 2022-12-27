import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {

        GameProgress gameProgress1 = new GameProgress(100, 1, 1, 10.0);
        GameProgress gameProgress2 = new GameProgress(80, 3, 10, 100.0);
        GameProgress gameProgress3 = new GameProgress(50, 10, 22, 300.0);

        List<GameProgress> arrayList = new ArrayList<>();
        arrayList.add(gameProgress1);
        arrayList.add(gameProgress2);
        arrayList.add(gameProgress3);

        String[] saveList = {
                "D://Games/savegames/save1.dat",
                "D://Games/savegames/save2.dat",
                "D://Games/savegames/save3.dat"};

        for (int i = 0; i <= saveList.length; i++) {
            try (FileOutputStream fos = new FileOutputStream(saveList[i]);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(arrayList.get(i));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("D://Games/savegames/save.zip"));) {
            zout.putNextEntry(new ZipEntry("save1.dat"));
            FileInputStream fis1 = new FileInputStream("D://Games/savegames/save1.dat");
            byte[] buffer1 = new byte[fis1.available()];
            zout.write(buffer1);

            zout.putNextEntry(new ZipEntry("save2.dat"));
            FileInputStream fis2 = new FileInputStream("D://Games/savegames/save2.dat");
            byte[] buffer2 = new byte[fis2.available()];
            zout.write(buffer2);


            zout.putNextEntry(new ZipEntry("save3.dat"));
            FileInputStream fis3 = new FileInputStream("D://Games/savegames/save3.dat");
            byte[] buffer3 = new byte[fis3.available()];
            zout.write(buffer3);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        File file1 = new File("D://Games/savegames/save1.dat");
        file1.delete();

        File file2 = new File("D://Games/savegames/save2.dat");
        file2.delete();

        File file3 = new File("D://Games/savegames/save3.dat");
        file3.delete();

    }

}
