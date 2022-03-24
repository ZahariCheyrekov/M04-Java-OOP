package catHouse.core;

import catHouse.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {

        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("End")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddHouse:
                result = addHouse(data);
                break;
            case BuyToy:
                result = buyToy(data);
                break;
            case ToyForHouse:
                result = toyForHouse(data);
                break;
            case AddCat:
                result = addCat(data);
                break;
            case FeedingCat:
                result = feedingCat(data);
                break;
            case SumOfAll:
                result = sumOfAll(data);
                break;
            case Statistics:
                result = getStatistics();
                break;
            case End:
                result = Command.End.name();
                break;
        }
        return result;
    }

    private String addHouse(String[] data) {
        String type = data[0];
        String name = data[1];

        return this.controller.addHouse(type, name);
    }

    private String buyToy(String[] data) {
        String type = data[0];
        return this.controller.buyToy(type);
    }

    private String toyForHouse(String[] data) {
        String houseName = data[0];
        String toyType = data[1];

        return this.controller.toyForHouse(houseName, toyType);
    }

    private String addCat(String[] data) {
        String houseName = data[0];
        String catType = data[1];
        String catName = data[2];
        String catBreed = data[3];
        double price = Double.parseDouble(data[4]);

        return this.controller.addCat(houseName, catType, catName, catBreed, price);
    }

    private String feedingCat(String[] data) {
        String houseName = data[0];
        return this.controller.feedingCat(houseName);
    }

    private String sumOfAll(String[] data) {
        String houseName = data[0];
        return this.controller.sumOfAll(houseName);
    }

    private String getStatistics() {
        return this.controller.getStatistics();
    }
}
