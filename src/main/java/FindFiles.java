import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class FindFiles {
    public static void main(String[] args) throws Exception {
        String root = "";
        String path = "";
        File rootDir = new File(root);
        File startFile = new File(path);
        List<String> result = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();
        byte[] bytesOfFile = new byte[(int)startFile.length()];

        FileInputStream fileStream = new FileInputStream(startFile.getName());
        fileStream.read(bytesOfFile);

        Collections.addAll(fileTree, rootDir.listFiles());

        while(!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();

            if(currentFile.isDirectory()){
                Collections.addAll(fileTree, currentFile.listFiles());
            }
            else{
                byte[] bytesOfCurrentFile = new byte[(int)currentFile.length()];
                FileInputStream fileInputStream = new FileInputStream(currentFile.getName());
                fileInputStream.read(bytesOfCurrentFile);

                if(Arrays.equals(bytesOfFile, bytesOfCurrentFile)){
                    result.add(currentFile.getName());
                }
            }
        }
    }
}