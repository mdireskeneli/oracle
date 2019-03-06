import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger ai = new AtomicInteger(0);

    public static ArrayList<String> noConsecutiveDups(ArrayList<String> input) {
        ArrayList<String> newList = new ArrayList<>();
        newList.add(input.get(0));
        for (int i = 1; i < input.size(); i++) {
            if (!Objects.equals(input.get(i - 1), input.get(i))) {
                newList.add(input.get(i));
            }
        }
        return newList;
    }

    public static void main(String args[]) throws Exception {
        ArrayList<String> ab = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            ab.add(getDayIn(i));
        }
        ArrayList<String> abc = noConsecutiveDups(ab);
        LocalDate localDate = LocalDate.now().withDayOfYear(1).withYear(2018);
        Map<String, String> map = new HashMap<>();
        abc.stream().forEach(abb -> map.put(localDate.plusDays(ai.getAndIncrement()).toString(), abb));
        String ld = args != null && args.length > 0 && args[0] != null ? args[0] : LocalDate.now().toString();
        System.out.println(map.get(ld));
    }

    public static String getDayIn(Integer a) throws Exception {
        String password = "1000000" + a;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        BigInteger number = new BigInteger(1, byteData);
        String substring = number.toString().substring(5, 7);
        Integer num = Integer.parseInt(substring);
        String map = map(num);
        return map;
    }

    public static String map(Integer num) {
        if (num < 15) {
            return "Golden Rice"; // 15 %
        } else if (num < 45) {
            return "A Au"; // 30 %
        } else if (num < 60) {
            return "Kantine"; // 15 %
        } else if (num < 75) {
            return "Gia-Han"; // 15 %
        } else if (num < 78) {
            return "Mr. HOANG"; // 3 %
        } else if (num < 81) {
            return "Louis Alfons"; // 3 %
        } else if (num < 86)  {
            return "Restaurant lila"; // 5 %
        } else if (num < 96)  {
            return "Wedding Grillhaus"; // 10 %
        } else {
            return "Alaturka"; // 4 %
        }
    }
}