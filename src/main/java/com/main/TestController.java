/**
 * コントローラークラス
 * 
 */

package com.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	// @Autowired :
	// 引っ張ってこれない場合でも、(required=false)で、エラー回避できる
	@Autowired
	MyDataRepository repository;

	@RequestMapping("/index")
	public String index(Model model) {
		Iterable<MyData> dataList = repository.findAll();
		model.addAttribute("data", dataList);
		return "index";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String inputGet(Model model) {
		return "input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	// @RequestParam : フォームで入力されたデータを取得するアノテーション
	public String inputPost(Model model, @RequestParam("name") String name, @RequestParam("pass") String pass) {
		MyData myData = new MyData(name, pass);
		// 入力データを、リポジトリに保存する
		repository.saveAndFlush(myData);
		// リポジトリに保存された全データを呼び出す
		Iterable<MyData> myDataList = repository.findAll();
		model.addAttribute("data", myDataList);

		return "inputresult";
	}

	@RequestMapping(value = "/serch", method = RequestMethod.GET)
	// @RequestParam : フォームで入力されたデータを取得するアノテーション
	public String serchGet(Model model) {
		return "serch";
	}

	@RequestMapping(value = "/serchById", method = RequestMethod.POST)
	// @RequestParam : フォームで入力されたデータを取得するアノテーション
	public String serchPost(Model model, @RequestParam("id") Integer id) {

		// IDからデータベースを検索する
		// 検索結果なしの場合は「javax.persistence.EntityNotFoundException」が発生する(現状、回避方法不明)
		MyData serchData = repository.getOne(id);
		model.addAttribute("serchData", serchData);

		return "serch";
	}

	@RequestMapping(value = "/serchByName", method = RequestMethod.POST)
	// @RequestParam : フォームで入力されたデータを取得するアノテーション
	public String serchBYname(Model model, @RequestParam("name") String name) {

		Iterable<MyData> myDataList = repository.findByName(name);
		model.addAttribute("serchData", myDataList);

		return "serch";
	}
}