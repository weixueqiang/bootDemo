package wd.bt.demo;

import java.util.ArrayList;
import java.util.List;

public class DemoDao {

	public List<String> listData(){
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add("test:"+i);
		}
		return list;
	}
	
}
