package M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.io;


import M04_JavaOOP.ExamPreparation.Exam15August2021.restaurant.io.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader  implements InputReader {
    private BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() throws IOException {
        return this.reader.readLine();
    }
}
