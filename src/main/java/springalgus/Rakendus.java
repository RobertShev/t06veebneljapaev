package springalgus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Rakendus {
	@RequestMapping("/algus")
    String tervitusfunktsioon() {
        return "Ahoi!";
    }
    
    @RequestMapping("/tervitus")
    String tervitus2(String eesnimi){
        return "Tere, "+eesnimi;
    }
    
    @RequestMapping("/korrutus")
    int korrutamine(int arv1, int arv2){
        return arv1*arv2;
        //http://localhost:8080/korrutus?arv1=3&arv2=5
    }
    /*@RequestMapping("/arvudesumma")
    String arvudeSumma(String arvud){
        double[] sums=new double[arvud.split(",").length];
        while(sums!=null){
            sums[]=Double.parseDouble(m)            
        }
    }*/
    @RequestMapping("/arvudesumma")
    public int arvudeLiitmine(String sisu){
        String[] m=sisu.split(",");
        int summa = 0;
        for(int i=0; i<m.length; i++){
            summa+=Integer.parseInt(m[i].trim());
            
        }
        return java.util.Arrays.stream(sisu.split(",")).mapToInt(s -> Integer.parseInt(s.trim())).sum();
    }
            
    
    public static void main(String[] args) {
		//System.getProperties().put("server.port", 40305);
        SpringApplication.run(Rakendus.class, args);
    }
}
