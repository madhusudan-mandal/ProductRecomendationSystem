package com.mandal.prs;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Product Recommendation System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product by ID");
            System.out.println("3. Search Product by Name");
            System.out.println("4. Filter Products by Category");
            System.out.println("5. Filter Products by Price Range");
            System.out.println("6. Filter Products by Rating");
            System.out.println("7. Sort Products by Price");
            System.out.println("8. Sort Products by Rating");
            System.out.println("9. Group Products by Category");
            System.out.println("10. Display All Products");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter Price: ");
                    float price = sc.nextFloat();
                    System.out.print("Enter Rating: ");
                    Float rating = sc.nextFloat();
                    productService.add(new Product(id, name, category, price, rating));
                    break;

                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = sc.nextInt();
                    productService.removeById(removeId);
                    break;

                case 3:
                    System.out.print("Enter Name to search: ");
                    String searchName = sc.nextLine();
                    productService.searchByName(searchName).forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter Category to filter: ");
                    String filterCategory = sc.nextLine();
                    productService.filterByCategory(filterCategory).forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Enter Min Price: ");
                    Float minPrice = sc.nextFloat();
                    System.out.print("Enter Max Price: ");
                    Float maxPrice = sc.nextFloat();
                    productService.filterByPriceRange(minPrice, maxPrice).forEach(System.out::println);
                    break;

                case 6:
                    System.out.print("Enter Min Rating: ");
                    Integer minRating = sc.nextInt();
                    productService.filterByRating(minRating).forEach(System.out::println);
                    break;

                case 7:
                    System.out.print("Sort by price in ascending order? (yes/no): ");
                    boolean priceAscending = sc.nextLine().equalsIgnoreCase("yes");
                    productService.sortByPrice().forEach(System.out::println);
                    break;

                case 8:
                    System.out.print("Sort by rating in ascending order? (yes/no): ");
                    boolean ratingAscending = sc.nextLine().equalsIgnoreCase("yes");
                    productService.sortByRating().forEach(System.out::println);
                    break;

                case 9:
                    productService.groupByCategory().forEach((cat, prodList) -> {
                        System.out.println(cat + ":");
                        prodList.forEach(System.out::println);
                    });
                    break;

                case 10:
                    productService.displayAllProducts();
                    break;

                case 11:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
