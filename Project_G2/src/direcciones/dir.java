package direcciones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class dir {

    public static void main(String[] args) {
    	
        String[] provincias = {
        		"alava", "albacete", "alicante", "almería", "asturias", "ávila", "badajoz", "barcelona",
                        "burgos", "cáceres", "cádiz", "cantabria", "castellón", "ciudad real", "córdoba", "cuenca",
                        "girona", "granada", "guadalajara", "gipuzkoa", "huelva", "huesca", 
                        "islas baleares", "jaén", "la coruña", "la rioja", "las palmas", "león",
                        "lérida", "lugo", "madrid", "málaga", "murcia", "navarra", "ourense", 
                        "palencia", "pontevedra", "salamanca", "santa cruz de tenerife", "segovia", "sevilla",
                        "soria", "tarragona", "teruel", "toledo", "valencia", "valladolid", "vizcaya",
                        "zamora", "zaragoza"
        };

        String[] direcciones = {
        		"Mercería Lourdes", "Estanco del Bosque", "Cafetería El Mirador", "Supermercado La Estrella", "Librería El Sabio",
        		"Papelería La Pluma Dorada", "Panadería El Horno Mágico", "Tienda de Ropa Elegancia", "Joyería Brillante", "Farmacia San José",
        		"Estanco El Humo", "Mercería La Aguja de Oro", "Supermercado El Ahorro", "Panadería El Trigo Dorado", "Cafetería Aroma Fresco",
        		"Librería La Imaginación", "Estanco del Puerto", "Tienda de Ropa Fashion City", "Farmacia La Salud Total", "Supermercado El Mercado Feliz",
        		"Cafetería La Buena Taza", "Panadería El Horno Creativo", "Librería La Página Dorada", "Mercería La Lana Suave", "Estanco del Bosque",
        		"Joyería Diamante Azul", "Cafetería La Vista al Mar", "Panadería El Rincón del Pan", "Supermercado El Ahorro Total", "Tienda de Ropa Fashion Street",
        		"Mercería La Lana Creativa", "Estanco del Humo Dulce", "Librería La Imaginación Infinita", "Farmacia La Salud Perfecta", "Joyería La Joya Eterna",
        		"Panadería La Masa Dorada", "Cafetería El Café Aromático", "Supermercado La Canasta Feliz", "Tienda de Ropa Fashion Style", "Estanco del Aire Puro",
        		"Mercería La Lana Colorida", "Librería La Página en Blanco", "Panadería El Rincón del Panadero", "Cafetería El Rincón del Café", "Joyería La Perla del Oro",
        		"Farmacia La Salud Natural", "Supermercado El Mercado Fresco", "Tienda de Ropa Fashion Trends", "Estanco del Aire Fresco", "Mercería La Aguja Mágica",
        		"Tienda de Electrónica TechCity", "Café de la Esquina", "Librería Imaginaria", "Supermercado Fresco y Feliz", "Estanco del Bosque Verde",
        		"Joyería Diamante Brillante", "Panadería La Masa Dorada", "Mercería Color y Estilo", "Farmacia La Salud Perfecta", "Moda Elegante Boutique",
        		"Restaurante Sabor Gourmet", "Estudio de Tatuajes Arte en Piel", "Peluquería Estilo Creativo", "Centro de Fitness ActivaMente", "Cafetería Aroma Fresco",
        		"Tienda de Juguetes Sonrisas Infinitas", "Estanco del Humo Dulce", "Centro de Belleza Belleza Natural", "Supermercado EcoVida", "Gimnasio Fuerza y Forma",
        		"Panadería El Rincón del Panadero", "Boutique de Moda ChicStyle", "Librería La Página en Blanco", "Mercería Hilos y Colores", "Cafetería El Rincón del Café",
        		"Estudio de Arte Pinceladas Creativas", "Estanco del Aire Fresco", "Joyas Exclusivas JoyaMía", "Farmacia Salud y Bienestar", "Supermercado Delicias Saludables",
        		"Peluquería Glamour Total", "Tienda de Ropa Trendy Fashion", "Cafetería La Buena Taza", "Librería de Ciencia Ficción Cosmos Literario", "Panadería El Horno Creativo",
        		"Estanco del Aire Puro", "Bazar Variado Todo en Uno", "Galería de Arte Visiones Creativas", "Supermercado La Canasta Feliz", "Cafetería Sabor y Aromas",
        		"Estudio de Fotografía Instantánea", "Boutique de Zapatos Pies de Ensueño", "Librería de Historia y Misterio", "Centro de Yoga Serenidad", "Peluquería Cortes de Autor",
        		"Panadería Artesanal El Sabor del Pan", "Estanco del Bosque Encantado", "Tienda de Tecnología Innovatech", "Cafetería Delicias del Café", "Moda Juvenil Trendy Teens",
        		"Boutique de Moda Elegante Glamour", "Librería de Aventuras Literarias", "Supermercado Frescura Natural", "Cafetería Aroma Celestial", "Estudio de Arte Pinturas Vivas",
        		"Tienda de Electrónica TechWorld", "Joyería Estilo Radiante", "Panadería El Sabor del Trigo", "Mercería Hilos y Encajes", "Gimnasio Fitness Activo", 
        		"Estanco del Bosque Encantado", "Café del Bulevar", "Centro de Belleza Bella Imagen", "Farmacia Salud y Vida", "Moda Urbana StreetStyle", 
        		"Restaurante Sazón del Chef", "Estudio de Tatuajes Arte en Tinta", "Peluquería Estilo Moderno", "Boutique de Ropa ChicStyle", "Librería La Imaginación Despierta", 
        		"Supermercado EcoVida", "Cafetería Sabor y Aromas", "Panadería La Masa Dorada", "Estanco del Aire Puro", "Centro de Fitness Energía Total", 
        		"Tienda de Juguetes Sonrisas Infinitas", "Galería de Arte Visiones Creativas", "Joyas Exclusivas Diamante Azul", "Farmacia La Salud Perfecta", "Bazar Variado Todo en Uno", 
        		"Panadería El Rincón del Panadero", "Boutique de Zapatos Pies de Ensueño", "Librería de Ciencia Ficción Cosmos Literario", "Cafetería Delicias del Café", "Estudio de Fotografía Instantánea", 
        		"Estanco del Aire Fresco", "Peluquería Cortes de Autor", "Supermercado Delicias Saludables", "Café de la Esquina", "Librería La Página en Blanco", 
        		"Estudio de Arte Pinceladas Creativas", "Joyería Diamante Brillante", "Panadería Artesanal El Sabor del Pan", "Tienda de Ropa Trendy Fashion", "Centro de Yoga Serenidad", 
        		"Estanco del Humo Dulce", "Cafetería La Buena Taza", "Librería de Historia y Misterio", "Moda Juvenil Trendy Teens", "Boutique de Tecnología Innovatech"




        };
        
        String rutaFich = "resources//provincias_direcciones.txt";
        
       

        escribirProvinciasYDireccionesEnFichero(provincias, direcciones, rutaFich);
    }

   private static void escribirProvinciasYDireccionesEnFichero(String[] provincias, String[] direcciones, String rutaFichero) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaFichero))) {
            for (int i = 0; i < provincias.length; i++) {
                
                writer.write(provincias[i] + ";");

                writer.write(direcciones[i * 3]);
                writer.newLine(); 

                writer.write(provincias[i] + ";");
                writer.write(direcciones[i * 3 + 1]);
                writer.newLine();

                writer.write(provincias[i] + ";");
                writer.write(direcciones[i * 3 + 2]);
                writer.newLine();
            }
            System.out.println("Fichero creado");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}