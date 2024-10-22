import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class FileIO {
    private File file;

    public FileIO (String filename) throws IOException
    {
        this.file = new File(filename);
        if (!this.file.exists())
        {
            boolean created = this.file.createNewFile();
            if (!created)
            {
                throw new IOException("Failed to create file");
            }
        }
    }

    public List<String> read()
    {
        List<String> list = new ArrayList<>();

        try
        {
            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine())
            {
                list.add(scanner.nextLine());
            }
            scanner.close();
        }
        catch (IOException e)
        {
            System.out.println("Failed to read file");
            System.out.println(e.getMessage());
        }

        return list;
    }
}
