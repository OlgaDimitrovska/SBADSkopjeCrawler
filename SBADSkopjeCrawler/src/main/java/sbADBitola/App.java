package sbADBitola;

import java.io.IOException;

import org.jsoup.Jsoup;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class App {

	
	 public static void main( String[] args ) throws IOException
	    {
	
     //org.jsoup.select.Elements date=doc.select("td.ns-kursna-home-datum");
     
	 WebClient webClient= new WebClient(BrowserVersion.CHROME);
   	 webClient.getOptions().setJavaScriptEnabled(true);
  	 HtmlPage page=webClient.getPage("https://www.stbbt.mk/kursna-lista.nspx");
 	 String pageContent=page.asXml();
  	 System.out.println(pageContent);
	 
  	 
  	 org.jsoup.nodes.Document doc = Jsoup.parse(pageContent);
  	 
  	// org.jsoup.select.Elements kurs=doc.select("");
  	 
	 
  	 org.jsoup.select.Elements rows = doc.select("ul#kursnaFizicki");
  	 
     String jsonMsg = "[";
     
     int flag=0;
    
     
     
     for(org.jsoup.nodes.Element row :rows)
    
     {
    	 
    	

         org.jsoup.select.Elements columns = row.select("li");
         
         int i = 1;
         
         jsonMsg = jsonMsg + "{";
      	
         for (org.jsoup.nodes.Element column:columns)

         {
        	 
            
             if(i==1)
             {
             	jsonMsg = jsonMsg + "\"Шифра\":";
             	
             	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
                 
             	jsonMsg = jsonMsg + ",";
             	
             	System.out.print(column.text());
             }
            if(i==2)
             {
             	jsonMsg = jsonMsg + "\"Валута\":";
             	
             	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
                 
             	jsonMsg = jsonMsg + ",";
            	
             	System.out.print(column.text());
             }
             if(i==3)
             {
            	jsonMsg = jsonMsg + "\"Единица\":";
             	
             	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
                 
             	jsonMsg = jsonMsg + ",";
             	
             	System.out.print(column.text());
             }
             if(i==4)
             {
            	jsonMsg = jsonMsg + "\"Единица\":";
             	
             	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
                 
             	jsonMsg = jsonMsg + ",";
             	
             	System.out.print(column.text());
             }
             if(i==5)
             {
            	jsonMsg = jsonMsg + "\"Единица\":";
             	
             	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
                 
             	jsonMsg = jsonMsg + ",";
             	
             	System.out.print(column.text());
             }
             if(i==6)
             {
            	jsonMsg = jsonMsg + "\"Единица\":";
             	
             	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
                 
             	jsonMsg = jsonMsg + ",";
             	
             	System.out.print(column.text());
             }
             if(i==7)
             {
             	jsonMsg = jsonMsg + "\"Куповен\":";
             	
             	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
                 
             	jsonMsg = jsonMsg + ",";
             	
            	System.out.print(column.text());
             }
             if(i==8)
             {
             	jsonMsg = jsonMsg + "\"Продажен\":";
             	
             	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
                 
             	jsonMsg = jsonMsg + "";
             	
           	System.out.print(column.text());
             }
//             if(i==6)
//             {
//             	jsonMsg = jsonMsg + "\"ДКуповен\":";
//             	
//             	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
//                 
//             	
//             	System.out.print(column.text());
//             }
//             if(i==6)
//             {
//             	jsonMsg = jsonMsg + "\"ДПродажен\":";
//             	
//             	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
//                 
//             	
//             	System.out.print(column.text());
//             }

          i++;

         }
         
        
         
         jsonMsg = jsonMsg + "},";
         
         System.out.println();
     
     }
     jsonMsg = jsonMsg.substring(0, jsonMsg.length()-1);
     jsonMsg = jsonMsg + "]";

     System.out.print(jsonMsg);
	
	    }
}
