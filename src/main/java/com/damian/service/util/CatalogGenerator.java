package com.damian.service.util;

import com.damian.domain.Basket;
import com.damian.domain.BasketItems;
import com.damian.domain.Catalog;
import com.damian.domain.CatalogDetails;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;


public class CatalogGenerator {



    public static final String FONT_SEGOPR = "C:\\Users\\Damian\\Desktop\\katalogimg\\nieb\\segoepr.ttf" ;
    public static final String FONT_ROBOTO_ITALIC = "C:\\Users\\Damian\\Desktop\\katalogimg\\nieb\\Roboto-Italic.ttf" ;
    public static final String FONT_ROBOTO_BOLD = "C:\\Users\\Damian\\Desktop\\katalogimg\\nieb\\Roboto-Bold.ttf" ;
    public static final String FONT_ROBOTO_REGULAR = "C:\\Users\\Damian\\Desktop\\katalogimg\\nieb\\Roboto-Regular.ttf" ;
    public static final String FIRST_PAGE_IMAGE = "C:\\Users\\Damian\\Desktop\\katalogimg\\nieb\\niebieskiobraz.jpg" ;
    public static final String COMPANY_LOGO = "C:\\Users\\Damian\\Desktop\\katalogimg\\nieb\\logo.png" ;
    public static final String CONTENT_PAGE_TOP_BACKGROUND = "C:\\Users\\Damian\\Desktop\\katalogimg\\nieb\\belkaniebieska.jpg" ;
    public static final String BASKET_EXAMPLE = "C:\\Users\\Damian\\Desktop\\katalogimg\\nieb\\kosz.png" ;



