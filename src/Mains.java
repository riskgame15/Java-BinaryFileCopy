
import java.io.*;
import java.util.Scanner;

public class Mains {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter source file path: ");
        String sourcePath = input.nextLine();
        System.out.print("Enter destination file path: ");
        String targetPath = input.nextLine();

        File source = new File(sourcePath);
        if (!source.exists()) {
            System.out.println("Source file does not exist! Please try again.");
            return;
        }
        File destination = new File(targetPath);
        if (destination.exists()) {
            System.out.println("Target file already exist! Please try again.");
            return;
        }

        try {
            copyFileUsingStream(source, destination);

        } catch (IOException e) {
            System.out.println("Cannot copy file");
            System.out.print("IO Exception: ");
            System.out.println(e.getMessage());
        }
    }

    private static void copyFileUsingStream(File source, File target) throws IOException {
        try (
                InputStream inputStream = new FileInputStream(source);
                OutputStream outputStream = new FileOutputStream(target);
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }
    }
}
