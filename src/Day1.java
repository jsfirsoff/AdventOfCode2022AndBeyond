import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Day1 {

    public static int solvePart1() throws FileNotFoundException {
        return getList().stream().max(Comparator.naturalOrder()).orElse(-1);
    }

    public static int solvePart2() throws FileNotFoundException {
        return getList().stream().sorted(Comparator.reverseOrder()).limit(3).reduce(0, Integer::sum);
    }

    private static ArrayList<Integer> getList() {
        var list = new ArrayList<Integer>();
        try (Stream<String> stream = Files.lines(Paths.get("data/day1"))) {
            var total = new AtomicInteger(0);
            stream.forEach(d -> {
                if (d.isBlank()) {
                    list.add(total.get());
                    total.set(0);
                } else {
                    total.getAndAdd(Integer.parseInt(d));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
