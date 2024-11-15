package arboles;

public class TestComparable {
    
    public static void main(String[] args) {
        
        Estudiante estudiante1 = new Estudiante (1245, "Juan Abitia");
        Estudiante estudiante2 = new Estudiante (1223, "Luis Castañeda");

        if (estudiante1.equals(estudiante2))
            System.out.println("Los estudiantes son iguales");
        else if (estudiante1.equals(estudiante2))
            System.out.println(estudiante1.getCodigo() + " es mayor que " + estudiante2.getCodigo());
        else
            System.out.println(estudiante1.getCodigo() + " es menor que " + estudiante2.getCodigo());

        Entero entero1 = new Entero(5);
        Entero entero2 = new Entero(10);

        if (entero1.equals(entero2))
            System.out.println("Los numeros son iguales");
        else if (entero1.esMayor(entero2))
            System.out.println(entero1.getDato() + " es mayor que " + entero2.getDato());
        else
        System.out.println(entero1.getDato() + " es menor que " + entero2.getDato());
    }
}