    public static ByteArrayInputStream generateCatalog() throws IOException {




        BasketItems bi1 = new BasketItems("Siwucha" , "0,5L" , 1);
        BasketItems bi2 = new BasketItems("Wino czerwone Isal" , "0,5l" , 1);
        BasketItems bi3 = new BasketItems("Alokochol bee" , "1L" , 1);
        BasketItems bi4 = new BasketItems("Łysoń Czekolada miód truskawka cripsy" , "100gr" , 1);
        BasketItems bi5 = new BasketItems("Góralskie Praliny \"Skarb Janosika\"" , "12gr" , 1);
        BasketItems bi6 = new BasketItems("Stara Wędzarnia Krakowska sucha" , "330ml" , 1);
        BasketItems bi7 = new BasketItems("Dobre Smaki Syrop z żurawiny" , "200ml" , 1);
        BasketItems bi8 = new BasketItems("Łysoń Czekolada miód truskawka cripsy" , "100gr" , 1);
        BasketItems bi9= new BasketItems("Ogródek Dziadunia Żurawina w syropie" , "270gr" , 1);
        BasketItems bi10 = new BasketItems("Łysoń Miód Nektarowy wielokwiatowy" , "250gr" , 1);
        BasketItems bi11 = new BasketItems("Alokochol bee" , "1L" , 1);
        BasketItems bi12 = new BasketItems("Łysoń Czekolada miód truskawka cripsy" , "100gr" , 1);

        ArrayList<BasketItems> itemList = new ArrayList<BasketItems>();
        itemList.add(bi1);
        itemList.add(bi2);
        itemList.add(bi3);
        itemList.add(bi4);
        itemList.add(bi5);
        itemList.add(bi6);
        itemList.add(bi7);
        itemList.add(bi8);
        itemList.add(bi9);
        itemList.add(bi10);
        itemList.add(bi11);
        itemList.add(bi12);


        Basket b1 = new Basket("Kosz rozkoszy2",new BigDecimal(1999),itemList) ;
        Basket b2 = new Basket("Niebiańskie praliny nocą",new BigDecimal(299 ),itemList) ;

        ArrayList<Basket> baskets = new ArrayList<Basket>() ;
        baskets.add(b1);
        baskets.add(b2);


        CatalogDetails cd = new CatalogDetails("Świąteczne Upominki katalog 2018","Paczkopol Logistic","Damian Paluch","dami@onet.eu","508789763","Oferta przygotwana specjalnie dla państwa");
        Catalog catalog = new Catalog(baskets,cd) ;




        PdfFont fontSegopr = PdfFontFactory.createFont(FONT_SEGOPR, "Cp1250", true);
        PdfFont fontRobotoItalic = PdfFontFactory.createFont(FONT_ROBOTO_ITALIC, "Cp1250", true);
        PdfFont fontRobotoBold = PdfFontFactory.createFont(FONT_ROBOTO_BOLD, "Cp1250", true);
        PdfFont fontRobotoRegular = PdfFontFactory.createFont(FONT_ROBOTO_REGULAR, "Cp1250", true);

        Color dBordowy = new DeviceRgb(147, 28, 0);
        Color dSzary = new DeviceRgb(96, 96, 96);
        Color dZloty = new DeviceRgb(198, 156, 109);


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(out));
        PageSize pageSize = new PageSize(1366, 768);
        Document doc = new Document(pdfDoc, pageSize);
        doc.setMargins(0, 0, 0, 0);
        PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());





        Image img = new Image(ImageDataFactory.create(FIRST_PAGE_IMAGE));
        img.setFixedPosition(475, 0);
        img.setHeight(768);
        img.setWidth(891);


        Image logoImg = new Image(ImageDataFactory.create(COMPANY_LOGO));
        logoImg.setFixedPosition(40, 450);
        logoImg.setHeight(300);
        logoImg.setWidth(400);
        setBorderForAllElement(logoImg);


        Text catalogName = new Text("Świąteczne Upominki katalog 2018.")
            .setFont(fontSegopr)
            .setFontSize(37)
            .setFontColor(dBordowy)
            .setTextAlignment(TextAlignment.CENTER)
            .setHorizontalAlignment(HorizontalAlignment.CENTER);

        Paragraph p = new Paragraph().add(catalogName);
        p.setFixedPosition(30, 275, 350);
        setBorderForAllElement(p);
        p.setHeight(120);
        p.setWidth(408);
        p.setFixedLeading(40f);


        Text offertText = new Text("Oferta przygotowana dla firmy:")
            .setFont(fontRobotoItalic)
            .setFontSize(20)
            .setFontColor(dSzary)
            .setTextAlignment(TextAlignment.CENTER)
            .setHorizontalAlignment(HorizontalAlignment.CENTER);

        Paragraph p2 = new Paragraph().add(offertText)
            .setFixedPosition(30, 230, 350);
        setBorderForAllElement(p2)
            .setHeight(40)
            .setWidth(408)
            .setFixedLeading(40f);

        Text customer = new Text("EnterStore Komputery")
            .setFont(fontRobotoBold)
            .setFontSize(36)
            .setFontColor(dSzary)
            .setTextAlignment(TextAlignment.CENTER)
            .setHorizontalAlignment(HorizontalAlignment.CENTER);


        Paragraph p3 = new Paragraph().add(customer)
            .setFixedPosition(30, 150, 390);
        setBorderForAllElement(p3)
            .setHeight(80)
            .setWidth(408)
            .setFixedLeading(40f);

        Text customeAssistant = new Text("Opiekun klienta:")
            .setFont(fontRobotoItalic)
            .setFontSize(20)
            .setFontColor(dSzary)
            .setTextAlignment(TextAlignment.CENTER)
            .setHorizontalAlignment(HorizontalAlignment.CENTER);

        Paragraph p4 = new Paragraph().add(customeAssistant)
            .setFixedPosition(30, 120, 350);
        setBorderForAllElement(p4)
            .setHeight(50)
            .setWidth(408)
            .setFixedLeading(40f);


        Text customeAssistantName = new Text("Jan Kowalski")
            .setFont(fontRobotoRegular)
            .setFontSize(20)
            .setFontColor(dSzary)
            .setTextAlignment(TextAlignment.CENTER)
            .setHorizontalAlignment(HorizontalAlignment.CENTER);

        Paragraph p5 = new Paragraph().add(customeAssistantName)
            .setFixedPosition(30, 100, 350);
        setBorderForAllElement(p5)
            .setWidth(408)
            .setFixedLeading(40f);
        setBorderForAllElement(p5);

        Text customeAssistantEmail = new Text("jan.kowalski@onet.pl:")
            .setFont(fontRobotoRegular)
            .setFontSize(20)
            .setFontColor(dSzary)
            .setTextAlignment(TextAlignment.CENTER)
            .setHorizontalAlignment(HorizontalAlignment.CENTER);

        Paragraph p6 = new Paragraph().add(customeAssistantEmail)
            .setFixedPosition(30, 60, 350)
            .setHeight(50)
            .setWidth(408)
            .setFixedLeading(40f);
        setBorderForAllElement(p6);
        Text customeAssistantPhone = new Text("508323188")
            .setFont(fontRobotoRegular)
            .setFontSize(20)
            .setFontColor(dSzary)
            .setTextAlignment(TextAlignment.CENTER)
            .setHorizontalAlignment(HorizontalAlignment.CENTER);

        Paragraph p7 = new Paragraph().add(customeAssistantPhone)
            .setFixedPosition(30, 30, 350)
            .setHeight(50)
            .setWidth(408)
            .setFixedLeading(40f);
        setBorderForAllElement(p7);
        /////////////////////////////////////////////////


        doc.add(img);
        doc.add(logoImg);
        doc.add(p);
        doc.add(p2);
        doc.add(p3);
        doc.add(p4);
        doc.add(p5);
        doc.add(p6);
        doc.add(p7);


        canvas.setStrokeColor(dZloty);
        canvas.moveTo(510, 730);
        canvas.lineTo(1330, 730).lineTo(1330, 35).lineTo(510, 35).setLineWidth(3f);
        canvas.closePathStroke();


        PdfCanvas canvasPage2 = new PdfCanvas(pdfDoc.addNewPage());
        doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));


        Image topImage = new Image(ImageDataFactory.create(CONTENT_PAGE_TOP_BACKGROUND));
        topImage.setFixedPosition(0, 669);
        topImage.setHeight(99);
        topImage.setWidth(1366);


        Text catalogNameContent = new Text("Świąteczne Upominki katalog 2018.")
            .setFont(fontSegopr)
            .setFontSize(49)
            .setFontColor(Color.WHITE)
            .setTextAlignment(TextAlignment.CENTER)
            .setHorizontalAlignment(HorizontalAlignment.CENTER);

        Paragraph catalogNameContentParagraph = new Paragraph().add(catalogNameContent);
        catalogNameContentParagraph.setFixedPosition(40, 660, 1330);
        setBorderForAllElement(catalogNameContentParagraph);
        catalogNameContentParagraph.setHeight(120);
        catalogNameContentParagraph.setWidth(1366);


        Image BasketImage = new Image(ImageDataFactory.create(BASKET_EXAMPLE));
        BasketImage.setFixedPosition(43, 35);
        BasketImage.setHeight(597);
        BasketImage.setWidth(850);


        Text basketName = new Text("01.Góralski podarek Marianny")
            .setFont(fontSegopr)
            .setFontSize(40)
            .setFontColor(dBordowy)
            .setTextAlignment(TextAlignment.CENTER)
            .setHorizontalAlignment(HorizontalAlignment.CENTER);

        Paragraph basketNameParagraph = new Paragraph().add(basketName);
        basketNameParagraph.setFixedPosition(830, 520, 500);
        setBorderForAllElement(basketNameParagraph);
        basketNameParagraph.setHeight(90);
        basketNameParagraph.setWidth(500);
        setBorderForAllElement(basketNameParagraph);

        canvasPage2.setStrokeColor(dZloty);
        canvasPage2.moveTo(830, 510);
        canvasPage2.lineTo(1300, 510).setLineWidth(3f);
        canvasPage2.closePathStroke();

        ArrayList<BasketItems> bi = catalog.getBaskets().get(0).getBasketItems();


        int hPosition = 430;
        for (BasketItems basketItems : bi) {


            Text productName = new Text("- "+basketItems.getProductName() + " " + basketItems.getProductCapacity())
                .setFont(fontRobotoItalic)
                .setFontSize(18)
                .setFontColor(dSzary)
                .setTextAlignment(TextAlignment.CENTER)
                .setHorizontalAlignment(HorizontalAlignment.CENTER);

            Paragraph productNameParagraph = new Paragraph().add(productName);
            productNameParagraph.setFixedPosition(830, hPosition, 500);
            setBorderForAllElement(productNameParagraph);
            productNameParagraph.setHeight(50);
            productNameParagraph.setWidth(500);
            setBorderForAllElement(productNameParagraph);

            hPosition -= 20;

            doc.add(productNameParagraph);

        }

        canvasPage2.setStrokeColor(dZloty);
        canvasPage2.moveTo(830, hPosition - 1);
        canvasPage2.lineTo(1300, hPosition - 1).setLineWidth(3f);
        canvasPage2.closePathStroke();

        Text basketPrice = new Text("Cena: 349 zł")
            .setFont(fontSegopr)
            .setFontSize(40)
            .setFontColor(dBordowy)
            .setTextAlignment(TextAlignment.CENTER)
            .setHorizontalAlignment(HorizontalAlignment.CENTER);

        Paragraph basketPriceParagraph = new Paragraph().add(basketPrice);
        basketPriceParagraph.setFixedPosition(1040, hPosition-90, 500);
        setBorderForAllElement(basketPriceParagraph);
        basketPriceParagraph.setHeight(90);
        basketPriceParagraph.setWidth(500);
        setBorderForAllElement(basketPriceParagraph);


        doc.add(topImage);
        doc.add(catalogNameContentParagraph);
        doc.add(BasketImage);
        doc.add(basketNameParagraph);
        doc.add(basketPriceParagraph);
        doc.close();

        return new ByteArrayInputStream(out.toByteArray());
    }

    private static Paragraph setBorderForAllElement (Paragraph paragraph){

        //return   paragraph.setBorder(new SolidBorder(1));
        return   paragraph.setBorder(Border.NO_BORDER);
    }

    private static Image setBorderForAllElement (Image image){

        //return   image.setBorder(new SolidBorder(1));
        return   image.setBorder(Border.NO_BORDER);
    }
}