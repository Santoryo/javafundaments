import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.FileWriter;

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

    public void write(List<String> list)
    {
        try
        {
            FileWriter writer = new FileWriter(this.file);
            for (var line : list)
            {
                writer.write(line + "\n");
            }
            writer.close();
            System.out.println("The file has been saved");
        }
        catch (IOException e)
        {
            System.out.println("Failed to write to file");
            System.out.println(e.getMessage());
        }
    }
}
