package parcialtres;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Scanner;

public class FabricaDeTrajes implements IFabricaDeTrajes{

    private ArrayList<Componente> componentesEnAlmacen;
    private TreeSet<Traje> trajesEnAlmacen;
    private boolean sonRebajas;
    private ArrayList<Traje> envios;
    
    // Constructor
    public FabricaDeTrajes() {
        this.componentesEnAlmacen = new ArrayList<>();
        this.trajesEnAlmacen = new TreeSet<>();
        this.sonRebajas = false;
        this.envios = new ArrayList<>();
    }

    // Método para mostrar el menú
    public void escribirMenu() {
        System.out.println("MENU FABRICA TRAJES");
        System.out.println("1.- Añadir Componente a almacén");
        System.out.println("2.- Listar Componentes del almacén");
        System.out.println("3.- Crear traje y añadir a almacén");
        System.out.println("4.- Listar trajes del almacén");
        System.out.println("7.- Activar/Desactivar las rebajas");
        System.out.println("8.- Crear envío");
        System.out.println("9.- Crear componentes de prueba");
        System.out.println("0.- Salir");
    }

    // Método para añadir un componente al almacén
    public void agregarComponente(Componente componente) {
        componentesEnAlmacen.add(componente);
    }
    
    @Override
    public void añadirComponenteAlmacen() throws IdException, MuchoExtracomunitarioException, MangaException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué tipo de componente desea añadir?");
        System.out.println("1. Chaqueta");
        System.out.println("2. Blusa");
        System.out.println("3. Falda");
        System.out.println("4. Pantalón");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Validar que el id del componente no exista anteriormente
        for (Componente componente : componentesEnAlmacen) {
            if (componente.getId() == id) {
                throw new IdException("El ID del componente ya existe.");
            }
        }
        
        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese Talla: ");
        String talla = scanner.nextLine();

        System.out.print("Ingrese Color: ");
        String color = scanner.nextLine();

        System.out.print("Es Comunitario (true/false): ");
        boolean esComunitario = scanner.nextBoolean();
        
        // Validar porcentaje de componentes extracomunitarios
        long extracomunitarios = componentesEnAlmacen.stream().filter(c -> !c.isEscomunitario()).count();
        if (!esComunitario && extracomunitarios >= componentesEnAlmacen.size() / 2.0) {
            throw new MuchoExtracomunitarioException("Más del 50% de los componentes son extracomunitarios.");
        }

        System.out.print("Ingrese Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        
        Componente componente = null;
        switch (tipo) {
            case 1:
                System.out.print("Ingrese Número de Botones: ");
                int numBotones = scanner.nextInt();
                precio += numBotones * 2; // Ajustar precio para chaqueta
                componente = new Chaqueta(id, nombre, talla, color, esComunitario, precio, numBotones);
                break;
            case 2:
                System.out.print("Es Manga Larga (true/false): ");
                boolean mangaLarga = scanner.nextBoolean();

                // Validar existencia de blusa de manga opuesta del mismo color
                boolean existeBlusaOpuesta = componentesEnAlmacen.stream().anyMatch(c -> 
                    c instanceof Blusa && c.getColor().equals(color) && ((Blusa) c).isMangaLarga() != mangaLarga);
                if (!existeBlusaOpuesta) {
                    throw new MangaException("Debe existir una blusa de manga opuesta del mismo color.");
                }

                componente = new Blusa(id, nombre, talla, color, esComunitario, precio, mangaLarga);
                break;
            case 3:
                System.out.print("Tiene Cremallera (true/false): ");
                boolean conCremalleraFalda = scanner.nextBoolean();
                if (conCremalleraFalda) {
                    precio += 1; // Ajustar precio para falda con cremallera
                }
                componente = new Falda(id, nombre, talla, color, esComunitario, precio, conCremalleraFalda);
                break;
            case 4:
                System.out.print("Tiene Cremallera (true/false): ");
                boolean conCremalleraPantalon = scanner.nextBoolean();
                if (conCremalleraPantalon) {
                    precio += 1; // Ajustar precio para pantalón con cremallera
                }
                componente = new Pantalon(id, nombre, talla, color, esComunitario, precio, conCremalleraPantalon);
                break;
            default:
                System.out.println("Tipo de componente no válido.");
                break;
        }

        if (componente != null) {
            agregarComponente(componente);
            System.out.println("Componente añadido exitosamente.");
        }
    }

