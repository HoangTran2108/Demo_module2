import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void main(String[] args) {
        File file = new File("product.dat");
        List<Product>products = new ArrayList<>();
        products.add(new Product("1","rice","ST", 1500));
        products.add(new Product("2","potato","ST", 2500));
        products.add(new Product("3","corn","ST", 2000));
        writeToFile(file, products);
        List<Product> productList = readFromFile(file);
        for (Product product:productList) {
            System.out.println(product);
        }
    }
    public static boolean writeToFile(File file, List<Product>products) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(products);
            oos.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } return true;
    }
    public static List<Product> readFromFile(File file) {
        List<Product>products = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            products = (List<Product>) ois.readObject();
            fileInputStream.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}