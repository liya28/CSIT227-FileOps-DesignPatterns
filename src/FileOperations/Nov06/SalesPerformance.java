package FileOperations.Nov06;

public class SalesPerformance {
    public static void main(String[] args) {
        String filename = "sales_data.csv";
        SalesAnalyzer analyzer = new SalesAnalyzer(filename);

        // Create the CSV file
        analyzer.createSampleCSV();

        // Load the data
        analyzer.loadData();

        // Analyze and print the results
        analyzer.analyzeAndPrintResults();
    }
}
