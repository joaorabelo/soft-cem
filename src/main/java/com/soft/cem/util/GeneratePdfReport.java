package com.soft.cem.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;
import com.soft.cem.model.Alunos;

public class GeneratePdfReport {
	public static final String IMAGE = "src/main/resources/img/logo.png";
	protected Font font;

	 public static ByteArrayInputStream alunosReport(List<Alunos> listaluno) {

	        Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();

	        try {
	        	
	            PdfPTable table = new PdfPTable(3);
	            table.setWidthPercentage(60);
	            table.setWidths(new int[]{1, 3, 3});

	            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

	            PdfPCell hcell;
	            hcell = new PdfPCell(new Phrase("Id", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("Name", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("Local de Nascimento", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);

	            for (Alunos alu : listaluno) {

	                PdfPCell cell;

	                cell = new PdfPCell(new Phrase(alu.getMatAlu().toString()));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                cell.setBorder(Rectangle.NO_BORDER);
	                table.addCell(cell);

	                cell = new PdfPCell(new Phrase(alu.getNomAlu()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                cell.setBorder(Rectangle.NO_BORDER);
	                table.addCell(cell);

	                cell = new PdfPCell(new Phrase(String.valueOf(alu.getLocNascAlu())));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                cell.setPaddingRight(5);
	                cell.setBorder(Rectangle.NO_BORDER);
	                table.addCell(cell);
	            }
	           

	            

	           

	            PdfWriter.getInstance(document, out);
	            document.open();
	            document.add(table);
	           
	            document.close();
	            
	        } catch (DocumentException ex) {
	        
	            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        return new ByteArrayInputStream(out.toByteArray());
	    }
	 
	 public static ByteArrayInputStream fichamatricula(Alunos alu) throws MalformedURLException, IOException  {

	        Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        

	        try {
	        	Font SUBFONT = new Font(Font.getFamilyIndex("TIMES_ROMAN"), 12,    Font.BOLD);
	        	PdfWriter.getInstance(document, out);
	        	 
	        	document.open();
	        	PdfPTable table1 = new PdfPTable(2);
	            table1.setWidthPercentage(100);
	           
	        	                
	        	Image img = Image.getInstance(IMAGE);
	        	img.setAlignment(Element.ALIGN_LEFT);
	        	img.scaleAbsolute(80f, 80f);
	        	img.setAbsolutePosition(1, 1);
	        	      		        	
	        	Paragraph p1 = new Paragraph("Colégio Eduardo Marques de Oliveira \nRua Presidente Vargas nº298 \nSimão Dias - SE \nFone:(79) 36111-1604\nE-mail: colegioeduardomarques@hotmail.com\nBlog: blogdocem.blogspot.com");
	        	p1.setAlignment(Element.ALIGN_CENTER);	    
	            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	           
	            table1.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
	            table1.addCell(img);
	            table1.addCell(p1);
	            
	            document.add(table1);
	            
	            LineSeparator ls = new LineSeparator();
	            
	            document.add(ls);
	            Chunk titulo = new Chunk ("FICHA DE MATRÍCULA");
	            
                document.add(titulo);
	            
	            PdfPTable table = new PdfPTable(1);
	            table.getDefaultCell().setBorder(0);
	            table.setWidthPercentage(100);
	            table.setSpacingBefore(8);
	            
	            PdfPCell hcell;
	            hcell = new PdfPCell(new Phrase("Id: "+ alu.getMatAlu().toString(),SUBFONT));
	            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);
	           
	            PdfPCell cell;
	            hcell = new PdfPCell(new Phrase("Nome: " + alu.getNomAlu(),SUBFONT));
	            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);
	            
	            
	            
                hcell = new PdfPCell(new Phrase("Local de Nascimento: " + alu.getLocNascAlu(),SUBFONT));
	            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);
                
	            
                hcell = new PdfPCell(new Phrase("Data de Nascimento: " + alu.getDtNascAlu(),SUBFONT));
	            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);
	        
                
                hcell = new PdfPCell(new Phrase("Sexo: " + alu.getSexoAlu(),SUBFONT));
	            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);
	            
                
                hcell = new PdfPCell(new Phrase("Endereço: " + alu.getIdEnd().getLocalEnd() +" Nº:" +alu.getIdEnd().getNumEnd(),SUBFONT));
	            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);
	          
                
                hcell = new PdfPCell(new Phrase("Cidade: " + alu.getIdEnd().getCidEnd(),SUBFONT));
	            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);
	            
                
                hcell = new PdfPCell(new Phrase("Estado:" + alu.getIdEnd().getUfEnd(),SUBFONT));
	            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("Filiação 1: " + alu.getFiliAlu() + "   Profissão 1: "+ alu.getProfFiliAlu(),SUBFONT));
	            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("Filiação 2: " + alu.getFiliAlu2() + "   Profissão 2: "+ alu.getProfFiliAlu2(),SUBFONT));
	            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("Observações:" + alu.getObsAlu(),SUBFONT));
	            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
	            hcell.setBorder(Rectangle.NO_BORDER);
	            table.addCell(hcell);
	            
	            table.getDefaultCell().setBorder(0);
	            table.setSpacingAfter(300f);
	            document.add(table);
	            
	            Chunk sigUnderline = new Chunk("                                                                                                                          ");
	            sigUnderline.setUnderline(0.1f, -2f);
	            Chunk dateUnderline = new Chunk("                                                                                                        ");
	            dateUnderline.setUnderline(0.1f, -2f);
	            Paragraph para = new Paragraph("DIRETOR: ");
	            para.add(sigUnderline);
	            para.add(new Chunk(""));
	            para.add(new Chunk("SECRETÁRIA ESCOLAR: "));
	            para.add(dateUnderline);
	            
	            
	            
	            document.add(para);
	           
	            
	        } catch (DocumentException ex) {
	        
	            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
	        }finally {
	        	if (document != null) {
	        		document.close();
	        	}
	        	if(out != null) {
	        	out.close();
	        	}
	        }
	        return new ByteArrayInputStream(out.toByteArray());
	      
	    }
	 
	 public PdfPCell createCell(String content, int colspan, int rowspan, int border) {
	    
			PdfPCell cell = new PdfPCell(new Phrase(content, font));
	        cell.setColspan(colspan);
	        cell.setRowspan(rowspan);
	        cell.setBorder(border);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        return cell;
	    }

	}
