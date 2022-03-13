package M04_JavaOOP.L04InterfacesAndAbstraction.Lab.T05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> data = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
         
            String[] info = command.split("[\\s]+");

            Identifiable identifiable;
            String name = info[0];

            if (info.length == 2) {
                String id = info[1];

                identifiable = new Robot(name, id);

            } else {
                int age = Integer.parseInt(info[1]);
                String id = info[2];

                identifiable = new Citizen(name, age, id);
            }

            data.add(identifiable);

            command = scanner.nextLine();
        }

        String lastFakeDigits = scanner.nextLine();

        System.out.println(data.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(lastFakeDigits))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
