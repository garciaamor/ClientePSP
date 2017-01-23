
package cliente;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JOptionPane;



public class Cliente {

    
    
    public static void main(String[] args) {
        
        int num1=0;
        int num2=0;
        int result=0;
        char signo;
        
       try{
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket("localhost",5555);
            System.out.println("Estableciendo la conexion");

            /*InetSocketAddress addr=new InetSocketAddress("localhost",5554);
            clienteSocket.bind(addr);
            clienteSocket.connect(addr);*/
            
            BufferedReader asdas = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            
            
            OutputStream os= clienteSocket.getOutputStream();

            System.out.println("Enviando mensaje");
            
            num1 = Integer.parseInt(JOptionPane.showInputDialog("Escribe el primer número"));
            num2 = Integer.parseInt(JOptionPane.showInputDialog("Escriba el segundo número"));
            result = Integer.parseInt(JOptionPane.showInputDialog("Que operación quieres realizar? \n1= +\n2= -\n3= X\n4= / "));
            os.write(result);
            os.write(num1);
            os.write(num2);
            
            os.flush();

            
            int total=asdas.read();
            System.out.println("Total de " + num1 + result + num2 + " = " + total);
            
            System.out.println("Cerrando el socket cliente");

            clienteSocket.close();

            System.out.println("Terminado");

            }catch (IOException e) {
                    e.printStackTrace();
            }
	}
}	