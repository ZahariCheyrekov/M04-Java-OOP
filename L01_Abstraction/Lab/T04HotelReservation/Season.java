package M04_JavaOOP.L01_Abstraction.Lab.T04HotelReservation;

public enum Season {
    Spring(2),
    Summer(4),
    Autumn(1),
    Winter(3);

    private int value;

    Season(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}