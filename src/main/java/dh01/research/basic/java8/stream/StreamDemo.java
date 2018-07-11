package dh01.research.basic.java8.stream;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Time : 18-4-30 上午9:50
 * Author : hcy
 * Description :
 */
public class StreamDemo {

    private static List<Dish> buildMenu(){
        return Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
    }

    private static void groupByMapping(List<Dish> menu){
        Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType = menu.stream()
                .collect(groupingBy(Dish::getType,mapping(dish -> {
                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT; }, toCollection(HashSet::new)
                )));
        System.out.println(caloricLevelsByType);
    }

    private static void subGroup(List<Dish> menu){
        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
                .collect(groupingBy(Dish::getType,groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT; }
                )));
        System.out.println(dishesByTypeCaloricLevel);
    }

    private static void partitionBy(List<Dish> menu){
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(comparing(Dish::getCalories)),Optional::get)));
        System.out.println(mostCaloricPartitionedByVegetarian);
    }

    public static void main(String[] args) {
        List<Dish> menu = buildMenu();
        groupByMapping(menu);
        subGroup(menu);
        partitionBy(menu);
    }
}
