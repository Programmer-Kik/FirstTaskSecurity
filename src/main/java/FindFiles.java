import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class FindFiles {
    public static void main(String[] args) throws Exception {
        String root = "C:\\Users\\1\\Desktop\\Test";
        File rootDir = new File(root);

        String pathStartFile = "C:\\Users\\1\\Desktop\\Test\\Example.txt";
        File startFile = new File(pathStartFile);

        List<String> result = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();

        FileInputStream fileStream = new FileInputStream(startFile);
        int byteOfData = fileStream.read();
        List<Integer> startFileInBytes = new ArrayList<>();
        while(byteOfData != -1) {
            startFileInBytes.add(byteOfData);
            byteOfData = fileStream.read();
        }

        Collections.addAll(fileTree, rootDir.listFiles());

        while (!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();

            if (currentFile.isDirectory()) {
                Collections.addAll(fileTree, currentFile.listFiles());
            } else {
                fileStream = new FileInputStream(currentFile);
                byteOfData = fileStream.read();
                List<Integer> curFileInBytes = new ArrayList<>();
                while(byteOfData != -1) {
                    curFileInBytes.add(byteOfData);
                    byteOfData = fileStream.read();
                }

                if(curFileInBytes.containsAll(startFileInBytes)){
                    result.add(currentFile.getName());
                }
            }
        }

        for (String item:result) {
            System.out.println(item);
        }
    }
}