import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Реализуйте структуру телефонной книги с помощью HashMap, учитывая,\n" +
                "        что 1 человек может иметь несколько телефонов.");
        phonebook();

        System.out.println("Пусть дан список сотрудников: Иван Иванов,... Иван Ежов.\n" +
                "        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.\n" +
                "         Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.");
        
        namesPopularity("Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, " +
               "Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, " +
                "Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, " +
                "Иван Ежов");
    }

     static void phonebook(){
        /*
        Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
        что 1 человек может иметь несколько телефонов.
         */
         Map<String, List<Integer>> map = new HashMap<>();
         List<Integer> IvanovA = new ArrayList<Integer>(){{
             add(1723);
             add(3214);
         } };
         List<Integer> VasilevV = new ArrayList<Integer>(){{
             add(1723);
             add(3214);
         } };
         List<Integer> PetrovaM = new ArrayList<Integer>(){{
             add(1723);
             add(3214);
         } };;

         map.put("Иванов А", IvanovA);
         map.put("Васильев В", VasilevV);
         map.put("Петрова М", PetrovaM);


         for (Map.Entry entry: map.entrySet()){
             System.out.println(entry);
         }
     }
    static void namesPopularity(String s){
        /*
        Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина,
        Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова,
        Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
         Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
         */
        String[] names = s.split(", ");
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (String name: names){
            String[] name1 = name.split(" ");
            int count = 1;

            if (treeMap.containsKey(name1[0])) {
                count += treeMap.get(name1[0]);
                treeMap.put(name1[0], count);
            }
            else {
                treeMap.put(name1[0], count);;
            }
        }
        List sortedArray = new ArrayList(treeMap.entrySet());
        Collections.sort(sortedArray, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                return o2.getValue() - o1.getValue();
            }
        });

        System.out.println(sortedArray);
    }

}