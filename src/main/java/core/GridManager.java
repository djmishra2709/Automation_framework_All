package core;

public class GridManager {

    private static Process process;

    public static void startGrid() {

        try {
            String javaHome = System.getenv("JAVA_HOME");

            String javaExe = javaHome + "\\bin\\java.exe";

            ProcessBuilder builder =
                    new ProcessBuilder(
                            javaExe,
                            "-jar",
                            "selenium-server-4.43.0.jar",
                            "standalone"
                    );

            builder.inheritIO();

            process = builder.start();

            System.out.println(
                    "Selenium Grid Started"
            );

            // Wait for Grid startup
            Thread.sleep(5000);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to start Selenium Grid",
                    e
            );
        }
    }

    public static void stopGrid() {

        if (process != null) {

            process.destroy();

            System.out.println(
                    "Selenium Grid Stopped"
            );
        }
    }
}