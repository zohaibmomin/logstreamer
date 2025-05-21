import java.io.*;

/* We need to implement Tail -f functionality */
public class LogStreamer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello");

        File file = new File("sample.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        //Go to EOF
        long filePointer = file.length();
        // Move the pointer to EOF
        randomAccessFile.seek(filePointer);

        while (true) {
            String line;
            while ((line = randomAccessFile.readLine()) != null) {
                System.out.println(line);

            }

            //Sleep for efficient use of CPU

            Thread.sleep(500);
            //Re-position the pointer because a new line is added
            filePointer = randomAccessFile.getFilePointer();
            randomAccessFile.seek(filePointer);

        }

    }
}
