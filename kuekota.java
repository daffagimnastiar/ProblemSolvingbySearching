import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RoutingKue {
    public static class House {
        String name;
        int demand;

        public House(String name, int demand) {
            this.name = name;
            this.demand = demand;
        }
    }

    public static class Route {
        List<House> houses;
        int totalDemand;

        public Route() {
            houses = new ArrayList<>();
            totalDemand = 0;
        }

        public void addHouse(House house) {
            houses.add(house);
            totalDemand += house.demand;
        }
    }

    public static void main(String[] args) {
        List<House> houses = new ArrayList<>();
        houses.add(new House("Rumah A", 5));
        houses.add(new House("Rumah B", 8));
        houses.add(new House("Rumah C", 3));
        houses.add(new House("Rumah D", 2));
        houses.add(new House("Rumah E", 7));

        int populationSize = 50;
        int generations = 1000;
        Random random = new Random();

        List<Route> population = new ArrayList<>();

        // Generate an initial population
        for (int i = 0; i < populationSize; i++) {
            List<House> shuffledHouses = new ArrayList<>(houses);
            Collections.shuffle(shuffledHouses, random);
            Route route = new Route();
            for (House house : shuffledHouses) {
                if (route.totalDemand + house.demand <= 15) {
                    route.addHouse(house);
                }
            }
            population.add(route);
        }

        // Implement the genetic algorithm (selection, crossover, mutation, and evolution) here

        // Print the best route found
        Route bestRoute = findBestRoute(population);
        System.out.println("Best Route:");
        for (House house : bestRoute.houses) {
            System.out.println(house.name);
        }
        System.out.println("Total Demand: " + bestRoute.totalDemand);
    }

    public static Route findBestRoute(List<Route> population) {
        // Implement a function to find the best route in the population
        // You can use a fitness function to evaluate routes
        return null;
    }
}
