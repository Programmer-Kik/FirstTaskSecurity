import java.io.File;
import java.util.*;

public class FindFiles {
    public static void main(String[] args) throws Exception {
        String root = "src/main/resources/Test";
        String pathStartFile = "src/main/resources/Test/Example.txt";

        File rootDir = new File(root);
        File startFile = new File(pathStartFile);

        List<String> result = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();

        String startFileInBytes = MyReader.readBytes(startFile);

        Collections.addAll(fileTree, rootDir.listFiles());

        while (!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();

            if (currentFile.isDirectory()) {
                Collections.addAll(fileTree, currentFile.listFiles());
            }
            else {
                String curFileInBytes = MyReader.readBytes(currentFile);

                if(curFileInBytes.contains(startFileInBytes)){
                    result.add(currentFile.getName());
                }
            }
        }

        for (String item:result) {
            System.out.println(item);
        }
    }
}