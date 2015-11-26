/**
 * エンティティクラス
 */
package com.main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// @Entity : このクラスがエンティヒｔクラスであることを示すアノテーション
@Entity
public class MyData {
	// @Id : この項目がプライマリーキーであることを示すアノテーション
	// @GeneratedValue : 自動的に値を生成することを示すアノテーション
	@Id
	@GeneratedValue
	protected Integer id;
	protected String name;
	protected String pass;

	public MyData() {
		super();
	}

	public MyData(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	public String toString() {
		return id + " : " + name + " : " + pass;
	}
}
