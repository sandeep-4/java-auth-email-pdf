package com.java.spring.reservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.java.spring.reservation.model.Reservation;

@Component
public class PDFGenerator {

	public void generateInteratory(Reservation reservation,String filePath) {
		Document document=new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			
			document.add(generateTable(reservation));
			document.close();
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

	private PdfPTable generateTable(Reservation reservation) {

		PdfPTable table=new PdfPTable(2);
		
		PdfPCell cell;
		
		cell=new PdfPCell(new Phrase("Flight Info"));
		cell.setColspan(2);
		table.addCell(cell);
		
		cell=new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());
		
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());
		
		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());
		
		table.addCell("Date of departure");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());
		
		cell=new PdfPCell(new Phrase("Passanger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		
		table.addCell("First Name");
		table.addCell(reservation.getPassanger().getFirstname());
		
		table.addCell("Last Name");
		table.addCell(reservation.getPassanger().getLastname());
		
		table.addCell("Email");
		table.addCell(reservation.getPassanger().getEmail());
		
		table.addCell("Phone");
		table.addCell(reservation.getPassanger().getPhone());
		
		return table;
	}
	


}
