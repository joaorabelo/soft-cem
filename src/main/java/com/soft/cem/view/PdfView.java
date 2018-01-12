package com.soft.cem.view;





import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.soft.cem.model.Alunos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by aboullaite on 2017-02-25.
 */
public class PdfView extends AbstractPdfView {
   
	
	
	
	
	@Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-pdf-file.pdf\"");

        
        
        
	
		
		@SuppressWarnings("unchecked")
		ArrayList<Alunos> users = (ArrayList<Alunos>) model.get("users");
        document.add(new Paragraph("Generated Users " + LocalDate.now()));

        PdfPTable table = new PdfPTable(users.stream().findAny().get().getColumnCount());
        table.setWidthPercentage(100.0f);
        table.setSpacingBefore(10);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.TIMES);
        font.setColor(Color.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.DARK_GRAY);
        cell.setPadding(5);

        // write table header
        cell.setPhrase(new Phrase("First Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Local de nasc", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("obs", font));
        table.addCell(cell);


        for(Alunos alu : users){
            table.addCell(alu.getNomAlu());
            table.addCell(alu.getLocNascAlu());
            table.addCell(alu.getObsAlu());
           

        }

        document.add(table);
    }
}
