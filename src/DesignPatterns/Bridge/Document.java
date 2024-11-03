package DesignPatterns.Bridge;
import java.util.*;

public abstract class Document {
    protected ExportFormat format;

    public Document(ExportFormat format) {
        this.format = format;
    }

    public void setExportFormat(ExportFormat exportFormat) {
        this.format = exportFormat;
    }

    public abstract void exportDocument();
}

class TextDocument extends Document {
    private List<String> paragraphs = new ArrayList<>();

    public TextDocument(ExportFormat format) {
        super(format);
    }

    public void addParagraph(String paragraph) {
        paragraphs.add(paragraph);
    }

    @Override
    public void exportDocument() {
        StringBuilder content = new StringBuilder();
        for (String paragraph : paragraphs) {
            content.append(paragraph).append("\n");
        }
        format.export(content.toString());
    }
}

class Spreadsheet extends Document {
    private List<List<String>> rows = new ArrayList<>();

    public Spreadsheet(ExportFormat format) {
        super(format);
    }

    public void addRow(List<String> row) {
        rows.add(row);
    }

    @Override
    public void exportDocument() {
        StringBuilder content = new StringBuilder();
        for (List<String> row : rows) {
            content.append(String.join(", ", row)).append("\n");
        }
        format.export(content.toString());
    }
}

interface ExportFormat {
    void export(String content);
}

class PDFExport implements ExportFormat {
    @Override
    public void export(String content) {
        System.out.println("Exporting content as PDF:\n" + content);
    }
}

class WordExport implements ExportFormat {
    @Override
    public void export(String content) {
        System.out.println("Exporting content as Word:\n" + content);
    }
}

class DocumentConversionSystem {
    public static void main(String[] args) {
        // Export a text document as PDF
        Document textDoc = new TextDocument(new PDFExport());
        textDoc.setExportFormat(new PDFExport()); // Optional: already set by constructor
        ((TextDocument) textDoc).addParagraph("Welcome to the Bridge Pattern.");
        ((TextDocument) textDoc).addParagraph("This document explains the Bridge Pattern with an example.");
        textDoc.exportDocument();

        System.out.println();

        // Export a spreadsheet as Word document
        Document spreadsheet = new Spreadsheet(new WordExport());
        ((Spreadsheet) spreadsheet).addRow(List.of("Name", "Age", "Occupation"));
        ((Spreadsheet) spreadsheet).addRow(List.of("Alice", "30", "Engineer"));
        ((Spreadsheet) spreadsheet).addRow(List.of("Bob", "25", "Designer"));
        spreadsheet.exportDocument();
    }
}