    // Método para listar componentes del almacén
    @Override
    public void listarComponentes() {
        if (componentesEnAlmacen.isEmpty()) {
            System.out.println("No hay componentes en el almacén.");
        } else {
            System.out.println("Componentes en el almacén:");
            for (Componente componente : componentesEnAlmacen) {
                System.out.println(componente);
            }
        }
    }
    
    @Override
    public void añadirTrajeAAlmacen() throws ColoresException, TallaException, TrajeExisteException {
        Scanner scanner = new Scanner(System.in);

        // Listar blusas existentes
        System.out.println("Blusas disponibles:");
        for (Componente componente : componentesEnAlmacen) {
            if (componente instanceof Blusa) {
                System.out.println(componente);
            }
        }
        System.out.print("Seleccione el ID de la blusa para el traje: ");
        int idBlusa = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Listar chaquetas existentes
        System.out.println("Chaquetas disponibles:");
        for (Componente componente : componentesEnAlmacen) {
            if (componente instanceof Chaqueta) {
                System.out.println(componente);
            }
        }
        System.out.print("Seleccione el ID de la chaqueta para el traje: ");
        int idChaqueta = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Listar faldas y pantalones existentes
        System.out.println("Faldas y Pantalones disponibles:");
        for (Componente componente : componentesEnAlmacen) {
            if (componente instanceof Falda) {
                System.out.println("Falda: " + componente);
            } else if (componente instanceof Pantalon) {
                System.out.println("Pantalón: " + componente);
            }
        }
        System.out.print("Seleccione el ID de la falda o pantalón para el traje: ");
        int idFaldaPantalon = scanner.nextInt();
        scanner.nextLine(); 

        // Obtener las piezas seleccionadas
        Blusa blusaSeleccionada = null;
        Chaqueta chaquetaSeleccionada = null;
        Componente faldaPantalonSeleccionado = null;
        for (Componente componente : componentesEnAlmacen) {
            if (componente.getId() == idBlusa && componente instanceof Blusa) {
                blusaSeleccionada = (Blusa) componente;
            } else if (componente.getId() == idChaqueta && componente instanceof Chaqueta) {
                chaquetaSeleccionada = (Chaqueta) componente;
            } else if (componente.getId() == idFaldaPantalon && (componente instanceof Falda || componente instanceof Pantalon)) {
                faldaPantalonSeleccionado = componente;
            }
        }

        // Verificar reglas antes de crear el traje
        if (blusaSeleccionada == null || chaquetaSeleccionada == null || faldaPantalonSeleccionado == null) {
            System.out.println("No se pudo crear el traje. Alguna de las piezas seleccionadas no existe.");
            return;
        }

        // Regla: Colores amigos
        if (!sonColoresAmigos(blusaSeleccionada.getColor(), chaquetaSeleccionada.getColor()) ||
            !sonColoresAmigos(blusaSeleccionada.getColor(), faldaPantalonSeleccionado.getColor())) {
            throw new ColoresException("El traje no cumple la regla de colores amigos.");
        }

        // Regla: Mismo tamaño para todas las piezas, excepto la falda
        if (!blusaSeleccionada.getTalla().equals(chaquetaSeleccionada.getTalla()) ||
            !blusaSeleccionada.getTalla().equals(faldaPantalonSeleccionado.getTalla())) {
            throw new TallaException("El traje no cumple la regla de tener todas las piezas del mismo tamaño.");
        }

        // Regla: Nombre único del traje
        String nombreTraje = blusaSeleccionada.getNombre() + "_" + chaquetaSeleccionada.getNombre() + "_" + faldaPantalonSeleccionado.getNombre();
        for (Traje traje : trajesEnAlmacen) {
            if (traje.getNombre().equals(nombreTraje)) {
                throw new TrajeExisteException("Ya existe un traje con el mismo nombre en el almacén.");
            }
        }

        // Crear el traje
        Traje traje = new Traje(nombreTraje);
        traje.getPiezas().add(blusaSeleccionada);
        traje.getPiezas().add(chaquetaSeleccionada);
        traje.getPiezas().add(faldaPantalonSeleccionado);

        // Eliminar las piezas del traje del almacén
        componentesEnAlmacen.remove(blusaSeleccionada);
        componentesEnAlmacen.remove(chaquetaSeleccionada);
        componentesEnAlmacen.remove(faldaPantalonSeleccionado);

        // Agregar el traje al conjunto trajesEnAlmacen
        trajesEnAlmacen.add(traje);
    }
    
