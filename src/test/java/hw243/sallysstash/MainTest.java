package hw243.sallysstash;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

public class MainTest {
  @Test
  public void test_main() throws FileNotFoundException {
    System.setIn(new FileInputStream("src/test/resources/input_v1.txt"));
    Main.main(null);
  }

}
