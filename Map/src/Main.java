import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Map<String, String>> animalList = new ArrayList<Map<String, String>>();

        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("name", "shark");
        map1.put("habitat", "ocean");
        animalList.add(map1);

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", "bear");
        map2.put("habitat", "land");
        animalList.add(map2);

        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("name", "moose");
        map3.put("habitat", "land");
        animalList.add(map3);

        Map<String, String> map4 = new HashMap<String, String>();
        map4.put("name", "frog");
        map4.put("habitat", "swamp");
        animalList.add(map4);

        Map<String, String> map5 = new HashMap<String, String>();
        map5.put("name", "jelly fish");
        map5.put("habitat", "ocean");
        animalList.add(map5);

        Map<String, String> map6 = new HashMap<String, String>();
        map6.put("name", "heron");
        map6.put("habitat", "swamp");
        animalList.add(map6);

        Map<String, String> map7 = new HashMap<String, String>();
        map7.put("name", "whale");
        map7.put("habitat", "ocean");
        animalList.add(map7);
        
//        用Map.of(key1, value1, key2, value2)，這個語法有一個需要注意的點是它會回傳immutable map，初始化後內容是不可變動的
//        animalList.add(Map.of("name", "shark", "habitat", "ocean"));
//        animalList.add(Map.of("name", "bear", "habitat", "land"));
//        animalList.add(Map.of("name", "moose", "habitat", "land"));
//        animalList.add(Map.of("name", "frog", "habitat", "swamp"));
//        animalList.add(Map.of("name", "jelly fish", "habitat", "ocean"));
//        animalList.add(Map.of("name", "heron", "habitat", "swamp"));
//        animalList.add(Map.of("name", "whale", "habitat", "ocean"));

//        System.out.println(animalList);   // [{habitat=ocean, name=shark}, {habitat=land, name=bear}, {habitat=land, name=moose}, {habitat=swamp, name=frog}, {habitat=ocean, name=jelly fish}, {habitat=swamp, name=heron}, {habitat=ocean, name=whale}]


        List<String> habitatAll = new ArrayList<String>();

        for (Map<String, String> map : animalList) {    // 從animalList中的每個Map裡 抓取habitat資料
            habitatAll.add(map.get("habitat"));         // 存入新創的List中
        }
//        System.out.println(habitatAll);   // [ocean, land, land, swamp, ocean, swamp, ocean]

        List<String> habitatDistinct = habitatAll.stream()
                .distinct() //去除重複
                .collect(Collectors.toList());
//        System.out.println(habitatDistinct);  // [ocean, land, swamp]


        Map<String, List<String>> animalMap = new HashMap<String, List<String>>();
        for (String habitat : habitatDistinct) {

            List<String> animal = new ArrayList<String>();  // 放各別地點所屬的動物

            for (Map<String, String> map : animalList) {
                if (habitat.equals(map.get("habitat"))) {   // 當habitatDistinct當時的地點 = animalList當時Map中的地點,代表該動物屬於habitatDistinct所跑的地點
                    animal.add(map.get("name"));    // 將同個地點的動物存入同一個List
                }
            }

            animalMap.put(habitat, animal);     // 將地點跟上面找到對應的動物List放入
//            System.out.print(animalMap);  // {ocean=[shark, jelly fish, whale]}{land=[bear, moose]}{swamp=[frog, heron]}
        }


        System.out.println("第一題：");
        animalMap.keySet()  // .keySet() 返回所有 key 组成的 set 集合
                .forEach(m -> {     // .forEach() 每一个元素執行特定操作
                    System.out.println(m + ": " + String.join(" , ", animalMap.get(m)));
                });

//========================================================================================

        System.out.println("============================================================");

        Map<String, String> capitalMap = new HashMap<String, String>();
        capitalMap.put("USA", "Washington");
        capitalMap.put("Japan", "Tokyo");
        capitalMap.put("Thailand", "Bangkok");
        capitalMap.put("UK", "London");
        capitalMap.put("Australia", "Canberra");
        capitalMap.put("Denmark", "Copenhagen");
        capitalMap.put("Egypt", "Cairo");
        capitalMap.put("Vietnam", "Hanoi");
        capitalMap.put("Italy", "Rome");
        capitalMap.put("Brazil", "Brasilia");
//        System.out.println(capitalMap);   // {USA=Washington, Vietnam=Hanoi, Japan=Tokyo, UK=London, Egypt=Cairo, Denmark=Copenhagen, Brazil=Brasilia, Italy=Rome, Thailand=Bangkok, Australia=Canberra}


        // https://blog.csdn.net/yaomingyang/article/details/78748130
        System.out.println("第二題：");
        for (String e : capitalMap.keySet()) {
            System.out.println(e + " : " + capitalMap.get(e));
        }

//        for(Map.Entry<String,String> e : capitalMap.entrySet()){
//            System.out.println(e.getKey()+" : "+ e.getValue());
//        }

//        capitalMap.keySet().stream().forEach(e -> {
//            System.out.println(e + ": " + capitalMap.get(e));
//        });
    }
}
