package com.mangocity.guava.table;

import org.junit.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

//new Map<E,Map<K,V>>()
public class TableTest {

	@Test
	public void testTable() {
		Table<String, Integer, String> aTable = HashBasedTable.create();

		for (char a = 'A'; a <= 'C'; ++a) {
			for (Integer b = 1; b <= 3; ++b) {
				System.out.println("put key: " + Character.toString(a) + " ,column: " + b + " ,columnValue: " + String.format("%c%d", a, b));
				aTable.put(Character.toString(a), b,
						String.format("%c%d", a, b));
			}
		}

		System.out.println("aTable: " + aTable);// {A={1=A1, 2=A2, 3=A3},
												// B={1=B1, 2=B2, 3=B3},
												// C={1=C1, 2=C2, 3=C3}}
		System.out.println("==================");
		System.out.println("column(2): " + aTable.column(2));
		System.out.println("row(\"B\"): " + aTable.row("B"));
		System.out.println("get(\"B\", 2): " + aTable.get("B", 2));
		System.out.println("contains(\"D\", 1): " + aTable.contains("D", 1));
		System.out.println("containsColumn(3): " + aTable.containsColumn(3));
		System.out.println("containsRow(\"C\"): " + aTable.containsRow("C"));
		System.out.println("columnMap(): " + aTable.columnMap());
		System.out.println("rowMap(): " + aTable.rowMap());
		System.out.println("remove(\"B\", 3): " + aTable.remove("B", 3));
	}
}
