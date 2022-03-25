package glacialExpedition.core;

import glacialExpedition.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
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
            case AddExplorer:
                result = addExplorer(data);
                break;
            case AddState:
                result = addState(data);
                break;
            case RetireExplorer:
                result = retireExplorer(data);
                break;
            case ExploreState:
                result = exploreState(data);
                break;
            case FinalResult:
                result = finalResult();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }

        return result;
    }

    private String retireExplorer(String[] data) {
        String explorerName = data[0];
        return controller.retireExplorer(explorerName);
    }

    private String finalResult() {
        return controller.finalResult();
    }

    private String exploreState(String[] data) {
        String stateName = data[0];
        return controller.exploreState(stateName);
    }

    private String addState(String[] data) {
        String stateName = data[0];
        String[] exhibits = Arrays.stream(data).skip(1).toArray(String[]::new);

        return controller.addState(stateName, exhibits);
    }

    private String addExplorer(String[] data) {
        String type = data[0];
        String explorerName = data[1];

        return controller.addExplorer(type, explorerName);
    }
}
