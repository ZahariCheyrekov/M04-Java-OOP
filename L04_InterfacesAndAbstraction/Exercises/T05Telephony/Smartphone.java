package M04_JavaOOP.L04InterfacesAndAbstraction.Exercises.T05Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();

        for (String url : this.urls) {
            if (url.matches("^[^0-9]+$")) {
                result.append(String.format("Browsing: %s!", url))
                        .append(System.lineSeparator());
            } else {
                result.append("Invalid URL!")
                        .append(System.lineSeparator());
            }
        }

        return result.toString();
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();

        for (String number : this.numbers) {
            if (number.matches("^[0-9]+$")) {
                result.append(String.format("Calling... %s", number))
                        .append(System.lineSeparator());
            } else {
                result.append("Invalid number!")
                        .append(System.lineSeparator());
            }
        }

        return result.toString();
    }
}