    // Método auxiliar para verificar colores amigos
    private boolean sonColoresAmigos(String color1, String color2) {
        return color1.charAt(0) == color2.charAt(0);
    }

    // Método para listar trajes
    @Override
    public void listarTrajes() {
        if (trajesEnAlmacen.isEmpty()) {
            System.out.println("No hay trajes en el almacén.");
        } else {
            System.out.println("Trajes en el almacén:");
            for (Traje traje : trajesEnAlmacen) {
                System.out.println(traje);
            }
        }
    }

    // Método para activar/desactivar las rebajas
    @Override
    public void activarDesactivarRebajas() {
        sonRebajas = !sonRebajas; // Cambiar el estado de rebajas

        // Actualizar precios de componentes y trajes en el almacén
        for (Componente componente : componentesEnAlmacen) {
            if (sonRebajas) {
                componente.setPrecio(componente.getPrecio() * 0.9); // Reducir precio en un 10% en rebajas
            } else {
                componente.setPrecio(componente.getPrecio() / 0.9); // Restaurar precio original
            }
        }

        for (Traje traje : trajesEnAlmacen) {
            for (Componente componente : traje.getPiezas()) {
                if (sonRebajas) {
                    componente.setPrecio(componente.getPrecio() * 0.9); // Reducir precio en un 10% en rebajas
                } else {
                    componente.setPrecio(componente.getPrecio() / 0.9); // Restaurar precio original
                }
            }
        }
    }

    // Método para crear un envío
    @Override
    public void crearEnvio() {
        Scanner scanner = new Scanner(System.in);
        envios = new ArrayList<>();

        System.out.println("Trajes disponibles para enviar:");
        for (Traje traje : trajesEnAlmacen) {
            System.out.println(traje.getNombre());
        }

        while (true) {
            System.out.print("Seleccione un traje para el envío (Ingrese '0' para terminar): ");
            String nombreTraje = scanner.nextLine();
            
            if (nombreTraje.equals("0")) {
                break;
            }

            Traje trajeSeleccionado = null;
            for (Traje traje : trajesEnAlmacen) {
                if (traje.getNombre().equals(nombreTraje)) {
                    trajeSeleccionado = traje;
                    break;
                }
            }

            if (trajeSeleccionado != null) {
                envios.add(trajeSeleccionado);
                trajesEnAlmacen.remove(trajeSeleccionado);
                System.out.println("Traje agregado al envío.");
            } else {
                System.out.println("Nombre de traje no válido. Intente de nuevo.");
            }
        }

        System.out.println("Envío creado exitosamente.");
    }
    
    // Método para crear componentes de prueba
    @Override
    public void crearComponentesDePrueba() {
        componentesEnAlmacen.add(new Chaqueta(1, "Chaqueta Negra", "M", "Negro", false, 100.0, 3));
        componentesEnAlmacen.add(new Blusa(2, "Blusa Blanca", "M", "Blanco", false, 30.0, true));
        componentesEnAlmacen.add(new Falda(3, "Falda Negra", "M", "Rosado", false, 40.0, true));
        componentesEnAlmacen.add(new Pantalon(4, "Pantalón Azul", "M", "Azul", false, 50.0, true));
        System.out.println("Componentes de prueba creados y añadidos al almacén.");
    }

    public static void main(String[] args) {
        FabricaDeTrajes fabrica = new FabricaDeTrajes();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            fabrica.escribirMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1:
                            fabrica.añadirComponenteAlmacen();
                            break;
                    case 2:
                        fabrica.listarComponentes();
                        break;

                    case 3:
                        fabrica.añadirTrajeAAlmacen();
                        break;

                    case 4:
                        fabrica.listarTrajes();
                        break;

                    case 7:
                        fabrica.activarDesactivarRebajas();
                        break;

                    case 8:
                        fabrica.crearEnvio();
                        break;

                    case 9:
                        fabrica.crearComponentesDePrueba();
                        break;

                    case 0:
                        System.out.println("Saliendo del programa.");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (IdException | MuchoExtracomunitarioException | MangaException | ColoresException | TallaException | TrajeExisteException e) {
                System.out.println("Error: " + e.getMessage());
            }
        
        } while (opcion != 0);

        scanner.close();
    
    }
}
