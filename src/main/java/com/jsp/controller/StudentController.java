package com.jsp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.model.Student;

public class StudentController {

	public static void saveStudent(Student s) {

		// load the driver
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/smsDatabase", "postgres",
					"mithun");
			System.out.println(con);
			PreparedStatement psmt = con.prepareStatement("insert into studenttable values (?,?,?,?,?,?,?,?,?)");
			psmt.setObject(1, s.getId());
			psmt.setObject(2, s.getName());
			psmt.setObject(3, s.getEmail());
			psmt.setObject(4, s.getPassword());
			psmt.setObject(5, s.getDob());
			psmt.setObject(6, s.getAddress());
			psmt.setObject(7, s.getGender());
			psmt.setObject(8, s.getMob());
			psmt.setObject(9, s.getRelationshipStatus());

			int n = psmt.executeUpdate();
			System.out.println(n);
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void findStudentById(int studId) {
			
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/smsDatabase","postgres","mithun");
			System.out.println(con);
			PreparedStatement psmt = con.prepareStatement("select * from studenttable where id = ?");
			psmt.setInt(1, studId);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getObject(1)+ " "+ rs.getObject(2));
			}
					
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}}
