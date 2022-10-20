package es.pildoras.conexionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaClientes {

	public static void main(String[] args) {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		try {
			
			//int ClienteId = 1;
			
			//comenzar sesion
			miSession.beginTransaction();
		
			//Clientes miCliente = miSession.get(Clientes.class, ClienteId);
			
			//miCliente.setNombre("Juan");
				
			//miSession.createQuery("update Clientes set apellido='Dominguez' where apellido LIKE 'D%'").executeUpdate();
			
			miSession.createQuery("delete Clientes where nombre = 'Jorge'").executeUpdate();
			
			
			
			miSession.getTransaction().commit();
			
			System.out.println("Registro actualizado correctamente en BBDD");
			
			
			

			
			//cerrar la sesión
			miSession.close();
			
			
		}
		finally {
			miFactory.isClosed();
		}
		
		
		
		
		
		
	}

}
