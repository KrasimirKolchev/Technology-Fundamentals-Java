package T_TextProcessingAndRegexEX;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        String pathInfo = path.substring(path.lastIndexOf("\\") + 1);

        String fileName = pathInfo.substring(0, pathInfo.lastIndexOf('.'));
        String fileExtension = pathInfo.substring(pathInfo.lastIndexOf('.') + 1);

        System.out.printf("File name: %s%nFile extension: %s", fileName, fileExtension);
    }
}
