package com.example.variables;

import java.util.HashMap;
import java.util.List;

import com.example.models.RssItem;
import com.example.news.R;

public class Variables {

	public static final String[] PAPERS = {" Ngoi Sao", "Ha Noi 24h", " ICT "," Hn 24h"};
	public static final int[] ICONS = {R.drawable.ngoisaonet, R.drawable.hanoi24h,R.drawable.haisao,R.drawable.dantri};
	// VnExpress
	
	public static final String[] VNEXPRESS_CATEGORIES = {"Thể thao ", "Thời cuộc",
		"Giải trí","Hollywood"};
	public static final String[] VNEXPRESS_LINKS = {"http://ngoisao.net/rss/the-thao.rss"
		,"http://ngoisao.net/rss/thoi-cuoc.rss",
		"http://ngoisao.net/rss/thu-gian.rss",
		"http://ngoisao.net/rss/hollywood.rss"
	};
	//Ha noi 24h
	public static final String[] HANOI24H_CATEGORIES = {"Bóng đá ", "An ninh - Hình sự",
		"Giáo dục - du học","Ô tô - Xe máy","Công nghệ thông tin",
		"Cười 24h"," Tin tức trong ngày"," Phi thường - kỳ quặc"
		};
	public static final String[] HANOI24H_LINKS = {"http://www.24h.com.vn/upload/rss/bongda.rss"
		,"http://www.24h.com.vn/upload/rss/anninhhinhsu.rss",
		"http://www.24h.com.vn/upload/rss/giaoducduhoc.rss",
		"http://www.24h.com.vn/upload/rss/otoxemay.rss",
		"http://www.24h.com.vn/upload/rss/congnghethongtin.rss",
		"http://www.24h.com.vn/upload/rss/cuoi24h.rss",
		"http://www.24h.com.vn/upload/rss/tintuctrongngay.rss",
		"http://www.24h.com.vn/upload/rss/phithuongkyquac.rss"
		
	};
	
	// ICT
	public static final String[] ICT_CATEGORIES = {"Viễn Thông", "Internet",
		"Phần mềm","Phần cứng"};
	public static final String[] ICT_LINKS = {"http://ictnews.vn/rss/vien-thong"
		,"http://ictnews.vn/rss/internet",
		"http://ictnews.vn/rss/cntt/phan-mem",
		"http://ictnews.vn/rss/cntt/phan-cung"
	};
	// all
	public static final String[][] CATEGORIES = {VNEXPRESS_CATEGORIES,HANOI24H_CATEGORIES,ICT_CATEGORIES };
	public static final String[][] LINKS = {VNEXPRESS_LINKS,HANOI24H_LINKS,ICT_LINKS };
	public static final String PAPER = " paper";
	public static final String CATEGORY= "category";
	public static final String LINK =  "link";
	
	
	public static  HashMap< Integer, List<RssItem>> newsMap = new  HashMap< Integer, List<RssItem>>();
	
}
