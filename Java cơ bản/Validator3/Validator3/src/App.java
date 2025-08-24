import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] argv) {
        System.out.print("Nhập tên tệp tin: ");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine().trim();

        ArrayList<Validator> val = new ArrayList<>();
        val.add(new NumberValidator());
        val.add(new AlphabetValidator());
        val.add(new LengthValidator(5, 10));
        val.add(new NgayThangNamValidator());
        val.add(new HexaValidator());

        try {
            FileReader fr = new FileReader(filename);
            Scanner fc = new Scanner(fr);

            while (fc.hasNextLine()) {
                String line = fc.nextLine();
                System.out.println(line);
                for (Validator v: val) {
                    if (v.validate(line)) {
                        System.out.print(", PASS");
                    } else {
                        System.out.print(", FAIL");
                    }
                }
                System.out.println();
            }

            fc.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
