package util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDownloader {

    public static final String DAEGU_APT_TEXT = "src/main/resources/new_build_daegu.txt";

    private FileDownloader() {
    }

    public static List<String> getTextInfos(String textRoute) {
        try {
            File file = new File(textRoute);
            Scanner scanner = new Scanner(file);

            List<String> textInfos = new ArrayList<>();
            while (scanner.hasNextLine()) {
                textInfos.add(scanner.nextLine());
            }
            return textInfos;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
