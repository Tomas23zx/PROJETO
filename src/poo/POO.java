package poo;

public class POO {
    public static void main(String[] args) {
       
        Cidade city = new Cidade("C", 15, 15); 
        Mapa mapa = new Mapa(25, 25, city); 
   
        String[][] matriz = mapa.getMapa(); 
        
      
        Menu menu = new Menu(matriz, mapa, city); 

        
        boolean isFirstTime = true;

        if (isFirstTime) {
            menu.menCiv(); 
            isFirstTime = false; 
        }

        
        menu.Interface();
        
        
        menu.menus(city);
    }
}
