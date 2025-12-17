package hw;

public class InterfaceVisibilityPractice {

    public static void main(String[] args) {

        // Доступ к public интерфейсу возможен из любого пакета
        PublicService service = new PublicServiceImpl();
        service.run();

        // Доступ к package-private интерфейсу возможен,
        // так как мы находимся в том же пакете hw
        PackageService ps = new PackageServiceImpl();
        ps.execute();
    }
}
