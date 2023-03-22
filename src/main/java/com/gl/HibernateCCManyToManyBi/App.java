package com.gl.HibernateCCManyToManyBi;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateCCManyToManyBi.config.HibernateConfig;
import com.gl.HibernateCCManyToManyBi.entity.Employee;
import com.gl.HibernateCCManyToManyBi.entity.Project;

/**
 * Hello world!
 *
 */
public class App {

	private static SessionFactory factory = HibernateConfig.getSessionFactory();

	public static void main(String[] args) {

		Employee employee1 = new Employee();
		employee1.setEmpName("Employee1");
		employee1.setPhone("8759522686");

		Employee employee2 = new Employee();
		employee2.setEmpName("Employee2");
		employee2.setPhone("7759522686");

		Project project1 = new Project();
		project1.setProjectName("Project_1");

		Project project2 = new Project();
		project2.setProjectName("Project_2");

		List<Project> projects = new ArrayList<Project>();
		projects.add(project1);
		projects.add(project2);
		
		employee1.setProjects(projects);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
		
		project2.setEmployees(employees);
		// Inserting data in Employee and Project
//		try {
//			Session session = factory.openSession();
//			Transaction tx = session.beginTransaction();
//			session.persist(employee1);
//			session.persist(employee2);
//			session.persist(project1);
//			session.persist(project2);
//			tx.commit();
//			session.close();
//		} catch (HibernateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// Fetching data from Employee and Project
				try {
					Session session = factory.openSession();
					Transaction tx = session.beginTransaction();
					Employee employee = session.get(Employee.class, 1);
					Project project = session.get(Project.class, 2);
					session.close();
					System.out.println("Employee ID : "+employee.getEmpId());
					System.out.println("Employee Name : "+employee.getEmpName());
					System.out.println("Employee Phone : "+employee.getPhone());
					System.out.println("Employee working in Projects : "+employee.getProjects());
					
					System.out.println("Project ID : "+project.getProjectId());
					System.out.println("Project Name : "+project.getProjectName());
					System.out.println("Project having Employees : "+project.getEmployees());
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
