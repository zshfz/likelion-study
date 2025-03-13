package com.sec11.myutil01;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> m_List = new LinkedList<>();

		m_List.add("java");
		m_List.add("servlet/jsp");
		m_List.add("spring");

		for (String res : m_List) {
			System.out.println(res);
		}

		System.out.println("===================");
		m_List.add(1, "python");
		m_List.set(2, "Html5");

		m_List.remove(3);

		for (String res : m_List) {
			System.out.println(res);
		}

	}

}
