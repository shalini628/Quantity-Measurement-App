import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class QuantityMeasurementAppTest {
    @Test
    void testEquality_YardToYard_SameValue() {
        var a = new QuantityMeasurementApp.QuantityLength(
                1.0,
                QuantityMeasurementApp.LengthUnit.YARDS
        );

        var b = new QuantityMeasurementApp.QuantityLength(
                1.0,
                QuantityMeasurementApp.LengthUnit.YARDS
        );

        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        var a = new QuantityMeasurementApp.QuantityLength(
                1.0,
                QuantityMeasurementApp.LengthUnit.YARDS
        );

        var b = new QuantityMeasurementApp.QuantityLength(
                3.0,
                QuantityMeasurementApp.LengthUnit.FEET
        );

        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        var a = new QuantityMeasurementApp.QuantityLength(
                1.0,
                QuantityMeasurementApp.LengthUnit.YARDS
        );

        var b = new QuantityMeasurementApp.QuantityLength(
                36.0,
                QuantityMeasurementApp.LengthUnit.INCHES
        );

        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_CentimetersToCentimeters_SameValue() {
        var a = new QuantityMeasurementApp.QuantityLength(
                2.0,
                QuantityMeasurementApp.LengthUnit.CENTIMETERS
        );

        var b = new QuantityMeasurementApp.QuantityLength(
                2.0,
                QuantityMeasurementApp.LengthUnit.CENTIMETERS
        );

        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_CentimetersToInches_EquivalentValue() {
        var a = new QuantityMeasurementApp.QuantityLength(
                1.0,
                QuantityMeasurementApp.LengthUnit.CENTIMETERS
        );

        var b = new QuantityMeasurementApp.QuantityLength(
                0.393701,
                QuantityMeasurementApp.LengthUnit.INCHES
        );

        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_DifferentValues() {
        var a = new QuantityMeasurementApp.QuantityLength(
                1.0,
                QuantityMeasurementApp.LengthUnit.YARDS
        );

        var b = new QuantityMeasurementApp.QuantityLength(
                2.0,
                QuantityMeasurementApp.LengthUnit.FEET
        );

        assertFalse(a.equals(b));
    }

    @Test
    void testEquality_SameReference() {
        var a = new QuantityMeasurementApp.QuantityLength(
                1.0,
                QuantityMeasurementApp.LengthUnit.FEET
        );

        assertTrue(a.equals(a));
    }

    @Test
    void testEquality_NullComparison() {
        var a = new QuantityMeasurementApp.QuantityLength(
                1.0,
                QuantityMeasurementApp.LengthUnit.FEET
        );

        assertFalse(a.equals(null));
    }

    @Test
    void testEquality_NullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        null
                )
        );
    }

    @Test
    void testEquality_AllUnits_ComplexScenario() {

        var yard = new QuantityMeasurementApp.QuantityLength(
                2.0,
                QuantityMeasurementApp.LengthUnit.YARDS
        );

        var feet = new QuantityMeasurementApp.QuantityLength(
                6.0,
                QuantityMeasurementApp.LengthUnit.FEET
        );

        var inch = new QuantityMeasurementApp.QuantityLength(
                72.0,
                QuantityMeasurementApp.LengthUnit.INCHES
        );

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inch));
        assertTrue(yard.equals(inch));
    }
}
