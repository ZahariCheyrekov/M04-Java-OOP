


public class ControllerImpl implements Controller {


    public ControllerImpl() {
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = this.helperRepository.findByName(helperName);

        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        Instrument instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);

        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helper.getName());
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        this.presentRepository.add(present);

        return String.format(SUCCESSFULLY_ADDED_PRESENT, present.getName());
    }

    @Override
    public String craftPresent(String presentName) {
        Present present = this.presentRepository.findByName(presentName);

        Helper suitableHelper = this.helperRepository
                .getModels()
                .stream()
                .filter(helper -> helper.getEnergy() > 50)
                .findFirst()
                .orElse(null);

        if (suitableHelper == null) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        shop.craft(present, suitableHelper);

        long instrumentsCountAfter = suitableHelper
                .getInstruments()
                .stream()
                .filter(Instrument::isBroken)
                .count();

        String isDone;

        if (present.isDone()) {
            isDone = "done";
            craftedPresents++;
        } else {
            isDone = "not done";
        }

        return String.format(PRESENT_DONE, presentName, isDone)
                + String.format(COUNT_BROKEN_INSTRUMENTS, instrumentsCountAfter);
    }

    @Override
    public String report() {
        StringBuilder info = new StringBuilder();

        info.append(String.format("%d presents are done!", craftedPresents)).append(System.lineSeparator());
        info.append("Helpers info:").append(System.lineSeparator());

        this.helperRepository
                .getModels()
                .forEach(helper -> info
                        .append(helper.toString())
                        .append(System.lineSeparator()));

        return info.toString().trim();
    }
}
