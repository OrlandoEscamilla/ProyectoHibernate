package es.pildoras.conexionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class ConsultaClientes {

	public static void main(String[] args) {
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		
		Session miSession = miFactory.openSession();
		
		try {
			
			//comenzar sesion
			miSession.beginTransaction();
		
			//consulta de Clientes		
			List<Clientes> losClientes = miSession.createQuery("from Clientes").getResultList();		
			/*
			for(Clientes unCliente:losClientes) {
				System.out.println(unCliente);
			}			
			*/
			for(int i = 0; i < losClientes.size(); i++) {
				System.out.println(losClientes.get(i));
			}
		
			
			//-----------------------------------------------------------------------------------------------------------------
			
			
			
			losClientes = miSession.createQuery("from Clientes cl where cl.apellido='Fernandez'").getResultList();
			
			for(int i = 0; i < losClientes.size(); i++) {
				System.out.println(losClientes.get(i));
			}
			 
			
			//-----------------------------------------------------------------------------------------------------------------
			
					
			//muestra los que viven en gran via o se apellidan Delgado
			losClientes = miSession.createQuery("from Clientes cl where cl.apellido='Fernandez' and cl.direccion='Roma'").getResultList();
			
			for(int i = 0; i < losClientes.size(); i++) {
				System.out.println(losClientes.get(i));
			}
			
			
			
			
			 //commit
			miSession.getTransaction().commit();
			
			 //cerrar la sesión
			miSession.close();
			
			
		}
		finally {
			miFactory.isClosed();
		}
		
		
		
		

	}

}
