import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class MyReader {
    public static String readBytes(File path) throws Exception {
        FileInputStream fileStream = new FileInputStream(path);
        int byteOfData = fileStream.read();
        StringBuilder stringBytes = new StringBuilder();

        while(byteOfData != -1) {
            stringBytes.append(byteOfData);
            byteOfData = fileStream.read();
        }

        return stringBytes.toString();
    }
}
