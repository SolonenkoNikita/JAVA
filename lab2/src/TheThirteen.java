
import liquibase.util.csv.CSVReader;
import java.io.FileReader;
import java.time.LocalDateTime;

public class TheThirteen {
    private static final String PATH = "src/images/numbers.csv";

    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(PATH));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            for (String e : nextLine)
                System.out.format("%s ", e);
        }
    }
}
