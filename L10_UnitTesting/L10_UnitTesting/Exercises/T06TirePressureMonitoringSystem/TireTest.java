package M04_JavaOOP.L10_UnitTesting.Exercises.T06TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class TireTest {

    @Test
    public void testAlarmIsOnWhenPressureIsOutOfLimit() throws NoSuchFieldException, IllegalAccessException {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(Double.valueOf(16));
        Alarm alarm = new Alarm(sensor);

        Field field = Alarm.class.getDeclaredField("sensor");
        field.setAccessible(true);
        field.set(alarm, sensor);

        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsGreaterThanUpper() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(Double.valueOf(22));

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsBetweenTheLimits() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(Double.valueOf(19));

        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testShouldReadThePressureSample() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(Double.valueOf(10));
    }
}