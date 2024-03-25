import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\janba\\Desktop\\MES\\MES\\Files\\data.txt";
        Scanner scanner = new Scanner(System.in);
        GlobalData data = new GlobalData(filePath);
        data.setGlobalData();
        //data.printData();
        Grid grid = new Grid(data.elementsNumber, data.nodesNumber, filePath);
        grid.setNodes();
        //grid.printNodes();
        // grid.setElements();
        //grid.printElements();

        Gauss gauss = new Gauss(4);
        System.out.println(gauss.solution1d(x -> 5 * Math.pow(x, 2) + 3 * x + 6));
        Gauss gauss2d = new Gauss(4);
        System.out.println(gauss.solution2d((x, y) -> (5 * x * x * y * y) + (3.0 * x * y) + 6.0));

        System.out.println("Podaj liczbę punktów");
        int n = scanner.nextInt();
        ;

        ElementUniwersalny element = new ElementUniwersalny(n);
        element.importData(n);
        System.out.println("Ksi: ");
        element.print(element.ksi);

        System.out.println("Eta: ");
        element.print(element.eta);


    }
}
