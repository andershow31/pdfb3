package pdfb3;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Main {

    public static void main(String[] args) {
        String pathFile = "src//pdfb3//arquivo.pdf"; // Caminho do arquivo
        try (PDDocument doc = Loader.loadPDF(new File(pathFile))) { // Carrega o arquivo
            PDFTextStripper pdfStripper = new PDFTextStripper(); // Carrega o texto do arquivo
            String textComplet = pdfStripper.getText(doc); // Joga o texto do arquivo numa string
            String[] linhas = textComplet.split("\\r?\\n"); // Separa a string pelas quebras de linha
            for (String linha : linhas) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
