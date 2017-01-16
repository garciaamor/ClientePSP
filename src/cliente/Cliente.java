
package cliente;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;



public class Cliente {

    
    public static void main(String[] args) {
        
       try{
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket("localhost",5555);
            System.out.println("Estableciendo la conexion");

            /*InetSocketAddress addr=new InetSocketAddress("localhost",5554);
            clienteSocket.bind(addr);
            clienteSocket.connect(addr);*/
            
            BufferedReader asdas = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            
            InputStream is = clienteSocket.getInputStream();
            OutputStream os= clienteSocket.getOutputStream();

            System.out.println("Enviando mensaje");

            String mensaje="mensaje desde el cliente";
            os.write(mensaje.getBytes());

            
            System.out.println(clienteSocket.isConnected());
            
            System.out.println("Mensaje enviado");
            
            System.out.println("El mensaje enviado es: "+mensaje);

            System.out.println("Cerrando el socket cliente");

            clienteSocket.close();

            System.out.println("Terminado");

            }catch (IOException e) {
                    e.printStackTrace();
            }
	}
}	