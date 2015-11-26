/**
 * リポジトリクラス
 * (データベースにアクセスするためのさまざまな手段(アクセス用のメソッド)を提供するためのもの)
 * 
 * @author f-konashi
 */

package com.main;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository : このインターフェイスが、リポジトリのインターフェイスであることを、Springに認識させるアノテーション
// データベースへのアクセスに必要なメソッドを利用できるようにする為、JpaRepositoryインターフェイスを継承する
// JpaRepository<エンティティクラス名, エンティティクラス名で設定したプライマリキーの型>

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Integer> {
	// 名前から検索する
	public List<MyData> findByName(String name);
}
